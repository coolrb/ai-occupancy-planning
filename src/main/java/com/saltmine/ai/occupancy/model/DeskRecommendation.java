package com.saltmine.ai.occupancy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeskRecommendation {
    private String deskId;
    private String areaId;
    private String locationDescription;
    private List<String> features;
    private int score;
}
