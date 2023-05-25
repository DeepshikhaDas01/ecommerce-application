package com.example.project.Spring.serviceImpl;

import com.example.project.Spring.dto.RegisterDto;
import com.example.project.Spring.entities.Register;
import com.example.project.Spring.exception.ResourceNotFoundException;
import com.example.project.Spring.repository.RegisterRepository;
import com.example.project.Spring.service.RegisterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired(required = false)
    private RegisterRepository registerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RegisterDto createUser(RegisterDto registerDto) {
        Register register = this.dtoToUser(registerDto);
        Register savedUser = this.registerRepository.save(register);
        return this.userToDto(savedUser);
    }

    @Override
    public RegisterDto updateUser(@RequestBody RegisterDto userDto, @PathVariable Integer id) {
        Register user = this.registerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id " + id));
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        Register updateUser = this.registerRepository.save(user);
        RegisterDto userDto1 = this.userToDto(updateUser);
        return userDto1;
    }

    @Override
    public RegisterDto getUserById(Integer id) {
        Register register = registerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id " + id));
        return this.userToDto(register);
    }

    @Override
    public List<RegisterDto> getAllUsers() {
        List<Register> registers = this.registerRepository.findAll();
        List<RegisterDto> registerDtos = registers.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return registerDtos;
    }

    @Override
    public ResponseEntity<RegisterDto> deleteUser(@PathVariable Integer id) {
        Register register = registerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id " + id));
        this.registerRepository.deleteById(id);
        return null;
    }

    private Register dtoToUser(RegisterDto registerDto) {
        Register register = modelMapper.map(registerDto,Register.class);
        return register;
    }

    private RegisterDto userToDto(Register register) {
        RegisterDto registerDto = modelMapper.map(register,RegisterDto.class);
        return  registerDto;
    }
}
