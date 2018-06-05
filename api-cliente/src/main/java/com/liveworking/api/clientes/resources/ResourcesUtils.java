package com.liveworking.api.clientes.resources;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.liveworking.api.clientes.event.EventResourceCreate;

@Component
public class ResourcesUtils<T> {
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	public ResponseEntity<T> publisherEvent(Object source, HttpServletResponse response, T registroSalvo, Long id) {
		publisher.publishEvent(new EventResourceCreate(source, response, id));
		return ResponseEntity.status(HttpStatus.CREATED).body(registroSalvo);
	}

}
