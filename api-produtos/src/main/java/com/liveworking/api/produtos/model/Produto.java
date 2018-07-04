package com.liveworking.api.produtos.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String nome;

	@NotNull
	private long ean;

	private String ms;

	@NotNull
	private String principio;

	@NotNull
	private String apresentacao;

	@NotNull
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo")
	private TipoProd tipoMed;

	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private Tarja tarja;

	@NotNull
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "pis")
	private TipoPis listaPisCofins;

	@NotNull
	private boolean ativo;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "data_cadastro")
	private LocalDateTime dataCadastro;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "data_atualizacao")
	private LocalDateTime dataAtualizacao;

	@OneToOne
	@JoinColumn(name = "fabricante_id")
	private Fabricante fabricante;

	@OneToOne
	@JoinColumn(name = "classe_terapeutica_id")
	private ClasseTerapeutica classeTerapeutica;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public ClasseTerapeutica getClasseTerapeutica() {
		return classeTerapeutica;
	}

	public void setClasseTerapeutica(ClasseTerapeutica classeTerapeutica) {
		this.classeTerapeutica = classeTerapeutica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ean ^ (ean >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (ean != other.ean)
			return false;
		return true;
	}

}
