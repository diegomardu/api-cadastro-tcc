package com.diegomardu.io.foca.no.tcc.rest;

import com.diegomardu.io.foca.no.tcc.model.entity.Professor;
import com.diegomardu.io.foca.no.tcc.model.repository.ProfessorRepository;
import com.diegomardu.io.foca.no.tcc.service.ProfessorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {

    private ProfessorService professorService;
    
    public ProfessorController (ProfessorService professorService) {
		this.professorService = professorService;
	}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Professor salvar(@RequestBody @Valid Professor professor){
        return professorService.salvar(professor);
    }

    @GetMapping
    public List<Professor> listarTodos(){
        return professorService.listarTodos();
    }

    @GetMapping("{id}")
    public Professor buscarPorId(@PathVariable Integer id){
        return professorService.buscarPorId(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        professorService.deletar(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id,@RequestBody Professor professorAtualizado){
        professorService.atualizar(id, professorAtualizado);
    }
}
