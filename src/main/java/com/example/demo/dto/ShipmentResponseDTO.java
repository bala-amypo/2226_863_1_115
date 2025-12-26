package com.example.demo.dto;

public class ShipmentResponseDTO {

    private Long id;
    private String shipmentCode;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getShipmentCode() { return shipmentCode; }
    public void setShipmentCode(String shipmentCode) { this.shipmentCode = shipmentCode; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
