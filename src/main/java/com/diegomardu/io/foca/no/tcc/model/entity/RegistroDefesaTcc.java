package com.diegomardu.io.foca.no.tcc.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class RegistroDefesaTcc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    @OneToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;

    private String data;

    private String periodo_letivo;

    @OneToOne
    @JoinColumn(name = "id_tcc")
    private TrabalhoConclusaoCurso trabalhoConclusaoCurso;

}
