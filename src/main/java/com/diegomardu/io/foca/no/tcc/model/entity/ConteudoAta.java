package com.diegomardu.io.foca.no.tcc.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ConteudoAta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String conteudo;
    private String data;

    @ManyToOne
    private TrabalhoConclusaoCurso tcc;
}
