package com.hersafety.hersafety.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hersafety.hersafety.DTO.MessageDTO;
import com.hersafety.hersafety.model.ReportReport;
import com.hersafety.hersafety.service.ReportReportsService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReportReportsController {

    ReportReportsService reportReportsService;

    public ReportReportsController(ReportReportsService reportReportsService) {
        this.reportReportsService = reportReportsService;
    }

    //TUDO ERRADO NESSE METODO, MAPEAR PARA PEGAR O COMENTARIO TAMBEM
    @PostMapping("/report/denounce/{report}/{reportId}/{placeId}/{reportedBy}")
    @ResponseStatus(HttpStatus.OK)
    public ReportReport createReportsReport(@PathVariable String report, @PathVariable Long placeId, @PathVariable String reportedBy,@PathVariable Long reportId, @RequestBody MessageDTO message){
        System.out.println(message);
        return reportReportsService.createReportsReport(report,reportId,placeId,reportedBy,message);
    }

    @GetMapping("/report/denounce/{report}/{placeId}/{reportedBy}")
    @ResponseStatus(HttpStatus.OK)
    public List<ReportReport> getAllReportsReport(){
        return reportReportsService.getAllReportsReport();
    }

    @GetMapping("report/reported-reports")
    @ResponseStatus(HttpStatus.OK)
    public List<ReportReport> getAll(){
        return reportReportsService.getAll();
    }

    @DeleteMapping("report/delete-reported/{reportId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteReportedComment(@PathVariable Long reportId){
        System.out.println("chamado");
        return reportReportsService.deleteReportedComment(reportId);
    }
}
