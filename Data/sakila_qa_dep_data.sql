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
-- Table structure for table `qa_dep_data`
--

DROP TABLE IF EXISTS `qa_dep_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qa_dep_data` (
  `DEP_ID` varchar(20) NOT NULL,
  `DATA_KEY` varchar(20) DEFAULT NULL,
  `DATA_VALUE` varchar(20) DEFAULT NULL,
  `FLOW_ID` decimal(10,0) NOT NULL,
  `CREATED_DT` date DEFAULT NULL,
  `STEP_ID` decimal(10,0) NOT NULL,
  PRIMARY KEY (`DEP_ID`,`FLOW_ID`,`STEP_ID`),
  KEY `QA_DEP_DATA_FK1` (`FLOW_ID`),
  KEY `QA_DEP_DATA_FK2` (`STEP_ID`),
  CONSTRAINT `QA_DEP_DATA_FK1` FOREIGN KEY (`FLOW_ID`) REFERENCES `qa_flow` (`FLOW_ID`),
  CONSTRAINT `QA_DEP_DATA_FK2` FOREIGN KEY (`STEP_ID`) REFERENCES `qa_step` (`STEP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qa_dep_data`
--

LOCK TABLES `qa_dep_data` WRITE;
/*!40000 ALTER TABLE `qa_dep_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `qa_dep_data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-30  7:23:04
