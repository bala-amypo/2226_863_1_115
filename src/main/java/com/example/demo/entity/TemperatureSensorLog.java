package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "temperature_sensor_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TemperatureSensorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;
    private Double temperatureValue;
    private LocalDateTime recordedAt;
    private String location;
}
