package com.hersafety.hersafety.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.hersafety.hersafety.model.Place;

import com.hersafety.hersafety.service.PlacesService;

@RestController
public class PlacesController {

    PlacesService placesService;
    public PlacesController(PlacesService placesService){
        this.placesService = placesService;
    }

    @GetMapping("/place")
    @ResponseStatus(HttpStatus.OK)
    public Place place(){//ajustar para passar o nome do lugar
        System.out.println("chamado");
        return placesService.getPlace();
    }


}
