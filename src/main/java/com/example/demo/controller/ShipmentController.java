package com.example.demo.controller;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.service.ShipmentRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentRecordService service;

    public ShipmentController(ShipmentRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ShipmentRecord createShipment(@RequestBody ShipmentRecord shipment) {
        return service.createShipment(shipment);
    }

    @GetMapping
    public List<ShipmentRecord> getAllShipments() {
        return service.getAllShipments();
    }
}
