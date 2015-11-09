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
-- Table structure for table `qa_test_case_flow_map`
--

DROP TABLE IF EXISTS `qa_test_case_flow_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qa_test_case_flow_map` (
  `TEST_CASE_ID` decimal(10,0) NOT NULL,
  `FLOW_ID` decimal(10,0) NOT NULL,
  `MAPPING_DESC` varchar(30) DEFAULT NULL,
  `EXEC_SEQUENCE` decimal(10,0) NOT NULL,
  `DEP_FLOW` decimal(10,0) DEFAULT NULL,
  `TEST_CASE_FLOW_MAP_ID` decimal(10,0) NOT NULL,
  PRIMARY KEY (`TEST_CASE_FLOW_MAP_ID`),
  KEY `QA_TEST_CASE_FLOW_MAP_FK1` (`TEST_CASE_ID`),
  KEY `QA_TEST_CASE_FLOW_MAP_FK2` (`FLOW_ID`),
  CONSTRAINT `QA_TEST_CASE_FLOW_MAP_FK1` FOREIGN KEY (`TEST_CASE_ID`) REFERENCES `qa_test_case` (`TEST_CASE_ID`),
  CONSTRAINT `QA_TEST_CASE_FLOW_MAP_FK2` FOREIGN KEY (`FLOW_ID`) REFERENCES `qa_flow` (`FLOW_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qa_test_case_flow_map`
--

LOCK TABLES `qa_test_case_flow_map` WRITE;
/*!40000 ALTER TABLE `qa_test_case_flow_map` DISABLE KEYS */;
INSERT INTO `qa_test_case_flow_map` VALUES (1,1,'LOGINFLOW',1,NULL,1),(2,2,'Amzon test flow',1,0,2),(3,3,'Flipkart login mapping',1,0,3);
/*!40000 ALTER TABLE `qa_test_case_flow_map` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-09  2:22:44
