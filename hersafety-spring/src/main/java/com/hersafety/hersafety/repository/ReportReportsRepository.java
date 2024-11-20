package com.hersafety.hersafety.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hersafety.hersafety.model.Report;
import com.hersafety.hersafety.model.ReportReport;

import jakarta.transaction.Transactional;

public interface ReportReportsRepository extends JpaRepository<ReportReport,Long>{
    @Modifying
    @Transactional
    @Query("DELETE FROM ReportReport r WHERE r.report.id = :reportId")
    void deleteByReportId(@Param("reportId") Long reportId);

    // Option using query native
    // @Query(value = "DELETE FROM report_reports WHERE Report_id = :reportId", nativeQuery = true)
    // void deleteByReportId(@Param("reportId") Long reportId);
}
