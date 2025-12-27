package com.example.demo.controller;

import com.example.demo.dto.ShipmentRequest;
import com.example.demo.dto.ShipmentResponse;
import com.example.demo.service.ShipmentRecordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shipments")
@Tag(name = "Shipments")
public class ShipmentRecordController {

    private final ShipmentRecordService service;

    public ShipmentRecordController(ShipmentRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ShipmentResponse> createShipment(
            @RequestBody ShipmentRequest request) {
        return ResponseEntity.ok(service.createShipment(request));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ShipmentResponse> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(service.updateShipmentStatus(id, status));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShipmentResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getShipmentById(id));
    }

    @GetMapping("/code/{shipmentCode}")
    public ResponseEntity<ShipmentResponse> getByCode(
            @PathVariable String shipmentCode) {
        return ResponseEntity.ok(service.getShipmentByCode(shipmentCode));
    }
}
