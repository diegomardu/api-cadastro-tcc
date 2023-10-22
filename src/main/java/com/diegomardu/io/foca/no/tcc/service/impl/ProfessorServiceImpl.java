package com.diegomardu.io.foca.no.tcc.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.diegomardu.io.foca.no.tcc.model.entity.Professor;
import com.diegomardu.io.foca.no.tcc.model.repository.ProfessorRepository;
import com.diegomardu.io.foca.no.tcc.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	private final ProfessorRepository professorRepository;
	
	public ProfessorServiceImpl(ProfessorRepository professorRepository) {
		this.professorRepository = professorRepository;
	}
	
	@Override
	public List<Professor> listarTodos() {
		return professorRepository.findAll();
	}

	@Override
	public Professor salvar(Professor professor) {
		return professorRepository.save(professor);
	}

	@Override
	public Professor buscarPorId(Integer id) {
		return professorRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Professor não localizado"));
	}

	@Override
	public void deletar(Integer id) {
		professorRepository
        .findById(id)
        .map( professor -> {
            professorRepository.delete(professor);
            return Void.TYPE;
        })
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Professor não encontrado"));
		
	}

	@Override
	public void atualizar(Integer id, Professor professorAtualizado) {
		professorRepository
        .findById(id)
        .map(professor -> {
            professorAtualizado.setId(professor.getId());
            return professorRepository.save(professorAtualizado);
        })
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Professor não encontrado"));
		
	}

}
