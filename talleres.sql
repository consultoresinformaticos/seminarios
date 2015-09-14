-- MySQL dump 10.13  Distrib 5.5.43, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: talleres
-- ------------------------------------------------------
-- Server version	5.5.43-0ubuntu0.14.04.1

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
-- Table structure for table `disertantes`
--

DROP TABLE IF EXISTS `disertantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disertantes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `curriculum` text,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disertantes`
--

LOCK TABLES `disertantes` WRITE;
/*!40000 ALTER TABLE `disertantes` DISABLE KEYS */;
INSERT INTO `disertantes` VALUES (0,'Carlos','Bustamante','si','cbustamante@consultoresinformaticos.com.py');
/*!40000 ALTER TABLE `disertantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) DEFAULT NULL,
  `fecha` date NOT NULL,
  `hora_inicio` datetime NOT NULL,
  `hora_fin` datetime NOT NULL,
  `seminarios_id` int(11) NOT NULL,
  `descripcion` text,
  PRIMARY KEY (`id`),
  KEY `fk_evento_seminarios1_idx` (`seminarios_id`),
  CONSTRAINT `fk_evento_seminarios1` FOREIGN KEY (`seminarios_id`) REFERENCES `seminarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (1,'Potenciando su aplicación de Genexus con K2Bt','2015-09-25','2015-09-25 17:00:00','2015-09-25 18:00:00',1,'<p>K2BTools es una herramienta que permite potenciar aún más la productividad que ofrece GeneXus. Utilizando diferentes patrones y extensiones como K2BAudit o el WebPanelDesginer, se logran aplicaciones con mayor calidad en menos tiempo. Entérate de los beneficios que ofrece K2BTools para que tus proyectos Genexus sean cada vez más productivos.</p>');
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento_has_disertantes`
--

DROP TABLE IF EXISTS `evento_has_disertantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento_has_disertantes` (
  `evento_id` int(11) NOT NULL,
  `disertantes_id` int(11) NOT NULL,
  PRIMARY KEY (`evento_id`,`disertantes_id`),
  KEY `fk_evento_has_disertantes_disertantes1_idx` (`disertantes_id`),
  KEY `fk_evento_has_disertantes_evento1_idx` (`evento_id`),
  CONSTRAINT `fk_evento_has_disertantes_disertantes1` FOREIGN KEY (`disertantes_id`) REFERENCES `disertantes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evento_has_disertantes_evento1` FOREIGN KEY (`evento_id`) REFERENCES `evento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento_has_disertantes`
--

LOCK TABLES `evento_has_disertantes` WRITE;
/*!40000 ALTER TABLE `evento_has_disertantes` DISABLE KEYS */;
/*!40000 ALTER TABLE `evento_has_disertantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instituciones`
--

DROP TABLE IF EXISTS `instituciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instituciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instituciones`
--

LOCK TABLES `instituciones` WRITE;
/*!40000 ALTER TABLE `instituciones` DISABLE KEYS */;
INSERT INTO `instituciones` VALUES (1,'UNA'),(2,'UCSA'),(3,'UAA'),(4,'UNINORTE'),(5,'UTIC');
/*!40000 ALTER TABLE `instituciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pantalla_usuario`
--

DROP TABLE IF EXISTS `pantalla_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pantalla_usuario` (
  `id_rol` int(11) NOT NULL,
  `id_pantalla` int(11) NOT NULL,
  PRIMARY KEY (`id_rol`,`id_pantalla`),
  KEY `fk_pantalla` (`id_pantalla`),
  CONSTRAINT `fk_pantalla` FOREIGN KEY (`id_pantalla`) REFERENCES `pantallas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rol` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pantalla_usuario`
--

LOCK TABLES `pantalla_usuario` WRITE;
/*!40000 ALTER TABLE `pantalla_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `pantalla_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pantallas`
--

DROP TABLE IF EXISTS `pantallas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pantallas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pantalla` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pantallas`
--

LOCK TABLES `pantallas` WRITE;
/*!40000 ALTER TABLE `pantallas` DISABLE KEYS */;
/*!40000 ALTER TABLE `pantallas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participantes`
--

DROP TABLE IF EXISTS `participantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participantes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `instituciones_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_participantes_instituciones1_idx` (`instituciones_id`),
  CONSTRAINT `fk_participantes_instituciones1` FOREIGN KEY (`instituciones_id`) REFERENCES `instituciones` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participantes`
--

LOCK TABLES `participantes` WRITE;
/*!40000 ALTER TABLE `participantes` DISABLE KEYS */;
INSERT INTO `participantes` VALUES (1,'enrique','rodriguez','enriquev.rodriguez@gmail.com',NULL,1),(2,'Alicia','Rodríguez','alirodrinunez@gmail.com',NULL,4),(3,'Enrique','Rodríguez','enriquev.rodriguez@gmail.com',NULL,3),(4,'lourdes','Nuñez','lulupy86@gmail.com',NULL,1),(5,'enrique','rodriguez','erodriguez@consultoresinformaticos.com.py',NULL,3),(6,'Karumbé ','Paiva','karumbe@domain.com',NULL,1);
/*!40000 ALTER TABLE `participantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participantes_has_evento`
--

DROP TABLE IF EXISTS `participantes_has_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participantes_has_evento` (
  `participantes_id` int(11) NOT NULL,
  `evento_id` int(11) NOT NULL,
  `asistencia` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`participantes_id`,`evento_id`),
  KEY `fk_participantes_has_evento_evento1_idx` (`evento_id`),
  KEY `fk_participantes_has_evento_participantes_idx` (`participantes_id`),
  CONSTRAINT `fk_participantes_has_evento_evento1` FOREIGN KEY (`evento_id`) REFERENCES `evento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_participantes_has_evento_participantes` FOREIGN KEY (`participantes_id`) REFERENCES `participantes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participantes_has_evento`
--

LOCK TABLES `participantes_has_evento` WRITE;
/*!40000 ALTER TABLE `participantes_has_evento` DISABLE KEYS */;
INSERT INTO `participantes_has_evento` VALUES (1,1,0),(2,1,0),(3,1,0),(4,1,0),(5,1,0),(6,1,0);
/*!40000 ALTER TABLE `participantes_has_evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'admin');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seminarios`
--

DROP TABLE IF EXISTS `seminarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seminarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seminarios`
--

LOCK TABLES `seminarios` WRITE;
/*!40000 ALTER TABLE `seminarios` DISABLE KEYS */;
INSERT INTO `seminarios` VALUES (1,'ETyC 2015','XIV exposición de ciencia y tecnología');
/*!40000 ALTER TABLE `seminarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rol` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_role` (`rol`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'erodriguez','bajocontrol',1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-14 11:09:04
