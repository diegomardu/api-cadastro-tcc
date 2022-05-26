package com.diegomardu.io.foca.no.tcc.rest;

import com.diegomardu.io.foca.no.tcc.dto.CadastroAtaDto;
import com.diegomardu.io.foca.no.tcc.model.entity.ConteudoAta;
import com.diegomardu.io.foca.no.tcc.model.entity.TrabalhoConclusaoCurso;
import com.diegomardu.io.foca.no.tcc.model.repository.ConteudoAtaRepository;
import com.diegomardu.io.foca.no.tcc.model.repository.TccRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/cadastro-ata")
public class ConteudoAtaController {

    @Autowired
    private ConteudoAtaRepository repository;

    private final TccRepository tccRepository;

    public ConteudoAtaController(TccRepository tccRepository) {
        this.tccRepository = tccRepository;
    }

    @GetMapping
    public List<ConteudoAta> listarTodos(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ConteudoAta salvar(@RequestBody CadastroAtaDto dto){

        Integer idTcc = dto.getIdTcc();

        TrabalhoConclusaoCurso trabalhoConclusaoCurso = tccRepository.findById(idTcc)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Orientação não encontrada para o Id {} fornecido " + idTcc));

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateTime = df.format(new Date());
        dto.setData(currentDateTime);

        ConteudoAta conteudoAta = new ConteudoAta();

        conteudoAta.setTitulo(dto.getTitulo());
        conteudoAta.setConteudo(dto.getConteudo());
        conteudoAta.setData(dto.getData());
        conteudoAta.setTcc(trabalhoConclusaoCurso);

        return repository.save(conteudoAta);
    }



}
