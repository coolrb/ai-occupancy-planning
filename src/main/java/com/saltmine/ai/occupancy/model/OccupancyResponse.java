package com.saltmine.ai.occupancy.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Response containing desk recommendations")
public class OccupancyResponse {
    @Schema(description = "Original query", example = "Find me an available standing desk near the marketing team on the 3rd floor for tomorrow afternoon")
    private String query;
    @Schema(description = "List of recommended desks")
    private List<DeskRecommendation> recommendations;
    @Schema(description = "Response message", example = "Desks found")
    private String message;
}
