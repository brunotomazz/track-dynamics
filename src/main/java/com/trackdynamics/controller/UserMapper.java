package com.trackdynamics.controller;

import com.trackdynamics.controller.dto.UserDTO;
import com.trackdynamics.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User convertUserDTOtoUser(UserDTO userDTO){
        User user = User.builder()
                .id(userDTO.getId())
                .email(userDTO.getEmail())
                .name(userDTO.getName())
                .lastName(userDTO.getLastName())
                .password(userDTO.getPassword())
                .build();
        return user;
    }
    public UserDTO convertUsertoUserDTO(User user){
        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .build();
        return userDTO;
    }


}
