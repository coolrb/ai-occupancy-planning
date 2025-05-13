package com.saltmine.ai.occupancy.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePreference {
    @Id
    private String employeeId;
    private String team;
    @ElementCollection
    private List<String> deskPreferences;
    @ElementCollection
    private List<String> equipmentNeeds;
    private String preferredLocation;
    @ElementCollection
    private List<String> adjacencyPreferences;
}
