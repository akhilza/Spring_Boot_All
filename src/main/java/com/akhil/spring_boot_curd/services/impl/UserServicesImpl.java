package com.akhil.spring_boot_curd.services.impl;

import com.akhil.spring_boot_curd.dto.UserDto;
import com.akhil.spring_boot_curd.entity.User;
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


    public String saveUser(UserDto userDto) {
         userRepository.save(dtoToEntity(userDto));
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
    public List<User> findAll() {
        List<User> all = userRepository.findAll();
        return all;
    }

    public User updateUser(UserDto userDto) {
        User userUpdate = userRepository.findById(userDto.getId()).orElseThrow(() ->
             new NotFoundException("Not Found Id")
        );
        return userRepository.save(dtoToEntity(userDto));
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User Successfully Delete By Id";
    }



    public static User dtoToEntity(UserDto userDto){
        User user=new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }

    public static UserDto entityToDto(User user){
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

}
