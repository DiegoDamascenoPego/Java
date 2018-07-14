package com.liveworking.api.produtos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.liveworking.api.produtos.config.property.ApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(ApiProperty.class)
public class ApiProdutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiProdutosApplication.class, args);
	}
}
