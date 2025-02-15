package com.hersafety.hersafety.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
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

    //method to report a comment
    public ReportReport createReportsReport(String report, Long reportId,Long placeId, String reportedBy, MessageDTO message) {

        //search for the comment using the ID
        Optional<Report> reportComment = reportRepository.findById(reportId);
        if(reportComment.isPresent() == false){
            throw new UserNotFoundException("Place id");
        }

        ReportReport reportReport = new ReportReport(report,reportComment.get(),placeId,message.getPlaceName(),reportedBy,message.getMessage());

        reportReport = reportReportsRepository.save(reportReport);

        return reportReport;
    }

    //Get all reported comments
    public List<ReportReport> getAllReportsReport() {
        
        List<ReportReport> reportReports = reportReportsRepository.findAll();

        return reportReports;
    }

    //Get all reported comments
    public List<ReportReport> getAll() {
        List<ReportReport> reportsList = reportReportsRepository.findAll();
        return reportsList;
    }

    //method to delete a report
    public ResponseEntity<Object> deleteReportedComment(Long reportId) {
        try{
            Optional<ReportReport> report = reportReportsRepository.findById(reportId);

            if(report.isPresent() == false){
                throw new UserNotFoundException("Report ID " + reportId + "Not found");
            }
            reportReportsRepository.deleteByReportId(report.get().getReport().getId());

        }catch(Exception e){
            throw new UserNotFoundException("Report ID " + reportId + "Not found");
        }
        return ResponseEntity.noContent().build();
    }

}
