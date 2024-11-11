package com.hersafety.hersafety.service;

import java.io.IOException;
//imports to consume API
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hersafety.hersafety.exception.UserNotFoundException;
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

    //GET PLACE (Check this method later, implement filters to thre region)
    public Place getPlace(String name){

        //name = "the+bernard+shaw";//delete after
        String nameToSearch = name.replace("+", " ");
        //search for the place in the database
        Optional<Place> findPlace = placeRepository.findByName(nameToSearch); 
        
        //if the place was found return the place
        if(findPlace.isPresent()){
            Place p = findPlace.get();
            return p;        
        }else{//if the place was'nt found search for it in the maps
            try {      
                //Get location from maps passing the place's name
                name = name.replace(" ", "+");
                String url = "https://maps.googleapis.com/maps/api/place/findplacefromtext/"+
                            "json?input="+name+"&inputtype=textquery&fields=formatted_address"+
                            "%2Cname%2Cgeometry%2Cplace_id%2Ctype&locationbias=country:IE&key=mykey";
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
                
                //create a place and call the method to fill the fields in the place object
                Place place = new Place();
                try{
                    place.fillFields(places);   
                }catch(IndexOutOfBoundsException ex){
                    return null;
                }
                
                //store the place in the database
                placeRepository.save(place);

                return place;

            } catch (JacksonException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return null;
    }

    //Get place by ID
    public EntityModel<Place> getPlaceById(Long id) {
        Optional<Place> place = placeRepository.findById(id);

        if(place.isPresent() == false){
            throw new UserNotFoundException("" + id);
        }

        EntityModel<Place> entityModel = EntityModel.of(place.get());
        return entityModel;

    }

    //Get All places
    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    //Delete Places
    public ResponseEntity<Object> deletePlace(Long id) {
        Optional<Place> place = placeRepository.findById(id);

        if(place.isPresent() == false){
            return ResponseEntity.badRequest().build();
        }

        placeRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    //Update Place
    public ResponseEntity<Place> updatePlace(Long id, String name) {
        Optional<Place> place = placeRepository.findById(id);

        if(place.isPresent() == false){
            return ResponseEntity.badRequest().build();
        }

        place.get().setName(name);

        placeRepository.save(place.get());

        return ResponseEntity.ok().body(place.get());
    }





}
