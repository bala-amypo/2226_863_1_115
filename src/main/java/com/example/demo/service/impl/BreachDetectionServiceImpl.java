package com.example.demo.service.impl;

import com.example.demo.dto.BreachRecordResponseDTO;
import com.example.demo.entity.BreachRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BreachDetectionServiceImpl implements BreachDetectionService {

    private BreachRecordRepository repository;

    public BreachDetectionServiceImpl(BreachRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public void logBreach(BreachRecordResponseDTO dto) {
        BreachRecord breach = new BreachRecord();
        breach.setRecordedTemperature(dto.getRecordedTemperature());
        breach.setResolved(false);
        repository.save(breach);
    }

    @Override
    public void resolveBreach(Long id) {
        BreachRecord breach = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Breach not found"));

        breach.setResolved(true);
        repository.save(breach);
    }

    @Override
    public BreachRecordResponseDTO getBreachById(Long id) {
        BreachRecord breach = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Breach not found"));

        BreachRecordResponseDTO dto = new BreachRecordResponseDTO();
        dto.setId(breach.getId());
        dto.setRecordedTemperature(breach.getRecordedTemperature());
        dto.setDetectedAt(breach.getDetectedAt());
        dto.setResolved(breach.isResolved());
        return dto;
    }

    @Override
    public List<BreachRecordResponseDTO> getAllBreaches() {
        return repository.findAll()
                .stream()
                .map(breach -> {
                    BreachRecordResponseDTO dto = new BreachRecordResponseDTO();
                    dto.setId(breach.getId());
                    dto.setRecordedTemperature(breach.getRecordedTemperature());
                    dto.setDetectedAt(breach.getDetectedAt());
                    dto.setResolved(breach.isResolved());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
