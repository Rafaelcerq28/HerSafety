package com.hersafety.hersafety.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hersafety.hersafety.model.Report;

public interface ReportRepository extends JpaRepository<Report,Long>{

}
