package com.example.project.Spring.serviceImpl;

import com.example.project.Spring.dto.UserDto;
import com.example.project.Spring.entities.User;
import com.example.project.Spring.exception.ResourceNotFoundException;
import com.example.project.Spring.repository.UserRepository;
import com.example.project.Spring.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

   @Autowired(required = false)
   private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(@RequestBody UserDto userDto, @PathVariable Integer id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id " + id));
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        User updateUser = this.userRepository.save(user);
        UserDto userDto1 = this.userToDto(updateUser);
        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id " + id));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public ResponseEntity<UserDto> deleteUser(@PathVariable Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id " + id));
        this.userRepository.deleteById(id);
        return null;
    }

    private User dtoToUser(UserDto userDto) {
        User user = modelMapper.map(userDto,User.class);
        return user;
    }

    private UserDto userToDto(User user) {
        UserDto userDto = modelMapper.map(user,UserDto.class);
        return  userDto;
    }
}
