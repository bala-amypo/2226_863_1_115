package com.example.demo.service;

import com.example.demo.entity.ShipmentRecord;
import java.util.List;

public interface ShipmentRecordService {

    ShipmentRecord createShipment(ShipmentRecord shipment);

    ShipmentRecord updateShipmentStatus(Long id, String status);

    ShipmentRecord getShipmentByCode(String shipmentCode);

    ShipmentRecord getShipmentById(Long id);

    List<ShipmentRecord> getAllShipments();
}
