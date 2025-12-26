package com.example.demo.service.impl;

import com.example.demo.dto.ShipmentRequestDTO;
import com.example.demo.dto.ShipmentResponseDTO;
import com.example.demo.entity.ShipmentRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ShipmentRecordRepository;
import com.example.demo.service.ShipmentRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipmentRecordServiceImpl implements ShipmentRecordService {

    private ShipmentRecordRepository repository;

    public ShipmentRecordServiceImpl(ShipmentRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShipmentResponseDTO createShipment(ShipmentRequestDTO dto) {

        ShipmentRecord record = new ShipmentRecord();
        record.setShipmentCode(dto.getShipmentCode());
        record.setOrigin(dto.getOrigin());
        record.setDestination(dto.getDestination());
        record.setStatus("CREATED");

        ShipmentRecord saved = repository.save(record);

        return mapToDTO(saved);
    }

    @Override
    public ShipmentResponseDTO getShipmentById(Long id) {
        ShipmentRecord record = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Shipment not found"));

        return mapToDTO(record);
    }

    @Override
    public List<ShipmentResponseDTO> getAllShipments() {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ShipmentResponseDTO mapToDTO(ShipmentRecord record) {
        ShipmentResponseDTO dto = new ShipmentResponseDTO();
        dto.setId(record.getId());
        dto.setShipmentCode(record.getShipmentCode());
        dto.setStatus(record.getStatus());
        return dto;
    }
}
