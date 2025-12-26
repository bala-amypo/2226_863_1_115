package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.ShipmentRequestDTO;
import com.example.demo.dto.ShipmentResponseDTO;
import com.example.demo.service.ShipmentRecordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
@Tag(name = "Shipments")
public class ShipmentController {

    private ShipmentRecordService service;

    public ShipmentController(ShipmentRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse createShipment(@RequestBody ShipmentRequestDTO dto) {
        service.createShipment(dto);
        return new ApiResponse(true, "Shipment created successfully");
    }

    @GetMapping("/{id}")
    public ShipmentResponseDTO getShipment(@PathVariable Long id) {
        return service.getShipmentById(id);
    }

    @GetMapping
    public List<ShipmentResponseDTO> getAllShipments() {
        return service.getAllShipments();
    }
}
