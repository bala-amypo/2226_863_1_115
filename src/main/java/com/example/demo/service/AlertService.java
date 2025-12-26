package com.example.demo.service;

import com.example.demo.dto.AlertRecordResponseDTO;

import java.util.List;

public interface AlertService {

    void triggerAlert(AlertRecordResponseDTO dto);

    void acknowledgeAlert(Long id);

    AlertRecordResponseDTO getAlertById(Long id);

    List<AlertRecordResponseDTO> getAllAlerts();
}
