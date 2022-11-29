package com.trackdynamics.service;

import com.trackdynamics.entity.User;

public interface UserService {
   User saveUser(User user);
   void deleteUser(User user);
   User listAll(User user);
}
