package com.example.demo.service;

import com.example.demo.entity.AlertRecord;
import java.util.List;

public interface AlertService {
    AlertRecord saveAlert(AlertRecord alert);
    List<AlertRecord> getAllAlerts();
}
