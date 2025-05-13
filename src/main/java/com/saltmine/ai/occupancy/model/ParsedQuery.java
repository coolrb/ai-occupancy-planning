package com.saltmine.ai.occupancy.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import jakarta.persistence.Id;

import java.sql.Time;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class ParsedQuery {
    @Id
    private String deskType;
    private String floor;
    private String zone;
    private String teamProximity;
    private String period;

}
