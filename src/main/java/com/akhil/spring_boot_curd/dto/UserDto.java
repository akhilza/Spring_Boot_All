package com.akhil.spring_boot_curd.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;


public @Data class UserDto implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate dob;
}
