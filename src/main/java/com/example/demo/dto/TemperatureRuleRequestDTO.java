package com.example.demo.dto;

public class TemperatureRuleRequestDTO {

    private String productType;
    private Double minTemp;
    private Double maxTemp;
    private boolean active;

    public String getProductType() { return productType; }
    public void setProductType(String productType) { this.productType = productType; }

    public Double getMinTemp() { return minTemp; }
    public void setMinTemp(Double minTemp) { this.minTemp = minTemp; }

    public Double getMaxTemp() { return maxTemp; }
    public void setMaxTemp(Double maxTemp) { this.maxTemp = maxTemp; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
