package com.hersafety.hersafety.service;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hersafety.hersafety.model.User;
import com.hersafety.hersafety.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //method to create User
    public ResponseEntity<User> createUser(User user){
        //search user in the database
        User savedUser = userRepository.save(user);
        //generating user uri
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                        path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).body(savedUser);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
