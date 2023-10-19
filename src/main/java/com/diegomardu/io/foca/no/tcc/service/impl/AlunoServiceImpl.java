package com.diegomardu.io.foca.no.tcc.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.diegomardu.io.foca.no.tcc.model.entity.Aluno;
import com.diegomardu.io.foca.no.tcc.model.repository.AlunoRepository;
import com.diegomardu.io.foca.no.tcc.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {
	
	private AlunoRepository alunoRepository;
	
	public AlunoServiceImpl(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	@Override
	public List<Aluno> listarTodos() {
		return alunoRepository.findAll();
	}

	@Override
	public Aluno salvar(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@Override
	public Aluno buscarPorId(Integer id) {
		return alunoRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Aluno não localizado"));
                
	}

	@Override
	public void deletar(Integer id) {
		alunoRepository
        .findById(id)
        .map( aluno -> {
            alunoRepository.delete(aluno);
            return Void.TYPE;
        })
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Aluno não encontrado"));
		
	}

	@Override
	public void atualizar(Integer id, Aluno alunoAtualizado) {
		alunoRepository
        .findById(id)
        .map(aluno -> {
            alunoAtualizado.setId(aluno.getId());
            return alunoRepository.save(alunoAtualizado);
        })
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Aluno não encontrado"));
		
	}

}
