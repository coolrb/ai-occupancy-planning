package com.saltmine.ai.occupancy.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AI Occupancy Planning API")
                        .version("1.0.0")
                        .description("API for querying workspace availability using natural language, integrating occupancy data, employee preferences, and organizational policies."));
    }
}
