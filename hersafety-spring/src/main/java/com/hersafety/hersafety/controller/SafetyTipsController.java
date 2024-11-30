package com.hersafety.hersafety.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hersafety.hersafety.service.SafetyTipsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SafetyTipsController {

    private SafetyTipsService safetyTipsService;

    public SafetyTipsController(SafetyTipsService safetyTipsService) {
        this.safetyTipsService = safetyTipsService;
    }

    //controller to get the safety tip
    @GetMapping("/safety/{username}")
    @ResponseStatus(HttpStatus.OK)
    public String getSafetyTips(@PathVariable String username){

        return safetyTipsService.getSafetyTips(username);
    }

}
