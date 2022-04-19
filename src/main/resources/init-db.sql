CREATE DATABASE  IF NOT EXISTS `db_name` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_name`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_name
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `app_features`
--

DROP TABLE IF EXISTS `app_features`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `app_features` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `featureName` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `featureIcon` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `featureUrl` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `userRole` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `priority` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_features`
--
-- ORDER BY:  `id`

LOCK TABLES `app_features` WRITE;
/*!40000 ALTER TABLE `app_features` DISABLE KEYS */;
INSERT INTO `app_features` (`id`, `featureName`, `featureIcon`, `featureUrl`, `userRole`, `priority`) VALUES (1,'Logout','fas fa-power-off','javascript:formSubmit();','ROLE_ADMIN','0'),(2,'My Profile','far fa-user-circle','my-profile','ROLE_ADMIN','1'),(3,'Logout','fas fa-power-off','javascript:formSubmit();','ROLE_USER','0'),(4,'My Profile','far fa-user-circle','my-profile','ROLE_USER','1');
/*!40000 ALTER TABLE `app_features` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `city_lkp`
--

DROP TABLE IF EXISTS `city_lkp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city_lkp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cityName` varchar(45) NOT NULL,
  `stateId` int(11) NOT NULL,
  `countryId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city_lkp`
--
-- ORDER BY:  `id`

LOCK TABLES `city_lkp` WRITE;
/*!40000 ALTER TABLE `city_lkp` DISABLE KEYS */;
INSERT INTO `city_lkp` (`id`, `cityName`, `stateId`, `countryId`) VALUES (1,'Hyderabad',25,1),(2,'Warangal',25,1),(3,'Amaravati',1,1),(4,'Vijayawada',1,1),(5,'Visakhapatnam',1,1),(6,'Karimnagar',25,1),(7,'Kurnool',1,1),(8,'Mumbai',15,1),(9,'Delhi',34,1),(10,'Chennai',24,1),(11,'Bengaluru',12,1),(12,'Medak',25,1),(13,'Tiruvananthapuram',13,1),(14,'Belgaum',12,1),(15,'Shimoga',12,1),(16,'Coimbatore',24,1),(17,'Salem',24,1),(18,'Madurai',24,1),(19,'Kanyakumari',24,1),(20,'Nagpur',15,1);
/*!40000 ALTER TABLE `city_lkp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country_lkp`
--

DROP TABLE IF EXISTS `country_lkp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country_lkp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `countryName` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country_lkp`
--
-- ORDER BY:  `id`

LOCK TABLES `country_lkp` WRITE;
/*!40000 ALTER TABLE `country_lkp` DISABLE KEYS */;
INSERT INTO `country_lkp` (`id`, `countryName`) VALUES (1,'India');
/*!40000 ALTER TABLE `country_lkp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state_lkp`
--

DROP TABLE IF EXISTS `state_lkp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state_lkp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stateName` varchar(45) NOT NULL,
  `countryId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state_lkp`
--
-- ORDER BY:  `id`

LOCK TABLES `state_lkp` WRITE;
/*!40000 ALTER TABLE `state_lkp` DISABLE KEYS */;
INSERT INTO `state_lkp` (`id`, `stateName`, `countryId`) VALUES (1,'Andhra Pradesh',1),(2,'Arunachal Pradesh',1),(3,'Assam',1),(4,'Bihar',1),(5,'Chattisgarh',1),(6,'Goa',1),(7,'Gujarat',1),(8,'Haryana',1),(9,'Himachal Pradesh',1),(10,'Jammu and Kashmir',1),(11,'Jharkhand',1),(12,'Karnataka',1),(13,'Kerala',1),(14,'Madhya Pradesh',1),(15,'Maharashtra',1),(16,'Manipur',1),(17,'Meghalaya',1),(18,'Mizoram',1),(19,'Nagaland',1),(20,'Odisha',1),(21,'Punjab',1),(22,'Rajasthan',1),(23,'Sikkim',1),(24,'Tamil Nadu',1),(25,'Telangana',1),(26,'Tripura',1),(27,'Uttar Pradesh',1),(28,'Uttarakhand',1),(29,'West Bengal',1),(30,'Andaman and Nicobar Islands',1),(31,'Chandigarh',1),(32,'Dadra and Nagar HAveli',1),(33,'Daman and Diu',1),(34,'Delhi',1),(35,'Lakshadweep',1),(36,'Puducherry',1),(37,'Leh-Ladakh',1);
/*!40000 ALTER TABLE `state_lkp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_profile`
--

DROP TABLE IF EXISTS `user_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_profile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(500) NOT NULL,
  `firstname` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `dateOfBirth` varchar(45) DEFAULT NULL,
  `address1` varchar(45) DEFAULT NULL,
  `address2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  `country` int(2) DEFAULT NULL,
  `zipcode` varchar(15) DEFAULT NULL,
  `imageFilePath` varchar(500) DEFAULT NULL,
  `imageFileType` varchar(45) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `userRole` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_profile`
--
-- ORDER BY:  `id`,`username`

LOCK TABLES `user_profile` WRITE;
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` (`id`, `username`, `firstname`, `lastname`, `email`, `mobile`, `gender`, `dateOfBirth`, `address1`, `address2`, `city`, `state`, `country`, `zipcode`, `imageFilePath`, `imageFileType`, `status`, `userRole`) VALUES (1,'superadmin','Super','Admin','superadmin@pranavalabs.com','1234567890',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL),(2,'admin','Admin',' ','admin@pranavalabs.com','123-456-7890','Female','07-06-1988','123 Test Apt','3334','Hyderabad',25,1,'500001','admin/profile_image','image/png',1,'ROLE_ADMIN');
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_role` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_time` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_by` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--
-- ORDER BY:  `id`

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` (`id`, `username`, `user_role`, `created_time`, `created_by`) VALUES (1,'superadmin','ROLE_SUPERADMIN',NULL,NULL),(2,'admin','ROLE_ADMIN',NULL,NULL);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles_lkp`
--

DROP TABLE IF EXISTS `user_roles_lkp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles_lkp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_role` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `display_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles_lkp`
--
-- ORDER BY:  `id`

LOCK TABLES `user_roles_lkp` WRITE;
/*!40000 ALTER TABLE `user_roles_lkp` DISABLE KEYS */;
INSERT INTO `user_roles_lkp` (`id`, `user_role`, `display_name`) VALUES (1,'ROLE_SUPERADMIN','Super Admin'),(2,'ROLE_ADMIN','Admin'),(3,'ROLE_USER','User');
/*!40000 ALTER TABLE `user_roles_lkp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--
-- ORDER BY:  `id`,`username`

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `username`, `password`, `status`) VALUES (1,'superadmin','$2a$10$uc1tQo9trB1QXgr2mq7Jae4sSb.5Dsdo918ZRJBxp.WMqiB5aAlpu',1),(2,'admin','$2a$10$uc1tQo9trB1QXgr2mq7Jae4sSb.5Dsdo918ZRJBxp.WMqiB5aAlpu',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-03 16:35:20
