package utils;

import org.springframework.stereotype.Component;

import com.system.day.DTO.StatusDTO;
import com.system.day.entity.Status;

@Component
public class StatusMapper {
	
	public Status convertToEntity(StatusDTO statusDTO) {
		Status status = new Status();
		
		status.setId(statusDTO.getId());
		status.setDescricao(statusDTO.getDescricao());
		
		return status;
	}
}
