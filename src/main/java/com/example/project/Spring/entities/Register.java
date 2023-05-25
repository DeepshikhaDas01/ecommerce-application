package com.example.project.Spring.entities;


import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "register")
public class Register {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "register_id")
    private int id;
    private String name;
    @Column( nullable = false, length = 100)
    private String email;
    private String password;

}
