package com.diegomardu.io.foca.no.tcc.model.repository;

import com.diegomardu.io.foca.no.tcc.model.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Integer> {

}

