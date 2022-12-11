package com.trackdynamics.controller;

import com.trackdynamics.controller.dto.TaskDTO;
import com.trackdynamics.controller.dto.UserDTO;
import com.trackdynamics.entity.Task;
import com.trackdynamics.entity.User;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public Task convertTaskDTOtoTask(TaskDTO taskDTO){
        return Task.builder()
                .id(taskDTO.getId())
                .title(taskDTO.getTitle())
                .description(taskDTO.getDescription())
                .deadline(taskDTO.getDeadline())
                .dateCreation((taskDTO.getDateCreation()))
                .user(User.builder().id(taskDTO.getIdUser()).build())
                .priority(taskDTO.getPriority())
                .overdue(taskDTO.getOverdue())
                .build();
    }

    public TaskDTO convertTasktoTaskDTO(Task task){
        return TaskDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .deadline(task.getDeadline())
                .dateCreation(task.getDateCreation())
                .idUser((UserDTO.builder().id(task.getUser().getId()).build()).getId())
                .priority(task.getPriority())
                .overdue(task.getOverdue())
                .build();
    }
}
