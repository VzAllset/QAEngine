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
INSERT INTO `qa_step` VALUES (1,'FLIPKART_LOGIN_CLICK','NORMAL_CLICK',1,3,'FIRST CLICK'),(2,'FILL_USERNAME','FILL',2,1,'fILL USERNAME'),(3,'FILL_PASSWORD','FILL',3,2,'FILL PASSWORD'),(4,'CLICK_LOGIN_BUTTON','NORMAL_CLICK',4,3,'CLICK LOGIN'),(5,'CLICK_SEARCH_BAR','NORMAL_CLICK',5,3,'DUMMY CLICK'),(6,'AMAZON_CLICK_LOGIN','NORMAL_CLICK',6,3,'DUMMY CLICK'),(7,'CLICK_SIGNIN','NORMAL_CLICK',7,3,'DUMMY CLICK'),(8,'AMAZON FILL USERNAME','FILL',8,1,'Fill username'),(9,'AMAZON FILL PASSWORD','FILL',9,4,'Fill password'),(10,'AMAZON_SIGNIN','NORMAL_CLICK',10,3,'DUMMY CLICK'),(11,'DROP MY LOGIN','NORMAL_CLICK',11,3,'DUMMY CLICK'),(12,'MY WISH LIST','NORMAL_CLICK',12,3,'DUMMY CLICK'),(13,'ADDING CART','NORMAL_CLICK',13,3,'DUMMY CLICK'),(14,'NAV CART','NORMAL_CLICK',14,3,'DUMMY CLICK'),(15,'CHECK_OUT','NORMAL_CLICK',15,3,'DUMMY CLICK'),(16,'Dummy click','NORMAL_CLICK',1,3,'DUMMY CLICK'),(17,'Fill username','FILL',19,6,'Fill username'),(18,'Fill password','FILL',20,7,'Fill password'),(19,'Click login JIRA','NORMAL_CLICK',21,3,'Click login btn'),(20,'Click New Issue btn','NORMAL_CLICK',22,3,'Click new issue btn'),(21,'Fill in summary','FILL',23,8,'Filling summary for JIRA defect'),(22,'Submit Issue','NORMAL_CLICK',24,3,'Submitting issue'),(23,'Capture ID','CAPTURE_ATTR',25,3,'Capture id generated'),(24,'Fill search','FILL',26,3,'Fill search box'),(25,'ENTER','PRESS_ENTER',26,3,'Press Enter Key'),(26,'Mouseover_YOUR_ACCOUNT','HOVER',27,3,'Hover over YOUR_ACCOUNT'),(27,'FIOS Check availability click','SELECTABLE_CLICK',28,3,''),(28,'Hover Over Shop','HOVER',35,3,''),(29,'Enter FIOS Address','FILL',30,9,''),(30,'Enter FIOS Zip','FILL',31,10,''),(31,'FIOS Click Continue Button','NORMAL_CLICK',32,3,''),(32,'FIOS Another Continue','NORMAL_CLICK',33,3,''),(33,'FIOS Click on Order Now','NORMAL_CLICK',34,3,''),(34,'Switch to IFrame','IFRAME_SWITCH',36,3,'Switch to Iframe DOM'),(35,'Click on slide','NORMAL_CLICK',37,3,'Click on slideshow'),(36,'Uncheck Remember Location','NORMAL_CLICK',29,3,''),(99999999,'Validation of flow','DUMMY',3,3,'');
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

-- Dump completed on 2015-11-23 17:49:40
