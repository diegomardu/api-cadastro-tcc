package com.diegomardu.io.foca.no.tcc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.diegomardu.io.foca.no.tcc.dto.CadastroTccDto;
import com.diegomardu.io.foca.no.tcc.model.entity.Aluno;
import com.diegomardu.io.foca.no.tcc.model.entity.Professor;
import com.diegomardu.io.foca.no.tcc.model.entity.TrabalhoConclusaoCurso;
import com.diegomardu.io.foca.no.tcc.model.repository.AlunoRepository;
import com.diegomardu.io.foca.no.tcc.model.repository.ProfessorRepository;
import com.diegomardu.io.foca.no.tcc.model.repository.TccRepository;

import lombok.NoArgsConstructor;

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
    
    @GetMapping("/lista")
    public List<TrabalhoConclusaoCurso> listarTodos(){
    	return repository.findAll();
    }

    @GetMapping
    public List<TrabalhoConclusaoCurso> pesquisa(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome
    ){
        return repository.findProfessorByNome("%" + nome + "%");
    }

    @GetMapping("{id}")
    public TrabalhoConclusaoCurso buscarPorId(@PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Orientação não localizada"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id,@RequestBody TrabalhoConclusaoCurso conclusaoCurso){
        repository
                .findById(id)
                .map(trabalhoTcc -> {
                    conclusaoCurso.setId(trabalhoTcc.getId());
                    return repository.save(conclusaoCurso);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Orientação não encontrada"));
    }
}
