package com.diegomardu.io.foca.no.tcc.dto;

import com.diegomardu.io.foca.no.tcc.model.entity.Status;
import com.diegomardu.io.foca.no.tcc.model.entity.TipoCursoOrientacao;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class CadastroTccDto {

    @NotEmpty
    private String cargaHoraria;

    @NotEmpty
    private String discente;

    @NotEmpty
    private String curso;

    @NotEmpty
    private String periodoLetivo;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    private TipoCursoOrientacao tipoCurso;

    @NotNull
    private Integer idProfessor;
}
