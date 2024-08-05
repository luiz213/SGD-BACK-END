package com.system.day.DTO;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.system.day.entity.Atividade;
import com.system.day.entity.Dia;
import com.system.day.entity.DiaAtividade;
import com.system.day.entity.Horario;

public class DiaAtividadeDTO {
	
	@JsonIgnore
	private Dia idDia;
	
	private Atividade idAtividade;
	 
	private Horario horarioInicio;

	private Horario horarioFim;
	
	public Dia getIdDia() {
		return idDia;
	}

	public void setIdDia(Dia idDia) {
		this.idDia = idDia;
	}

	public Atividade getIdAtividade() {
		return idAtividade;
	}

	public void setIdAtividade(Atividade idAtividade) {
		this.idAtividade = idAtividade;
	}
	
	public Horario getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(Horario horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public Horario getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(Horario horarioFim) {
		this.horarioFim = horarioFim;
	}

	static ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	public static DiaAtividadeDTO convertToDo(DiaAtividade entity) {
		return getModelMapper().map(entity, DiaAtividadeDTO.class);		
	}
}
