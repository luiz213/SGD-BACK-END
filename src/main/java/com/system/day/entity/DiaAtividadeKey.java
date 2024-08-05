package com.system.day.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class DiaAtividadeKey implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long idDia;
	
	private Long idAtividade;
	
	public DiaAtividadeKey() {
		
	}
	
	public DiaAtividadeKey(Long idDia, Long idAtividade) {
		this.idDia = idDia;
		this.idAtividade = idAtividade;
		
	}

	public Long getIdDia() {
		return idDia;
	}

	public void setIdDia(Long idDia) {
		this.idDia = idDia;
	}

	public Long getIdAtividade() {
		return idAtividade;
	}

	public void setIdAtividade(Long idAtividade) {
		this.idAtividade = idAtividade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	


}
