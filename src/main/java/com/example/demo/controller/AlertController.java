package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.AlertRecordResponseDTO;
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

    @PostMapping
    public ApiResponse triggerAlert(@RequestBody AlertRecordResponseDTO dto) {
        service.triggerAlert(dto);
        return new ApiResponse(true, "Alert triggered");
    }

    @PutMapping("/{id}/acknowledge")
    public ApiResponse acknowledge(@PathVariable Long id) {
        service.acknowledgeAlert(id);
        return new ApiResponse(true, "Alert acknowledged");
    }

    @GetMapping("/{id}")
    public AlertRecordResponseDTO getAlert(@PathVariable Long id) {
        return service.getAlertById(id);
    }

    @GetMapping
    public List<AlertRecordResponseDTO> getAllAlerts() {
        return service.getAllAlerts();
    }
}
