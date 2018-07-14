CREATE TABLE usuarios(
codigo BIGINT(20) PRIMARY KEY,
nome VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL,
senha VARCHAR(150) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao(
codigo BIGINT(20) PRIMARY KEY,
descricao VARCHAR(50) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE usuario_permissao(
codigo_usuario BIGINT(20) NOT NULL,
codigo_permissao BIGINT(20) NOT NULL,

PRIMARY KEY(codigo_usuario, codigo_permissao),
FOREIGN KEY (codigo_usuario) REFERENCES usuarios (codigo),
FOREIGN KEY (codigo_permissao) REFERENCES permissao (codigo)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO usuarios(codigo, nome, email, senha)values(1, "Admin","admin@admin.com.br", "$2a$10$6BT9s2K0gFIWAd1hpA4irefZyCzeN4KkjFIJwleojU.CvuZ.f4teS");
INSERT INTO usuarios(codigo, nome, email, senha)values(2, "Users","users@user.com.br", "$2a$10$qb7mB.iC3TeA3CrLqj868OqSIkxOqw7lG1Vg7SCP2Hrir4d4XVcEu");

INSERT INTO permissao(codigo, descricao) values (1,"ROLE_CADASTRAR_PRODUTOS");
INSERT INTO permissao(codigo, descricao) values (2,"ROLE_CONSULTAR_PRODUTOS");
INSERT INTO permissao(codigo, descricao) values (3,"ROLE_CADASTRAR_FABRICANTES");
INSERT INTO permissao(codigo, descricao) values (4,"ROLE_CONSULTAR_FABRICANTES");

INSERT INTO usuario_permissao(codigo_usuario,codigo_permissao) values (1,1);
INSERT INTO usuario_permissao(codigo_usuario,codigo_permissao) values (1,2);
INSERT INTO usuario_permissao(codigo_usuario,codigo_permissao) values (1,3);
INSERT INTO usuario_permissao(codigo_usuario,codigo_permissao) values (1,4);
INSERT INTO usuario_permissao(codigo_usuario,codigo_permissao) values (2,2);
INSERT INTO usuario_permissao(codigo_usuario,codigo_permissao) values (2,4);