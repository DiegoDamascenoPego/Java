CREATE TABLE `cliente_categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  `data_cadastro` datetime NOT NULL,
  `data_alteracao` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;
