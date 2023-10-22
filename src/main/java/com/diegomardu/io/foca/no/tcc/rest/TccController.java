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
import com.diegomardu.io.foca.no.tcc.service.impl.TccServiceImpl;

import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/cadastro-tcc")
public class TccController {

    private final TccServiceImpl serviceImpl;
    
    public TccController(TccServiceImpl serviceImpl) {
    	this.serviceImpl = serviceImpl;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrabalhoConclusaoCurso salvar(@RequestBody CadastroTccDto dto){
        return serviceImpl.salvar(dto);
    }
    
    @GetMapping("/lista")
    public List<TrabalhoConclusaoCurso> listarTodos(){
    	return serviceImpl.listarTodos();
    }

	/*
	 * @GetMapping public List<TrabalhoConclusaoCurso> pesquisa(
	 * 
	 * @RequestParam(value = "nome", required = false, defaultValue = "") String
	 * nome ){ return repository.findProfessorByNome("%" + nome + "%"); }
	 */

    @GetMapping("{id}")
    public TrabalhoConclusaoCurso buscarPorId(@PathVariable Integer id){
        return serviceImpl.buscarPorId(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id,@RequestBody TrabalhoConclusaoCurso conclusaoCurso){
        serviceImpl.atualizar(id, conclusaoCurso);
    }
}
