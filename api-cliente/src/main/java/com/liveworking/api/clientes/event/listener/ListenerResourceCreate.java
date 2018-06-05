package com.liveworking.api.clientes.event.listener;

import java.net.URI;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.liveworking.api.clientes.event.EventResourceCreate;

@Component
public class ListenerResourceCreate implements ApplicationListener<EventResourceCreate> {

	@Override 
	public void onApplicationEvent(EventResourceCreate eventResourceCreate) {
		AddHeaderLocation(eventResourceCreate);

	}

	private void AddHeaderLocation(EventResourceCreate eventResourceCreate) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(eventResourceCreate.getCodigo()).toUri();

		eventResourceCreate.getResponse().setHeader("Location", uri.toASCIIString());
	}

}
