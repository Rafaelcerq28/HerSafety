package com.hersafety.hersafety.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hersafety.hersafety.model.Place;
import com.hersafety.hersafety.model.Role;
import com.hersafety.hersafety.model.User;
import com.hersafety.hersafety.repository.PlaceRepository;
import com.hersafety.hersafety.repository.UserRepository;

@Service
public class InitializeService {

    UserRepository userRepository;
    PlaceRepository placeRepository;

    public InitializeService(UserRepository userRepository, PlaceRepository placeRepository) {
        this.userRepository = userRepository;
        this.placeRepository = placeRepository;
    }

    public ResponseEntity<Object> initialize() {
        User u = new User();

        Optional<User> userToCheck = userRepository.findByUsername("admin");

        if(userToCheck.isPresent() == false){
            u.setUsername("admin");
            u.setPassword("admin");
            u.setName("ADMIN");
            u.setEmail("admin@example.com");
            u.setRole(Role.ADMIN);
            u.setActive(true);

            userRepository.save(u);

        }

        Place p = new Place();

        Optional<Place> place = placeRepository.findByName("Temple Bar_test");

        if(place.isPresent() == false){

            p.setName("Temple Bar_test");
            p.setPlaceId("ChIJc-pZtZwOZ0gREjDIGajHACY");
            p.setAddress("Temple Bar, Dublin, Ireland");

            ArrayList<String> types = new ArrayList<>();
            types.add("neighborhood");
            types.add("political");

            p.setTypes(types); 
            p.setLat(53.34548884133697);
            p.setLng(-6.264198665007002);     

            placeRepository.save(p);
        }


        return ResponseEntity.badRequest().build();
    }

/*{
  "id": 0,
  "username": "string",
  "password": "string",
  "name": "string",
  "dateOfBirth": "2024-12-02",
  "email": "string",
  "notifications": true,
  "securityInfo": {
    "id": 0,
    "question1": "string",
    "question2": "string",
    "question3": "string",
    "question4": "string",
    "question5": "string"
  },
  "role": "USER",
  "createdAt": "2024-12-02T23:19:44.374Z",
  "active": true
} */
}
