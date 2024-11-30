package com.hersafety.hersafety.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hersafety.hersafety.model.Report;

public interface ReportRepository extends JpaRepository<Report,Long>{
    //Find report by place ID
    List<Report> findByPlaceId(Long placeId);
    //Find report by user ID
    List<Report> findByUserId(Long userId);
}
