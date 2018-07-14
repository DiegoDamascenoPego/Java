package com.liveworking.api.produtos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.liveworking.api.produtos.model.Produto;
import com.liveworking.api.produtos.model.dto.ResumoProdutos;
import com.liveworking.api.produtos.repository.filter.ProdutoFilter;

public interface ProdutoRepositoryQuery {
		
	public Page<Produto> buscarProdutoPorPrincipioAtivo(ProdutoFilter produtoFilter, Pageable pageable);
	
	public Page<ResumoProdutos> buscarProdutoPorPrincipio(ProdutoFilter produtoFilter, Pageable pageable);

}
