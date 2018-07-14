package com.liveworking.api.produtos.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liveworking.api.produtos.model.Fabricante;
import com.liveworking.api.produtos.security.securityAutorize;
import com.liveworking.api.produtos.service.CrudService;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteResource {

	@Autowired
	CrudService<Fabricante> service;

	@Autowired
	private ResourceUtils<Fabricante> resourcesUtils;

	@GetMapping("/{id}")
	@PreAuthorize(securityAutorize.role_consultar_fabricantes)
	public ResponseEntity<Fabricante> buscar(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.localizar(id));
	}

	@GetMapping
	@PreAuthorize(securityAutorize.role_consultar_fabricantes)
	public ResponseEntity<List<Fabricante>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(service.listar());
	}

	@PostMapping
	@PreAuthorize(securityAutorize.role_cadastrar_fabricantes)
	public ResponseEntity<Fabricante> cadastrar(@Valid @RequestBody Fabricante fabricante,
			HttpServletResponse response) {

		Fabricante registro = service.cadastrar(fabricante);

		return resourcesUtils.publisherEvent(this, response, registro, registro.getCnpj());
	}

	@PutMapping("/{cnpj}")
	public ResponseEntity<Fabricante> atualizar(@PathVariable long cnpj, @Valid @RequestBody Fabricante fabricante,
			HttpServletResponse response) {
		return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(cnpj, fabricante));

	}

	@DeleteMapping("/{cnpj}")
	public ResponseEntity<Void> apagar(@PathVariable long cnpj) {
		service.apagar(cnpj);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
