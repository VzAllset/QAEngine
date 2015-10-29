-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sakila
-- ------------------------------------------------------
-- Server version	5.7.9-log

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
-- Table structure for table `qa_object`
--

DROP TABLE IF EXISTS `qa_object`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qa_object` (
  `OBJ_ID` decimal(10,0) NOT NULL,
  `OBJ_NAME` varchar(30) DEFAULT NULL,
  `OBJ_XPATH` varchar(500) DEFAULT NULL,
  `OBJ_DESC` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`OBJ_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qa_object`
--

LOCK TABLES `qa_object` WRITE;
/*!40000 ALTER TABLE `qa_object` DISABLE KEYS */;
INSERT INTO `qa_object` VALUES (1,'LOGIN_LINK','/html/body/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/ul/li[8]/a','login link in first page'),(2,'USER_TEXT','/html/body/div[9]/div[2]/div/div/div/div/div[1]/div[1]/div/div/div[4]/div[2]/input','USERNAME TEXT BOX'),(3,'PASSWORD_TEXT','/html/body/div[9]/div[2]/div/div/div/div/div[1]/div[1]/div/div/div[4]/div[4]/input','PASSWORD'),(4,'LOGIN_BUTTON','/html/body/div[9]/div[2]/div/div/div/div/div[1]/div[1]/div/div/div[4]/div[7]/input','LOGIN BUTTON'),(5,'SEARCH_BAR','/html/body/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[2]/form/div/div/div[1]/input[1]','SEARCH BOX');
/*!40000 ALTER TABLE `qa_object` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-29 10:47:04
