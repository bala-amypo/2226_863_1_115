package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "temperature_logs")
public class TemperatureSensorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double temperature;
    private LocalDateTime loggedAt;

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private ShipmentRecord shipment;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }

    public LocalDateTime getLoggedAt() { return loggedAt; }
    public void setLoggedAt(LocalDateTime loggedAt) { this.loggedAt = loggedAt; }

    public ShipmentRecord getShipment() { return shipment; }
    public void setShipment(ShipmentRecord shipment) { this.shipment = shipment; }
}
