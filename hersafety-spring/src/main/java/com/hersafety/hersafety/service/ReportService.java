package com.hersafety.hersafety.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hersafety.hersafety.DTO.ReportRequest;
import com.hersafety.hersafety.model.Place;
import com.hersafety.hersafety.model.Report;
import com.hersafety.hersafety.model.User;
import com.hersafety.hersafety.repository.PlaceRepository;
import com.hersafety.hersafety.repository.ReportRepository;
import com.hersafety.hersafety.repository.UserRepository;

@Service
public class ReportService {

    UserRepository userRepository;
    PlaceRepository placeRepository;
    ReportRepository reportRepository;

    public ReportService(UserRepository userRepository, PlaceRepository placeRepository, ReportRepository reportRepository) {
        this.userRepository = userRepository;
        this.placeRepository = placeRepository;
        this.reportRepository = reportRepository;
    }

    public ResponseEntity<Report> addReport(ReportRequest report) {
        Optional<User> user = userRepository.findById(report.getUserId());
        Optional<Place> place = placeRepository.findById(report.getPlaceId());

        if(user.isPresent() == false || place.isPresent() == false){
            return ResponseEntity.badRequest().build();
        }

        Report reportToAdd = new Report();

        reportToAdd.setUser(user.get());
        reportToAdd.setPlace(place.get());
        reportToAdd.setSafety(report.getSafety());
        reportToAdd.setWelcoming(report.getWelcoming());
        reportToAdd.setToilets(report.getToilets());
        reportToAdd.setFeminineProducts(report.getFeminineProducts());
        reportToAdd.setIllumination(report.getIllumination());
        reportToAdd.setCrowdQuality(report.getCrowdQuality());
        reportToAdd.setPrivacy(report.getPrivacy());
        reportToAdd.setSafetyInfo(report.getSafetyInfo());
        reportToAdd.setComment(report.getComment());

        reportRepository.save(reportToAdd);

        return null;
    }

}
