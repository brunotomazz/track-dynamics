package com.trackdynamics.service;

import com.trackdynamics.entity.Task;
import com.trackdynamics.entity.User;
import com.trackdynamics.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{
    public final TaskRepository taskRepository;
    public final UserService userService;

    @Override
    public Task saveTask(Task task) {
        User user = userService.findById(task.getUser().getId());
        if (user != null){
            task.setUser(user);
            return taskRepository.save(task);
        }
        System.out.println("User not found!");
        return null;
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    @Override
    public void deleteTaskById(Integer id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> listAllTasks(){
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }
}
