package com.trackdynamics.controller;

import com.trackdynamics.controller.dto.UserDTO;
import com.trackdynamics.entity.User;
import com.trackdynamics.exception.RegistryNotFoundException;
import com.trackdynamics.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO) {  //DTO trafega a info do objeto entre camadas do sistema.
        User user = userMapper.convertUserDTOtoUser(userDTO);
            user = userService.saveUser(user);
            log.info("Mostrar user convertido {}", user);
            return ResponseEntity.of(Optional.of(userMapper.convertUsertoUserDTO(user)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Integer id) {
        try {
            userService.deleteUserById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id + "deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) throws RegistryNotFoundException {
        try {
            User user = userService.findById(id).orElseThrow(() -> new RegistryNotFoundException("User not found with id " + id));
            return ResponseEntity.of(Optional.of(userMapper.convertUsertoUserDTO(user)));
        } catch (RegistryNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/list-all")
    public ResponseEntity<?> listAllUser() {
        List<User> users = userService.listAllUser();
//        List<UserDTO> userDTO = new ArrayList<>();//
//        for(User u : user) {
//            userDTO.add(userMapper.convertUsertoUserDTO(u));
//        }
//        return userDTO;
        return ResponseEntity.of(Optional.of(users.stream()
                .map(userMapper::convertUsertoUserDTO)
                .toList()));
    }
}

//GET - recuperar um informação.
//POST - criar um recurso, enviar um comando q contém um corpo.
//PUT - Atualizar um recurso.
//DELETE - deletar recurso.