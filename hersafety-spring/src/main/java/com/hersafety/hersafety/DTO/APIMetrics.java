package com.hersafety.hersafety.DTO;

public class APIMetrics {

    private int totalUsers;
    private int totalPlaces;
    private int totalReports;
    private int totalReportedComments;
    
    public APIMetrics(int totalUsers, int totalPlaces, int totalReports, int totalReportedComments) {
        this.totalUsers = totalUsers;
        this.totalPlaces = totalPlaces;
        this.totalReports = totalReports;
        this.totalReportedComments = totalReportedComments;
    }
    
    public APIMetrics() {
    }

    public int getTotalUsers() {
        return totalUsers;
    }
    public void setTotalUsers(int totalUsers) {
        this.totalUsers = totalUsers;
    }
    public int getTotalPlaces() {
        return totalPlaces;
    }
    public void setTotalPlaces(int totalPlaces) {
        this.totalPlaces = totalPlaces;
    }
    public int getTotalReports() {
        return totalReports;
    }
    public void setTotalReports(int totalReports) {
        this.totalReports = totalReports;
    }
    public int getTotalReportedComments() {
        return totalReportedComments;
    }
    public void setTotalReportedComments(int totalReportedComments) {
        this.totalReportedComments = totalReportedComments;
    }

    
}

