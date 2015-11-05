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
-- Table structure for table `qa_flow_step_map`
--

DROP TABLE IF EXISTS `qa_flow_step_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qa_flow_step_map` (
  `FLOW_STEP_MAP_ID` decimal(10,0) NOT NULL,
  `FLOW_ID` decimal(10,0) NOT NULL,
  `STEP_ID` decimal(10,0) NOT NULL,
  `REF_FLOW_ID` decimal(10,0) DEFAULT NULL,
  `MAPPING_DESC` varchar(200) DEFAULT NULL,
  `EXEC_SEQUENCE` decimal(10,0) DEFAULT NULL,
  `REF_STEP_ID` decimal(10,0) DEFAULT NULL,
  `REF_KEY` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`FLOW_STEP_MAP_ID`),
  KEY `QA_FLOW_STEP_MAP_FK1` (`FLOW_ID`),
  KEY `QA_FLOW_STEP_MAP_FK2` (`STEP_ID`),
  KEY `QA_FLOW_STEP_MAP_FK3` (`REF_FLOW_ID`),
  KEY `QA_FLOW_STEP_MAP_FK4` (`REF_STEP_ID`),
  CONSTRAINT `QA_FLOW_STEP_MAP_FK1` FOREIGN KEY (`FLOW_ID`) REFERENCES `qa_flow` (`FLOW_ID`),
  CONSTRAINT `QA_FLOW_STEP_MAP_FK2` FOREIGN KEY (`STEP_ID`) REFERENCES `qa_step` (`STEP_ID`),
  CONSTRAINT `QA_FLOW_STEP_MAP_FK3` FOREIGN KEY (`REF_FLOW_ID`) REFERENCES `qa_flow` (`FLOW_ID`),
  CONSTRAINT `QA_FLOW_STEP_MAP_FK4` FOREIGN KEY (`REF_STEP_ID`) REFERENCES `qa_step` (`STEP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qa_flow_step_map`
--

LOCK TABLES `qa_flow_step_map` WRITE;
/*!40000 ALTER TABLE `qa_flow_step_map` DISABLE KEYS */;
INSERT INTO `qa_flow_step_map` VALUES (1,1,1,NULL,'',3,NULL,NULL),(2,1,2,NULL,NULL,4,NULL,NULL),(3,1,3,NULL,NULL,5,NULL,NULL),(4,1,4,NULL,NULL,6,NULL,NULL),(5,1,5,NULL,NULL,1,NULL,NULL),(6,1,16,NULL,NULL,2,NULL,NULL),(7,2,6,NULL,NULL,1,NULL,NULL),(8,2,7,NULL,NULL,2,NULL,NULL),(9,2,8,NULL,NULL,3,NULL,NULL),(10,2,9,NULL,NULL,4,NULL,NULL),(11,2,10,NULL,NULL,5,NULL,NULL),(12,2,11,NULL,NULL,6,NULL,NULL),(13,2,12,NULL,NULL,7,NULL,NULL),(14,2,13,NULL,NULL,8,NULL,NULL),(15,2,14,NULL,NULL,9,NULL,NULL),(16,2,15,NULL,NULL,10,NULL,NULL);
/*!40000 ALTER TABLE `qa_flow_step_map` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-05  8:50:39
