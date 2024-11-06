package com.hersafety.hersafety.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hersafety.hersafety.DTO.UserResponse;
import com.hersafety.hersafety.model.User;
import com.hersafety.hersafety.repository.AuthenticationService;
import com.hersafety.hersafety.security.UserAuthentication;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthenticationControler {

    private AuthenticationService authenticationService;

    public AuthenticationControler(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public UserResponse Login(@RequestBody UserAuthentication user){
        System.out.println("user no controller " + user.getUsername());
        return authenticationService.login(user);
    }

    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> logout(@RequestBody UserAuthentication user){
        return authenticationService.logout(user);
    }
}
