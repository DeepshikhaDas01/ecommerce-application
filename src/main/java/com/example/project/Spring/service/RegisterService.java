package com.example.project.Spring.service;

import com.example.project.Spring.dto.RegisterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegisterService {


    RegisterDto createUser(RegisterDto registerDto);

    RegisterDto updateUser(RegisterDto registerDto,Integer id);

    RegisterDto getUserById(Integer id);

    List<RegisterDto> getAllUsers();

    ResponseEntity<RegisterDto> deleteUser(Integer id);


}
