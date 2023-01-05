package com.trackdynamics.service;

import com.trackdynamics.entity.Task;
import com.trackdynamics.exception.DeleteRegistryException;
import com.trackdynamics.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
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
    public void deleteTaskById(Integer id) throws DeleteRegistryException {
        try {
            taskRepository.deleteById(id);
        } catch (Exception e) {
            throw new DeleteRegistryException("An error ocurred when trying to delete task with id " + id);
        }
    }

    @Override
    public List<Task> listAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Integer id) {
        return taskRepository.findById(id);
    }

    @Override
    public void deleteByUserId(Integer id) {
        taskRepository.deleteByUserId(id);
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
}
