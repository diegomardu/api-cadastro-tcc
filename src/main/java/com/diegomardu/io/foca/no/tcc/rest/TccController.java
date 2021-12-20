package com.diegomardu.io.foca.no.tcc.rest;

import com.diegomardu.io.foca.no.tcc.dto.CadastroTccDto;
import com.diegomardu.io.foca.no.tcc.model.entity.Professor;
import com.diegomardu.io.foca.no.tcc.model.entity.TrabalhoConclusaoCurso;
import com.diegomardu.io.foca.no.tcc.model.repository.ProfessorRepository;
import com.diegomardu.io.foca.no.tcc.model.repository.TccRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/cadastro-tcc")
public class TccController {

    @Autowired
    private TccRepository repository;

    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrabalhoConclusaoCurso salvar(@RequestBody CadastroTccDto dto){
        Integer idProfessor = dto.getIdProfessor();

        Professor professor = professorRepository.findById(idProfessor)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Professor não encontrado"));

        TrabalhoConclusaoCurso tcc = new TrabalhoConclusaoCurso();
        tcc.setCargaHoraria(dto.getCargaHoraria());
        tcc.setCurso(dto.getCurso());
        tcc.setDiscente(dto.getDiscente());
        tcc.setPeriodoLetivo(dto.getPeriodoLetivo());
        tcc.setStatus(dto.getStatus());
        tcc.setTipoCursoOrientacao(dto.getTipoCurso());
        tcc.setProfessor(professor);

        return repository.save(tcc);
    }
}
