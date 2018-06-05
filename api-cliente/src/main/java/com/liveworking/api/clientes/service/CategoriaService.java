package com.liveworking.api.clientes.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.liveworking.api.clientes.model.Categoria;
import com.liveworking.api.clientes.repository.CategoriaRepository;

@Service
public class CategoriaService implements ICrudService<Categoria> {

	@Autowired
	CategoriaRepository categoriaRepository;

	public Categoria cadastrar(Categoria categoria) {

		if (categoria.getId() == 0) {
			categoria.setData_cadastro(LocalDateTime.now());
		}
		
		categoria.setData_alteracao(LocalDateTime.now());

		return categoriaRepository.save(categoria);
	}

	public List<Categoria> listar() {
		return categoriaRepository.findAll();

	}

	private Categoria buscar(long id) {
		return categoriaRepository.findById(id).orElse(null);
	}

	public void apagar(long id) {
		categoriaRepository.deleteById(id);
	}

	public Categoria atualizar(Long id, Categoria objeto_novo) {
		Categoria categoria = localizar(id);

		BeanUtils.copyProperties(objeto_novo, categoria, "id", "data_cadastro", "data_alteracao");
		return cadastrar(categoria);
	}

	public Categoria localizar(Long id) {
		Categoria categoria = buscar(id);

		if (categoria == null) {
			throw new EmptyResultDataAccessException("Categorias", 1);
		}
		return categoria;
	}

	@Override
	public Long GetId(Categoria Registro) {
		return Registro.getId();
	}

}
