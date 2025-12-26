package com.example.demo.service;

import com.example.demo.dto.TemperatureLogRequestDTO;
import com.example.demo.dto.TemperatureLogResponseDTO;

import java.util.List;

public interface TemperatureLogService {

    void recordLog(TemperatureLogRequestDTO dto);

    TemperatureLogResponseDTO getLogById(Long id);

    List<TemperatureLogResponseDTO> getLogsByShipment(Long shipmentId);
}
