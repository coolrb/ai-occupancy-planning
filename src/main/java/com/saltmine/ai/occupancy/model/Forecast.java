package com.saltmine.ai.occupancy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Forecast {
    private Map<String, Integer> nextDay = new HashMap<>();
}
