package com.trackdynamics.service;

import com.trackdynamics.entity.Task;

public interface TaskService {
    Task saveTask(Task task);
    void deleteTask(Task task);
    Task listAllTasks(Task task);
}
