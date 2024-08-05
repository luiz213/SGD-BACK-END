package com.system.day.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "DIA_ATIVIDADE")
public class DiaAtividade {
	
	@EmbeddedId
	private DiaAtividadeKey id;
	
	@MapsId("idDia")
	@ManyToOne
	@JoinColumn(name = "ID_DIA")
	private Dia idDia;
	
	@MapsId("idAtividade")
	@ManyToOne
	@JoinColumn(name = "ID_ATIVIDADE")
	private Atividade idAtividade;
	
	@ManyToOne
	@JoinColumn(name = "ID_HORARIO_INICIO")
	private Horario idHorarioInicio;	

	@ManyToOne
	@JoinColumn(name = "ID_HORARIO_FIM")
	private Horario idHorarioFim;
	
	public DiaAtividade() {
		
	}
	
	public DiaAtividade(DiaAtividadeKey id, Dia idDia, Atividade idAtividade, Horario idHorarioInicio, Horario idHorarioFim) {

		this.id = id;
		this.idDia = idDia;
		this.idAtividade = idAtividade;
		this.idHorarioInicio = idHorarioInicio;
		this.idHorarioFim = idHorarioFim;
	}	

	public DiaAtividadeKey getId() {
		return id;
	}

	public void setId(DiaAtividadeKey id) {
		this.id = id;
	}

	public Dia getIdDia() {
		return idDia;
	}

	public void setIdDia(Dia idDia) {
		this.idDia = idDia;
	}

	public Atividade getIdAtividade() {
		return idAtividade;
	}

	public void setIdAtividade(Atividade idAtividade) {
		this.idAtividade = idAtividade;
	}

	public Horario getIdHorarioInicio() {
		return idHorarioInicio;
	}

	public void setIdHorarioInicio(Horario idHorarioInicio) {
		this.idHorarioInicio = idHorarioInicio;
	}

	public Horario getIdHorarioFim() {
		return idHorarioFim;
	}

	public void setIdHorarioFim(Horario idHorarioFim) {
		this.idHorarioFim = idHorarioFim;
	}

}
