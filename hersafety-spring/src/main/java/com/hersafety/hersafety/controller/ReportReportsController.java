package com.hersafety.hersafety.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import com.hersafety.hersafety.model.ReportReport;
import com.hersafety.hersafety.service.ReportReportsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReportReportsController {

    ReportReportsService reportReportsService;

    public ReportReportsController(ReportReportsService reportReportsService) {
        this.reportReportsService = reportReportsService;
    }

    @PostMapping("/report/denounce/{report}/{placeId}/{reportedBy}")
    @ResponseStatus(HttpStatus.OK)
    public ReportReport createReportsReport(@PathVariable String report, @PathVariable Long placeId, @PathVariable String reportedBy){
        return reportReportsService.createReportsReport(report,placeId,reportedBy);
    }

    @GetMapping("/report/denounce/{report}/{placeId}/{reportedBy}")
    @ResponseStatus(HttpStatus.OK)
    public List<ReportReport> getAllReportsReport(){
        return reportReportsService.getAllReportsReport();
    }
}
