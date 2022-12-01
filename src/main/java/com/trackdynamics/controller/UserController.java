package com.trackdynamics.controller;

import com.trackdynamics.controller.dto.UserDTO;
import com.trackdynamics.entity.User;
import com.trackdynamics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public UserDTO save(@RequestBody UserDTO userDTO){  //DTO trafega a info do objeto entre camadas do sistema.
        User user = userMapper.convertUserDTOtoUser(userDTO);
        user = userService.saveUser(user);
        UserDTO userDTOConverted = userMapper.convertUsertoUserDTO(user);
        return userDTOConverted;
    }
}


//GET - recuperar um informação.
//POST - criar um recurso, enviar um comando q contém um corpo.
//PUT - Atualizar um recurso.
//DELETE - deletar recurso.