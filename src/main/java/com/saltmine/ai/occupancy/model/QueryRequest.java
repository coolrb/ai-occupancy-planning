package com.saltmine.ai.occupancy.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class QueryRequest {
    @Schema(description = "Natural language query describing the desired desk", example = "Find me an available standing desk near the marketing team on the 3rd floor for tomorrow afternoon")
    private String query;
}
