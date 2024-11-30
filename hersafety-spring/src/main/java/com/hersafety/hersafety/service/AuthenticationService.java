package com.hersafety.hersafety.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hersafety.hersafety.DTO.UserResponse;
import com.hersafety.hersafety.exception.UserNotFoundException;
import com.hersafety.hersafety.model.User;
import com.hersafety.hersafety.repository.UserRepository;
import com.hersafety.hersafety.security.UserAuthentication;

@Service
public class AuthenticationService {

    private UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Method to authenticate the user returning a UserResponse (DTO)
    public UserResponse login(UserAuthentication user) {

        //Get the user from the database and check if it was found, if not throw a userNot Found exception
        Optional<User> userToLogin = userRepository.findByUsername(user.getUsername());

        if(userToLogin.isPresent() == false){
            throw new UserNotFoundException("User: " + user.getUsername());
        }else if((userToLogin.get().getUsername().equals(user.getUsername()) == false) || (userToLogin.get().getPassword().equals(user.getPassword()) == false)){
            throw new UserNotFoundException("User: " + user.getUsername());
        }

        //check if the user is banned or not
        if(userToLogin.get().isActive() == false){
            throw new UserNotFoundException("User: " + user.getUsername() + "Banned");
        }
        
        //Creating the user response
        UserResponse userResponse = new UserResponse();

        userResponse.setName(userToLogin.get().getName());
        userResponse.setUsername(userToLogin.get().getUsername());
        userResponse.setDateOfBirth(userToLogin.get().getDateOfBirth());
        userResponse.setEmail(userToLogin.get().getEmail());
        userResponse.setCreatedAt(userToLogin.get().getCreatedAt());
        userResponse.setRole(userToLogin.get().getRole());
        return userResponse;
    }

    //logout method
    public ResponseEntity<?> logout(UserAuthentication user){
        return ResponseEntity.noContent().build();
    }

}
