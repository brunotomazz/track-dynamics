package com.trackdynamics;

import com.trackdynamics.controller.dto.UserDTO;
import com.trackdynamics.entity.User;

public class CreateUser {
    public User createUser(){
        User bruno = User.builder()
                .id(1)
                .name("Bruno")
                .lastName("Tomaz")
                .email("bruno.tomaz@gmail.com")
                .password("123456").build();
        return bruno;
    }

    public UserDTO createUserDTO(){
        UserDTO userDTO = UserDTO.builder()
                .id(2)
                .email("leonardo.costa@gmail.com")
                .name("Leonardo")
                .lastName("da Costa")
                .password("123456")
                .build();
        return userDTO;
    }
}
