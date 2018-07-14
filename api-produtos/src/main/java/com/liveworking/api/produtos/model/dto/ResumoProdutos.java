package com.liveworking.api.produtos.model.dto;

import com.liveworking.api.produtos.model.Tarja;
import com.liveworking.api.produtos.model.TipoPis;
import com.liveworking.api.produtos.model.TipoProd;

public class ResumoProdutos {

	private String nome;

	private long ean;

	private String ms;

	private String principio;

	private String apresentacao;

	private TipoProd tipoMed;

	private Tarja tarja;

	private TipoPis listaPisCofins;

	private String fabricante;

	private String classeTerapeutica;

	public ResumoProdutos(String nome, long ean, String ms, String principio, String apresentacao, TipoProd tipoMed,
			Tarja tarja, TipoPis listaPisCofins, String fabricante, String classeTerapeutica) {
		
		this.nome = nome;
		this.ean = ean;
		this.ms = ms;
		this.principio = principio;
		this.apresentacao = apresentacao;
		this.tipoMed = tipoMed;
		this.tarja = tarja;
		this.listaPisCofins = listaPisCofins;
		this.fabricante = fabricante;
		this.classeTerapeutica = classeTerapeutica;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getEan() {
		return ean;
	}

	public void setEan(long ean) {
		this.ean = ean;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public String getPrincipio() {
		return principio;
	}

	public void setPrincipio(String principio) {
		this.principio = principio;
	}

	public String getApresentacao() {
		return apresentacao;
	}

	public void setApresentacao(String apresentacao) {
		this.apresentacao = apresentacao;
	}

	public TipoProd getTipoMed() {
		return tipoMed;
	}

	public void setTipoMed(TipoProd tipoMed) {
		this.tipoMed = tipoMed;
	}

	public Tarja getTarja() {
		return tarja;
	}

	public void setTarja(Tarja tarja) {
		this.tarja = tarja;
	}

	public TipoPis getListaPisCofins() {
		return listaPisCofins;
	}

	public void setListaPisCofins(TipoPis listaPisCofins) {
		this.listaPisCofins = listaPisCofins;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getClasseTerapeutica() {
		return classeTerapeutica;
	}

	public void setClasseTerapeutica(String classeTerapeutica) {
		this.classeTerapeutica = classeTerapeutica;
	}

}
