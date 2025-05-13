package com.saltmine.ai.occupancy.repository;

import com.saltmine.ai.occupancy.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, String> {
}
