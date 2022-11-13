package com.akhil.spring_boot_curd.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "first_id", nullable = false)
    private Long first_id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate dob;


    public User() {
    }
}
