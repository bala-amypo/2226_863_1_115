package com.example.demo.controller;

import com.example.demo.dto.BreachRequest;
import com.example.demo.dto.BreachResponse;
import com.example.demo.service.BreachDetectionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/breaches")
@Tag(name = "Breach Records")
public class BreachRecordController {

    private final BreachDetectionService service;

    public BreachRecordController(BreachDetectionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BreachResponse> logManualBreach(
            @RequestBody BreachRequest request) {
        return ResponseEntity.ok(service.logBreach(request));
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<BreachResponse> resolveBreach(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.resolveBreach(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BreachResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getBreachById(id));
    }

    @GetMapping("/shipment/{shipmentId}")
    public ResponseEntity<List<BreachResponse>> getByShipment(
            @PathVariable Long shipmentId) {
        return ResponseEntity.ok(service.getBreachesByShipment(shipmentId));
    }
}
