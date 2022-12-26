package com.trackdynamics.controller;

import com.trackdynamics.CreateUser;
import com.trackdynamics.controller.dto.UserDTO;
import com.trackdynamics.entity.User;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;

public class UserMapperTest {

    private CreateUser createUser = new CreateUser();
    private UserMapper userMapper = new UserMapper();

    @Test
    void testConvertUsertoUserDTO(){
        User bruno = createUser.createUser();
        UserDTO brunoConverted = userMapper.convertUsertoUserDTO(bruno);
        System.out.println(brunoConverted);

        assertThat(bruno.getId()).isEqualTo(brunoConverted.getId());
        assertThat(bruno.getName()).isEqualTo(brunoConverted.getName());
        assertThat(bruno.getLastName()).isEqualTo(brunoConverted.getLastName());
        assertThat(bruno.getEmail()).isEqualTo(brunoConverted.getEmail());
        assertThat(bruno.getPassword()).isEqualTo(brunoConverted.getPassword());
    }

    @Test
    void testConvertUserDTOtoUser(){
        UserDTO bruno = createUser.createUserDTO();
        User brunoConverted = userMapper.convertUserDTOtoUser(bruno);
        System.out.println(brunoConverted);

        assertThat(bruno.getId()).isEqualTo(brunoConverted.getId());
        assertThat(bruno.getName()).isEqualTo(brunoConverted.getName());
        assertThat(bruno.getLastName()).isEqualTo(brunoConverted.getLastName());
        assertThat(bruno.getEmail()).isEqualTo(brunoConverted.getEmail());
        assertThat(bruno.getPassword()).isEqualTo(brunoConverted.getPassword());
    }
}
