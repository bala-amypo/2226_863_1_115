package com.example.demo.service;

import com.example.demo.entity.BreachRecord;
import java.util.List;

public interface BreachDetectionService {
    BreachRecord saveBreach(BreachRecord breach);
    List<BreachRecord> getAllBreaches();
}
