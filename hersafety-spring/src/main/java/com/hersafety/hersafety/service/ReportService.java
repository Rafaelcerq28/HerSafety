package com.hersafety.hersafety.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hersafety.hersafety.DTO.ReportMetrics;
import com.hersafety.hersafety.DTO.ReportRequest;
import com.hersafety.hersafety.controller.ReportController;
import com.hersafety.hersafety.exception.UserNotFoundException;
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


    //validate the inputs
    //Create report
    public ResponseEntity<ReportRequest> addReport(String username, ReportRequest report) {
        System.out.println(report.toString());
        // Optional<User> user = userRepository.findById(report.getUserId());
        Optional<User> user = userRepository.findByUsername(username);
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

        reportToAdd = reportRepository.save(reportToAdd);
        report.setId(reportToAdd.getId());

        System.out.println(report.toString());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                        path("/{id}").buildAndExpand(report.getId()).toUri();

        return ResponseEntity.created(location).body(report);
    }

    //GET a List os reports by placeId
    public List<ReportRequest> getAllReportsByPlace(long id) {
        List<Report> reports = reportRepository.findByPlaceId(id);
        List<ReportRequest> reportResponse = new ArrayList();

        for (Report report : reports) {
            reportResponse.add(new ReportRequest().convertToDTO(report));
        }
        
        return reportResponse;
    }

    //GET a List os reports by userId
    public List<ReportRequest> getAllReportsByUser(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        if(user.isPresent() == false){
            throw new UserNotFoundException("User: " + username);
        }

        List<Report> reports = reportRepository.findByUserId(user.get().getId());
        List<ReportRequest> reportResponse = new ArrayList();

        for (Report report : reports) {
            reportResponse.add(new ReportRequest().convertToDTO(report));
        }
        
        return reportResponse;
    }

    //GET All reports
    public List<ReportRequest> getAllReports() {
        List<Report> reports = reportRepository.findAll();
        List<ReportRequest> reportResponse = new ArrayList();

        for (Report report : reports) {
            reportResponse.add(new ReportRequest().convertToDTO(report));
        }
        
        return reportResponse;
    }

    //Get Report by Id
    public ReportRequest getReportById(long id) {
        Optional<Report> report = reportRepository.findById(id);
        if(report.isPresent() == false){
            return null;
        }

        return new ReportRequest().convertToDTO(report.get());
    }

    //Delete by id
    public ResponseEntity<Object> deleteReport(long id) {
        Optional<Report> reportToDelete = reportRepository.findById(id);
    
        if(reportToDelete.isPresent() == false){
            return null;
        }

        reportRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


    //validate the inputs
    //upsate report
    public ResponseEntity<ReportRequest> updateReport(long id, ReportRequest report) {
            Optional<Report> reportToUpdate = reportRepository.findById(id);
            
            if(reportToUpdate.isPresent() == false){
                return null;
            }

            reportToUpdate.get().setSafety(report.getSafety());
            reportToUpdate.get().setWelcoming(report.getWelcoming());
            reportToUpdate.get().setToilets(report.getToilets());
            reportToUpdate.get().setFeminineProducts(report.getFeminineProducts());
            reportToUpdate.get().setIllumination(report.getIllumination());
            reportToUpdate.get().setCrowdQuality(report.getCrowdQuality());
            reportToUpdate.get().setPrivacy(report.getPrivacy());
            reportToUpdate.get().setComment(report.getComment());
            reportToUpdate.get().setSafetyInfo(report.getSafetyInfo());

            reportRepository.save(reportToUpdate.get());

            ReportRequest reportRequest = new ReportRequest();

            reportRequest.convertToDTOSelf(reportToUpdate.get());

            return ResponseEntity.ok().body(reportRequest);
    }


    public ReportMetrics getAllReportMetrics(long placeId) {
        //Get the reports in the database
        List<Report> reports = reportRepository.findByPlaceId(placeId);

        //create an object to store the metrics
        ReportMetrics reportMetrics = new ReportMetrics();
       
        //check if exist some reports
        if(reports.isEmpty() == true){
            return null;
        }
        //Variables to store the sum of the reports
        double safetyAvg = 0;
        double welcomingAvg = 0;
        double toiletsAvg = 0;
        double feminineProductsAvg = 0;
        double illuminationAvg = 0;
        double crowdQualityAvg = 0;
        double privacyAvg = 0;
        double safetyInfoAvg = 0;
        double totalReports = 0;

        //iterates the report summing up the values
        for (Report report : reports) {

            safetyAvg += report.getSafety();
            welcomingAvg += report.getWelcoming();
            toiletsAvg += report.getToilets();
            feminineProductsAvg += report.getFeminineProducts();
            illuminationAvg +=  report.getIllumination();
            crowdQualityAvg +=  report.getCrowdQuality();
            privacyAvg +=  report.getPrivacy();
            safetyInfoAvg +=  report.getSafetyInfo();
        }

        //get the average
        totalReports = reports.size();
        safetyAvg = safetyAvg / totalReports;
        welcomingAvg = welcomingAvg / totalReports;
        toiletsAvg = toiletsAvg / totalReports;
        feminineProductsAvg = feminineProductsAvg / totalReports;
        illuminationAvg = illuminationAvg / totalReports;
        crowdQualityAvg = crowdQualityAvg / totalReports;
        privacyAvg = privacyAvg / totalReports;
        safetyInfoAvg = safetyInfoAvg / totalReports;

        //store the average in the object
        reportMetrics.setId(placeId);
        reportMetrics.setSafetyAvg((int)safetyAvg);
        reportMetrics.setWelcomingAvg((int)welcomingAvg);
        reportMetrics.setToiletsAvg((int)toiletsAvg);
        reportMetrics.setFeminineProductsAvg((int)feminineProductsAvg);
        reportMetrics.setIlluminationAvg((int)illuminationAvg);
        reportMetrics.setCrowdQualityAvg((int)crowdQualityAvg);
        reportMetrics.setPrivacyAvg((int)privacyAvg);
        reportMetrics.setSafetyInfoAvg((int)safetyInfoAvg);
        reportMetrics.setTotalReports((int)totalReports);

        return reportMetrics;
    }




}
