package com.liveworking.api.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liveworking.api.clientes.model.Categoria;

public interface CategoriaRepository extends JpaRepository< Categoria, Long> {

}
