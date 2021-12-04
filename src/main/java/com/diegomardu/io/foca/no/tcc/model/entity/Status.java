package com.diegomardu.io.foca.no.tcc.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    EM_ANDAMENTO("Em andamento"),
    CONCLUIDO("Concluido");

    private String descricao;
}
