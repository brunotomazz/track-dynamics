package com.trackdynamics.service;

import com.trackdynamics.entity.Task;
import com.trackdynamics.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;


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
    public List<Task> listAllTasks(){
        return taskRepository.findAll();
    }
}
