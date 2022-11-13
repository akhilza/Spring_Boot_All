package com.akhil.spring_boot_curd.services.impl;

import com.akhil.spring_boot_curd.dto.UserDto;
import com.akhil.spring_boot_curd.entity.User;
import com.akhil.spring_boot_curd.exception.NoFoundException;
import com.akhil.spring_boot_curd.exception.NotFoundException;
import com.akhil.spring_boot_curd.repository.UserRepository;
import com.akhil.spring_boot_curd.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImpl  implements UserService {

    private UserRepository userRepository;


    public UserServicesImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public String saveUser(User user) {
        userRepository.save(user);
        return "Data Successfully Save";
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            return new NotFoundException("Not Found Id");
        });
        return user;
    }

    @Override
    public User findByName(String name) {
        User byName = userRepository.findByName(name);
        return byName;
    }

    @Override
    public List<User> findAll() {
        List<User> all = userRepository.findAll();
        return all;
    }

    @Override
    public User updateUser(User user) {
        User userUpdate = userRepository.findById(user.getFirst_id()).orElseThrow(() -> {
            return new NotFoundException("Not Found Id");
        });
        userUpdate.setFirst_id(user.getFirst_id());
        userUpdate.setFirstName(user.getFirstName());
        userUpdate.setLastName(user.getLastName());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setPassword(user.getPassword());
        userUpdate.setDob(user.getDob());
        return userRepository.save(userUpdate);
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User Successfully Delete By Id";
    }


}
