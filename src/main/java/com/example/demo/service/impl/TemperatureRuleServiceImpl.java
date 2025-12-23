package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    private final TemperatureRuleRepository repo;

    public TemperatureRuleServiceImpl(TemperatureRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public TemperatureRule createRule(TemperatureRule rule) {
        if (rule.getMinTemp() >= rule.getMaxTemp()) {
            throw new IllegalArgumentException("minTemp must be less than maxTemp");
        }
        return repo.save(rule);
    }

    @Override
    public List<TemperatureRule> getAllRules() {
        return repo.findAll();
    }
}
