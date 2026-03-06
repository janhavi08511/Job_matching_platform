package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDTO {
    private String fullName;
    private String email;
    private String password;
    private Integer experience;
    private String skills;
    private String preferredRole;

}
