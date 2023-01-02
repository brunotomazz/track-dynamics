package com.trackdynamics.controller;

import com.trackdynamics.controller.dto.TaskDTO;
import com.trackdynamics.entity.Task;
import com.trackdynamics.entity.User;
import com.trackdynamics.exception.RegistryNotFoundException;
import com.trackdynamics.service.TaskService;
import com.trackdynamics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<?> save(@RequestBody TaskDTO taskDTO) throws RegistryNotFoundException {
        try {
            Task task = taskMapper.convertTaskDTOtoTask(taskDTO);
            User user = userService.findById(task.getUser().getId()).orElseThrow(() -> new RegistryNotFoundException("User not found with id " + taskDTO.getIdUser()));
            task.setUser(user);
            task = taskService.saveTask(task);
            return ResponseEntity.of(Optional.of(taskMapper.convertTasktoTaskDTO(task)));
        } catch (RegistryNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTaskById(@PathVariable("id") Integer id) {
        try {
            taskService.deleteTaskById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id + "deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) throws RegistryNotFoundException {
        try {
            Task task = taskService.findById(id).orElseThrow(() -> new RegistryNotFoundException("Task not found with id " + id));
            return ResponseEntity.of(Optional.of(taskMapper.convertTasktoTaskDTO(task)));

        } catch (RegistryNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/list-all")
    public ResponseEntity<?> listAllTasks() {
        List<Task> tasks = taskService.listAllTasks();
        return ResponseEntity.of(Optional.of(tasks.stream()
                .map(taskMapper::convertTasktoTaskDTO)
                .toList()));
    }
}
