package com.trackdynamics.service;

import com.trackdynamics.entity.User;
import com.trackdynamics.exception.DeleteRegistryException;
import com.trackdynamics.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService { //controller chama o serviço
    private final UserRepository userRepository;
    private final TaskService taskService;

    @Override
    public User saveUser(User user) {   //método para salvar no banco
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUserById(Integer id) throws DeleteRegistryException {
        try {
            taskService.deleteByUserId(id);
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new DeleteRegistryException("An error ocurred when trying to delete user with id " + id);
        }
    }

    @Override
    public List<User> listAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
