package com.trackdynamics.repository;

import com.trackdynamics.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository <Task,Integer> {
}
