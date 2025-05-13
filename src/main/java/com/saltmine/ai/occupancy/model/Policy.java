package com.saltmine.ai.occupancy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Policy {
    @Id
    private String id;
    private String name;
    private String description;
    private boolean active;
    private String enforcementLevel;
}
