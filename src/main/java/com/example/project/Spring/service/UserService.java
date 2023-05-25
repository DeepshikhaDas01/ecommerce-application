package com.example.project.Spring.service;

import com.example.project.Spring.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user,Integer id);

    UserDto getUserById(Integer id);

    List<UserDto> getAllUsers();

    ResponseEntity<UserDto> deleteUser(Integer id);

}
