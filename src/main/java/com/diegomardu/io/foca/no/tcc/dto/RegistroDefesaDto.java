package com.diegomardu.io.foca.no.tcc.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@NoArgsConstructor
public class RegistroDefesaDto {

    @NotEmpty
    private Integer idAluno;

    @NotEmpty
    private Integer idProfessor;

    @NotEmpty
    private Integer idTcc;

    @NotEmpty
    private Date data;

    @NotEmpty
    private String periodo_letivo;
}
