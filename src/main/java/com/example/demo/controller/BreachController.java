package com.example.demo.controller;

import com.example.demo.entity.BreachRecord;
import com.example.demo.service.BreachDetectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/breaches")
public class BreachController {

    private  BreachDetectionService service;

    public BreachController(BreachDetectionService service) {
        this.service = service;
    }

    @PostMapping
    public BreachRecord createBreach(@RequestBody BreachRecord breach) {
        return service.saveBreach(breach);
    }

    @GetMapping
    public List<BreachRecord> getAllBreaches() {
        return service.getAllBreaches();
    }
}
