package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.TemperatureRuleRequestDTO;
import com.example.demo.dto.TemperatureRuleResponseDTO;
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

    @PostMapping
    public ApiResponse createRule(@RequestBody TemperatureRuleRequestDTO dto) {
        service.createRule(dto);
        return new ApiResponse(true, "Rule created successfully");
    }

    @GetMapping("/active")
    public List<TemperatureRuleResponseDTO> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping("/product/{productType}")
    public TemperatureRuleResponseDTO getRuleByProduct(
            @PathVariable String productType) {
        return service.getRuleByProductType(productType);
    }
}
