package com.hersafety.hersafety.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hersafety.hersafety.DTO.APIMetrics;
import com.hersafety.hersafety.model.Place;
import com.hersafety.hersafety.model.Report;
import com.hersafety.hersafety.model.ReportReport;
import com.hersafety.hersafety.model.User;
import com.hersafety.hersafety.repository.PlaceRepository;
import com.hersafety.hersafety.repository.ReportReportsRepository;
import com.hersafety.hersafety.repository.ReportRepository;
import com.hersafety.hersafety.repository.UserRepository;

@Service
public class MetricsService {

    UserRepository userRepository;
    PlaceRepository placeRepository;
    ReportRepository reportRepository;
    ReportReportsRepository reportReportsRepository;

    public MetricsService(UserRepository userRepository, PlaceRepository placeRepository,
            ReportRepository reportRepository, ReportReportsRepository reportReportsRepository) {
        this.userRepository = userRepository;
        this.placeRepository = placeRepository;
        this.reportRepository = reportRepository;
        this.reportReportsRepository = reportReportsRepository;
    }

    //Service to colect values from the system
    public APIMetrics platformMetrics() {

        List<User> users = userRepository.findAll();
        List<Place> places = placeRepository.findAll();
        List<Report> reports = reportRepository.findAll();
        List<ReportReport> reportedReports = reportReportsRepository.findAll();

        APIMetrics apiMetrics = new APIMetrics(
            users.size(),
            places.size(),
            reports.size(),
            reportedReports.size()
            );

        return apiMetrics;
    }

}
