package com.diegomardu.io.foca.no.tcc.service;

import java.util.List;

import com.diegomardu.io.foca.no.tcc.dto.CadastroTccDto;
import com.diegomardu.io.foca.no.tcc.model.entity.TrabalhoConclusaoCurso;

public interface TccService {
	
	List<TrabalhoConclusaoCurso> listarTodos();
	
	TrabalhoConclusaoCurso buscarPorId(Integer id);
	
	TrabalhoConclusaoCurso salvar(CadastroTccDto dto);
	
	void atualizar(Integer id, TrabalhoConclusaoCurso conclusaoCurso);

}
