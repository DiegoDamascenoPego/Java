package com.liveworking.api.produtos.security;

public final class securityAutorize {
	
	private final static String scope_read = "#oauth2.hasScope('read')";
	
	private final static String scope_write = "#oauth2.hasScope('write')";

	public final static String role_consultar_fabricantes = "hasAuthority('ROLE_CONSULTAR_FABRICANTES') and " + scope_read;
	
	public final static String role_cadastrar_fabricantes =  "hasAuthority('ROLE_CADASTRAR_FABRICANTES') and " + scope_write;
	
}
