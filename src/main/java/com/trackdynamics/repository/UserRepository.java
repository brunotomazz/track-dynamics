package com.trackdynamics.repository;

import com.trackdynamics.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Integer> {
}
