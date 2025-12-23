package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    private TemperatureRuleRepository repository;

    public TemperatureRuleServiceImpl(TemperatureRuleRepository repository) {
        this.repository = repository;
    }

    public TemperatureRule createRule(TemperatureRule rule) {
        return repository.save(rule);
    }

    public TemperatureRule updateRule(Long id, TemperatureRule rule) {
        rule.setId(id);
        return repository.save(rule);
    }

    public List<TemperatureRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    public TemperatureRule getRuleByProductType(String productType) {
        return repository.findByProductType(productType).orElse(null);
    }

    public List<TemperatureRule> getAllRules() {
        return repository.findAll();
    }
}
