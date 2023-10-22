package com.diegomardu.io.foca.no.tcc.service;

import java.util.List;

import com.diegomardu.io.foca.no.tcc.dto.CadastroAtaDto;
import com.diegomardu.io.foca.no.tcc.model.entity.ConteudoAta;

public interface ConteudoAtaService {
	
	List<ConteudoAta> listarTodos();
	
	List<ConteudoAta> buscarPorId(Integer id);
	
	ConteudoAta salvar(CadastroAtaDto dto);

}
