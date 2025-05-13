package com.saltmine.ai.occupancy.repository;

import com.saltmine.ai.occupancy.model.Occupancy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OccupancyRepository extends JpaRepository<Occupancy, String> {
    Optional<Occupancy> findByAreaId(String areaId);
}
