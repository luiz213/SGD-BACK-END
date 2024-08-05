package com.system.day.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.day.DTO.HorarioDTO;
import com.system.day.entity.Horario;
import com.system.day.repository.HorarioRepository;

import jakarta.persistence.EntityNotFoundException;
import utils.HorarioMapper;

@Service
public class HorarioService {
	
	@Autowired
	private HorarioRepository horarioRepository;
	
	@Autowired
	private HorarioMapper horarioMapper;
	
	public HorarioDTO getById(Long id) {		
		Horario horario = getHorarioRepository().findById(id).orElseThrow(				
				() -> new EntityNotFoundException("Não existe um horario com o id:" + id));
		return HorarioDTO.convertToDTO(horario);		
	}
	
	public List<HorarioDTO> getAll(){
		List<Horario> horarios = getHorarioRepository().findAll();
		List<HorarioDTO> horariosDTO = horarios.stream().map(
				horario -> HorarioDTO.convertToDTO(horario)).toList();
		return horariosDTO;		
	}
	
	public void create(HorarioDTO horarioDTO) {
		Horario horario = getHorarioMapper().convertToEntity(horarioDTO);
		getHorarioRepository().save(horario);		
	}
	
	public void update(HorarioDTO horarioDTO) {
		Horario horario = getHorarioRepository().findById(horarioDTO.getId()).orElseThrow(				
				() -> new EntityNotFoundException("Não existe um horario com o id:" + horarioDTO.getId()));
		horario.setId(horarioDTO.getId());
		horario.setHora(horarioDTO.getHora());
		getHorarioRepository().save(horario);				
	}
	
	public void delete(Long id) {
		getHorarioRepository().findById(id).orElseThrow(				
				() -> new EntityNotFoundException("Não existe um horario com o id:" + id));
		getHorarioRepository().deleteById(id);		
	}	
	
	public HorarioRepository getHorarioRepository() {
		return horarioRepository;
	}
	
	public HorarioMapper getHorarioMapper() {
		return horarioMapper;
	}
}
