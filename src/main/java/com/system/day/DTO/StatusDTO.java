package com.system.day.DTO;

import org.modelmapper.ModelMapper;
import com.system.day.entity.Status;

public class StatusDTO {
	
	private Long id;
	
	private String descricao;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	static ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	public static StatusDTO convertToDTO(Status entity) {
		return getModelMapper().map(entity, StatusDTO.class);		
	}
}
