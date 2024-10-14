package com.hersafety.hersafety.model;

import java.util.List;

import com.hersafety.hersafety.model.mapsResponse.PlaceResponse;

public class Place {
    private String address;
    private String name;
    private String placeId;
    private List<String> types;
    private double lat;
    private double lng;

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPlaceId() {
        return placeId;
    }
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }
    public double getLat() {
        return lat;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }
    public double getLng() {
        return lng;
    }
    public void setLng(double lng) {
        this.lng = lng;
    }

    public List<String> getTypes() {
        return types;
    }
    public void setTypes(List<String> types) {
        this.types = types;
    }

    //Method to fill the place using the fields from maps response
    public void fillFields(PlaceResponse placeResponse){
        this.name = placeResponse.getCandidates().get(0).getName();
        this.address = placeResponse.getCandidates().get(0).getFormatted_address();
        this.placeId = placeResponse.getCandidates().get(0).getPlace_id();
        this.lat = placeResponse.getCandidates().get(0).getGeometry().getLocation().getLat();
        this.lng = placeResponse.getCandidates().get(0).getGeometry().getLocation().getLng();
        this.types = placeResponse.getCandidates().get(0).getTypes();
    }


}
