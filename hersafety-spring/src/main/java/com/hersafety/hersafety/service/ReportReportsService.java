package com.hersafety.hersafety.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hersafety.hersafety.model.ReportReport;
import com.hersafety.hersafety.repository.ReportReportsRepository;

@Service
public class ReportReportsService {

    ReportReportsRepository reportReportsRepository;

    public ReportReportsService(ReportReportsRepository reportReportsRepository) {
        this.reportReportsRepository = reportReportsRepository;
    }

    public ReportReport createReportsReport(String report, Long placeId, String reportedBy) {
        ReportReport reportReport = new ReportReport(report,reportedBy,placeId);

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
