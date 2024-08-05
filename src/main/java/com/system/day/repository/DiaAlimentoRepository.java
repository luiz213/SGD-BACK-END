package com.system.day.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.day.entity.Dia;
import com.system.day.entity.DiaAlimento;
import com.system.day.entity.DiaAlimentoKey;

@Repository
public interface DiaAlimentoRepository extends JpaRepository<DiaAlimento, DiaAlimentoKey>{
	
	List<DiaAlimento> getByIdDia(Dia dia);

}
