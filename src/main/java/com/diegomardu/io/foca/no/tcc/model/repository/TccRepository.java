package com.diegomardu.io.foca.no.tcc.model.repository;

import com.diegomardu.io.foca.no.tcc.model.entity.TrabalhoConclusaoCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TccRepository extends JpaRepository<TrabalhoConclusaoCurso, Integer> {

    @Query(" select s from TrabalhoConclusaoCurso s join s.orientador c "
            + " where upper( c.nome ) like upper( :nome )")
    List<TrabalhoConclusaoCurso> findProfessorByNome(@Param("nome") String nome
    );
}

