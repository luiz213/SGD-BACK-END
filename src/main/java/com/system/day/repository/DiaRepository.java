package com.system.day.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.system.day.entity.Dia;

@Repository
public interface DiaRepository extends JpaRepository<Dia, Long> {

}
