package com.hersafety.hersafety.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.hateoas.EntityModel;
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

    //List all user
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Get one user
    public EntityModel<User> getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent() == false){
            return null;
        }

        EntityModel<User> entityModel = EntityModel.of(user.get());

        return entityModel;
    }

    //Delete User
    public ResponseEntity<Object> deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        
        //insert an exception here
        if(user.isPresent() == false){
            return ResponseEntity.badRequest().build();
        }

        userRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    //Update user
    public ResponseEntity<User> updateUser(Long id, User user) {
        Optional<User> userToUpdate = userRepository.findById(id);
        if(userToUpdate.isPresent() == false){
            return ResponseEntity.badRequest().build();
        }

        userToUpdate.get().setName(user.getName());
        userToUpdate.get().setEmail(user.getEmail());
        userToUpdate.get().setDateOfBirth(user.getDateOfBirth());
        userToUpdate.get().setNotifications(user.getNotifications());
        userToUpdate.get().setPassword(user.getPassword());

        User updatedUser = userRepository.save(userToUpdate.get());
        
        return ResponseEntity.ok().body(updatedUser);
    }

}
