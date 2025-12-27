package com.example.demo.controller;

import com.example.demo.dto.AlertRequest;
import com.example.demo.dto.AlertResponse;
import com.example.demo.service.AlertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@Tag(name = "Alerts")
public class AlertRecordController {

    private final AlertService service;

    public AlertRecordController(AlertService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AlertResponse> triggerAlert(
            @RequestBody AlertRequest request) {
        return ResponseEntity.ok(service.triggerAlert(request));
    }

    @PutMapping("/{id}/acknowledge")
    public ResponseEntity<AlertResponse> acknowledge(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.acknowledgeAlert(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAlertById(id));
    }

    @GetMapping("/shipment/{shipmentId}")
    public ResponseEntity<List<AlertResponse>> getByShipment(
            @PathVariable Long shipmentId) {
        return ResponseEntity.ok(service.getAlertsByShipment(shipmentId));
    }
}
