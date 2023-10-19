package com.diegomardu.io.foca.no.tcc.service;

import java.util.List;

import com.diegomardu.io.foca.no.tcc.model.entity.Aluno;

public interface AlunoService {
	
	List<Aluno> listarTodos();
	
	Aluno salvar(Aluno aluno);
	
	Aluno buscarPorId(Integer id);
	
	void deletar(Integer id);
	
	void atualizar(Integer id, Aluno alunoAtualizado);

}
