package com.liveworking.api.produtos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liveworking.api.produtos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);
}
