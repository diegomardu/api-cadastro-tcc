package com.diegomardu.io.foca.no.tcc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Entity
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "Campo nome é obrigatório")
    private String nome;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "Campo apelido é obrigatório")
    private String apelido;

    @Column(nullable = false, length = 11)
    @NotNull(message = "Campo CPF é obrigatório")
    @CPF(message = "Campo cpf invalido")
    private String cpf;

    @NotEmpty(message = "Campo curso é obrigatório")
    private String curso;

    @NotEmpty(message = "Campo matricula é obrigatório")
    private String matricula;
}
