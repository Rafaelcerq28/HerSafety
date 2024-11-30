package com.hersafety.hersafety.controller;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.hersafety.hersafety.model.Place;
import com.hersafety.hersafety.service.PlacesService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PlacesController {

    private PlacesService placesService;
    
    public PlacesController(PlacesService placesService){
        this.placesService = placesService;
    }

    //Controller to get a place (this method can create a place by getting from the google maps API)
    @GetMapping("/place/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Place getPlace(@PathVariable(value = "name")String name){
        return placesService.getPlace(name);
    }

    //Controller to get place by place_id
    @GetMapping("/place/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EntityModel<Place> getPlaceById(@PathVariable(value = "id")Long id){
        return placesService.getPlaceById(id);
    }

    //Controller to get a place passing the name as a variable
    //?name=temple+bar
    @GetMapping("/place")
    @ResponseStatus(HttpStatus.OK)
    public Place placeByParam (@RequestParam(value = "name")String name){
        return placesService.getPlace(name);
    }

    //Controller to get all places
    @GetMapping("/places")
    @ResponseStatus(HttpStatus.OK)
    public List<Place> getAllPlaces(){
        return placesService.getAllPlaces();
    }

    //Controller to delete a place passing the place_id
    @DeleteMapping("/place/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deletePlace(@PathVariable(value = "id")Long id){
        return placesService.deletePlace(id);
    }

    //Controller to update a place passing the place_id + place name 
    @PutMapping("/place/{id}")//?name=temple+bar
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Place> updatePlace(@PathVariable(value = "id")Long id, @RequestParam (value = "name")String name){
        return placesService.updatePlace(id,name);
    }
}
