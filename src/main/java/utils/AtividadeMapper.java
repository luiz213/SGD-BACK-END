package utils;

import org.springframework.stereotype.Component;

import com.system.day.DTO.AtividadeDTO;
import com.system.day.entity.Atividade;

@Component
public class AtividadeMapper {
	
	public Atividade convertToEntity(AtividadeDTO atividadeDTO) {
		Atividade atividade = new Atividade();
		
		atividade.setId(atividadeDTO.getId());
		atividade.setDescricao(atividadeDTO.getDescricao());
		
		return atividade;		
	}
}
