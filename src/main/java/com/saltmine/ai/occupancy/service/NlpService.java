package com.saltmine.ai.occupancy.service;


import org.springframework.stereotype.Service;
import com.saltmine.ai.occupancy.model.ParsedQuery;

@Service
class NlpService {
    public ParsedQuery parseQuery(String query) {
        // Simulate OpenAI API response
        return new ParsedQuery("standing", "3rd Floor", "Marketing Zone", "marketing-team", "afternoon");
    }
}
