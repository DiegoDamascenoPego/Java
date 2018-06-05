CREATE TABLE `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sobrenome` varchar(45) DEFAULT '',
  `data_nascimento` date DEFAULT NULL,
  `data_cadastro` datetime NOT NULL,
  `data_atualizacao` datetime NOT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `tipo` char(1) NOT NULL DEFAULT '0',
  `ativo` tinyint(1) NOT NULL,
  `id_categoria` int(11) DEFAULT 0 NOT NULL,   
  `desconto_permite` char(1) DEFAULT 'N',
  `desconto_avista` double(15,2) DEFAULT '0.00',
  `desconto_prazo` double(15,2) DEFAULT '0.00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `clientes_cpf` (`cpf`)
) ENGINE=InnoDB COMMENT='tabela de clientes';



