package com.liveworking.api.clientes.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class EventResourceCreate extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	
	
	public EventResourceCreate(Object source, HttpServletResponse response, Long codigo) {
		super(source);
		this.response = response;
		this.codigo   = codigo;
	}
	
	private HttpServletResponse response;
	public HttpServletResponse getResponse() {
		return response;
	}

	public Long getCodigo() {
		return codigo;
	}

	private Long codigo;
	

}
