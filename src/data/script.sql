-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: algoritmos_casa_alfajor
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.21-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `categoria_id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_categoriaid` int(11) DEFAULT NULL,
  `categoria_nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`categoria_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,NULL,'Alfajorcitos Unid'),(2,NULL,'Alfajore En Copa'),(3,NULL,'Alfajores Caja Chica'),(4,NULL,'Alfajores Caja Del Mes'),(5,NULL,'Alfajores Caja Grande'),(6,NULL,'Alfajores Caja Loncherita'),(7,NULL,'Alfajores Coctel'),(8,NULL,'Alfajores Familiares'),(9,NULL,'Alfajores Personales'),(10,NULL,'Bebidas Calientes'),(11,NULL,'Bebidas Frías'),(12,NULL,'Berries del peru'),(13,NULL,'Bocaditos Postres'),(14,NULL,'Bocaditos Postres Coctel unida'),(15,NULL,'Bocaditos Salados'),(16,NULL,'Bolsas Reutilizables'),(17,NULL,'Combos'),(18,NULL,'Empanadas'),(19,NULL,'Manjar Blanco'),(20,NULL,'Para Armar en Casa - Alfa Pack'),(21,NULL,'Para Armar en Casa - Dulce Pac'),(22,NULL,'Postres Familiares'),(23,NULL,'Postres Personales'),(24,NULL,'Sándwiches Personales');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `cliente_id` int(11) NOT NULL AUTO_INCREMENT,
  `membresia_id` int(11) NOT NULL,
  `cliente_orden` varchar(45) DEFAULT NULL,
  `cliente_nombres` varchar(45) DEFAULT NULL,
  `cliente_apellidos` varchar(45) DEFAULT NULL,
  `cliente_edad` varchar(45) DEFAULT NULL,
  `cliente_telefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cliente_id`),
  KEY `fk_cliente_id_idx` (`membresia_id`),
  CONSTRAINT `fk_cliente_id` FOREIGN KEY (`membresia_id`) REFERENCES `membresia` (`membresia_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallepedido`
--

DROP TABLE IF EXISTS `detallepedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallepedido` (
  `detallepedido_id` int(11) NOT NULL AUTO_INCREMENT,
  `producto_id` int(11) NOT NULL,
  `pedido_id` int(11) NOT NULL,
  `detallepedido_cantidad` int(11) DEFAULT NULL,
  `detallepedido_precio` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`detallepedido_id`),
  KEY `fk_detallepedido_id1_idx` (`producto_id`),
  KEY `fk_detallepedido_id2_idx` (`pedido_id`),
  CONSTRAINT `fk_detallepedido_id1` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`producto_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detallepedido_id2` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`pedido_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallepedido`
--

LOCK TABLES `detallepedido` WRITE;
/*!40000 ALTER TABLE `detallepedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallepedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membresia`
--

DROP TABLE IF EXISTS `membresia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membresia` (
  `membresia_id` int(11) NOT NULL AUTO_INCREMENT,
  `membresia_nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`membresia_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membresia`
--

LOCK TABLES `membresia` WRITE;
/*!40000 ALTER TABLE `membresia` DISABLE KEYS */;
INSERT INTO `membresia` VALUES (1,'CLÁSICA'),(2,'PLATA'),(3,'ORO'),(4,'BLACK');
/*!40000 ALTER TABLE `membresia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `pedido_id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_id` int(11) NOT NULL,
  `pedido_orden` varchar(45) DEFAULT NULL,
  `pedido_fecha` datetime DEFAULT NULL,
  `pedido_total` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`pedido_id`),
  KEY `fk_pedido_id1_idx` (`cliente_id`),
  CONSTRAINT `fk_pedido_id1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`cliente_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `producto_id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_id` int(11) NOT NULL,
  `producto_nombre` varchar(100) DEFAULT NULL,
  `producto_costo` decimal(10,2) DEFAULT NULL,
  `producto_precio` decimal(10,2) DEFAULT NULL,
  `producto_cantvendida` int(11) DEFAULT NULL,
  PRIMARY KEY (`producto_id`),
  KEY `fk_producto_id1_idx` (`categoria_id`),
  CONSTRAINT `fk_producto_id1` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`categoria_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (13,1,'Trufas - Caja x 10',7.45,14.90,13),(14,1,'Biscrut Copa - Manjar',0.00,10.90,2),(15,1,'Alfajor Tradicional - Personal redondo',4.72,5.90,34),(16,1,'Caja De Alfajores 1 Sabor - Pecana x 16 und',16.20,18.90,3),(17,1,'Pionono - Tradicional con manjar blanco chico',0.00,19.90,10),(18,1,'Pionono - Sabor a chocolate con fudge personal',6.58,7.90,3),(19,1,'Caf? - Capuccino',5.93,7.90,11),(20,1,'Alfa Pack - Chocolate x 20',11.67,14.00,2),(21,1,'Caja De Alfajores 2 Sabores - Tradicional / Casta?a x 10 und',7.93,11.90,2),(22,1,'Chif?n - Sabor a Naranja Grande',16.58,19.90,14),(23,1,'Bolsas De Tela - Chica',5.20,6.50,8),(24,1,'Caja De Alfajores 1 Sabor - Tradicional x 20 und',0.00,18.90,81);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-10 11:14:16
