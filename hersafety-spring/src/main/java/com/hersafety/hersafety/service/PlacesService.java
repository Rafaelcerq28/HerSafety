package com.hersafety.hersafety.service;

import java.io.IOException;
//imports to consume API
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hersafety.hersafety.model.Place;
import com.hersafety.hersafety.model.mapsResponse.PlaceResponse;

@Service
public class PlacesService {
    
    //temporary
    public Place getPlace(){
        try {       
            //Getting location from maps 
            String url = "https://maps.googleapis.com/maps/api/place/findplacefromtext/"+
                        "json?input=the+bernard+shaw&inputtype=textquery&fields=formatted_address"+
                        "%2Cname%2Cgeometry%2Cplace_id%2Ctype&key=AIzaSyCCoF7TuazSQC7PlFsjwAxPE7wdAhrrVFU";
            URI address = URI.create(url);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(address).GET().build();     
            HttpResponse<String> response;
            response = client.send(request, BodyHandlers.ofString());
            String body = response.body();

            //using jackson to convert Json in an Java object
            String jsonString = body;
            ObjectMapper mapper = new ObjectMapper();
            PlaceResponse places = mapper.readValue(jsonString, PlaceResponse.class);
            //

            Place place = new Place();
            //call the method to fill the fields in the place object
            place.fillFields(places);

            return place;

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
