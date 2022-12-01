package com.trackdynamics.service;

import com.trackdynamics.entity.Task;

import java.util.List;

public interface TaskService {
    Task saveTask(Task task);
    void deleteTask(Task task);
    List<Task> listAllTasks();
}
