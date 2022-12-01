package com.trackdynamics.service;

import com.trackdynamics.entity.Task;
import com.trackdynamics.repository.TaskRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{
    public final TaskRepository taskRepository;

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    @Override
    public Task listAllTasks(Task task) {
        return null;
    }
}
