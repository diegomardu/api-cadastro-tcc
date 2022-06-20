package com.diegomardu.io.foca.no.tcc.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CadastroAtaDto {

    private String titulo;

    private String conteudo;

    private String data;

    private Integer idTcc;
}
