package com.example.demo.service.impl;

import com.example.demo.dto.TemperatureLogRequestDTO;
import com.example.demo.dto.TemperatureLogResponseDTO;
import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.entity.ShipmentRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TemperatureSensorLogRepository;
import com.example.demo.repository.ShipmentRecordRepository;
import com.example.demo.service.TemperatureLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemperatureLogServiceImpl implements TemperatureLogService {

    private TemperatureSensorLogRepository logRepository;
    private ShipmentRecordRepository shipmentRepository;

    public TemperatureLogServiceImpl(
            TemperatureSensorLogRepository logRepository,
            ShipmentRecordRepository shipmentRepository) {
        this.logRepository = logRepository;
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public void recordLog(TemperatureLogRequestDTO dto) {

        ShipmentRecord shipment = shipmentRepository.findById(dto.getShipmentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Shipment not found"));

        TemperatureSensorLog log = new TemperatureSensorLog();
        log.setTemperature(dto.getTemperature());
        log.setLoggedAt(LocalDateTime.now());
        log.setShipment(shipment);

        logRepository.save(log);
    }

    @Override
    public TemperatureLogResponseDTO getLogById(Long id) {
        TemperatureSensorLog log = logRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Log not found"));

        TemperatureLogResponseDTO dto = new TemperatureLogResponseDTO();
        dto.setId(log.getId());
        dto.setTemperature(log.getTemperature());
        dto.setLoggedAt(log.getLoggedAt());
        return dto;
    }

    @Override
    public List<TemperatureLogResponseDTO> getLogsByShipment(Long shipmentId) {
        return logRepository.findByShipmentId(shipmentId)
                .stream()
                .map(log -> {
                    TemperatureLogResponseDTO dto = new TemperatureLogResponseDTO();
                    dto.setId(log.getId());
                    dto.setTemperature(log.getTemperature());
                    dto.setLoggedAt(log.getLoggedAt());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
