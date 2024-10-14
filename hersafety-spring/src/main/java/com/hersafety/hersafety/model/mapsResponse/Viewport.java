package com.hersafety.hersafety.model.mapsResponse;

public class Viewport {
    private Northeast northeast;
    private Southwest southwest;

    // Getters and setters

    public Northeast getNortheast() {
        return northeast;
    }

    public void setNortheast(Northeast northeast) {
        this.northeast = northeast;
    }

    public Southwest getSouthwest() {
        return southwest;
    }

    public void setSouthwest(Southwest southwest) {
        this.southwest = southwest;
    }
}
