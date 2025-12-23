package com.example.demo.controller;

import com.example.demo.entity.AlertRecord;
import com.example.demo.service.AlertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@Tag(name = "Alerts")
public class AlertController {

    private AlertService service;

    public AlertController(AlertService service) {
        this.service = service;
    }

    // POST /api/alerts
    @PostMapping("/")
    public AlertRecord triggerAlert(@RequestBody AlertRecord alert) {
        return service.triggerAlert(alert);
    }

    // PUT /api/alerts/{id}/acknowledge
    @PutMapping("/{id}/acknowledge")
    public AlertRecord acknowledgeAlert(@PathVariable Long id) {
        return service.acknowledgeAlert(id);
    }

    // GET /api/alerts/shipment/{shipmentId}
    @GetMapping("/shipment/{shipmentId}")
    public List<AlertRecord> getAlertsByShipment(@PathVariable Long shipmentId) {
        return service.getAlertsByShipment(shipmentId);
    }

    // GET /api/alerts/{id}
    @GetMapping("/{id}")
    public AlertRecord getAlertById(@PathVariable Long id) {
        return service.getAlertById(id);
    }

    // GET /api/alerts
    @GetMapping("/")
    public List<AlertRecord> getAllAlerts() {
        return service.getAllAlerts();
    }
}
