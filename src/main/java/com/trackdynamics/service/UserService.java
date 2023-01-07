package com.trackdynamics.service;

import com.trackdynamics.entity.User;
import com.trackdynamics.exception.DeleteRegistryException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    void deleteUser(User user);

    void deleteUserById(Integer id) throws DeleteRegistryException;

    List<User> listAllUser();

    Optional<User> findById(Integer id);
}
