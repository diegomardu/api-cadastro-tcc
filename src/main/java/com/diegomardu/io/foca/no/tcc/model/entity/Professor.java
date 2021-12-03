package com.diegomardu.io.foca.no.tcc.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nome;


    private String matricula;

    @Column(nullable = false, length = 150)
    private String apelido;

    @Email(message = "Email invalido")
    @Column(unique = false, nullable = false)
    private String email;

}
