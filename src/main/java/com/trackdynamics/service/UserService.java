package com.trackdynamics.service;

import com.trackdynamics.entity.User;

import java.util.List;

public interface UserService {
   User saveUser(User user);
   void deleteUser(User user);
   List<User> listAllUser();
}
