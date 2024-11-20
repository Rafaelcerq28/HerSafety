package com.hersafety.hersafety.model;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="report_reports")
public class ReportReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Report_id", nullable = false)
    private Report report;

    private String reportType;
    private String reportedBy;
    // private Long reportId;
    private Long place;
    private String message;


    @CreationTimestamp
    private Instant createdAt;
    
    public ReportReport() {
    }

    public ReportReport(String reportType, Report report,Long place, String reportedBy,String message) {
        this.reportType = reportType;
        this.reportedBy = reportedBy;
        this.report = report;
        this.place = place;
        this.message = message;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getPlace() {
        return place;
    }

    public void setPlace(Long place) {
        this.place = place;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Report getReport() {
        return report;
    }



    public void setReport(Report report) {
        this.report = report;
    }



    public String getReportType() {
        return reportType;
    }



    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    
}
