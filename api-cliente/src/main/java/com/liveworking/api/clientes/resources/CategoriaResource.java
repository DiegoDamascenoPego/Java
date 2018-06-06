package com.liveworking.api.clientes.resources;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liveworking.api.clientes.model.Categoria;
import com.liveworking.api.clientes.service.CategoriaService;

@RestController
@RequestMapping("/clientes/categorias")
public class CategoriaResource{

	@Autowired
	private CategoriaService service;
	
	@Autowired
	private ICrudSource<Categoria> source;


	@GetMapping
	public ResponseEntity<List<Categoria>> listar() {
		return source.listar(service);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscar(@PathVariable Long id) {
		return source.buscar(id, service);
	}

	@PostMapping
	public ResponseEntity<Categoria> cadastrar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		return source.cadastrar(categoria, response, service);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Categoria> atualizar(@PathVariable long id, @Valid @RequestBody Categoria categoria) {
		return source.atualizar(id, categoria, service);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable long id) {
		return source.apagar(id, service);
	}

}
