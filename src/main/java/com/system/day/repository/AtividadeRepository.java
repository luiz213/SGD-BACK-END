package com.system.day.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.day.entity.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

}
