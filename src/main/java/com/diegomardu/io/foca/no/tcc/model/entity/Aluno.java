package com.diegomardu.io.foca.no.tcc.model.entity;

import lombok.Data;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String apelido;

    @Column(nullable = false, length = 11)
    @NotNull(message = "Campo CPF é obrigatório")
    @CPF(message = "Campo cpf invalido")
    private String cpf;
    private String curso;
    private String matricula;
}
