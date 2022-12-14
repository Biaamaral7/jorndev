package com.jorndev.jorndevdemo.controllers;


import com.jorndev.jorndevdemo.dto.UserDTO;
import com.jorndev.jorndevdemo.dto.UserResponseDTO;
import com.jorndev.jorndevdemo.models.User;
import com.jorndev.jorndevdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserDTO userdto) {
        User user = userService.createUser(userdto.userObject());
        return new ResponseEntity<>(UserResponseDTO.userObject(user), HttpStatus.CREATED);
    }

}
