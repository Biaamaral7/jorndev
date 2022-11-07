package com.jorndev.jorndevdemo.controllers;


import com.jorndev.jorndevdemo.models.User;
import com.jorndev.jorndevdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserDTO userdto) {
        userService.saveUser(userdto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
