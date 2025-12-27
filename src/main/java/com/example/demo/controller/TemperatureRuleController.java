package com.example.demo.controller;

import com.example.demo.dto.TemperatureRuleRequest;
import com.example.demo.dto.TemperatureRuleResponse;
import com.example.demo.service.TemperatureRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Temperature Rules")
public class TemperatureRuleController {

    private final TemperatureRuleService service;

    public TemperatureRuleController(TemperatureRuleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TemperatureRuleResponse> createRule(
            @RequestBody TemperatureRuleRequest request) {
        return ResponseEntity.ok(service.createRule(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TemperatureRuleResponse> updateRule(
            @PathVariable Long id,
            @RequestBody TemperatureRuleRequest request) {
        return ResponseEntity.ok(service.updateRule(id, request));
    }

    @GetMapping("/active")
    public ResponseEntity<List<TemperatureRuleResponse>> getActiveRules() {
        return ResponseEntity.ok(service.getActiveRules());
    }

    @GetMapping("/product/{productType}")
    public ResponseEntity<TemperatureRuleResponse> getByProductType(
            @PathVariable String productType) {
        return ResponseEntity.ok(service.getRuleByProductType(productType));
    }
}
