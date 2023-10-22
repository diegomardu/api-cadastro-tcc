package com.diegomardu.io.foca.no.tcc.service;

import java.util.List;

import com.diegomardu.io.foca.no.tcc.model.entity.Professor;

public interface ProfessorService {
	
	List<Professor> listarTodos();
	
	Professor salvar(Professor professor);
	
	Professor buscarPorId(Integer id);
	
	void deletar(Integer id);
	
	void atualizar(Integer id, Professor professorAtualizado);
	
}
