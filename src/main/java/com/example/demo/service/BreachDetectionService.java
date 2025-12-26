package com.example.demo.service;

import com.example.demo.dto.BreachRecordResponseDTO;

import java.util.List;

public interface BreachDetectionService {

    void logBreach(BreachRecordResponseDTO dto);

    void resolveBreach(Long id);

    BreachRecordResponseDTO getBreachById(Long id);

    List<BreachRecordResponseDTO> getAllBreaches();
}
