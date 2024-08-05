package com.system.day.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.day.entity.Alimento;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {

}
