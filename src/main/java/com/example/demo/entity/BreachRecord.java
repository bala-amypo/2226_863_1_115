package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "breaches")
public class BreachRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double recordedTemperature;
    private LocalDateTime detectedAt;
    private boolean resolved;

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private ShipmentRecord shipment;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getRecordedTemperature() { return recordedTemperature; }
    public void setRecordedTemperature(Double recordedTemperature) { this.recordedTemperature = recordedTemperature; }

    public LocalDateTime getDetectedAt() { return detectedAt; }
    public void setDetectedAt(LocalDateTime detectedAt) { this.detectedAt = detectedAt; }

    public boolean isResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }

    public ShipmentRecord getShipment() { return shipment; }
    public void setShipment(ShipmentRecord shipment) { this.shipment = shipment; }
}
