package com.liveworking.api.produtos.event.listener;

import java.net.URI;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.liveworking.api.produtos.event.EventResourceCreate;

@Component
public class ListenerResourceCreate implements ApplicationListener<EventResourceCreate> {

	@Override
	public void onApplicationEvent(EventResourceCreate event) {
		AddHeaderLocation(event);

	}

	private void AddHeaderLocation(EventResourceCreate eventResourceCreate) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(eventResourceCreate.getCodigo()).toUri();

		eventResourceCreate.getResponse().setHeader("Location", uri.toASCIIString());
	}

}
