package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.BreachRecordResponseDTO;
import com.example.demo.service.BreachDetectionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/breaches")
@Tag(name = "Breach Records")
public class BreachController {

    private BreachDetectionService service;

    public BreachController(BreachDetectionService service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse logBreach(@RequestBody BreachRecordResponseDTO dto) {
        service.logBreach(dto);
        return new ApiResponse(true, "Breach logged");
    }

    @PutMapping("/{id}/resolve")
    public ApiResponse resolveBreach(@PathVariable Long id) {
        service.resolveBreach(id);
        return new ApiResponse(true, "Breach resolved");
    }

    @GetMapping("/{id}")
    public BreachRecordResponseDTO getBreach(@PathVariable Long id) {
        return service.getBreachById(id);
    }

    @GetMapping
    public List<BreachRecordResponseDTO> getAllBreaches() {
        return service.getAllBreaches();
    }
}
