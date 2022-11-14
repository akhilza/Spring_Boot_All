package com.akhil.spring_boot_curd.services;

import com.akhil.spring_boot_curd.dto.UserDto;
import com.akhil.spring_boot_curd.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    String saveUser(UserDto userDto);

    User findById(Long id);


    List<User> findAll();

    User updateUser(UserDto userDto);

    String deleteUser(Long id);
}
