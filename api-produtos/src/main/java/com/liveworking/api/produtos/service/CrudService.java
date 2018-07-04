package com.liveworking.api.produtos.service;

import java.util.List;

public interface CrudService<T> {
	
	public T localizar(Long id);

	public List<T> listar();

	public T cadastrar(T entity);

	public T atualizar(Long id, T entity);

	public void apagar(long id);
	
	public Long GetId(T entity);

}
