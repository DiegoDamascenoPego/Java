package com.liveworking.api.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liveworking.api.clientes.model.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Long> {
	

}
