DROP TABLE sabor;
DROP TABLE cardapio;
DROP TABLE sabor_cardapio;
DROP TABLE usuario;
DROP TABLE ingrediente;

CREATE TABLE sabor(
  id       INT NOT NULL AUTO_INCREMENT,
  nome     VARCHAR(45) NOT NULL,
  desricao VARCHAR(450),
  salgada  TINYINT NOT NULL,
PRIMARY KEY(id)

);

CREATE TABLE cardapio(
  id       INT NOT NULL AUTO_INCREMENT,
  nome     VARCHAR(45) NOT NULL,
  desricao VARCHAR(450),
PRIMARY KEY(id)
);

CREATE TABLE sabor_cardapio(
	id INT NOT NULL AUTO_INCREMENT,
    id_sabor INT NOT NULL,
    id_cardapio INT NOT NULL,
	preco DECIMAL(13, 2) NOT NULL,
    PRIMARY KEY (id),
FOREIGN KEY(id_sabor)REFERENCES sabor(id),
FOREIGN KEY(id_cardapio)REFERENCES cardapio(id),
UNIQUE KEY(id_sabor, id_cardapio)
);

CREATE TABLE usuario(
  id       INT NOT NULL AUTO_INCREMENT,
  nome     VARCHAR(255) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  email  VARCHAR(45) NOT NULL,
PRIMARY KEY(id)

);

CREATE TABLE ingrediente(
  id       INT NOT NULL AUTO_INCREMENT,
  nome     VARCHAR(255) NOT NULL,
PRIMARY KEY(id)

);

CREATE TABLE ingrediente_sabor(
	id INT NOT NULL AUTO_INCREMENT,
    id_ingrediente INT NOT NULL,
    id_sabor INT NOT NULL,
    PRIMARY KEY (id),
FOREIGN KEY(id_ingrediente)REFERENCES ingrediente(id),
FOREIGN KEY(id_sabor)REFERENCES sabor(id),
UNIQUE KEY(id_ingrediente, id_sabor)
);