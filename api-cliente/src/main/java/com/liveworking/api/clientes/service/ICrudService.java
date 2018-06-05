package com.liveworking.api.clientes.service;

import java.util.List;

public interface ICrudService<T> {
	public T localizar(Long id);

	public List<T> listar();

	public T cadastrar(T registro);

	public T atualizar(Long id, T registro_novo);

	public void apagar(long id);
	
	public Long GetId(T Registro);

}
