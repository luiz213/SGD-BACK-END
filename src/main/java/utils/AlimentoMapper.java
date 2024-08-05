package utils;

import org.springframework.stereotype.Component;
import com.system.day.DTO.AlimentoDTO;
import com.system.day.entity.Alimento;

@Component
public class AlimentoMapper {
	
	public Alimento convertToEntity(AlimentoDTO alimentoDTO) {
		Alimento alimento = new Alimento();
		alimento.setId(alimentoDTO.getId());
		alimento.setNome(alimentoDTO.getNome());
		alimento.setCalorias(alimentoDTO.getCalorias());
		
		return alimento;
	}

}
