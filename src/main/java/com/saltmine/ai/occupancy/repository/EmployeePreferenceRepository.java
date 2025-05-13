package com.saltmine.ai.occupancy.repository;

import com.saltmine.ai.occupancy.model.EmployeePreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePreferenceRepository extends JpaRepository<EmployeePreference, String> {
}
