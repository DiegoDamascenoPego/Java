package com.liveworking.api.clientes.resources;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.liveworking.api.clientes.model.Cliente;
import com.liveworking.api.clientes.model.Descontos;
import com.liveworking.api.clientes.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClientesResource {

	@Autowired
	ClienteService service;

	@Autowired
	ICrudSource<Cliente> source;

	@GetMapping
	public ResponseEntity<List<Cliente>> Listar() {
		return source.listar(service);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable long id) {
		return source.buscar(id, service);
	}

	@PostMapping
	public ResponseEntity<Cliente> cadastrar(@Valid @RequestBody Cliente cliente, HttpServletResponse response) {
		return source.cadastrar(cliente, response, service);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable long id, @Valid @RequestBody Cliente cliente) {
		return source.atualizar(id, cliente, service);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> apagar(@PathVariable long id) {
		return source.apagar(id, service);
	}

	@PutMapping("/{id}/descontos")
	public ResponseEntity<Cliente> atualizarDescontos(@PathVariable long id, @Valid @RequestBody Descontos descontos) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.atualizarDescontos(id, descontos));
	}

}
