package com.example.demo.dto;

public class TemperatureLogRequestDTO {

    private Long shipmentId;
    private Double temperature;

    public Long getShipmentId() { return shipmentId; }
    public void setShipmentId(Long shipmentId) { this.shipmentId = shipmentId; }

    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }
}
