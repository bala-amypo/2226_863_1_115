package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.TemperatureLogRequestDTO;
import com.example.demo.dto.TemperatureLogResponseDTO;
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

    @PostMapping
    public ApiResponse recordLog(@RequestBody TemperatureLogRequestDTO dto) {
        service.recordLog(dto);
        return new ApiResponse(true, "Temperature log recorded");
    }

    @GetMapping("/{id}")
    public TemperatureLogResponseDTO getLog(@PathVariable Long id) {
        return service.getLogById(id);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<TemperatureLogResponseDTO> getLogsByShipment(
            @PathVariable Long shipmentId) {
        return service.getLogsByShipment(shipmentId);
    }
}
