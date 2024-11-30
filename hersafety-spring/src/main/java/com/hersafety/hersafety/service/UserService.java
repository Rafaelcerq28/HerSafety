package com.hersafety.hersafety.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hersafety.hersafety.DTO.UserResponse;
import com.hersafety.hersafety.exception.CustomizedResponseEntityExceptionHandler;
import com.hersafety.hersafety.exception.UnauthorizedException;
import com.hersafety.hersafety.exception.UserNotFoundException;
import com.hersafety.hersafety.model.Role;
import com.hersafety.hersafety.model.SecurityInfo;
import com.hersafety.hersafety.model.User;
import com.hersafety.hersafety.repository.SecurityInfoRepository;
import com.hersafety.hersafety.repository.UserRepository;

@Service                
public class UserService{

    private UserRepository userRepository;
    private SecurityInfoRepository securityInfoRepository;
    public UserService(UserRepository userRepository, SecurityInfoRepository securityInfoRepository) {
        this.userRepository = userRepository;
        this.securityInfoRepository = securityInfoRepository;
    }

    //method to create User
    public ResponseEntity<UserResponse> createUser(User user){
        user.setRole(Role.USER);
        user.setActive(true);

        User savedUser = userRepository.save(user);

        UserResponse userResponse = new UserResponse(
            savedUser.getUsername(), 
            savedUser.getName(), 
            savedUser.getDateOfBirth(), 
            savedUser.getEmail(), savedUser.getNotifications(), 
            savedUser.getCreatedAt(), 
            savedUser.getRole(),
            savedUser.isActive());

        //generating user url
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                        path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).body(userResponse);
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

    //Method to update the security info
    public ResponseEntity<SecurityInfo> updateSecurityInfo(String username, SecurityInfo securityInfo) {

        Optional<User> userToUpdate = userRepository.findByUsername(username);
        SecurityInfo securityInfoToUpdate = new SecurityInfo();

        if(userToUpdate.isPresent() == false){
            throw new UserNotFoundException("User: " + username);
        }

        if(userToUpdate.get().getSecurityInfo() == null){

            userToUpdate.get().setSecurityInfo(securityInfo);

            userRepository.save(userToUpdate.get());
            
            return ResponseEntity.ok().body(userToUpdate.get().getSecurityInfo());

        }else{

            securityInfoToUpdate = userToUpdate.get().getSecurityInfo();

            securityInfoToUpdate.setQuestion1(securityInfo.getQuestion1());
            securityInfoToUpdate.setQuestion2(securityInfo.getQuestion2());
            securityInfoToUpdate.setQuestion3(securityInfo.getQuestion3());
            securityInfoToUpdate.setQuestion4(securityInfo.getQuestion4());
            securityInfoToUpdate.setQuestion5(securityInfo.getQuestion5());

            securityInfoRepository.save(securityInfoToUpdate);

            return ResponseEntity.ok().body(userToUpdate.get().getSecurityInfo()); 
        }

    }

    //Mehtod to get the security info
    public ResponseEntity<SecurityInfo> getSecurityInfo(String username) {
        Optional<User> userToGet = userRepository.findByUsername(username);

        if(userToGet.isPresent() == false){
            throw new UserNotFoundException("User: " + username);
        }

        if(userToGet.get().getSecurityInfo() == null){
            return ResponseEntity.noContent().build();
        }else{
            SecurityInfo securityInfo = new SecurityInfo();
            securityInfo = userToGet.get().getSecurityInfo();
    
            return ResponseEntity.ok().body(securityInfo);
        }

    }

    //Method to update the status
    public boolean updateActiveStatus(String username) {
        Optional<User> userToUpdate = userRepository.findByUsername(username);
        
        if(userToUpdate.isPresent() == false){
            throw new UserNotFoundException(username);
        }

        if(userToUpdate.get().getRole() == Role.ADMIN){
            throw new UnauthorizedException("Denied");
        }

        userToUpdate.get().setActive(!userToUpdate.get().isActive());

        User userToReturn = userRepository.save(userToUpdate.get());

        return userToReturn.isActive();
    }

}
