package com.hersafety.hersafety.model;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="report_reports")
public class ReportReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String report;
    private String reportedBy;
    private Long reportId;
    private Long place;
    private String message;


    @CreationTimestamp
    private Instant createdAt;
    
    public ReportReport() {
    }

    

    public ReportReport(String report, Long reportId,Long place, String reportedBy,String message) {
        this.report = report;
        this.reportedBy = reportedBy;
        this.reportId = reportId;
        this.place = place;
        this.message = message;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
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

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    @Override
    public String toString() {
        return "ReportReport [id=" + id + ", report=" + report + ", reportedBy=" + reportedBy + ", reportId=" + reportId
                + ", place=" + place + ", message=" + message + ", createdAt=" + createdAt + "]";
    }

    
}
