package com.liveworking.api.clientes.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.liveworking.api.clientes.model.Cliente;
import com.liveworking.api.clientes.model.Descontos;
import com.liveworking.api.clientes.repository.ClientesRepository;

@Service
public class ClienteService implements ICrudService<Cliente> {

	@Autowired
	ClientesRepository clientesRepository;

	@Autowired
	CategoriaService categoriaService;

	public Cliente cadastrar(Cliente cliente) {
		if (cliente.getId() == 0) {
			cliente.setData_cadastro(LocalDateTime.now());
			cliente.setAtivo(true);
		}

		try {
			categoriaService.localizar(cliente.getId_categoria());
		} catch (Exception e) {
			throw new EmptyResultDataAccessException("Cliente_Categoria", 1);
		}

		cliente.setData_atualizacao(LocalDateTime.now());
		return clientesRepository.save(cliente);
	}

	public Cliente buscarTodos(long id) {
		return clientesRepository.findById(id).orElse(null);
	}

	public List<Cliente> listar() {
		return clientesRepository.findAll();

	}

	private Cliente buscar(long id) {
		return clientesRepository.findById(id).orElse(null);
	}

	public void apagar(long id) {
		clientesRepository.deleteById(id);
	}

	public Cliente atualizar(Long id, Cliente cliente_novo) {
		Cliente cliente = localizar(id);
		BeanUtils.copyProperties(cliente_novo, cliente, "id", "data_cadastro", "data_atualizacao");
		return cadastrar(cliente);
	}

	public Cliente atualizarDescontos(long id, Descontos descontos) {
		Cliente cliente = localizar(id);
		cliente.setDesconto(descontos);
		return cadastrar(cliente);

	}

	public Cliente localizar(Long id) {
		Cliente cliente = buscar(id);

		if (cliente == null) {
			throw new EmptyResultDataAccessException("Cliente", 10);
		}
		return cliente;
	}

	@Override
	public Long GetId(Cliente Registro) {
		return Registro.getId();
	}

}
