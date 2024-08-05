package com.system.day.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class DiaAlimentoKey {

	private static final long serialVersionUID = 1L;
	
	private Long idDia;
	
	private Long idAlimento;
	
	public DiaAlimentoKey(Long idDia, Long idAlimento) {
		super();
		this.idDia = idDia;
		this.idAlimento = idAlimento;
	}
	
	public DiaAlimentoKey() {
		
	}

	public Long getIdDia() {
		return idDia;
	}

	public void setIdDia(Long idDia) {
		this.idDia = idDia;
	}

	public Long getIdAlimento() {
		return idAlimento;
	}

	public void setIdAlimento(Long idAlimento) {
		this.idAlimento = idAlimento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
