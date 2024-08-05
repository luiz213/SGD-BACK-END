package com.system.day.DTO;

import org.modelmapper.ModelMapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.system.day.entity.Alimento;
import com.system.day.entity.Dia;
import com.system.day.entity.DiaAlimento;

public class DiaAlimentoDTO {
	
	@JsonIgnore
	private Dia idDia;
	
	private Alimento idAlimento;
	
	public DiaAlimentoDTO() {}

	public Dia getIdDia() {
		return idDia;
	}

	public void setIdDia(Dia idDia) {
		this.idDia = idDia;
	}

	public Alimento getIdAlimento() {
		return idAlimento;
	}

	public void setIdAlimento(Alimento idAlimento) {
		this.idAlimento = idAlimento;
	}
	
	static ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	public static DiaAlimentoDTO convertToDTO(DiaAlimento diaAlimento) {
		return getModelMapper().map(diaAlimento, DiaAlimentoDTO.class);
	}
}
