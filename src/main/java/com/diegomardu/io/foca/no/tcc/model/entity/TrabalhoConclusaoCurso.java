package com.diegomardu.io.foca.no.tcc.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_tcc")
public class TrabalhoConclusaoCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cargaHoraria;
    private String curso;
    private String periodoLetivo;

    private String status;
    private String tipoCursoOrientacao;

    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor orientador;

    @OneToOne
    @JoinColumn(name = "id_aluno")
    private Aluno discente;


}
