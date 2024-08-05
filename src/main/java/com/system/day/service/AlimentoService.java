package com.system.day.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.day.DTO.AlimentoDTO;
import com.system.day.entity.Alimento;
import com.system.day.repository.AlimentoRepository;

import jakarta.persistence.EntityNotFoundException;
import utils.AlimentoMapper;

@Service
public class AlimentoService {
	
	@Autowired
	private AlimentoRepository alimentoRepository;
	
	@Autowired
	private AlimentoMapper alimentoMapper;
	
	public AlimentoDTO getById(Long id) {		
		Alimento alimento = getAlimentoRepository().findById(id).orElseThrow(				
				() -> new EntityNotFoundException("Não existe um alimento com o id:" + id));
		return AlimentoDTO.convertToDTO(alimento);		
	}
	
	public List<AlimentoDTO> getAll(){
		List<Alimento> alimentos = getAlimentoRepository().findAll();
		List<AlimentoDTO> alimentosDTO = alimentos.stream().map(
				alimento -> AlimentoDTO.convertToDTO(alimento)).toList();
		return alimentosDTO;		
	}
	
	public void create(AlimentoDTO alimentoDTO) {
		Alimento alimento = getAlimentoMapper().convertToEntity(alimentoDTO);
		getAlimentoRepository().save(alimento);		
	}
	
	public void update(AlimentoDTO alimentoDTO) {
		Alimento alimento = getAlimentoRepository().findById(alimentoDTO.getId()).orElseThrow(				
				() -> new EntityNotFoundException("Não existe um alimento com o id:" + alimentoDTO.getId()));
		alimento.setId(alimentoDTO.getId());
		alimento.setNome(alimentoDTO.getNome());
		alimento.setCalorias(alimentoDTO.getCalorias());		
		getAlimentoRepository().save(alimento);				
	}
	
	public void delete(Long id) {
		getAlimentoRepository().findById(id).orElseThrow(				
				() -> new EntityNotFoundException("Não existe um alimento com o id:" + id));
		getAlimentoRepository().deleteById(id);		
	}	
	
	public AlimentoRepository getAlimentoRepository() {
		return alimentoRepository;
	}
	
	public AlimentoMapper getAlimentoMapper() {
		return alimentoMapper;
	}
}
