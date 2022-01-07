package com.diegomardu.io.foca.no.tcc.rest;

import com.diegomardu.io.foca.no.tcc.model.entity.Aluno;
import com.diegomardu.io.foca.no.tcc.model.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin("http://localhost:4200")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<Aluno> listarTodos(){
        return alunoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Aluno salvar(@RequestBody @Valid Aluno aluno){
        return alunoRepository.save(aluno);
    }

    @GetMapping("{id}")
    public Aluno buscarPorId(@PathVariable Integer id){
        return alunoRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Aluno não localizado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        alunoRepository
                .findById(id)
                .map( professor -> {
                    alunoRepository.delete(professor);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Aluno não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id,@RequestBody Aluno alunoAtualizado){
        alunoRepository
                .findById(id)
                .map(professor -> {
                    alunoAtualizado.setId(professor.getId());
                    return alunoRepository.save(alunoAtualizado);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Aluno não encontrado"));
    }
}
