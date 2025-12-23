package com.example.demo.controller;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Temperature Rules")
public class TemperatureRuleController {

    private TemperatureRuleService service;

    public TemperatureRuleController(TemperatureRuleService service) {
        this.service = service;
    }

    @PostMapping("/")
    public TemperatureRule createRule(@RequestBody TemperatureRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public TemperatureRule updateRule(@PathVariable Long id,
                                      @RequestBody TemperatureRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<TemperatureRule> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping("/product/{productType}")
    public TemperatureRule getRuleByProduct(@PathVariable String productType) {
        return service.getRuleByProductType(productType);
    }

    @GetMapping("/")
    public List<TemperatureRule> getAllRules() {
        return service.getAllRules();
    }
}
