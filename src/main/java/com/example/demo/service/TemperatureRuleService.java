package com.example.demo.service;

import com.example.demo.entity.TemperatureRule;
import java.util.List;

public interface TemperatureRuleService {

    TemperatureRule createRule(TemperatureRule rule);

    TemperatureRule updateRule(Long id, TemperatureRule rule);

    List<TemperatureRule> getActiveRules();

    TemperatureRule getRuleByProductType(String productType);

    List<TemperatureRule> getAllRules();
}
