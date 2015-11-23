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
-- Table structure for table `qa_test_case`
--

DROP TABLE IF EXISTS `qa_test_case`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qa_test_case` (
  `TEST_CASE_ID` decimal(10,0) NOT NULL,
  `TEST_CASE_NAME` varchar(50) DEFAULT NULL,
  `TEST_CASE_DESC` varchar(200) DEFAULT NULL,
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `CREATE_USERID` varchar(15) DEFAULT NULL,
  `LAST_UPDATED_USERID` varchar(15) DEFAULT NULL,
  `LAST_UPDATED_DT` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`TEST_CASE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qa_test_case`
--

LOCK TABLES `qa_test_case` WRITE;
/*!40000 ALTER TABLE `qa_test_case` DISABLE KEYS */;
INSERT INTO `qa_test_case` VALUES (1,'CREATE_ORDER','Creating an order','2015-10-29 15:49:56','Barath','Barath','2015-10-29 15:49:56'),(2,'AMAZON_ORDER','creating an order','2015-10-30 19:00:00','Dinesh','Dinesh','2015-10-30 19:00:00'),(3,'Flipkart test module','Flipkart test login flow was successful','2015-11-08 22:44:39','Barath',NULL,'2015-11-09 05:45:06'),(4,'Jira Test case','Test Case for JIRA tool','2015-11-11 18:13:34','Barath',NULL,'2015-11-20 10:46:39'),(5,'Amazon Test Case','Amazon site case','2015-11-11 05:31:50','Barath',NULL,'2015-11-21 10:32:00'),(6,'Wireline Order','Ordering a FIOS','2015-11-23 07:31:54','',NULL,'2015-11-21 12:32:01');
/*!40000 ALTER TABLE `qa_test_case` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-23 17:49:34
