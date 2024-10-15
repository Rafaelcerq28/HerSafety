package com.hersafety.hersafety.model;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int safety;
    private int welcoming;
    private int toilets;
    private int feminineProducts;
    private int illumination;
    private int crowdQuality;
    private int privacy;
    private int safetyInfo;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;

    @CreationTimestamp
    private Instant createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Report [id=" + id + ", safety=" + safety + ", welcoming=" + welcoming + ", toilets=" + toilets
                + ", feminineProducts=" + feminineProducts + ", illumination=" + illumination + ", crowdQuality="
                + crowdQuality + ", privacy=" + privacy + ", safetyInfo=" + safetyInfo + ", comment=" + comment
                + ", user=" + user + ", place=" + place + ", createdAt=" + createdAt + "]";
    }

    

}
