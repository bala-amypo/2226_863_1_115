package com.example.demo.service;

import com.example.demo.entity.ShipmentRecord;
import java.util.List;

public interface ShipmentRecordService {
    ShipmentRecord saveShipment(ShipmentRecord shipment);
    List<ShipmentRecord> getAllShipments();
}
