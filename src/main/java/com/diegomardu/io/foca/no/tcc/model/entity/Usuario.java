package com.diegomardu.io.foca.no.tcc.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name = "login")
    @NotEmpty(message = "O campo usuário é obrigatório")
    private String username;

    @Column(name = "senha")
    @NotEmpty(message = "O campo senha é obrigatório")
    private String password;

    @Email
    private String email;
}
