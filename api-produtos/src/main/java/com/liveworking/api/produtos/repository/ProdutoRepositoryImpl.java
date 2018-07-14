package com.liveworking.api.produtos.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.liveworking.api.produtos.model.Produto;
import com.liveworking.api.produtos.model.dto.ResumoProdutos;
import com.liveworking.api.produtos.repository.filter.ProdutoFilter;

public class ProdutoRepositoryImpl implements ProdutoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Produto> buscarProdutoPorPrincipioAtivo(ProdutoFilter produtoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();

		CriteriaQuery<Produto> criteria = builder.createQuery(Produto.class);
		Root<Produto> root = criteria.from(Produto.class);

		Predicate[] predicates = criarFiltro(produtoFilter, builder, root);

		criteria.where(predicates);

		TypedQuery<Produto> query = manager.createQuery(criteria);

		adicionarPaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, TotalRegistros(produtoFilter));
	}

	private void adicionarPaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroporPaginas = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistroporPaginas;

		query.setFirstResult(primeiroRegistro);
		query.setMaxResults(totalRegistroporPaginas);

	}

	private Predicate[] criarFiltro(ProdutoFilter produtoFilter, CriteriaBuilder builder, Root<Produto> root) {

		List<Predicate> predicates = new ArrayList<>();

		if (produtoFilter.getPrincipioAtivo().contains("+")) {

			String[] parts = produtoFilter.getPrincipioAtivo().split(Pattern.quote("+"));

			for (String string : parts) {
				if (!StringUtils.isEmpty(parts)) {
					predicates
							.add(builder.like(builder.lower(root.get("principio")), "%" + string.toLowerCase() + "%"));
				}
			}
		} else {
			if (!StringUtils.isEmpty(produtoFilter.getPrincipioAtivo())) {
				predicates.add(builder.like(builder.lower(root.get("principio")),
						"%" + produtoFilter.getPrincipioAtivo().toLowerCase() + "%"));
			}
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private Long TotalRegistros(ProdutoFilter produtoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);

		Root<Produto> root = criteriaQuery.from(Produto.class);

		Predicate[] predicates = criarFiltro(produtoFilter, builder, root);

		criteriaQuery.where(predicates);
		criteriaQuery.select(builder.count(root));

		return manager.createQuery(criteriaQuery).getSingleResult();

	}

	@Override
	public Page<ResumoProdutos> buscarProdutoPorPrincipio(ProdutoFilter produtoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();

		CriteriaQuery<ResumoProdutos> criteria = builder.createQuery(ResumoProdutos.class);
		
		Root<Produto> root = criteria.from(Produto.class);
		
		criteria.select(builder.construct(ResumoProdutos.class, 
				root.get("nome"),
				root.get("ean"),
				root.get("ms"),
				root.get("principio"),
				root.get("apresentacao"),
				root.get("tipoMed"),
				root.get("tarja"),
				root.get("listaPisCofins"),
				root.get("fabricante").get("nome"),
				root.get("classeTerapeutica").get("nome")));
		

		

		Predicate[] predicates = criarFiltro(produtoFilter, builder, root);

		criteria.where(predicates);

		TypedQuery<ResumoProdutos> query = manager.createQuery(criteria);

		adicionarPaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, TotalRegistros(produtoFilter));
	}

}
