package com.saltmine.ai.occupancy.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Occupancy {
    @Id
    private String areaId;
    private String timestamp;
    private int occupancyCount;
    private int occupancyPercentage;
    @ElementCollection
    private Map<String, Integer> forecast = new HashMap<>();
    public Occupancy(String areaId, String timestamp, int occupancyCount, int occupancyPercentage) {
        this.areaId = areaId;
        this.timestamp = timestamp;
        this.occupancyCount = occupancyCount;
        this.occupancyPercentage = occupancyPercentage;
    }
}
