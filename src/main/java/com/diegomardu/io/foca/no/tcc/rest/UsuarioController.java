package com.diegomardu.io.foca.no.tcc.rest;

import com.diegomardu.io.foca.no.tcc.exception.UsuarioCadastradoException;
import com.diegomardu.io.foca.no.tcc.model.entity.Usuario;
import com.diegomardu.io.foca.no.tcc.model.repository.UsuarioRepository;
import com.diegomardu.io.foca.no.tcc.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario){

        try {
            service.salvar(usuario);
        }catch (UsuarioCadastradoException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
