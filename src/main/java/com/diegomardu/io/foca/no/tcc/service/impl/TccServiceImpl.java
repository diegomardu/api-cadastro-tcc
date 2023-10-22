package com.diegomardu.io.foca.no.tcc.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.diegomardu.io.foca.no.tcc.dto.CadastroTccDto;
import com.diegomardu.io.foca.no.tcc.model.entity.Aluno;
import com.diegomardu.io.foca.no.tcc.model.entity.Professor;
import com.diegomardu.io.foca.no.tcc.model.entity.TrabalhoConclusaoCurso;
import com.diegomardu.io.foca.no.tcc.model.repository.AlunoRepository;
import com.diegomardu.io.foca.no.tcc.model.repository.ProfessorRepository;
import com.diegomardu.io.foca.no.tcc.model.repository.TccRepository;
import com.diegomardu.io.foca.no.tcc.service.TccService;

@Service
public class TccServiceImpl implements TccService{
	
	private final TccRepository repository;
	
	private final ProfessorRepository professorRepository;
	
	private final AlunoRepository alunoRepository;
	
	public TccServiceImpl(TccRepository repository, ProfessorRepository professorRepository, AlunoRepository alunoRepository) {
		this.repository = repository;
		this.professorRepository = professorRepository;
		this.alunoRepository = alunoRepository;
	}

	@Override
	public List<TrabalhoConclusaoCurso> listarTodos() {
		return repository.findAll();
	}

	@Override
	public TrabalhoConclusaoCurso buscarPorId(Integer id) {
		return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Orientação não localizada"));
	}

	@Override
	public TrabalhoConclusaoCurso salvar(CadastroTccDto dto) {
		Integer idProfessor = dto.getIdProfessor();
        Integer idAluno = dto.getIdAluno();

        Professor professor = professorRepository.findById(idProfessor)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Professor não encontrado"));

        Aluno aluno = alunoRepository.findById(idAluno)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Aluno não encontrado"));

        TrabalhoConclusaoCurso tcc = new TrabalhoConclusaoCurso();
        tcc.setCargaHoraria("67");
        tcc.setCurso(aluno.getCurso());
        tcc.setPeriodoLetivo(dto.getPeriodoLetivo());
        tcc.setStatus(dto.getStatus());
        tcc.setTipoCursoOrientacao(dto.getTipoCurso());
        tcc.setOrientador(professor);
        tcc.setDiscente(aluno);


        return repository.save(tcc);
	}

	@Override
	public void atualizar(Integer id, TrabalhoConclusaoCurso conclusaoCurso) {
		repository
        .findById(id)
        .map(trabalhoTcc -> {
            conclusaoCurso.setId(trabalhoTcc.getId());
            return repository.save(conclusaoCurso);
        })
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Orientação não encontrada"));
		
	}

}
