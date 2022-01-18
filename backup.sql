-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: pepperone
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cardapio`
--

DROP TABLE IF EXISTS `cardapio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cardapio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardapio`
--

LOCK TABLES `cardapio` WRITE;
/*!40000 ALTER TABLE `cardapio` DISABLE KEYS */;
INSERT INTO `cardapio` VALUES (1,'WEB');
/*!40000 ALTER TABLE `cardapio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingrediente`
--

DROP TABLE IF EXISTS `ingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingrediente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingrediente`
--

LOCK TABLES `ingrediente` WRITE;
/*!40000 ALTER TABLE `ingrediente` DISABLE KEYS */;
INSERT INTO `ingrediente` VALUES (1,'mussarela'),(2,'presunto'),(3,'tomate'),(4,'cebola'),(5,'milho'),(6,'champignon'),(7,'palmito'),(8,'catupiry'),(9,'cheddar'),(10,'provolone'),(11,'gorgonzola'),(12,'parmesao'),(13,'lombo'),(14,'bacon'),(15,'frango'),(16,'salame'),(17,'pepperoni'),(18,'oregano'),(19,'manjericao'),(20,'atum'),(21,'calabresa'),(22,'ovo'),(23,'pimentao'),(24,'ervilha'),(25,'batata palha');
/*!40000 ALTER TABLE `ingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingrediente_sabor`
--

DROP TABLE IF EXISTS `ingrediente_sabor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingrediente_sabor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_ingrediente` int NOT NULL,
  `id_sabor` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_ingrediente` (`id_ingrediente`,`id_sabor`),
  KEY `id_sabor` (`id_sabor`),
  CONSTRAINT `ingrediente_sabor_ibfk_1` FOREIGN KEY (`id_ingrediente`) REFERENCES `ingrediente` (`id`),
  CONSTRAINT `ingrediente_sabor_ibfk_2` FOREIGN KEY (`id_sabor`) REFERENCES `sabor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingrediente_sabor`
--

LOCK TABLES `ingrediente_sabor` WRITE;
/*!40000 ALTER TABLE `ingrediente_sabor` DISABLE KEYS */;
INSERT INTO `ingrediente_sabor` VALUES (2,1,2);
/*!40000 ALTER TABLE `ingrediente_sabor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sabor`
--

DROP TABLE IF EXISTS `sabor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sabor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `salgada` tinyint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sabor`
--

LOCK TABLES `sabor` WRITE;
/*!40000 ALTER TABLE `sabor` DISABLE KEYS */;
INSERT INTO `sabor` VALUES (2,'Margherita',1),(3,'Marinara',1),(5,'Diavola',1),(6,'Pepperoni',1),(7,'Capricciosa',1);
/*!40000 ALTER TABLE `sabor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sabor_cardapio`
--

DROP TABLE IF EXISTS `sabor_cardapio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sabor_cardapio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_sabor` int NOT NULL,
  `id_cardapio` int NOT NULL,
  `preco` decimal(13,2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_sabor` (`id_sabor`,`id_cardapio`),
  KEY `id_cardapio` (`id_cardapio`),
  CONSTRAINT `sabor_cardapio_ibfk_1` FOREIGN KEY (`id_sabor`) REFERENCES `sabor` (`id`),
  CONSTRAINT `sabor_cardapio_ibfk_2` FOREIGN KEY (`id_cardapio`) REFERENCES `cardapio` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sabor_cardapio`
--

LOCK TABLES `sabor_cardapio` WRITE;
/*!40000 ALTER TABLE `sabor_cardapio` DISABLE KEYS */;
INSERT INTO `sabor_cardapio` VALUES (1,2,1,30.00),(2,3,1,35.00);
/*!40000 ALTER TABLE `sabor_cardapio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'lucas','120594','lucasld12@gmail.com');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-18 19:17:02
