package com.example.project.Spring.controller;

import com.example.project.Spring.dto.RegisterDto;
import com.example.project.Spring.exception.ApiResponse;
import com.example.project.Spring.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/")
    public ResponseEntity<List<RegisterDto>> getAllUsers(){
        return ResponseEntity.ok(this.registerService.getAllUsers());
    }

    @PostMapping("/")
    public ResponseEntity<RegisterDto> createUser(@Valid @RequestBody RegisterDto registerDto){
        RegisterDto createUserDto = this.registerService.createUser(registerDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegisterDto> getUserById(@PathVariable Integer id){
        return ResponseEntity.ok(this.registerService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegisterDto> updateUser(@RequestBody RegisterDto userDto,@PathVariable Integer id){
        RegisterDto updatedUser = this.registerService.updateUser(userDto,id);
        updatedUser.setEmail(userDto.getEmail());
        updatedUser.setPassword(userDto.getPassword());
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id){
        this.registerService.deleteUser(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully !!",true),HttpStatus.OK);
    }

}
