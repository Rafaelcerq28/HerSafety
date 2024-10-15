package com.hersafety.hersafety.DTO;

import com.hersafety.hersafety.model.Report;

public class ReportRequest {
/* 
    {
        "userId": 2,
        "placeId":1,
        "safety": 4,
        "welcoming": 5,
        "toilets": 3,
        "feminineProducts": 2,
        "illumination": 4,
        "crowdQuality": 3,
        "privacy": 4,
        "safetyInfo": 5,
        "comment": "O lugar é seguro, mas poderia melhorar na oferta de produtos femininos."
      }
  */     
    private int safety;
    private int welcoming;
    private int toilets;
    private int feminineProducts;
    private int illumination;
    private int crowdQuality;
    private int privacy;
    private int safetyInfo;
    private String comment;

    private long userId;
    private long placeId;
    
    public int getSafety() {
        return safety;
    }
    public void setSafety(int safety) {
        this.safety = safety;
    }
    public int getWelcoming() {
        return welcoming;
    }
    public void setWelcoming(int welcoming) {
        this.welcoming = welcoming;
    }
    public int getToilets() {
        return toilets;
    }
    public void setToilets(int toilets) {
        this.toilets = toilets;
    }
    public int getFeminineProducts() {
        return feminineProducts;
    }
    public void setFeminineProducts(int feminineProducts) {
        this.feminineProducts = feminineProducts;
    }
    public int getIllumination() {
        return illumination;
    }
    public void setIllumination(int illumination) {
        this.illumination = illumination;
    }
    public int getCrowdQuality() {
        return crowdQuality;
    }
    public void setCrowdQuality(int crowdQuality) {
        this.crowdQuality = crowdQuality;
    }
    public int getPrivacy() {
        return privacy;
    }
    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }
    public int getSafetyInfo() {
        return safetyInfo;
    }
    public void setSafetyInfo(int safetyInfo) {
        this.safetyInfo = safetyInfo;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public long getPlaceId() {
        return placeId;
    }
    public void setPlaceId(long placeId) {
        this.placeId = placeId;
    }

    public ReportRequest convertToDTO(Report report){
        ReportRequest dto = new ReportRequest();

        dto.setUserId(report.getUser().getId());
        dto.setPlaceId(report.getPlace().getId());
        dto.setSafety(report.getSafety());
        dto.setWelcoming(report.getWelcoming());
        dto.setToilets(report.getToilets());
        dto.setFeminineProducts(report.getFeminineProducts());
        dto.setIllumination(report.getIllumination());
        dto.setCrowdQuality(report.getCrowdQuality());
        dto.setPrivacy(report.getPrivacy());
        dto.setSafetyInfo(report.getSafetyInfo());
        dto.setComment(report.getComment());

        return dto;
    }
}
