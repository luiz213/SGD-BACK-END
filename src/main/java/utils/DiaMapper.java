package utils;

import org.springframework.stereotype.Component;

import com.system.day.DTO.DiaDTO;
import com.system.day.entity.Dia;

@Component
public class DiaMapper {
	
	public Dia convertToEntity(DiaDTO diaDTO) {
		Dia dia = new Dia();
		
		dia.setId(diaDTO.getId());
		dia.setDia(diaDTO.getDia());
		dia.setValorGasto(diaDTO.getValorGasto());
		dia.setWhey(diaDTO.getWhey());
		dia.setCreatina(diaDTO.getCreatina());
		
		return dia;
	}

}
