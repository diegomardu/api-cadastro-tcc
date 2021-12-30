package com.diegomardu.io.foca.no.tcc.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "Campo nome é obrigatório")
    private String nome;

    @NotEmpty(message = "Campo matricula é obrigatório")
    private String matricula;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "Campo apelido é obrigatório")
    private String apelido;

    @Email(message = "Email invalido")
    @Column(unique = false, nullable = false)
    private String email;

}
