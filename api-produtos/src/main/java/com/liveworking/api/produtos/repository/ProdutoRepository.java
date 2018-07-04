package com.liveworking.api.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liveworking.api.produtos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoRepositoryQuery {

	public Produto findByEan(long Ean);

}
