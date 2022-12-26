package com.trackdynamics.controller;

import com.trackdynamics.controller.dto.UserDTO;
import com.trackdynamics.entity.User;
import com.trackdynamics.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public UserDTO save(@RequestBody UserDTO userDTO){  //DTO trafega a info do objeto entre camadas do sistema.
        User user = userMapper.convertUserDTOtoUser(userDTO);
        user = userService.saveUser(user);
        log.info("Mostrar user convertido {}", user);
        return userMapper.convertUsertoUserDTO(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable("id") Integer id) {
        User user = userService.findById(id);
        return userMapper.convertUsertoUserDTO(user);
    }
}


//GET - recuperar um informação.
//POST - criar um recurso, enviar um comando q contém um corpo.
//PUT - Atualizar um recurso.
//DELETE - deletar recurso.