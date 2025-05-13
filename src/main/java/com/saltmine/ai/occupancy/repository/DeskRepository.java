package com.saltmine.ai.occupancy.repository;

import com.saltmine.ai.occupancy.model.Desk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeskRepository extends JpaRepository<Desk, String> {
    List<Desk> findByTypeAndFloorAndZoneAndStatus(String type, int floor, String zone, String status);
}
