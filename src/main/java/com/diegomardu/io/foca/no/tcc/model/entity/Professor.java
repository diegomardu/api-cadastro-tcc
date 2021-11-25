package com.diegomardu.io.foca.no.tcc.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Professor {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nome;

    private String matricula;

}
