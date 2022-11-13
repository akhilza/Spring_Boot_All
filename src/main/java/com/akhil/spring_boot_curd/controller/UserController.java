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
    public ResponseEntity<?> saveUser(@RequestBody User user){
        String saveData = userService.saveUser(user);
        return new ResponseEntity<>(saveData, HttpStatus.CREATED);
    }

    @GetMapping("/id")
    public ResponseEntity<?> findById(@PathVariable Long id){
        User byId = userService.findById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<?> findByName(@PathVariable String name){
        User byName = userService.findByName(name);
        return new ResponseEntity<>(byName, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        List<User> all = userService.findAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        User userUpdate = userService.updateUser(user);
        return new ResponseEntity<>(userUpdate,HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        String deleteUser = userService.deleteUser(id);
        return new ResponseEntity<>(deleteUser,HttpStatus.OK);
    }


}
