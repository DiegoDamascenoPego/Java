package com.liveworking.api.clientes.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Descontos {
	
	@Column(name="desconto_avista")
	private BigDecimal avista;
	
	@Column(name="desconto_prazo")
	private BigDecimal prazo;
	
	@Column(name="desconto_permite")
	private String permite;

	public BigDecimal getAvista() {
		return avista;
	}

	public BigDecimal getPrazo() {
		return prazo;
	}

	public void setPrazo(BigDecimal prazo) {
		this.prazo = prazo;
	}

	public String getPermite() {
		return permite;
	}

	public void setPermite(String permite) {
		this.permite = permite;
	}

	public void setAvista(BigDecimal avista) {
		this.avista = avista;
	}

	
}
