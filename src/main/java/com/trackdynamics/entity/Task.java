package com.trackdynamics.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private LocalDate deadline;
    @Column(name = "date_creation")
    private LocalDateTime dateCreation;
    @ManyToOne
    @JoinColumn(name = "id_user",referencedColumnName = "id",nullable = false) //junção com outra tabela(chave estrangeira)
    private User user;
    @Column
    private String priority;
    @Column
    private Boolean overdue;
}
