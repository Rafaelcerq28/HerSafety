package com.hersafety.hersafety.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.hersafety.hersafety.model.Place;
import com.hersafety.hersafety.service.PlacesService;

@RestController
public class PlacesController {

    private PlacesService placesService;
    public PlacesController(PlacesService placesService){
        this.placesService = placesService;
    }

    //Method to get a place (this method can create a place by getting from the google maps API)
    @GetMapping("/place/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Place place(@PathVariable(value = "name")String name){
        System.out.println("chamado");
        return placesService.getPlace(name);
    }

    @GetMapping("/place")//?name=temple+bar
    @ResponseStatus(HttpStatus.OK)
    public Place placeByParam (@RequestParam(value = "name")String name){
        System.out.println("chamado");
        return placesService.getPlace(name);
    }
    //just test, delete
    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String testUser(){
        placesService.testUser();
        return "";
    }

}
