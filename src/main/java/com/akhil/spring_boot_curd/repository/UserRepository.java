package com.akhil.spring_boot_curd.repository;

import com.akhil.spring_boot_curd.dto.UserDto;
import com.akhil.spring_boot_curd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


}
