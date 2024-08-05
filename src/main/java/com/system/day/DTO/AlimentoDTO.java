package com.system.day.DTO;

import org.modelmapper.ModelMapper;
import com.system.day.entity.Alimento;

public class AlimentoDTO {
	
	private Long id;	

	private String nome;
	
	private int calorias;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	static ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	public static AlimentoDTO convertToDTO(Alimento entity) {
		return getModelMapper().map(entity, AlimentoDTO.class);		
	}
}
