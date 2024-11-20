package com.hersafety.hersafety.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hersafety.hersafety.DTO.MessageDTO;
import com.hersafety.hersafety.exception.UserNotFoundException;
import com.hersafety.hersafety.model.Report;
import com.hersafety.hersafety.model.ReportReport;
import com.hersafety.hersafety.repository.ReportReportsRepository;
import com.hersafety.hersafety.repository.ReportRepository;

@Service
public class ReportReportsService {

    ReportReportsRepository reportReportsRepository;
    ReportRepository reportRepository;
    public ReportReportsService(ReportReportsRepository reportReportsRepository, ReportRepository reportRepository) {
        this.reportReportsRepository = reportReportsRepository;
        this.reportRepository = reportRepository;
    }

    public ReportReport createReportsReport(String report, Long reportId,Long placeId, String reportedBy, MessageDTO message) {
        // String report, Long reportId,Long place, String reportedBy,String message
        System.out.println(message);

        Optional<Report> reportComment = reportRepository.findById(reportId);
        if(reportComment.isPresent() == false){
            throw new UserNotFoundException("Place id");
        }
        ReportReport reportReport = new ReportReport(report,reportComment.get(),placeId,reportedBy,message.getMessage());

        reportReport = reportReportsRepository.save(reportReport);

        return reportReport;
    }

    public List<ReportReport> getAllReportsReport() {
        
        List<ReportReport> reportReports = reportReportsRepository.findAll();

        return reportReports;
    }

    public List<ReportReport> getAll() {
        List<ReportReport> reportsList = reportReportsRepository.findAll();
        System.out.println(reportsList.toString());
        return reportsList;
    }

}
