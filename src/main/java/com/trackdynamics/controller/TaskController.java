package com.trackdynamics.controller;

import com.trackdynamics.controller.dto.TaskDTO;
import com.trackdynamics.entity.Task;
import com.trackdynamics.entity.User;
import com.trackdynamics.service.TaskService;
import com.trackdynamics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private UserService userService;

    @PostMapping
    public TaskDTO save(@RequestBody TaskDTO taskDTO) {
        Task task = taskMapper.convertTaskDTOtoTask(taskDTO);
        User user = userService.findById(task.getUser().getId());
        if (user != null) {
            task.setUser(user);
            task = taskService.saveTask(task);
            return taskMapper.convertTasktoTaskDTO(task);
        }
        System.out.println("User not found!");
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable("id") Integer id){
        taskService.deleteTaskById(id);
    }

    @GetMapping("/{id}")
    public TaskDTO findById(@PathVariable("id") Integer id){
        Task task = taskService.findById(id);
        return taskMapper.convertTasktoTaskDTO(task);
    }

    @GetMapping("/list-all")
    public List<TaskDTO> listAllTasks() {
        List<Task> tasks = taskService.listAllTasks();
        return tasks.stream()
                .map(taskMapper::convertTasktoTaskDTO)
                .toList();
    }


}
