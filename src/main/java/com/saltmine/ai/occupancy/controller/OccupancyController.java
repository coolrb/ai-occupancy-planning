package com.saltmine.ai.occupancy.controller;

import com.saltmine.ai.occupancy.model.OccupancyResponse;
import com.saltmine.ai.occupancy.model.QueryRequest;
import com.saltmine.ai.occupancy.service.OccupancyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/occupancy")
class OccupancyController {
    private final OccupancyService occupancyService;

    public OccupancyController(OccupancyService occupancyService) {
        this.occupancyService = occupancyService;
    }

    @PostMapping("/query")
    public OccupancyResponse findDesk(@RequestBody QueryRequest request) {
        return occupancyService.findAvailableDesks(request.getQuery());
    }
}
