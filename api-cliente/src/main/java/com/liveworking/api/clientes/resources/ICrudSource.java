package com.liveworking.api.clientes.resources;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.liveworking.api.clientes.service.ICrudService;

public interface ICrudSource<T> {
	
	public ResponseEntity<T> buscar(@PathVariable long id, ICrudService<T> service) ;

	public ResponseEntity<List<T>> listar(ICrudService<T> service);
	
	public ResponseEntity<T> cadastrar(@Valid @RequestBody T registro, HttpServletResponse response,
			ICrudService<T> service) ;

	public ResponseEntity<T> atualizar(@PathVariable long id, @Valid @RequestBody T registro, 
			ICrudService<T> service);

	public ResponseEntity<Void> apagar(@PathVariable long id, ICrudService<T> service) ;
}
