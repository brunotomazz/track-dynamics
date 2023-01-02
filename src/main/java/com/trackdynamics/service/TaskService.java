package com.trackdynamics.service;

import com.trackdynamics.entity.Task;
import com.trackdynamics.exception.DeleteRegistryException;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task saveTask(Task task);
    void deleteTask(Task task);
    void deleteTaskById(Integer id) throws DeleteRegistryException;
    List<Task> listAllTasks();
    Optional<Task> findById(Integer id);
    void deleteByUserId(Integer id);
}
