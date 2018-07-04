CREATE TABLE fabricantes (
	id INT NOT NULL AUTO_INCREMENT,
	cnpj varchar(18) NOT NULL,
	nome varchar(100) NOT NULL,	  
	data_cadastro datetime NOT NULL,
	data_atualizacao datetime NOT NULL,
	ativo BOOL DEFAULT 1 NULL,
	PRIMARY KEY (id),
	UNIQUE KEY cnpj (cnpj)
)
ENGINE=InnoDB;