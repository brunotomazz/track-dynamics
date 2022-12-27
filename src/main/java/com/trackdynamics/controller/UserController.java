package com.trackdynamics.controller;

import com.trackdynamics.controller.dto.UserDTO;
import com.trackdynamics.entity.User;
import com.trackdynamics.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/list-all")
    public List<UserDTO> listAllUser() {
        List<User> users = userService.listAllUser();
//        List<UserDTO> userDTO = new ArrayList<>();//
//        for(User u : user) {
//            userDTO.add(userMapper.convertUsertoUserDTO(u));
//        }
//        return userDTO;
        return users.stream()
                .map(userMapper::convertUsertoUserDTO)
                .toList();
    }
}

//GET - recuperar um informação.
//POST - criar um recurso, enviar um comando q contém um corpo.
//PUT - Atualizar um recurso.
//DELETE - deletar recurso.