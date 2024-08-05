package com.system.day.DTO;

import java.sql.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import com.system.day.entity.Dia;
import com.system.day.entity.Status;

public class DiaDTO {
	
	private Long id;
	
	private Date dia;
	
	private double valorGasto;
	
	private Status whey;
	
	private Status creatina;	
	
	private List<AtividadeHorario> postAtividades;
	
	private List<DiaAlimentoDTO> postAlimentos;
	
	private List<DiaAlimentoDTO> alimentos;
	
	private List<DiaAtividadeDTO> atividades;	
	
	public DiaDTO() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public double getValorGasto() {
		return valorGasto;
	}

	public void setValorGasto(double valorGasto) {
		this.valorGasto = valorGasto;
	}
	
	public Status getWhey() {
		return whey;
	}

	public void setWhey(Status whey) {
		this.whey = whey;
	}

	public Status getCreatina() {
		return creatina;
	}

	public void setCreatina(Status creatina) {
		this.creatina = creatina;
	}

	public List<AtividadeHorario> getPostAtividades() {
		return postAtividades;
	}

	public void setPostAtividades(List<AtividadeHorario> postAtividades) {
		this.postAtividades = postAtividades;
	}

	public List<DiaAlimentoDTO> getPostAlimentos() {
		return postAlimentos;
	}

	public void setPostAlimentos(List<DiaAlimentoDTO> postAlimentos) {
		this.postAlimentos = postAlimentos;
	}

	public List<DiaAlimentoDTO> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(List<DiaAlimentoDTO> alimentos) {
		this.alimentos = alimentos;
	}

	public List<DiaAtividadeDTO> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<DiaAtividadeDTO> atividades) {
		this.atividades = atividades;
	}

	static ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	public static DiaDTO convertToDTO(Dia entity) {
		return getModelMapper().map(entity, DiaDTO.class);		
	}	
}
