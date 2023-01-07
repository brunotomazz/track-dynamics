package com.trackdynamics.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    @Size(min = 2, max = 80, message = "name must be between 2 and 80 charachters")
    @NotNull(message = "name can not be null")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String password;
    @Column
    private String email;
}
