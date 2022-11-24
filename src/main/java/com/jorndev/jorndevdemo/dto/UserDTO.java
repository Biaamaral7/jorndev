package com.jorndev.jorndevdemo.dto;


import com.jorndev.jorndevdemo.models.User;
import lombok.Getter;

@Getter
public class UserDTO {

    private String name;
    private String email;
    private String phone;
    private String password;

    public User userObject(){
        return new User(name, email, phone, password);
    }

}
