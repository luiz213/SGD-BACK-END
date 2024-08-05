package com.system.day.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.day.DTO.AtividadeDTO;
import com.system.day.entity.Atividade;
import com.system.day.repository.AtividadeRepository;

import jakarta.persistence.EntityNotFoundException;
import utils.AtividadeMapper;

@Service
public class AtividadeService {
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	@Autowired
	private AtividadeMapper atividadeMapper;
	
	public AtividadeDTO getById(Long id) {		
		Atividade atividade = getAtividadeRepository().findById(id).orElseThrow(				
				() -> new EntityNotFoundException("Não existe um atividade com o id:" + id));
		return AtividadeDTO.convertToDTO(atividade);		
	}
	
	public List<AtividadeDTO> getAll(){
		List<Atividade> atividades = getAtividadeRepository().findAll();
		List<AtividadeDTO> atividadesDTO = atividades.stream().map(
				atividade -> AtividadeDTO.convertToDTO(atividade)).toList();
		return atividadesDTO;		
	}
	
	public void create(AtividadeDTO atividadeDTO) {
		Atividade atividade = getAtividadeMapper().convertToEntity(atividadeDTO);
		getAtividadeRepository().save(atividade);		
	}
	
	public void update(AtividadeDTO atividadeDTO) {
		Atividade atividade = getAtividadeRepository().findById(atividadeDTO.getId()).orElseThrow(				
				() -> new EntityNotFoundException("Não existe um atividade com o id:" + atividadeDTO.getId()));
		atividade.setId(atividadeDTO.getId());
		atividade.setDescricao(atividadeDTO.getDescricao());	
		getAtividadeRepository().save(atividade);				
	}
	
	public void delete(Long id) {
		getAtividadeRepository().findById(id).orElseThrow(				
				() -> new EntityNotFoundException("Não existe um atividade com o id:" + id));
		getAtividadeRepository().deleteById(id);		
	}	
	
	public AtividadeRepository getAtividadeRepository() {
		return atividadeRepository;
	}
	
	public AtividadeMapper getAtividadeMapper() {
		return atividadeMapper;
	}
}
