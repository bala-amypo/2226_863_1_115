package com.example.demo.service;

import com.example.demo.entity.AlertRecord;
import java.util.List;

public interface AlertService {

    AlertRecord triggerAlert(AlertRecord alert);

    AlertRecord acknowledgeAlert(Long id);

    AlertRecord getAlertById(Long id);

    List<AlertRecord> getAlertsByShipment(Long shipmentId);

    List<AlertRecord> getAllAlerts();
}
package com.example.demo.service;

import com.example.demo.entity.AlertRecord;
import java.util.List;

public interface AlertService {

    AlertRecord createAlert(AlertRecord alert);

    List<AlertRecord> getAlertsByShipment(Long shipmentId);
}
