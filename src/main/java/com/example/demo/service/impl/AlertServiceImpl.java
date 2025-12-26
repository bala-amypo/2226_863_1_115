package com.example.demo.service.impl;

import com.example.demo.dto.AlertRecordResponseDTO;
import com.example.demo.entity.AlertRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AlertRecordRepository;
import com.example.demo.service.AlertService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertServiceImpl implements AlertService {

    private AlertRecordRepository repository;

    public AlertServiceImpl(AlertRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public void triggerAlert(AlertRecordResponseDTO dto) {
        AlertRecord alert = new AlertRecord();
        alert.setMessage(dto.getMessage());
        alert.setAcknowledged(false);
        repository.save(alert);
    }

    @Override
    public void acknowledgeAlert(Long id) {
        AlertRecord alert = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Alert not found"));

        alert.setAcknowledged(true);
        repository.save(alert);
    }

    @Override
    public AlertRecordResponseDTO getAlertById(Long id) {
        AlertRecord alert = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Alert not found"));

        AlertRecordResponseDTO dto = new AlertRecordResponseDTO();
        dto.setId(alert.getId());
        dto.setMessage(alert.getMessage());
        dto.setAcknowledged(alert.isAcknowledged());
        dto.setCreatedAt(alert.getCreatedAt());
        return dto;
    }

    @Override
    public List<AlertRecordResponseDTO> getAllAlerts() {
        return repository.findAll()
                .stream()
                .map(alert -> {
                    AlertRecordResponseDTO dto = new AlertRecordResponseDTO();
                    dto.setId(alert.getId());
                    dto.setMessage(alert.getMessage());
                    dto.setAcknowledged(alert.isAcknowledged());
                    dto.setCreatedAt(alert.getCreatedAt());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
