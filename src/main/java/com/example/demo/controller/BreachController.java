package com.example.demo.controller;

import com.example.demo.entity.BreachRecord;
import com.example.demo.service.BreachDetectionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/breaches")
@Tag(name = "Breach Records")
public class BreachController {

    private BreachDetectionService service;

    public BreachController(BreachDetectionService service) {
        this.service = service;
    }

    @PostMapping("/")
    public BreachRecord logBreach(@RequestBody BreachRecord breach) {
        return service.logBreach(breach);
    }

    @PutMapping("/{id}/resolve")
    public BreachRecord resolveBreach(@PathVariable Long id) {
        return service.resolveBreach(id);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<BreachRecord> getBreachesByShipment(@PathVariable Long shipmentId) {
        return service.getBreachesByShipment(shipmentId);
    }

    @GetMapping("/{id}")
    public BreachRecord getBreachById(@PathVariable Long id) {
        return service.getBreachById(id);
    }

    @GetMapping("/")
    public List<BreachRecord> getAllBreaches() {
        return service.getAllBreaches();
    }
}
