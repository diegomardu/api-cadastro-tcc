package com.diegomardu.io.foca.no.tcc.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.diegomardu.io.foca.no.tcc.dto.CadastroAtaDto;
import com.diegomardu.io.foca.no.tcc.model.entity.ConteudoAta;
import com.diegomardu.io.foca.no.tcc.model.entity.TrabalhoConclusaoCurso;
import com.diegomardu.io.foca.no.tcc.model.repository.ConteudoAtaRepository;
import com.diegomardu.io.foca.no.tcc.model.repository.TccRepository;
import com.diegomardu.io.foca.no.tcc.service.ConteudoAtaService;

@Service
public class ConteudoAtaServiceImpl implements ConteudoAtaService{
	
	private final ConteudoAtaRepository ataRepository;
	
	private final TccRepository tccRepository;
	
	public ConteudoAtaServiceImpl(ConteudoAtaRepository ataRepository,TccRepository tccRepository) {
		this.ataRepository = ataRepository;
		this.tccRepository = tccRepository;
	}

	@Override
	public List<ConteudoAta> listarTodos() {
		return ataRepository.findAll();
	}

	@Override
	public List<ConteudoAta> buscarPorId(Integer id) {
		return ataRepository.findConteudoAtaByTccId(id);
	}

	@Override
	public ConteudoAta salvar(CadastroAtaDto dto) {
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

        return ataRepository.save(conteudoAta);
	}

}
