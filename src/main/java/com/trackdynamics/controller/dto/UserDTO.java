package com.trackdynamics.controller.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class UserDTO {
    private Integer id;
    private String name;
    private String lastName;
    private String password;
    private String email;

}
