package com.system.day.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.day.DTO.StatusDTO;
import com.system.day.entity.Status;
import com.system.day.repository.StatusRepository;

import jakarta.persistence.EntityNotFoundException;
import utils.StatusMapper;

@Service
public class StatusService {
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private StatusMapper statusMapper;
	
	public StatusDTO getById(Long id) {		
		Status status = getStatusRepository().findById(id).orElseThrow(				
				() -> new EntityNotFoundException("Não existe um status com o id:" + id));
		return StatusDTO.convertToDTO(status);		
	}
	
	public List<StatusDTO> getAll(){
		List<Status> statuss = getStatusRepository().findAll();
		List<StatusDTO> statussDTO = statuss.stream().map(
				status -> StatusDTO.convertToDTO(status)).toList();
		return statussDTO;		
	}
	
	public void create(StatusDTO statusDTO) {
		Status status = getStatusMapper().convertToEntity(statusDTO);
		getStatusRepository().save(status);		
	}
	
	public void update(StatusDTO statusDTO) {
		Status status = getStatusRepository().findById(statusDTO.getId()).orElseThrow(				
				() -> new EntityNotFoundException("Não existe um status com o id:" + statusDTO.getId()));
		status.setId(statusDTO.getId());
		status.setDescricao(statusDTO.getDescricao());
		getStatusRepository().save(status);				
	}
	
	public void delete(Long id) {
		getStatusRepository().findById(id).orElseThrow(				
				() -> new EntityNotFoundException("Não existe um status com o id:" + id));
		getStatusRepository().deleteById(id);		
	}	
	
	public StatusRepository getStatusRepository() {
		return statusRepository;
	}
	
	public StatusMapper getStatusMapper() {
		return statusMapper;
	}
}
