package com.trackdynamics.controller;

import com.trackdynamics.controller.dto.UserDTO;
import com.trackdynamics.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping
    public UserDTO save(@RequestBody UserDTO userDTO){

    }
}


//GET - recuperar um informação.
//POST - criar um recurso, enviar um comando q contém um corpo.
//PUT - Atualizar um recurso.
//DELETE - deletar recurso.