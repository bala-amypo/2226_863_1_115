package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "temperature_rules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TemperatureRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productType;
    private Double minTemp;
    private Double maxTemp;
    private boolean active;

    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
}
