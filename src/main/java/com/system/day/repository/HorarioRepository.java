package com.system.day.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.day.entity.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {

}
