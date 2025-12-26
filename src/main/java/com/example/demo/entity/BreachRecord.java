package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "breach_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BreachRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;
    private Long logId;
    private Double breachValue;
    private String severity;
    private boolean resolved;

    @PrePersist
    public void prePersist() {
        resolved = false;
    }
}
