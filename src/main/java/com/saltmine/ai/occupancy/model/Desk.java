package com.saltmine.ai.occupancy.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Desk {
    @Id
    private String id;
    private String type;
    private String areaId;
    private int floor;
    private String zone;
    private String status;
    @ElementCollection
    private List<String> features;
    private String locationDescription;
}
