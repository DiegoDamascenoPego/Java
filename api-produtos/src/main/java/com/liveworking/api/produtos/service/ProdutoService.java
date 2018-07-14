package com.liveworking.api.produtos.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.liveworking.api.produtos.model.Produto;
import com.liveworking.api.produtos.model.dto.ResumoProdutos;
import com.liveworking.api.produtos.repository.ProdutoRepository;
import com.liveworking.api.produtos.repository.filter.ProdutoFilter;

@Qualifier("ProdutoService")
@Service
@Primary
public class ProdutoService implements CrudService<Produto> {

	@Autowired
	ProdutoRepository dao;

	@Override
	public Produto localizar(Long id) {
		Produto produto = dao.findByEan(id);

		if (produto == null) {

			throw new EmptyResultDataAccessException(1);

		}
		return produto;
	}

	@Override
	public List<Produto> listar() {
		return dao.findAll();
	}
	
	public Page<Produto> buscarPorPrincipio(ProdutoFilter produtoFilter, Pageable pageable) {
		return dao.buscarProdutoPorPrincipioAtivo(produtoFilter, pageable);
	}
	
	public Page<ResumoProdutos> buscarResumoPorPrincipio(ProdutoFilter produtoFilter, Pageable pageable) {
		return dao.buscarProdutoPorPrincipio(produtoFilter, pageable);
	}

	@Override
	public Produto cadastrar(Produto entity) {

		if (entity.getId() == 0) {
			entity.setDataCadastro(LocalDateTime.now());
			entity.setAtivo(true);
		}

		return salvar(entity);

	}

	@Override
	public Produto atualizar(Long id, Produto entity) {
		Produto produto = localizar(id);

		BeanUtils.copyProperties(entity, produto, "id", "ean", "dataCadastro", "dataAtualizacao");

		return salvar(produto);
	}

	@Override
	public void apagar(long id) {
		dao.delete(localizar(id));
	}

	@Override
	public Long GetId(Produto entity) {
		return entity.getId();
	}

	private Produto salvar(Produto entity) {

		entity.setDataAtualizacao(LocalDateTime.now());

		return dao.save(entity);
	}

}
