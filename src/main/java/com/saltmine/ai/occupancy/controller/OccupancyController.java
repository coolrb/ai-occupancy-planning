package com.saltmine.ai.occupancy.controller;

import com.saltmine.ai.occupancy.model.OccupancyResponse;
import com.saltmine.ai.occupancy.model.QueryRequest;
import com.saltmine.ai.occupancy.service.OccupancyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/occupancy")
@Tag(name = "Occupancy API", description = "API for querying workspace availability")
class OccupancyController {
    private final OccupancyService occupancyService;

    @Autowired
    public OccupancyController(OccupancyService occupancyService) {
        this.occupancyService = occupancyService;
    }

    @PostMapping("/query")
    @Operation(
            summary = "Find available desks",
            description = "Processes a natural language query to find available desks matching criteria such as desk type, location, and time, considering employee preferences and organizational policies.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful response with desk recommendations",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = OccupancyResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid query format",
                            content = @Content
                    )
            }
    )
    public OccupancyResponse findDesk(@RequestBody QueryRequest request) {
        return occupancyService.findAvailableDesks(request.getQuery());
    }
}
