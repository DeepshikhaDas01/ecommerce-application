package com.example.project.Spring.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {


        private int id;
        @NotEmpty
        private String name;
        @NotEmpty
        private String email;
        @NotEmpty
        @Size(min=3,max = 10,message ="Invalid password!(3-10 characters)")
        private String password;


    }
