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
-- Table structure for table `qa_test_suite_test_case_map`
--

DROP TABLE IF EXISTS `qa_test_suite_test_case_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qa_test_suite_test_case_map` (
  `TEST_SUITE_ID` decimal(10,0) NOT NULL,
  `TEST_CASE_ID` decimal(10,0) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `DEP_SUITE` decimal(10,0) DEFAULT NULL,
  `EXEC_SEQUENCE` decimal(10,0) DEFAULT NULL,
  `TEST_SUITE_TEST_CASE_MAP_ID` decimal(10,0) NOT NULL,
  PRIMARY KEY (`TEST_SUITE_TEST_CASE_MAP_ID`),
  KEY `TEST_CASE_ID` (`TEST_CASE_ID`),
  KEY `qa_test_suite_test_case_map_FK2` (`TEST_SUITE_ID`),
  KEY `qa_test_suite_test_case_map_FK3` (`DEP_SUITE`),
  CONSTRAINT `qa_test_suite_test_case_map_FK2` FOREIGN KEY (`TEST_SUITE_ID`) REFERENCES `qa_test_suite` (`TEST_SUITE_ID`),
  CONSTRAINT `qa_test_suite_test_case_map_FK3` FOREIGN KEY (`DEP_SUITE`) REFERENCES `qa_test_suite` (`TEST_SUITE_ID`),
  CONSTRAINT `qa_test_suite_test_case_map_ibfk_1` FOREIGN KEY (`TEST_CASE_ID`) REFERENCES `qa_test_case` (`TEST_CASE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qa_test_suite_test_case_map`
--

LOCK TABLES `qa_test_suite_test_case_map` WRITE;
/*!40000 ALTER TABLE `qa_test_suite_test_case_map` DISABLE KEYS */;
INSERT INTO `qa_test_suite_test_case_map` VALUES (1,1,'test suite',NULL,1,1),(2,2,'test suite',NULL,2,2),(3,3,'test module',NULL,1,3),(4,4,'JIRA Test suite to test case mapping',NULL,1,4);
/*!40000 ALTER TABLE `qa_test_suite_test_case_map` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-20 19:56:32
