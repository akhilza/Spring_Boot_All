package com.akhil.spring_boot_curd.controller;

import com.akhil.spring_boot_curd.dto.UserDto;
import com.akhil.spring_boot_curd.entity.User;
import com.akhil.spring_boot_curd.services.UserService;
import com.akhil.spring_boot_curd.services.impl.UserServicesImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto){
        String saveData = userService.saveUser(userDto);
        return new ResponseEntity<>(saveData, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id){
        User byId = userService.findById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll(){
        List<User> all = userService.findAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody UserDto userDto){
        User user = userService.updateUser(userDto);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        String deleteUser = userService.deleteUser(id);
        return new ResponseEntity<>(deleteUser,HttpStatus.FORBIDDEN);
    }


}
