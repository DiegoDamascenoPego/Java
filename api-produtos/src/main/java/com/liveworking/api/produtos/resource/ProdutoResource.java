package com.liveworking.api.produtos.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liveworking.api.produtos.model.Produto;
import com.liveworking.api.produtos.repository.filter.ProdutoFilter;
import com.liveworking.api.produtos.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

	@Autowired
	ProdutoService service;

	@Autowired
	private ResourceUtils<Produto> resourcesUtils;

	@GetMapping("/{ean}")
	public ResponseEntity<Produto> buscar(@PathVariable long ean) {
		return ResponseEntity.status(HttpStatus.OK).body(service.localizar(ean));
	}

	@GetMapping
	public ResponseEntity<List<Produto>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(service.listar());
	}
	
	@GetMapping("/principio")
	public Page<Produto> buscarPorPrincipio(ProdutoFilter produtoFilter, Pageable pageable) {
		return service.buscarPorPrincipio(produtoFilter, pageable);
	}

	@PostMapping
	public ResponseEntity<Produto> cadastrar(@Valid @RequestBody Produto entity, HttpServletResponse response) {
		Produto produto = service.cadastrar(entity);

		return resourcesUtils.publisherEvent(this, response, produto, produto.getEan());
	}

	@PutMapping("/{ean}")
	public ResponseEntity<Produto> atualizar(@PathVariable long ean, @RequestBody Produto entity,
			HttpServletResponse response) {
		return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(ean, entity));
	}

	@DeleteMapping("/{ean}")
	public ResponseEntity<Void> apagar(@PathVariable long ean) {

		service.apagar(ean);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
