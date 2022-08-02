package com.diegomardu.io.foca.no.tcc.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class RegistroDefesaDto {

    @NotEmpty
    private Integer idTcc;

    @NotEmpty
    private String data;
}
