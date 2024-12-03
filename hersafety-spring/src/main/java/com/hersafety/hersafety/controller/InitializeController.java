package com.hersafety.hersafety.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hersafety.hersafety.service.InitializeService;

@RestController
public class InitializeController {

    InitializeService initializeService;

    public InitializeController(InitializeService initializeService) {
        this.initializeService = initializeService;
    }

    @GetMapping("/initialize")
    public ResponseEntity<Object> initialize(){
        return initializeService.initialize();
    }
}
