package com.trackdynamics.controller;

import com.trackdynamics.controller.dto.TaskDTO;
import com.trackdynamics.entity.Task;
import com.trackdynamics.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        TaskDTO taskDTOConverted = taskMapper.convertTasktoTaskDTO(task);
        return taskDTOConverted;
    }
}
