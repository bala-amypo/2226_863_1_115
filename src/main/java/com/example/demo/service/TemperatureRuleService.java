package com.example.demo.service;

import com.example.demo.dto.TemperatureRuleRequestDTO;
import com.example.demo.dto.TemperatureRuleResponseDTO;

import java.util.List;

public interface TemperatureRuleService {

    void createRule(TemperatureRuleRequestDTO dto);

    List<TemperatureRuleResponseDTO> getActiveRules();

    TemperatureRuleResponseDTO getRuleByProductType(String productType);
}
