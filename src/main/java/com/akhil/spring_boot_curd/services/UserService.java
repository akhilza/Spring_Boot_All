package com.akhil.spring_boot_curd.services;

import com.akhil.spring_boot_curd.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    String saveUser(User user);

    User findById(Long id);

    User findByName(String name);

    List<User> findAll();

    User updateUser(User user);

    String deleteUser(Long id);
}
