DROP TABLE sabor;
DROP TABLE cardapio;
DROP TABLE sabor_cardapio;

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