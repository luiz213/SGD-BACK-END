package com.system.day.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "DIA_ALIMENTO")
public class DiaAlimento {
	
	@EmbeddedId
	private DiaAlimentoKey id;
	
	@MapsId("idDia")
	@ManyToOne
	@JoinColumn(name = "ID_DIA")
	private Dia idDia;
	
	@MapsId("idAlimento")
	@ManyToOne
	@JoinColumn(name = "ID_ALIMENTO")
	private Alimento idAlimento;
	
	public DiaAlimento(DiaAlimentoKey id, Dia idDia, Alimento idAlimento) {
		this.id = id;
		this.idDia = idDia;
		this.idAlimento = idAlimento;
	}
	
	public DiaAlimento() {
		
	}

	public DiaAlimentoKey getId() {
		return id;
	}

	public void setId(DiaAlimentoKey id) {
		this.id = id;
	}

	public Dia getIdDia() {
		return idDia;
	}

	public void setIdDia(Dia idDia) {
		this.idDia = idDia;
	}

	public Alimento getIdAlimento() {
		return idAlimento;
	}

	public void setIdAlimento(Alimento idAlimento) {
		this.idAlimento = idAlimento;
	}
}
