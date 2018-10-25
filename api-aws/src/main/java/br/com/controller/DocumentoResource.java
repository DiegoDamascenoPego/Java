package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.service.DocumentoService;

@RestController
@RequestMapping("/documentos")
@CrossOrigin("*")
public class DocumentoResource {

	@Autowired
	DocumentoService service;

	@GetMapping
	public ResponseEntity<?> status() {
		return ResponseEntity.status(HttpStatus.OK).body("API Funcionando");
	}
	
	@GetMapping("/{cnpj}")
	public ResponseEntity<?> documentos(@PathVariable String cnpj) {
		return ResponseEntity.status(HttpStatus.OK).body(service.buscarDocumento(cnpj));
	}

	@PostMapping
	public ResponseEntity<?> salvar(@RequestParam String cnpj, 	@RequestParam MultipartFile arquivo) {

		return ResponseEntity.status(HttpStatus.OK).body(service.salvar(cnpj, arquivo));

	}

}
