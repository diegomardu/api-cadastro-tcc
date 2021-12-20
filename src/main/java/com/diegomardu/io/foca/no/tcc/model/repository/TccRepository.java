package com.diegomardu.io.foca.no.tcc.model.repository;

import com.diegomardu.io.foca.no.tcc.model.entity.TrabalhoConclusaoCurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TccRepository extends JpaRepository<TrabalhoConclusaoCurso, Integer> {
}
