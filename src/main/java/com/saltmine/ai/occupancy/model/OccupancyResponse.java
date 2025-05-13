package com.saltmine.ai.occupancy.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OccupancyResponse {
    private String query;
    private List<DeskRecommendation> recommendations;
    private String message;
}
