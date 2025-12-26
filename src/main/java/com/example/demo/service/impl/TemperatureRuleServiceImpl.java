package com.example.demo.service.impl;

import com.example.demo.dto.TemperatureRuleRequestDTO;
import com.example.demo.dto.TemperatureRuleResponseDTO;
import com.example.demo.entity.TemperatureRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    private TemperatureRuleRepository repository;

    public TemperatureRuleServiceImpl(TemperatureRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createRule(TemperatureRuleRequestDTO dto) {

        TemperatureRule rule = new TemperatureRule();
        rule.setProductType(dto.getProductType());
        rule.setMinTemp(dto.getMinTemp());
        rule.setMaxTemp(dto.getMaxTemp());
        rule.setActive(dto.isActive());

        repository.save(rule);
    }

    @Override
    public List<TemperatureRuleResponseDTO> getActiveRules() {
        return repository.findByActiveTrue()
                .stream()
                .map(rule -> {
                    TemperatureRuleResponseDTO dto = new TemperatureRuleResponseDTO();
                    dto.setId(rule.getId());
                    dto.setProductType(rule.getProductType());
                    dto.setMinTemp(rule.getMinTemp());
                    dto.setMaxTemp(rule.getMaxTemp());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public TemperatureRuleResponseDTO getRuleByProductType(String productType) {
        TemperatureRule rule = repository.findByProductType(productType)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rule not found"));

        TemperatureRuleResponseDTO dto = new TemperatureRuleResponseDTO();
        dto.setId(rule.getId());
        dto.setProductType(rule.getProductType());
        dto.setMinTemp(rule.getMinTemp());
        dto.setMaxTemp(rule.getMaxTemp());
        return dto;
    }
}
