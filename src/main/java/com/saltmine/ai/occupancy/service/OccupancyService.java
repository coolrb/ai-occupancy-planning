package com.saltmine.ai.occupancy.service;

import com.saltmine.ai.occupancy.model.*;
import com.saltmine.ai.occupancy.repository.DeskRepository;
import com.saltmine.ai.occupancy.repository.EmployeePreferenceRepository;
import com.saltmine.ai.occupancy.repository.OccupancyRepository;
import com.saltmine.ai.occupancy.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class OccupancyService {
    private final NlpService nlpService;
    private final DeskRepository deskRepository;
    private final OccupancyRepository occupancyRepository;
    private final EmployeePreferenceRepository employeePreferenceRepository;
    private final PolicyRepository policyRepository;

    @Autowired
    public OccupancyService(NlpService nlpService, DeskRepository deskRepository,
                            OccupancyRepository occupancyRepository,
                            EmployeePreferenceRepository employeePreferenceRepository,
                            PolicyRepository policyRepository) {
        this.nlpService = nlpService;
        this.deskRepository = deskRepository;
        this.occupancyRepository = occupancyRepository;
        this.employeePreferenceRepository = employeePreferenceRepository;
        this.policyRepository = policyRepository;
    }

    public OccupancyResponse findAvailableDesks(String query) {
        // Parse query
        ParsedQuery parsedQuery = nlpService.parseQuery(query);

        // Extract query parameters
        String deskType = parsedQuery.getDeskType();
        String floor = parsedQuery.getFloor();
        String zone = parsedQuery.getZone();
        String timePeriod = parsedQuery.getPeriod();

        // Filter desks
        List<DeskRecommendation> recommendations = new ArrayList<>();
        List<Desk> desks = deskRepository.findByTypeAndFloorAndZoneAndStatus(
                deskType, 3, zone, "available");

        for (Desk desk : desks) {
            // Check occupancy forecast (Policy: Capacity Limits <= 80%)
            String areaId = desk.getAreaId();
            Optional<Occupancy> occupancyOpt = occupancyRepository.findByAreaId(areaId);
            if (occupancyOpt.isPresent()) {
                int forecast = occupancyOpt.get().getForecast().getOrDefault(timePeriod, 100);
                if (forecast > 80) {
                    continue;
                }
            }

            // Check employee preferences (mock for EMP-1001)
            Optional<EmployeePreference> empPrefOpt = employeePreferenceRepository.findById("EMP-1001");
            if (empPrefOpt.isPresent()) {
                EmployeePreference empPref = empPrefOpt.get();
                // Equipment needs
                if (!desk.getFeatures().containsAll(empPref.getEquipmentNeeds())) {
                    continue;
                }
                // Location preference (near-window)
                if (empPref.getDeskPreferences().contains("near-window") &&
                        !desk.getLocationDescription().toLowerCase().contains("window")) {
                    continue;
                }
                // Score desk
                int score = calculateScore(desk, empPref);
                recommendations.add(new DeskRecommendation(
                        desk.getId(),
                        desk.getAreaId(),
                        desk.getLocationDescription(),
                        desk.getFeatures(),
                        score
                ));
            }
        }

        // Sort by score
        recommendations.sort((a, b) -> Integer.compare(b.getScore(), a.getScore()));

        return new OccupancyResponse(
                query,
                recommendations,
                recommendations.isEmpty() ? "No desks available matching criteria" : "Desks found"
        );
    }

    private int calculateScore(Desk desk, EmployeePreference empPref) {
        int score = 0;
        // Proximity to marketing team
        if (desk.getZone().equals("Marketing Zone")) {
            score += 50;
        }
        // Near-window preference
        if (empPref.getDeskPreferences().contains("near-window") &&
                desk.getLocationDescription().toLowerCase().contains("window")) {
            score += 30;
        }
        // Equipment match
        score += desk.getFeatures().stream()
                .filter(f -> empPref.getEquipmentNeeds().contains(f))
                .mapToInt(f -> 10)
                .sum();
        return score;
    }
}
