package com.diegomardu.io.foca.no.tcc.model.repository;

import com.diegomardu.io.foca.no.tcc.model.entity.RegistroDefesaTcc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroDefesaTccRepository extends JpaRepository<RegistroDefesaTcc, Integer> {
}
