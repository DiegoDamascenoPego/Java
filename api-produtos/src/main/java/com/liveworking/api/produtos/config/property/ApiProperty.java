package com.liveworking.api.produtos.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("api")
public class ApiProperty {

	private String originPermitida = "htpp://localhost:8000";

	private final Security security = new Security();

	public Security getSecurity() {
		return security;
	}

	public String getOriginPermitida() {
		return originPermitida;
	}

	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}

	public static class Security {

		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}

	}

}
