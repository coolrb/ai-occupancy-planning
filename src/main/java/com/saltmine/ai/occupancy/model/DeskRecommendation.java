package com.saltmine.ai.occupancy.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Schema(description = "Details of a recommended desk")
@AllArgsConstructor
@NoArgsConstructor
public class DeskRecommendation {
    @Schema(description = "Unique desk identifier", example = "D-301")
    private String deskId;
    @Schema(description = "Area identifier", example = "area-001")
    private String areaId;
    @Schema(description = "Location description", example = "Near window, east corner")
    private String locationDescription;
    @Schema(description = "List of desk features", example = "[\"dual-monitors\", \"ergonomic-chair\", \"adjustable-height\"]")
    private List<String> features;
    @Schema(description = "Recommendation score", example = "90")
    private int score;
}
