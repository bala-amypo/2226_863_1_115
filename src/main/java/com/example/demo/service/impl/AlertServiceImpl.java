package com.example.demo.service.impl;

import com.example.demo.entity.AlertRecord;
import com.example.demo.repository.AlertRecordRepository;
import com.example.demo.service.AlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {

    private  AlertRecordRepository repo;

    public AlertServiceImpl(AlertRecordRepository repo) {
        this.repo = repo;
    }

    public AlertRecord saveAlert(AlertRecord alert) {
        return repo.save(alert);
    }

    public List<AlertRecord> getAllAlerts() {
        return repo.findAll();
    }
}
