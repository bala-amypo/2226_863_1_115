package com.example.demo.service.impl;

import com.example.demo.entity.BreachRecord;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreachDetectionServiceImpl implements BreachDetectionService {

    private BreachRecordRepository repository;

    public BreachDetectionServiceImpl(BreachRecordRepository repository) {
        this.repository = repository;
    }

    public BreachRecord logBreach(BreachRecord breach) {
        return repository.save(breach);
    }

    public BreachRecord resolveBreach(Long id) {
        BreachRecord breach = repository.findById(id).orElse(null);
        breach.setResolved(true);
        return repository.save(breach);
    }

    public BreachRecord getBreachById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<BreachRecord> getBreachesByShipment(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    public List<BreachRecord> getAllBreaches() {
        return repository.findAll();
    }
}
