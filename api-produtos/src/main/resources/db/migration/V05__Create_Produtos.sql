CREATE TABLE produtos (
	id INT NOT NULL AUTO_INCREMENT,
	nome varchar(100) NOT NULL,
	ean varchar(14) NOT NULL,
	ms varchar(20) NOT NULL,
	principio text NOT NULL,  
	apresentacao varchar(200) NOT NULL,
	tipo varchar(11) NOT NULL COMMENT "0 Biologicos 1 Especifico 2 Generico 3 Referencia 4 Radiofarmaco 5 Similar",
	pis tinyint(1) NOT NULL COMMENT "0 NEGATIVA 1 NEUTRA 2 POSITIVA",
	tarja tinyint(1) NOT NULL COMMENT "0 Tarja Preta 1 Tarja Vermelha 2 Venda Livre",
	data_cadastro datetime NOT NULL,
	data_atualizacao datetime NOT NULL,
	ativo BOOL DEFAULT 1 NULL,
	classe_terapeutica_id varchar(20) NOT NULL,
	fabricante_id INT NOT NULL,
	PRIMARY KEY (id),
	UNIQUE KEY ean (ean),
	FOREIGN KEY (fabricante_id) REFERENCES fabricantes(id),
    FOREIGN KEY (classe_terapeutica_id) REFERENCES classes_terapeuticas(id)
)
ENGINE=InnoDB;

