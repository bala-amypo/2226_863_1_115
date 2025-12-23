package com.example.demo.controller;

import com.example.demo.entity.AlertRecord;
import com.example.demo.service.AlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertController {

    private  AlertService service;

    public AlertController(AlertService service) {
        this.service = service;
    }

    @PostMapping
    public AlertRecord createAlert(@RequestBody AlertRecord alert) {
        return service.saveAlert(alert);
    }

    @GetMapping
    public List<AlertRecord> getAllAlerts() {
        return service.getAllAlerts();
    }
}
