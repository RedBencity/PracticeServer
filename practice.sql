CREATE DATABASE  IF NOT EXISTS `practice` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `practice`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: practice
-- ------------------------------------------------------
-- Server version	5.7.4-m14

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
-- Table structure for table `fuci`
--

DROP TABLE IF EXISTS `fuci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fuci` (
  `phone` varchar(45) NOT NULL,
  `question001` varchar(5) DEFAULT NULL,
  `question002` varchar(5) DEFAULT NULL,
  `question003` varchar(5) DEFAULT NULL,
  `question004` varchar(5) DEFAULT NULL,
  `question005` varchar(5) DEFAULT NULL,
  `question006` varchar(5) DEFAULT NULL,
  `question007` varchar(5) DEFAULT NULL,
  `question008` varchar(5) DEFAULT NULL,
  `question009` varchar(5) DEFAULT NULL,
  `question010` varchar(5) DEFAULT NULL,
  `question011` varchar(5) DEFAULT NULL,
  `question012` varchar(5) DEFAULT NULL,
  `question013` varchar(5) DEFAULT NULL,
  `question014` varchar(5) DEFAULT NULL,
  `question015` varchar(5) DEFAULT NULL,
  `question016` varchar(5) DEFAULT NULL,
  `question017` varchar(5) DEFAULT NULL,
  `question018` varchar(5) DEFAULT NULL,
  `question019` varchar(5) DEFAULT NULL,
  `question020` varchar(5) DEFAULT NULL,
  `question021` varchar(5) DEFAULT NULL,
  `question022` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fuci`
--

LOCK TABLES `fuci` WRITE;
/*!40000 ALTER TABLE `fuci` DISABLE KEYS */;
INSERT INTO `fuci` VALUES ('15668327535','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true');
/*!40000 ALTER TABLE `fuci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jieci`
--

DROP TABLE IF EXISTS `jieci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jieci` (
  `phone` varchar(45) NOT NULL,
  `question001` varchar(5) DEFAULT NULL,
  `question002` varchar(5) DEFAULT NULL,
  `question003` varchar(5) DEFAULT NULL,
  `question004` varchar(5) DEFAULT NULL,
  `question005` varchar(5) DEFAULT NULL,
  `question006` varchar(5) DEFAULT NULL,
  `question007` varchar(5) DEFAULT NULL,
  `question008` varchar(5) DEFAULT NULL,
  `question009` varchar(5) DEFAULT NULL,
  `question010` varchar(5) DEFAULT NULL,
  `question011` varchar(5) DEFAULT NULL,
  `question012` varchar(5) DEFAULT NULL,
  `question013` varchar(5) DEFAULT NULL,
  `question014` varchar(5) DEFAULT NULL,
  `question015` varchar(5) DEFAULT NULL,
  `question016` varchar(5) DEFAULT NULL,
  `question017` varchar(5) DEFAULT NULL,
  `question018` varchar(5) DEFAULT NULL,
  `question019` varchar(5) DEFAULT NULL,
  `question020` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jieci`
--

LOCK TABLES `jieci` WRITE;
/*!40000 ALTER TABLE `jieci` DISABLE KEYS */;
INSERT INTO `jieci` VALUES ('15668327535',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `jieci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal`
--

DROP TABLE IF EXISTS `personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personal` (
  `p_phone` varchar(11) NOT NULL,
  `p_password` varchar(45) NOT NULL,
  `p_nickname` varchar(45) NOT NULL,
  PRIMARY KEY (`p_phone`),
  UNIQUE KEY `p_phone_UNIQUE` (`p_phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal`
--

LOCK TABLES `personal` WRITE;
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
INSERT INTO `personal` VALUES ('15668327535','000','red'),('18366189150','123456','ben');
/*!40000 ALTER TABLE `personal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `save_fuci`
--

DROP TABLE IF EXISTS `save_fuci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `save_fuci` (
  `phone` varchar(45) NOT NULL,
  `question001` varchar(20) DEFAULT NULL,
  `question002` varchar(20) DEFAULT NULL,
  `question003` varchar(20) DEFAULT NULL,
  `question004` varchar(20) DEFAULT NULL,
  `question005` varchar(20) DEFAULT NULL,
  `question006` varchar(20) DEFAULT NULL,
  `question007` varchar(20) DEFAULT NULL,
  `question008` varchar(20) DEFAULT NULL,
  `question009` varchar(20) DEFAULT NULL,
  `question010` varchar(20) DEFAULT NULL,
  `question011` varchar(20) DEFAULT NULL,
  `question012` varchar(20) DEFAULT NULL,
  `question013` varchar(20) DEFAULT NULL,
  `question014` varchar(20) DEFAULT NULL,
  `question015` varchar(20) DEFAULT NULL,
  `question016` varchar(20) DEFAULT NULL,
  `question017` varchar(20) DEFAULT NULL,
  `question018` varchar(20) DEFAULT NULL,
  `question019` varchar(20) DEFAULT NULL,
  `question020` varchar(20) DEFAULT NULL,
  `question021` varchar(20) DEFAULT NULL,
  `question022` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `save_fuci`
--

LOCK TABLES `save_fuci` WRITE;
/*!40000 ALTER TABLE `save_fuci` DISABLE KEYS */;
/*!40000 ALTER TABLE `save_fuci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `save_jieci`
--

DROP TABLE IF EXISTS `save_jieci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `save_jieci` (
  `phone` varchar(45) NOT NULL,
  `question001` varchar(20) DEFAULT NULL,
  `question002` varchar(20) DEFAULT NULL,
  `question003` varchar(20) DEFAULT NULL,
  `question004` varchar(20) DEFAULT NULL,
  `question005` varchar(20) DEFAULT NULL,
  `question006` varchar(20) DEFAULT NULL,
  `question007` varchar(20) DEFAULT NULL,
  `question008` varchar(20) DEFAULT NULL,
  `question009` varchar(20) DEFAULT NULL,
  `question010` varchar(20) DEFAULT NULL,
  `question011` varchar(20) DEFAULT NULL,
  `question012` varchar(20) DEFAULT NULL,
  `question013` varchar(20) DEFAULT NULL,
  `question014` varchar(20) DEFAULT NULL,
  `question015` varchar(20) DEFAULT NULL,
  `question016` varchar(20) DEFAULT NULL,
  `question017` varchar(20) DEFAULT NULL,
  `question018` varchar(20) DEFAULT NULL,
  `question019` varchar(20) DEFAULT NULL,
  `question020` varchar(20) DEFAULT NULL,
  `question021` varchar(20) DEFAULT NULL,
  `question022` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `save_jieci`
--

LOCK TABLES `save_jieci` WRITE;
/*!40000 ALTER TABLE `save_jieci` DISABLE KEYS */;
/*!40000 ALTER TABLE `save_jieci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `save_shitai`
--

DROP TABLE IF EXISTS `save_shitai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `save_shitai` (
  `phone` varchar(45) NOT NULL,
  `question001` varchar(20) DEFAULT NULL,
  `question002` varchar(20) DEFAULT NULL,
  `question003` varchar(20) DEFAULT NULL,
  `question004` varchar(20) DEFAULT NULL,
  `question005` varchar(20) DEFAULT NULL,
  `question006` varchar(20) DEFAULT NULL,
  `question007` varchar(20) DEFAULT NULL,
  `question008` varchar(20) DEFAULT NULL,
  `question009` varchar(20) DEFAULT NULL,
  `question010` varchar(20) DEFAULT NULL,
  `question011` varchar(20) DEFAULT NULL,
  `question012` varchar(20) DEFAULT NULL,
  `question013` varchar(20) DEFAULT NULL,
  `question014` varchar(20) DEFAULT NULL,
  `question015` varchar(20) DEFAULT NULL,
  `question016` varchar(20) DEFAULT NULL,
  `question017` varchar(20) DEFAULT NULL,
  `question018` varchar(20) DEFAULT NULL,
  `question019` varchar(20) DEFAULT NULL,
  `question020` varchar(20) DEFAULT NULL,
  `question021` varchar(20) DEFAULT NULL,
  `question022` varchar(20) DEFAULT NULL,
  `question023` varchar(20) DEFAULT NULL,
  `question024` varchar(20) DEFAULT NULL,
  `question025` varchar(20) DEFAULT NULL,
  `question026` varchar(20) DEFAULT NULL,
  `question027` varchar(20) DEFAULT NULL,
  `question028` varchar(20) DEFAULT NULL,
  `question029` varchar(20) DEFAULT NULL,
  `question030` varchar(20) DEFAULT NULL,
  `question031` varchar(20) DEFAULT NULL,
  `question032` varchar(20) DEFAULT NULL,
  `question033` varchar(20) DEFAULT NULL,
  `question034` varchar(20) DEFAULT NULL,
  `question035` varchar(20) DEFAULT NULL,
  `question036` varchar(20) DEFAULT NULL,
  `question037` varchar(20) DEFAULT NULL,
  `question038` varchar(20) DEFAULT NULL,
  `question039` varchar(20) DEFAULT NULL,
  `question040` varchar(20) DEFAULT NULL,
  `question041` varchar(20) DEFAULT NULL,
  `question042` varchar(20) DEFAULT NULL,
  `question043` varchar(20) DEFAULT NULL,
  `question044` varchar(20) DEFAULT NULL,
  `question045` varchar(20) DEFAULT NULL,
  `question046` varchar(20) DEFAULT NULL,
  `question047` varchar(20) DEFAULT NULL,
  `question048` varchar(20) DEFAULT NULL,
  `question049` varchar(20) DEFAULT NULL,
  `question050` varchar(20) DEFAULT NULL,
  `question051` varchar(20) DEFAULT NULL,
  `question052` varchar(20) DEFAULT NULL,
  `question053` varchar(20) DEFAULT NULL,
  `question054` varchar(20) DEFAULT NULL,
  `question055` varchar(20) DEFAULT NULL,
  `question056` varchar(20) DEFAULT NULL,
  `question057` varchar(20) DEFAULT NULL,
  `question058` varchar(20) DEFAULT NULL,
  `question059` varchar(20) DEFAULT NULL,
  `question060` varchar(20) DEFAULT NULL,
  `question061` varchar(20) DEFAULT NULL,
  `question062` varchar(20) DEFAULT NULL,
  `question063` varchar(20) DEFAULT NULL,
  `question064` varchar(20) DEFAULT NULL,
  `question065` varchar(20) DEFAULT NULL,
  `question066` varchar(20) DEFAULT NULL,
  `question067` varchar(20) DEFAULT NULL,
  `question068` varchar(20) DEFAULT NULL,
  `question069` varchar(20) DEFAULT NULL,
  `question070` varchar(20) DEFAULT NULL,
  `question071` varchar(20) DEFAULT NULL,
  `question072` varchar(20) DEFAULT NULL,
  `question073` varchar(20) DEFAULT NULL,
  `question074` varchar(20) DEFAULT NULL,
  `question075` varchar(20) DEFAULT NULL,
  `question076` varchar(20) DEFAULT NULL,
  `question077` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `save_shitai`
--

LOCK TABLES `save_shitai` WRITE;
/*!40000 ALTER TABLE `save_shitai` DISABLE KEYS */;
INSERT INTO `save_shitai` VALUES ('15668327535',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'save','save',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `save_shitai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `save_wenziyingyong`
--

DROP TABLE IF EXISTS `save_wenziyingyong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `save_wenziyingyong` (
  `phone` varchar(45) NOT NULL,
  `question001` varchar(20) DEFAULT NULL,
  `question002` varchar(20) DEFAULT NULL,
  `question003` varchar(20) DEFAULT NULL,
  `question004` varchar(20) DEFAULT NULL,
  `question005` varchar(20) DEFAULT NULL,
  `question006` varchar(20) DEFAULT NULL,
  `question007` varchar(20) DEFAULT NULL,
  `question008` varchar(20) DEFAULT NULL,
  `question009` varchar(20) DEFAULT NULL,
  `question010` varchar(20) DEFAULT NULL,
  `question011` varchar(20) DEFAULT NULL,
  `question012` varchar(20) DEFAULT NULL,
  `question013` varchar(20) DEFAULT NULL,
  `question014` varchar(20) DEFAULT NULL,
  `question015` varchar(20) DEFAULT NULL,
  `question016` varchar(20) DEFAULT NULL,
  `question017` varchar(20) DEFAULT NULL,
  `question018` varchar(20) DEFAULT NULL,
  `question019` varchar(20) DEFAULT NULL,
  `question020` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `save_wenziyingyong`
--

LOCK TABLES `save_wenziyingyong` WRITE;
/*!40000 ALTER TABLE `save_wenziyingyong` DISABLE KEYS */;
/*!40000 ALTER TABLE `save_wenziyingyong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `save_xingrongci`
--

DROP TABLE IF EXISTS `save_xingrongci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `save_xingrongci` (
  `phone` varchar(45) NOT NULL,
  `question001` varchar(20) DEFAULT NULL,
  `question002` varchar(20) DEFAULT NULL,
  `question003` varchar(20) DEFAULT NULL,
  `question004` varchar(20) DEFAULT NULL,
  `question005` varchar(20) DEFAULT NULL,
  `question006` varchar(20) DEFAULT NULL,
  `question007` varchar(20) DEFAULT NULL,
  `question008` varchar(20) DEFAULT NULL,
  `question009` varchar(20) DEFAULT NULL,
  `question010` varchar(20) DEFAULT NULL,
  `question011` varchar(20) DEFAULT NULL,
  `question012` varchar(20) DEFAULT NULL,
  `question013` varchar(20) DEFAULT NULL,
  `question014` varchar(20) DEFAULT NULL,
  `question015` varchar(20) DEFAULT NULL,
  `question016` varchar(20) DEFAULT NULL,
  `question017` varchar(20) DEFAULT NULL,
  `question018` varchar(20) DEFAULT NULL,
  `question019` varchar(20) DEFAULT NULL,
  `question020` varchar(20) DEFAULT NULL,
  `question021` varchar(20) DEFAULT NULL,
  `question022` varchar(20) DEFAULT NULL,
  `question023` varchar(20) DEFAULT NULL,
  `question024` varchar(20) DEFAULT NULL,
  `question025` varchar(20) DEFAULT NULL,
  `question026` varchar(20) DEFAULT NULL,
  `question027` varchar(20) DEFAULT NULL,
  `question028` varchar(20) DEFAULT NULL,
  `question029` varchar(20) DEFAULT NULL,
  `question030` varchar(20) DEFAULT NULL,
  `question031` varchar(20) DEFAULT NULL,
  `question032` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `save_xingrongci`
--

LOCK TABLES `save_xingrongci` WRITE;
/*!40000 ALTER TABLE `save_xingrongci` DISABLE KEYS */;
/*!40000 ALTER TABLE `save_xingrongci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shitai`
--

DROP TABLE IF EXISTS `shitai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shitai` (
  `phone` varchar(45) NOT NULL,
  `question001` varchar(5) DEFAULT NULL,
  `question002` varchar(5) DEFAULT NULL,
  `question003` varchar(5) DEFAULT NULL,
  `question004` varchar(5) DEFAULT NULL,
  `question005` varchar(5) DEFAULT NULL,
  `question006` varchar(5) DEFAULT NULL,
  `question007` varchar(5) DEFAULT NULL,
  `question008` varchar(5) DEFAULT NULL,
  `question009` varchar(5) DEFAULT NULL,
  `question010` varchar(5) DEFAULT NULL,
  `question011` varchar(5) DEFAULT NULL,
  `question012` varchar(5) DEFAULT NULL,
  `question013` varchar(5) DEFAULT NULL,
  `question014` varchar(5) DEFAULT NULL,
  `question015` varchar(5) DEFAULT NULL,
  `question016` varchar(5) DEFAULT NULL,
  `question017` varchar(5) DEFAULT NULL,
  `question018` varchar(5) DEFAULT NULL,
  `question019` varchar(5) DEFAULT NULL,
  `question020` varchar(5) DEFAULT NULL,
  `question021` varchar(5) DEFAULT NULL,
  `question022` varchar(5) DEFAULT NULL,
  `question023` varchar(5) DEFAULT NULL,
  `question024` varchar(5) DEFAULT NULL,
  `question025` varchar(5) DEFAULT NULL,
  `question026` varchar(5) DEFAULT NULL,
  `question027` varchar(5) DEFAULT NULL,
  `question028` varchar(5) DEFAULT NULL,
  `question029` varchar(5) DEFAULT NULL,
  `question030` varchar(5) DEFAULT NULL,
  `question031` varchar(5) DEFAULT NULL,
  `question032` varchar(5) DEFAULT NULL,
  `question033` varchar(5) DEFAULT NULL,
  `question034` varchar(5) DEFAULT NULL,
  `question035` varchar(5) DEFAULT NULL,
  `question036` varchar(5) DEFAULT NULL,
  `question037` varchar(5) DEFAULT NULL,
  `question038` varchar(5) DEFAULT NULL,
  `question039` varchar(5) DEFAULT NULL,
  `question040` varchar(5) DEFAULT NULL,
  `question041` varchar(5) DEFAULT NULL,
  `question042` varchar(5) DEFAULT NULL,
  `question043` varchar(5) DEFAULT NULL,
  `question044` varchar(5) DEFAULT NULL,
  `question045` varchar(5) DEFAULT NULL,
  `question046` varchar(5) DEFAULT NULL,
  `question047` varchar(5) DEFAULT NULL,
  `question048` varchar(5) DEFAULT NULL,
  `question049` varchar(5) DEFAULT NULL,
  `question050` varchar(5) DEFAULT NULL,
  `question051` varchar(5) DEFAULT NULL,
  `question052` varchar(5) DEFAULT NULL,
  `question053` varchar(5) DEFAULT NULL,
  `question054` varchar(5) DEFAULT NULL,
  `question055` varchar(5) DEFAULT NULL,
  `question056` varchar(5) DEFAULT NULL,
  `question057` varchar(5) DEFAULT NULL,
  `question058` varchar(5) DEFAULT NULL,
  `question059` varchar(5) DEFAULT NULL,
  `question060` varchar(5) DEFAULT NULL,
  `question061` varchar(5) DEFAULT NULL,
  `question062` varchar(5) DEFAULT NULL,
  `question063` varchar(5) DEFAULT NULL,
  `question064` varchar(5) DEFAULT NULL,
  `question065` varchar(5) DEFAULT NULL,
  `question066` varchar(5) DEFAULT NULL,
  `question067` varchar(5) DEFAULT NULL,
  `question068` varchar(5) DEFAULT NULL,
  `question069` varchar(5) DEFAULT NULL,
  `question070` varchar(5) DEFAULT NULL,
  `question071` varchar(5) DEFAULT NULL,
  `question072` varchar(5) DEFAULT NULL,
  `question073` varchar(5) DEFAULT NULL,
  `question074` varchar(5) DEFAULT NULL,
  `question075` varchar(5) DEFAULT NULL,
  `question076` varchar(5) DEFAULT NULL,
  `question077` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shitai`
--

LOCK TABLES `shitai` WRITE;
/*!40000 ALTER TABLE `shitai` DISABLE KEYS */;
INSERT INTO `shitai` VALUES ('15668327535','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true','true',NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('18366189150',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `shitai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statistics`
--

DROP TABLE IF EXISTS `statistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statistics` (
  `phone` varchar(45) NOT NULL,
  `yingyu_right` int(11) DEFAULT NULL,
  `yingyu_total` int(11) DEFAULT NULL,
  `yuwen_right` int(11) DEFAULT NULL,
  `yuwen_total` int(11) DEFAULT NULL,
  `shuxue_right` int(11) DEFAULT NULL,
  `shuxue_total` int(11) DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statistics`
--

LOCK TABLES `statistics` WRITE;
/*!40000 ALTER TABLE `statistics` DISABLE KEYS */;
INSERT INTO `statistics` VALUES ('15668327535',21,106,10,20,0,0),('18366189150',2,10,0,0,0,0);
/*!40000 ALTER TABLE `statistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wenziyingyong`
--

DROP TABLE IF EXISTS `wenziyingyong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wenziyingyong` (
  `phone` varchar(45) NOT NULL,
  `question001` varchar(20) DEFAULT NULL,
  `question002` varchar(20) DEFAULT NULL,
  `question003` varchar(20) DEFAULT NULL,
  `question004` varchar(20) DEFAULT NULL,
  `question005` varchar(20) DEFAULT NULL,
  `question006` varchar(20) DEFAULT NULL,
  `question007` varchar(20) DEFAULT NULL,
  `question008` varchar(20) DEFAULT NULL,
  `question009` varchar(20) DEFAULT NULL,
  `question010` varchar(20) DEFAULT NULL,
  `question011` varchar(20) DEFAULT NULL,
  `question012` varchar(20) DEFAULT NULL,
  `question013` varchar(20) DEFAULT NULL,
  `question014` varchar(20) DEFAULT NULL,
  `question015` varchar(20) DEFAULT NULL,
  `question016` varchar(20) DEFAULT NULL,
  `question017` varchar(20) DEFAULT NULL,
  `question018` varchar(20) DEFAULT NULL,
  `question019` varchar(20) DEFAULT NULL,
  `question020` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wenziyingyong`
--

LOCK TABLES `wenziyingyong` WRITE;
/*!40000 ALTER TABLE `wenziyingyong` DISABLE KEYS */;
/*!40000 ALTER TABLE `wenziyingyong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xingrongci`
--

DROP TABLE IF EXISTS `xingrongci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xingrongci` (
  `phone` varchar(45) NOT NULL,
  `question001` varchar(5) DEFAULT NULL,
  `question002` varchar(5) DEFAULT NULL,
  `question003` varchar(5) DEFAULT NULL,
  `question004` varchar(5) DEFAULT NULL,
  `question005` varchar(5) DEFAULT NULL,
  `question006` varchar(5) DEFAULT NULL,
  `question007` varchar(5) DEFAULT NULL,
  `question008` varchar(5) DEFAULT NULL,
  `question009` varchar(5) DEFAULT NULL,
  `question010` varchar(5) DEFAULT NULL,
  `question011` varchar(5) DEFAULT NULL,
  `question012` varchar(5) DEFAULT NULL,
  `question013` varchar(5) DEFAULT NULL,
  `question014` varchar(5) DEFAULT NULL,
  `question015` varchar(5) DEFAULT NULL,
  `question016` varchar(5) DEFAULT NULL,
  `question017` varchar(5) DEFAULT NULL,
  `question018` varchar(5) DEFAULT NULL,
  `question019` varchar(5) DEFAULT NULL,
  `question020` varchar(5) DEFAULT NULL,
  `question021` varchar(5) DEFAULT NULL,
  `question022` varchar(5) DEFAULT NULL,
  `question023` varchar(5) DEFAULT NULL,
  `question024` varchar(5) DEFAULT NULL,
  `question025` varchar(5) DEFAULT NULL,
  `question026` varchar(5) DEFAULT NULL,
  `question027` varchar(5) DEFAULT NULL,
  `question028` varchar(5) DEFAULT NULL,
  `question029` varchar(5) DEFAULT NULL,
  `question030` varchar(5) DEFAULT NULL,
  `question031` varchar(5) DEFAULT NULL,
  `question032` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xingrongci`
--

LOCK TABLES `xingrongci` WRITE;
/*!40000 ALTER TABLE `xingrongci` DISABLE KEYS */;
INSERT INTO `xingrongci` VALUES ('15668327535','true','true','true','true','true','true','true','true','true','true',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `xingrongci` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-04 13:39:05
