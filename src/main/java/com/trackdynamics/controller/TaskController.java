package com.trackdynamics.controller;

import com.trackdynamics.controller.dto.TaskDTO;
import com.trackdynamics.entity.Task;
import com.trackdynamics.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskMapper taskMapper;

    @PostMapping
    public TaskDTO save(@RequestBody TaskDTO taskDTO){
        Task task = taskMapper.convertTaskDTOtoTask(taskDTO);
        task = taskService.saveTask(task);
        return taskMapper.convertTasktoTaskDTO(task);
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
}
