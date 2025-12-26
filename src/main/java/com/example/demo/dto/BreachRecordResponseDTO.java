package com.example.demo.dto;

import java.time.LocalDateTime;

public class BreachRecordResponseDTO {

    private Long id;
    private Double recordedTemperature;
    private LocalDateTime detectedAt;
    private boolean resolved;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getRecordedTemperature() { return recordedTemperature; }
    public void setRecordedTemperature(Double recordedTemperature) { this.recordedTemperature = recordedTemperature; }

    public LocalDateTime getDetectedAt() { return detectedAt; }
    public void setDetectedAt(LocalDateTime detectedAt) { this.detectedAt = detectedAt; }

    public boolean isResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
}
