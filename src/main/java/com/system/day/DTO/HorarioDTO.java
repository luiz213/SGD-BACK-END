package com.system.day.DTO;

import java.util.Date;
import org.modelmapper.ModelMapper;
import com.system.day.entity.Horario;

public class HorarioDTO {
	
	private Long id;
	
	private Date Hora;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getHora() {
		return Hora;
	}

	public void setHora(Date hora) {
		Hora = hora;
	}

	static ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	public static HorarioDTO convertToDTO(Horario entity) {
		return getModelMapper().map(entity, HorarioDTO.class);		
	}

}
