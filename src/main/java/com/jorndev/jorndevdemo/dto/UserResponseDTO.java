package com.jorndev.jorndevdemo.dto;

import com.jorndev.jorndevdemo.models.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserResponseDTO {

    private int id;
    private String name;
    private String email;
    private String phone;
    private boolean admin;

    public static UserResponseDTO userObject (User user)
    {
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.isAdmin());
    }

}
