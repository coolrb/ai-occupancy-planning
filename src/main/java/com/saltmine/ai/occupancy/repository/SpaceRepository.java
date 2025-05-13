package com.saltmine.ai.occupancy.repository;

import com.saltmine.ai.occupancy.model.Space;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceRepository extends JpaRepository<Space, String> {
}
