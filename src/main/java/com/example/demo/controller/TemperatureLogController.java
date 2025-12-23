package com.example.demo.controller;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.service.TemperatureLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
@Tag(name = "Temperature Logs")
public class TemperatureLogController {

    private TemperatureLogService service;

    public TemperatureLogController(TemperatureLogService service) {
        this.service = service;
    }

    // POST /api/logs
    @PostMapping("/")
    public TemperatureSensorLog recordLog(@RequestBody TemperatureSensorLog log) {
        return service.recordLog(log);
    }

    // GET /api/logs/shipment/{shipmentId}
    @GetMapping("/shipment/{shipmentId}")
    public List<TemperatureSensorLog> getLogsByShipment(@PathVariable Long shipmentId) {
        return service.getLogsByShipment(shipmentId);
    }

    // GET /api/logs/{id}
    @GetMapping("/{id}")
    public TemperatureSensorLog getLogById(@PathVariable Long id) {
        return service.getLogById(id);
    }

    // GET /api/logs
    @GetMapping("/")
    public List<TemperatureSensorLog> getAllLogs() {
        return service.getAllLogs();
    }
}
