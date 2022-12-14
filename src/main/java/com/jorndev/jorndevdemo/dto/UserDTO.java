package com.jorndev.jorndevdemo.dto;


import com.jorndev.jorndevdemo.models.User;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class UserDTO {

    @NotBlank(message = "{name.not.blank}")
    private String name;
    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.not.valid}")
    private String email;
    @NotBlank(message = "{phone.not.blank}")
    private String phone;
    @NotBlank(message = "{password.not.blank}")
    private String password;

    public User userObject(){
        return new User(name, email, phone, password);
    }

}
