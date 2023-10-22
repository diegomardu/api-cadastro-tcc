package com.diegomardu.io.foca.no.tcc.rest;

import com.diegomardu.io.foca.no.tcc.dto.CadastroAtaDto;
import com.diegomardu.io.foca.no.tcc.model.entity.Aluno;
import com.diegomardu.io.foca.no.tcc.model.entity.ConteudoAta;
import com.diegomardu.io.foca.no.tcc.model.entity.TrabalhoConclusaoCurso;
import com.diegomardu.io.foca.no.tcc.model.repository.ConteudoAtaRepository;
import com.diegomardu.io.foca.no.tcc.model.repository.TccRepository;
import com.diegomardu.io.foca.no.tcc.service.impl.ConteudoAtaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/cadastro-ata")
public class ConteudoAtaController {

	private final ConteudoAtaServiceImpl ataServiceImpl;

    public ConteudoAtaController(ConteudoAtaServiceImpl ataServiceImpl) {
        this.ataServiceImpl = ataServiceImpl;
    }

    @GetMapping
    public List<ConteudoAta> listarTodos(){
        return ataServiceImpl.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ConteudoAta salvar(@RequestBody CadastroAtaDto dto){
    	return ataServiceImpl.salvar(dto);
    }

    @GetMapping("{id}")
    public List<ConteudoAta> buscarConteudoAta(@PathVariable Integer id){
        return ataServiceImpl.buscarPorId(id);
    }

}
