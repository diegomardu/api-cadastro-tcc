package com.diegomardu.io.foca.no.tcc.model.repository;

import com.diegomardu.io.foca.no.tcc.model.entity.ConteudoAta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConteudoAtaRepository extends JpaRepository<ConteudoAta, Integer> {

   // @Query(value = "select '*' from ConteudoAta where tcc.id = :id")
    List<ConteudoAta> findConteudoAtaByTccId(@Param("tcc_id") Integer id);

}
