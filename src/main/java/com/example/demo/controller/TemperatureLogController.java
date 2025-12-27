package com.example.demo.controller;

import com.example.demo.dto.TemperatureLogRequest;
import com.example.demo.dto.TemperatureLogResponse;
import com.example.demo.service.TemperatureLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
@Tag(name = "Temperature Logs")
public class TemperatureLogController {

    private final TemperatureLogService service;

    public TemperatureLogController(TemperatureLogService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TemperatureLogResponse> recordLog(
            @RequestBody TemperatureLogRequest request) {
        return ResponseEntity.ok(service.recordLog(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemperatureLogResponse> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.getLogById(id));
    }

    @GetMapping("/shipment/{shipmentId}")
    public ResponseEntity<List<TemperatureLogResponse>> getByShipment(
            @PathVariable Long shipmentId) {
        return ResponseEntity.ok(service.getLogsByShipment(shipmentId));
    }
}
