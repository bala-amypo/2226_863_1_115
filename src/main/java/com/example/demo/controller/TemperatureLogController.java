package com.example.demo.controller;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.service.TemperatureLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class TemperatureLogController {

    private final TemperatureLogService service;

    public TemperatureLogController(TemperatureLogService service) {
        this.service = service;
    }

    @PostMapping
    public TemperatureSensorLog createLog(@RequestBody TemperatureSensorLog log) {
        return service.saveLog(log);
    }

    @GetMapping
    public List<TemperatureSensorLog> getAllLogs() {
        return service.getAllLogs();
    }
}
