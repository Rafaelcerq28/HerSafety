package com.hersafety.hersafety.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hersafety.hersafety.DTO.ReportRequest;
import com.hersafety.hersafety.model.Report;
import com.hersafety.hersafety.service.ReportService;

@RestController
public class ReportController {

    ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    //Post Report
    @PostMapping("/report")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Report> addReport(@RequestBody ReportRequest report){
        return reportService.addReport(report);
    }

}
