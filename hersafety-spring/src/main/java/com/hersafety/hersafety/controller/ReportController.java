package com.hersafety.hersafety.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hersafety.hersafety.DTO.ReportRequest;

import com.hersafety.hersafety.service.ReportService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReportController {

    ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    //Post Report
    @PostMapping("/report")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ReportRequest> addReport(@RequestBody ReportRequest report){
        return reportService.addReport(report);
    }

    //GET a List os reports by placeId
    @GetMapping("/report/place/{placeId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ReportRequest> getAllReportsByPlace(@PathVariable (value = "placeId")long placeId){
        return reportService.getAllReportsByPlace(placeId);
    }

    //GET a List os reports by userId
    @GetMapping("/report/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ReportRequest> getAllReportsByUser(@PathVariable (value = "userId")long userId){
        return reportService.getAllReportsByUser(userId);
    }

    //GET All reports
    @GetMapping("/report")
    @ResponseStatus(HttpStatus.OK)
    public List<ReportRequest> getAllReports(){
        return reportService.getAllReports();
    }

    //Get Report by Id
    @GetMapping("/report/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReportRequest getReportById(@PathVariable (value = "id") long id){
        return reportService.getReportById(id);
    }

    //Delete
    @DeleteMapping("/report/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteReport(@PathVariable (value = "id")long id){
        return reportService.deleteReport(id);
    }

    //update
    @PutMapping("/report/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ReportRequest> updateReport(@PathVariable (value = "id") long id, @RequestBody ReportRequest report){
        return reportService.updateReport(id,report);
    }
}
