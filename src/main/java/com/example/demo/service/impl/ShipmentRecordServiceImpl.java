package com.example.demo.service.impl;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.repository.ShipmentRecordRepository;
import com.example.demo.service.ShipmentRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentRecordServiceImpl implements ShipmentRecordService {

    private ShipmentRecordRepository repository;

    public ShipmentRecordServiceImpl(ShipmentRecordRepository repository) {
        this.repository = repository;
    }

    public ShipmentRecord createShipment(ShipmentRecord shipment) {
        return repository.save(shipment);
    }

    public ShipmentRecord updateShipmentStatus(Long id, String status) {
        ShipmentRecord s = repository.findById(id).orElse(null);
        s.setStatus(status);
        return repository.save(s);
    }

    public ShipmentRecord getShipmentByCode(String code) {
        return repository.findByShipmentCode(code).orElse(null);
    }

    public ShipmentRecord getShipmentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<ShipmentRecord> getAllShipments() {
        return repository.findAll();
    }
}
