package com.hersafety.hersafety.service;

import java.io.IOException;
//imports to consume API
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hersafety.hersafety.model.Place;
import com.hersafety.hersafety.model.User;
import com.hersafety.hersafety.model.mapsResponse.PlaceResponse;
import com.hersafety.hersafety.repository.PlaceRepository;
import com.hersafety.hersafety.repository.UserRepository;

@Service
public class PlacesService {

    UserRepository userRepository;
    PlaceRepository placeRepository;

    public PlacesService(UserRepository userRepository, PlaceRepository placeRepository) {
        this.userRepository = userRepository;
        this.placeRepository = placeRepository;
    }

    //GET PLACE
    public Place getPlace(String name){

        //name = "the+bernard+shaw";//delete after
        String nameToSearch = name.replace("+", " ");
        //search for the place in the database
        Optional<Place> findPlace = placeRepository.findByName(nameToSearch); 

        //if the place was found return the place
        if(findPlace.isPresent()){
            Place p = findPlace.get();
            return p;
        //if the place was'nt found search for it in the maps
        }else{
            try {      
                //Get location from maps passing the place's name
                String url = "https://maps.googleapis.com/maps/api/place/findplacefromtext/"+
                            "json?input="+name+"&inputtype=textquery&fields=formatted_address"+
                            "%2Cname%2Cgeometry%2Cplace_id%2Ctype&key=key";
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
                System.out.println(places.getStatus());
                
                //create a place and call the method to fill the fields in the place object
                Place place = new Place();
                place.fillFields(places);
                //store the place in the database
                placeRepository.save(place);

                return place;

            } catch (JacksonException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch(IOException ex){

            }
        }
        return null;
    }

    //just test, delete
    public String testUser(){
        
        User u = new User();
        u.setName("fulaninho");
        userRepository.save(u);
        return "";
    }

}
