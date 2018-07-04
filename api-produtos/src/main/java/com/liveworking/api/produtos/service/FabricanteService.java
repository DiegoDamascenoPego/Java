package com.liveworking.api.produtos.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.liveworking.api.produtos.model.Fabricante;
import com.liveworking.api.produtos.repository.FabricanteRepository;

@Qualifier("FabricanteService")
@Service
public class FabricanteService implements CrudService<Fabricante> {

	@Autowired
	FabricanteRepository dao;

	@Override
	public Fabricante localizar(Long id) {
		Fabricante fabricante = dao.findByCnpj(id);

		if (fabricante == null) {

			throw new EmptyResultDataAccessException(1);

		}
		return fabricante;
	}

	@Override
	public List<Fabricante> listar() {
		return dao.findAll();
	}

	@Override
	public Fabricante cadastrar(Fabricante entity) {

		if (entity.getId() == 0) {
			entity.setDataCadastro(LocalDateTime.now());
			entity.setAtivo(true);

		}
		return salvar(entity);
	}

	@Override
	public Fabricante atualizar(Long id, Fabricante entity) {
		Fabricante fabricante = localizar(entity.getCnpj());

		BeanUtils.copyProperties(entity, fabricante, "id", "dataCadastro", "dataAtualizacao");

		return salvar(fabricante);

	}

	@Override
	public void apagar(long id) {
		dao.delete(localizar(id));
	}

	@Override
	public Long GetId(Fabricante Registro) {
		return Registro.getId();
	}

	private Fabricante salvar(Fabricante fabricante) {
		fabricante.setDataAtualizacao(LocalDateTime.now());

		return dao.save(fabricante);
	}

}
