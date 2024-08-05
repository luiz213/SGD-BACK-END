package utils;

import org.springframework.stereotype.Component;

import com.system.day.DTO.DiaAtividadeDTO;
import com.system.day.entity.DiaAtividade;

@Component
public class DiaAtividadeMapper {
	
	public DiaAtividade converterToEntity(DiaAtividadeDTO diaAtividadeDTO) {
		DiaAtividade diaAtividade = new DiaAtividade();
		diaAtividade.setIdDia(diaAtividadeDTO.getIdDia());
		diaAtividade.setIdAtividade(diaAtividadeDTO.getIdAtividade());
		diaAtividade.setIdHorarioInicio(diaAtividadeDTO.getHorarioInicio());
		diaAtividade.setIdHorarioFim(diaAtividadeDTO.getHorarioFim());		
		return diaAtividade;		
	}
}
