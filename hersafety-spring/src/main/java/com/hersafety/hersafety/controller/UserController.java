package com.hersafety.hersafety.controller;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hersafety.hersafety.DTO.UserResponse;
import com.hersafety.hersafety.model.User;
import com.hersafety.hersafety.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
/*
GET /users: Retorna a lista de todos os usuários.
GET /users/{id}: Retorna um usuário específico pelo id.
POST /users: Cria um novo usuário.
PUT /users/{id}: Atualiza um usuário existente.
 */

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Create user
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserResponse> createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    //List all users
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    
    //Get a single user by id
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EntityModel<User> getUser(@PathVariable(value = "id")Long id){
        return userService.getUser(id);
    }

    //delete user
    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id")Long id){
        return userService.deleteUser(id);
    }

    //edit user
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> updateUser(@PathVariable(value = "id")Long id, @RequestBody User user){
        return userService.updateUser(id,user);
    }
}
