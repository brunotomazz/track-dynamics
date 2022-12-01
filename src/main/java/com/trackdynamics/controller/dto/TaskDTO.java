package com.trackdynamics.controller.dto;

import com.trackdynamics.entity.User;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class TaskDTO {
    private Integer id;
    private String title;
    private String description;
    private LocalDate deadline;
    private LocalDateTime dateCreation;
    private Integer idUser;
    private String priority;
    private Boolean overdue;
}
