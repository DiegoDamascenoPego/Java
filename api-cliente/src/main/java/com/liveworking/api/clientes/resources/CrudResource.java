package com.liveworking.api.clientes.resources;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.liveworking.api.clientes.service.ICrudService;

@Component
public class CrudResource<T> implements ICrudSource<T> {

	@Autowired
	ResourcesUtils<T> resourcesUtils;
	

	

	public ResponseEntity<T> buscar(@PathVariable long id, ICrudService<T> service) {
		return ResponseEntity.status(HttpStatus.OK).body(service.localizar(id));

	}

	public ResponseEntity<List<T>> listar(ICrudService<T> service) {
		return ResponseEntity.status(HttpStatus.OK).body(service.listar());

	}

	public ResponseEntity<T> cadastrar(@Valid @RequestBody T registro, HttpServletResponse response,
			ICrudService<T> service) {
		T registroSalvo = service.cadastrar(registro);
		return resourcesUtils.publisherEvent(this, response, registroSalvo, service.GetId(registroSalvo));
	}

	public ResponseEntity<T> atualizar(@PathVariable long id, @Valid @RequestBody T registro, ICrudService<T> service) {
		return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(id, registro));
	}

	public ResponseEntity<Void> apagar(@PathVariable long id, ICrudService<T> service) {
		service.apagar(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
