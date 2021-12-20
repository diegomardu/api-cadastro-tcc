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
    private String discente;
    private String curso;
    private String periodoLetivo;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private TipoCursoOrientacao tipoCursoOrientacao;

    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;


}
