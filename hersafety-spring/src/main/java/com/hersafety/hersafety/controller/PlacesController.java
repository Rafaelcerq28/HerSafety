package com.hersafety.hersafety.controller;

import java.io.IOException;
//imports to consume API
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hersafety.hersafety.model.Place;
import com.hersafety.hersafety.model.mapsResponse.PlaceResponse;

@RestController
public class PlacesController {

    @GetMapping("/places")
    @ResponseStatus(HttpStatus.OK)
    public String places(){
        String hello = "hello modafoca";
        return hello;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Place test(){
        //REFATORAR E CRIAR ALGUNS METODOS PARA ISSO ALEM DE MOVER PARA A SERVICE

        try {       
            //Getting location from maps 
            String url = "https://maps.googleapis.com/maps/api/place/findplacefromtext/"+
                        "json?input=the+bernard+shaw&inputtype=textquery&fields=formatted_address"+
                        "%2Cname%2Cgeometry%2Cplace_id&key=MYKEY";
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
