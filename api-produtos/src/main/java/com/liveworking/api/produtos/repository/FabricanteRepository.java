package com.liveworking.api.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liveworking.api.produtos.model.Fabricante;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {

	public Fabricante findByCnpj(Long cnpj);
	
}
