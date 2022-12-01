package com.trackdynamics.service;

import com.trackdynamics.entity.User;
import com.trackdynamics.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{ //controller chama o serviço
    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {   //método para salvar no banco
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> listAllUser() {
        return userRepository.findAll();
    }
}
