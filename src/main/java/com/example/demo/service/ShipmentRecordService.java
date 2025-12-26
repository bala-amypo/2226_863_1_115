package com.example.demo.service;

import com.example.demo.dto.ShipmentRequestDTO;
import com.example.demo.dto.ShipmentResponseDTO;

import java.util.List;

public interface ShipmentRecordService {

    ShipmentResponseDTO createShipment(ShipmentRequestDTO dto);

    ShipmentResponseDTO getShipmentById(Long id);

    List<ShipmentResponseDTO> getAllShipments();
}
