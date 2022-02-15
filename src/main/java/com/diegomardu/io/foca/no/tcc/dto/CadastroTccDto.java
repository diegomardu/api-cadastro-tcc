package com.diegomardu.io.foca.no.tcc.dto;

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
    private String curso;

    @NotEmpty
    private String periodoLetivo;

    @NotEmpty
    private String status;

    @NotEmpty
    private String tipoCurso;

    @NotNull
    private Integer idProfessor;

    @NotNull
    private Integer idAluno;
}
