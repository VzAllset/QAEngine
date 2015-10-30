-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 113.128.162.200    Database: sakila
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
-- Table structure for table `qa_step`
--

DROP TABLE IF EXISTS `qa_step`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qa_step` (
  `STEP_ID` decimal(10,0) NOT NULL,
  `STEP_NAME` varchar(30) DEFAULT NULL,
  `ACTION` varchar(30) DEFAULT NULL,
  `OBJ_ID` decimal(10,0) NOT NULL,
  `DATA_ID` decimal(10,0) NOT NULL,
  `STEP_DESC` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`STEP_ID`),
  KEY `QA_STEP_FK1` (`OBJ_ID`),
  KEY `QA_STEP_FK2` (`DATA_ID`),
  CONSTRAINT `QA_STEP_FK1` FOREIGN KEY (`OBJ_ID`) REFERENCES `qa_object` (`OBJ_ID`),
  CONSTRAINT `QA_STEP_FK2` FOREIGN KEY (`DATA_ID`) REFERENCES `qa_data` (`DATA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qa_step`
--

LOCK TABLES `qa_step` WRITE;
/*!40000 ALTER TABLE `qa_step` DISABLE KEYS */;
INSERT INTO `qa_step` VALUES (1,'CLICK_LOGIN','NORMAL_CLICK',1,3,'FIRST CLICK'),(2,'FILL_USERNAME','FILL',2,1,'fILL USERNAME'),(3,'FILL_PASSWORD','FILL',3,2,'FILL PASSWORD'),(4,'CLICK_LOGIN_BUTTON','NORMAL_CLICK',4,3,'CLICK LOGIN'),(5,'CLICK_SEARCH_BAR','NORMAL_CLICK',5,3,'DUMMY CLICK'),(6,'CLICK_LOGIN','NORMAL_CLICK',6,3,'DUMMY CLICK'),(7,'CLICK_SIGNIN','NORMAL_CLICK',7,3,'DUMMY CLICK'),(8,'FILL USERNAME','FILL',8,1,'Fill username'),(9,'FILL PASSWORD','FILL',9,4,'Fill password'),(10,'LOGIN','NORMAL_CLICK',10,3,'DUMMY CLICK'),(11,'DROP MY LOGIN','NORMAL_CLICK',11,3,'DUMMY CLICK'),(12,'MY WISH LIST','NORMAL_CLICK',12,3,'DUMMY CLICK'),(13,'ADDING CART','NORMAL_CLICK',13,3,'DUMMY CLICK'),(14,'NAV CART','NORMAL_CLICK',14,3,'DUMMY CLICK'),(15,'CHECK_OUT','NORMAL_CLICK',15,3,'DUMMY CLICK');
/*!40000 ALTER TABLE `qa_step` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-30  7:23:09