package com.hersafety.hersafety.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hersafety.hersafety.DTO.APIMetrics;
import com.hersafety.hersafety.service.MetricsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MetricsController {

    MetricsService metricsService;

    public MetricsController(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    //Controller to get system information, such as the amount of users, places stored and reports
    @GetMapping("/metrics")
    @ResponseStatus(HttpStatus.OK)
    public APIMetrics platformMetrics(){
        return metricsService.platformMetrics();
    }
}
