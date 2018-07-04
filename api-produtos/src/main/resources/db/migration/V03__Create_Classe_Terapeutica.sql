CREATE TABLE classes_terapeuticas (
	id varchar(20) NOT NULL,
	nome varchar(100) NOT NULL,
	data_criacao datetime NOT NULL,
	data_atualizacao datetime NOT NULL,
	ativo BOOL DEFAULT 1 NULL,
    PRIMARY KEY (id)
)
ENGINE=InnoDB;