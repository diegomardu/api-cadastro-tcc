package com.diegomardu.io.foca.no.tcc.rest;

import com.diegomardu.io.foca.no.tcc.dto.RegistroDefesaDto;
import com.diegomardu.io.foca.no.tcc.model.entity.Aluno;
import com.diegomardu.io.foca.no.tcc.model.entity.Professor;
import com.diegomardu.io.foca.no.tcc.model.entity.RegistroDefesaTcc;
import com.diegomardu.io.foca.no.tcc.model.entity.TrabalhoConclusaoCurso;
import com.diegomardu.io.foca.no.tcc.model.repository.AlunoRepository;
import com.diegomardu.io.foca.no.tcc.model.repository.ProfessorRepository;
import com.diegomardu.io.foca.no.tcc.model.repository.RegistroDefesaTccRepository;
import com.diegomardu.io.foca.no.tcc.model.repository.TccRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/registro_defesa")
public class RegistroDefesaTccController {

    @Autowired
    private RegistroDefesaTccRepository registroDefesaTccRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private TccRepository tccRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RegistroDefesaTcc agendarDefesa(@RequestBody @Valid RegistroDefesaDto dto){

        Integer idAluno = dto.getIdAluno();
        Integer idProfessor = dto.getIdProfessor();
        Integer idTcc = dto.getIdTcc();

        Aluno aluno = alunoRepository.findById(idAluno)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Aluno não encontrado"));

        Professor  professor = professorRepository.findById(idProfessor)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Professor não encontrado"));

        TrabalhoConclusaoCurso trabalhoConclusaoCurso = tccRepository.findById(idTcc)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Orientação não encontrada"));

        RegistroDefesaTcc registroDefesaTcc = new RegistroDefesaTcc();
        registroDefesaTcc.setAluno(aluno);
        registroDefesaTcc.setProfessor(professor);
        registroDefesaTcc.setTrabalhoConclusaoCurso(trabalhoConclusaoCurso);
        registroDefesaTcc.setData(dto.getData());
        registroDefesaTcc.setPeriodo_letivo(dto.getPeriodo_letivo());

        return registroDefesaTccRepository.save(registroDefesaTcc);
    }
}
