package com.diegomardu.io.foca.no.tcc.rest;

import com.diegomardu.io.foca.no.tcc.dto.CadastroTccDto;
import com.diegomardu.io.foca.no.tcc.model.entity.Aluno;
import com.diegomardu.io.foca.no.tcc.model.entity.Professor;
import com.diegomardu.io.foca.no.tcc.model.entity.TrabalhoConclusaoCurso;
import com.diegomardu.io.foca.no.tcc.model.repository.AlunoRepository;
import com.diegomardu.io.foca.no.tcc.model.repository.ProfessorRepository;
import com.diegomardu.io.foca.no.tcc.model.repository.TccRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/cadastro-tcc")
@NoArgsConstructor
public class TccController {

    @Autowired
    private TccRepository repository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrabalhoConclusaoCurso salvar(@RequestBody CadastroTccDto dto){
        Integer idProfessor = dto.getIdProfessor();
        Integer idAluno = dto.getIdAluno();

        Professor professor = professorRepository.findById(idProfessor)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Professor não encontrado"));

        Aluno aluno = alunoRepository.findById(idAluno)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Aluno não encontrado"));

        TrabalhoConclusaoCurso tcc = new TrabalhoConclusaoCurso();
        tcc.setCargaHoraria(dto.getCargaHoraria());
        tcc.setCurso(dto.getCurso());
        tcc.setPeriodoLetivo(dto.getPeriodoLetivo());
        tcc.setStatus(dto.getStatus());
        tcc.setTipoCursoOrientacao(dto.getTipoCurso());
        tcc.setOrientador(professor);
        tcc.setDiscente(aluno);

        return repository.save(tcc);
    }

    @GetMapping
    public List<TrabalhoConclusaoCurso> pesquisa(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome
    ){
        return repository.findProfessorByNome("%" + nome + "%");
    }
}
