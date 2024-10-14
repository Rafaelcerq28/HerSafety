package com.hersafety.hersafety.model.mapsResponse;

import java.util.List;

public class PlaceResponse {
    private List<Candidate> candidates;
    private String status;

    // Getters and setters

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
