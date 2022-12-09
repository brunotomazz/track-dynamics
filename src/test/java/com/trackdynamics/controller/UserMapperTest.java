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
    }

    @Test
    void testConvertUserDTOtoUser(){
        UserDTO bruno = createUser.createUserDTO();
        User brunoConverted = userMapper.convertUserDTOtoUser(bruno);
        System.out.println(brunoConverted);

        Assertions.assertEquals(createUser.createUser(), brunoConverted);
    }
}
