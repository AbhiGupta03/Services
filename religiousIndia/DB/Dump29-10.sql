CREATE DATABASE  IF NOT EXISTS `religious_india` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `religious_india`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: religious_india
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt

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
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--

--
-- Table structure for table `ri_aarti`
--

DROP TABLE IF EXISTS `ri_aarti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_aarti` (
  `AARTI_ID` varchar(20) NOT NULL default '',
  `AARTI_NAME` varchar(70) default NULL,
  `AARTI_DESC` varchar(100) default NULL,
  `AARTI_DAY` varchar(70) default NULL,
  `START_TIME` varchar(50) default NULL,
  `END_TIME` varchar(50) default NULL,
  `TEMPLE_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`AARTI_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_aarti`
--

LOCK TABLES `ri_aarti` WRITE;
/*!40000 ALTER TABLE `ri_aarti` DISABLE KEYS */;
INSERT INTO `ri_aarti` VALUES ('1','Morning Aarti','Daily Aarti','All','7','7.3','2','1','abhi','2018-04-06 13:04:05','','2018-04-06 13:04:05'),('2','Eve Aarti','Daily Aarti','All','19','19.5','2','1','abhi','2018-04-06 13:04:35','','2018-04-06 13:04:35'),('3','Morning Aarti','Daily aarti','All','8','8.30','1','1','abhi','2018-04-16 11:58:35','','2018-04-16 11:58:35'),('4','Eve Aatrti','Daily aarti','All','20','20.30','1','1','abhi','2018-04-16 11:58:56','','2018-04-16 11:58:56'),('5','Morning Aarti','Daily Aarti','All','5.30','6.15','3','1','abhi','2018-04-16 17:16:18','','2018-04-16 17:16:18'),('6','Eve Aarti','Daily Aarti','All','19.30','20','3','1','abhi','2018-04-16 17:16:50','','2018-04-16 17:16:50'),('7','Eve Aarti','Daily Aarti','All','17.30','17.45','4','1','abhi',NULL,NULL,NULL);
/*!40000 ALTER TABLE `ri_aarti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_address`
--

DROP TABLE IF EXISTS `ri_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_address` (
  `address_id` int(11) NOT NULL auto_increment,
  `state` varchar(50) default NULL,
  `dist` varchar(50) default NULL,
  `city` varchar(50) default NULL,
  `address_detail` varchar(100) NOT NULL,
  `is_temple_address` varchar(2) default '0',
  `is_active` varchar(2) default '1',
  `created_by` varchar(50) default NULL,
  `created_on` datetime default NULL,
  `updated_by` varchar(50) default NULL,
  `updated_on` datetime default NULL,
  `city_id` varchar(20) default NULL,
  `pincode` varchar(10) default NULL,
  `contact_no` varchar(12) default NULL,
  PRIMARY KEY  (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_address`
--

LOCK TABLES `ri_address` WRITE;
/*!40000 ALTER TABLE `ri_address` DISABLE KEYS */;
INSERT INTO `ri_address` VALUES (1,'Uttarakhand','Chamoli','Chamoli','Badrinath Temple,Uttarakhand','1','1','abhi','2018-04-06 18:02:52','','2018-04-06 18:02:52','1365','246422',NULL),(2,'Punjab','Amritsar','Amritsar','Golden Temple Rd, Atta Mandi, Katra Ahluwalia','1','1','abhi','2018-04-12 18:02:52',NULL,'2018-04-12 18:02:52','1054','143006',NULL),(3,'Uttar Pradesh','Varanasi','Varanasi','Kashi Vishvanath Temple,Varanasi','1','1','abhi','2018-04-16 17:14:38','','2018-04-16 17:14:38','1044','',NULL),(4,'New Delhi','Delhi','Delhi','Nehru Place,New Delhi','1','1','abhi','2018-04-16 17:14:38',NULL,'2018-04-16 17:14:38','1109','110076',NULL),(5,'Delhi','Delhi','Delhi','anjaan gali,gumnnam mahula','0','1','abhi','2018-04-16 17:14:38',NULL,'2018-04-16 17:14:38','1054','',NULL),(10,'Delhi','Delhi','Delhi','C-545, New Ashok Nagar','0','1','abhi',NULL,NULL,NULL,NULL,'',NULL),(11,'Uttar Pradesh','Noida','Noida','Noida extension','0','1','abhi',NULL,'Abhi','2018-10-11 15:11:30',NULL,'201305',NULL),(15,'Punjab','Amritsar','Amritsar','iskcon temple amritsar','0','1','abhi',NULL,NULL,NULL,'1054','',NULL),(16,'Delhi','Delhi','Delhi','Hare Krishna, Hills Rd, East of Kailash, New Delhi','1','1','abhi',NULL,NULL,NULL,NULL,'110096',NULL),(17,'Delhi','Delhi','Delhi','Mandir Marg, Near Gole market, New Delhi','1','1','abhi',NULL,NULL,NULL,NULL,'110001',NULL),(18,' Gujarat','Saurashtra','Veraval','Somnath-Temple, Saurashtra, Gujarat','1','1','abhi',NULL,NULL,NULL,NULL,'362268',NULL),(19,'Uttar Pradesh','Mathura','Vrindavan ','Bankebihari,Mathura,Uttar Pradesh','1','1','abhi',NULL,NULL,NULL,NULL,NULL,NULL),(20,'Andhra Pradesh','Chittoor','Tirupati','Tirupati,Andhra Pradesh','1','1','abhi',NULL,NULL,NULL,NULL,'517101',NULL),(21,'Madhya Pradesh','Ujjain','Ujjain','Mahakaleshwar,Ujjain, Madhya Pradesh','1','1','abhi',NULL,NULL,NULL,NULL,NULL,NULL),(22,'Delhi','Delhi','Delhi','G Block, Preet Vihar, New Delhi','1','1','abhi',NULL,NULL,NULL,NULL,'110092',NULL),(23,'Tamil Nadu',' Rameswaram',' Rameswaram','Ramanathaswamy Temple, Tamil Nadu','1','1','abhi',NULL,NULL,NULL,NULL,NULL,NULL),(24,' Jammu and Kashmir',' Katra',' Katra','Vaishno Devi, Katra, Jammu and Kashmir','1','1','abhi',NULL,NULL,NULL,NULL,'182301',NULL),(50,'UP','Kanpur','Kanpur','First Street, Sarvodaya Nagar, Kanpur','1','0','Abhi','2018-10-04 17:58:04','Abhi','2018-10-04 17:58:04',NULL,NULL,'09935713711'),(66,'UP','Kanpur','Kanpur','First Street, Sarvodaya Nagar, Kanpur','1','0','Abhi','2018-10-18 15:56:28','Abhi','2018-10-18 15:56:28',NULL,NULL,'09935713711'),(67,'UP','Kanpur','Kanpur','First Street, Sarvodaya Nagar, Kanpur','1','0','Abhi','2018-10-18 16:04:48','Abhi','2018-10-18 16:04:48',NULL,NULL,'09935713711'),(68,'UP','Kanpur','Kanpur','First Street, Sarvodaya Nagar, Kanpur','1','0','Abhi','2018-10-18 18:21:54','Abhi','2018-10-18 18:21:54',NULL,NULL,'09935713711'),(69,'Karnataka','Dehli','Delhi','Sector 12 Noida','1','0','Abhi','2018-10-18 18:22:05','Abhi','2018-10-18 18:22:05',NULL,NULL,'7835851375'),(71,'UP','Kanpur','Kanpur','First Street, Sarvodaya Nagar, Kanpur','1','0','Abhi','2018-10-23 14:21:18','Abhi','2018-10-23 14:21:18',NULL,NULL,'09935713711'),(72,'Uttar Pradesh','BHIND','Amritsar','Sector 12 Noida ','1','0','Abhi','2018-10-23 15:15:17','Abhi','2018-10-23 15:15:17',NULL,NULL,'7835851375'),(84,'MP','Ujjain','Ujjain','Mahakaal ','1','0','Abhi','2018-10-24 12:52:37','Abhi','2018-10-24 12:52:37',NULL,NULL,'7835851375'),(85,'UP','Noida','Noida','Noida ext.','0','1','Abhi',NULL,'Abhi',NULL,NULL,NULL,'8545251535');
/*!40000 ALTER TABLE `ri_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_address_details`
--

DROP TABLE IF EXISTS `ri_address_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_address_details` (
  `ADDRESS_ID` varchar(20) NOT NULL default '',
  `ADDRESS_LINE1` text,
  `ADDRESS_LINE2` text,
  `CITY` varchar(50) default NULL,
  `STATE_PROVINCE` varchar(10) default NULL,
  `POSTAL_CODE` varchar(50) default NULL,
  `COUNTRY` varchar(50) default 'INDIA',
  `LANDMARK` text,
  `ADDRESS_TYPE` text,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  `VERSION_ID` varchar(20) default NULL,
  PRIMARY KEY  (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_address_details`
--

LOCK TABLES `ri_address_details` WRITE;
/*!40000 ALTER TABLE `ri_address_details` DISABLE KEYS */;
INSERT INTO `ri_address_details` VALUES ('1','C-545','New Ashok Nagar','New Delhi','New Delhi','110096','India',NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL),('6','Aditya Celebrity homes','Sector-76,Noida','Noida','UP','100200','India',NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `ri_address_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_address_test2`
--

DROP TABLE IF EXISTS `ri_address_test2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_address_test2` (
  `ADDRESS_ID` varchar(20) NOT NULL default '',
  `STATE` varchar(50) default NULL,
  `DIST` varchar(50) default NULL,
  `CITY` varchar(50) default NULL,
  `ADDRESS_DETAIL` varchar(100) default NULL,
  `IS_TEMPLE_ADDRESS` varchar(2) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  `City_Id` varchar(20) default NULL,
  `PINCODE` varchar(45) default NULL,
  PRIMARY KEY  (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_address_test2`
--

LOCK TABLES `ri_address_test2` WRITE;
/*!40000 ALTER TABLE `ri_address_test2` DISABLE KEYS */;
INSERT INTO `ri_address_test2` VALUES ('1','Uttarakhand','Chamoli','Chamoli','Badrinath Temple,Uttarakhand','1','1','abhi','2018-04-06 18:02:52','','2018-04-06 18:02:52','1365','246422'),('10','Delhi','Delhi','Delhi','C-545, New Ashok Nagar','0','1','abhi',NULL,NULL,NULL,NULL,''),('11','Uttar Pradesh','Noida','Noida','Noida extension','0','1','abhi',NULL,NULL,NULL,NULL,''),('15','Punjab','Amritsar','Amritsar','iskcon temple amritsar','0','1','abhi',NULL,NULL,NULL,'1054',''),('16','Delhi','Delhi','Delhi','Hare Krishna, Hills Rd, East of Kailash, New Delhi','1','1','abhi',NULL,NULL,NULL,NULL,'110096'),('17','Delhi','Delhi','Delhi','Mandir Marg, Near Gole market, New Delhi','1','1','abhi',NULL,NULL,NULL,NULL,'110001'),('18',' Gujarat','Saurashtra','Veraval','Somnath-Temple, Saurashtra, Gujarat','1','1','abhi',NULL,NULL,NULL,NULL,NULL),('19','Uttar Pradesh','Mathura','Vrindavan ','Bankebihari,Mathura,Uttar Pradesh','1','1','abhi',NULL,NULL,NULL,NULL,NULL),('2','Punjab','Amritsar','Amritsar','Golden Temple Rd, Atta Mandi, Katra Ahluwalia','1','1','abhi','2018-04-12 18:02:52',NULL,'2018-04-12 18:02:52','1054','143006'),('20','Andhra Pradesh','Chittoor','Tirupati','Tirupati,Andhra Pradesh','1','1','abhi',NULL,NULL,NULL,NULL,NULL),('21','Madhya Pradesh','Ujjain','Ujjain','Mahakaleshwar,Ujjain, Madhya Pradesh','1','1','abhi',NULL,NULL,NULL,NULL,NULL),('22','Delhi','Delhi','Delhi','G Block, Preet Vihar, New Delhi','1','1','abhi',NULL,NULL,NULL,NULL,'110092'),('23','Tamil Nadu',' Rameswaram',' Rameswaram','Ramanathaswamy Temple, Tamil Nadu','1','1','abhi',NULL,NULL,NULL,NULL,NULL),('24',' Jammu and Kashmir',' Katra',' Katra','Vaishno Devi, Katra, Jammu and Kashmir','1','1','abhi',NULL,NULL,NULL,NULL,'182301'),('25','Uttar Pradesh','Noida','Noida','Iris software Inc,sector 142,noida','0','1','abhi',NULL,NULL,NULL,NULL,'201301'),('26','Uttar Pradesh','Noida','Noida','H-102,Aditya Celebrity Homes,Sector-76','0','1','abhi',NULL,NULL,NULL,NULL,'India'),('3','Uttar Pradesh','Varanasi','Varanasi','Kashi Vishvanath Temple,Varanasi','1','1','abhi','2018-04-16 17:14:38','','2018-04-16 17:14:38','1044',''),('4','New Delhi','Delhi','Delhi','Nehru Place,New Delhi','1','1','abhi','2018-04-16 17:14:38',NULL,'2018-04-16 17:14:38','1109','110076'),('5','Delhi','Delhi','Delhi','anjaan gali,gumnnam mahula','0','1','abhi','2018-04-16 17:14:38',NULL,'2018-04-16 17:14:38','1054',''),('6','Delhi','Delhi','Delhi','C-545, New Ashok Nagar','0','1','abhi','2018-04-16 17:14:38',NULL,'2018-04-16 17:14:38',NULL,'110096');
/*!40000 ALTER TABLE `ri_address_test2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_booking_type`
--

DROP TABLE IF EXISTS `ri_booking_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_booking_type` (
  `BOOKING_TYPE_ID` varchar(20) NOT NULL default '',
  `BOOKING_TYPE_NAME` varchar(50) default NULL,
  `BOOKING_TYPE_DESC` text,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`BOOKING_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_booking_type`
--

LOCK TABLES `ri_booking_type` WRITE;
/*!40000 ALTER TABLE `ri_booking_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_booking_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_cart_items_details`
--

DROP TABLE IF EXISTS `ri_cart_items_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_cart_items_details` (
  `version_id` int(11) default NULL,
  `item_id` int(11) NOT NULL auto_increment,
  `is_temple_donation` varchar(2) default '0',
  `is_pandit_booking` varchar(2) default '0',
  `is_temple_pooja_booking` varchar(2) default '0',
  `temle_donation_category_id` varchar(20) default NULL,
  `donation_sub_category_id` varchar(20) default NULL,
  `is_pandit_subsription` varchar(2) default '0',
  `pandit_subsription_plan_id` varchar(20) default NULL,
  `pandit_id` varchar(20) default NULL,
  `pooja_id` varchar(20) default NULL,
  `temple_id` varchar(20) default NULL,
  `created_by` varchar(50) default NULL,
  `updated_by` varchar(50) default NULL,
  `ri_cart_items_detailscol` varchar(45) default NULL,
  `created_on` datetime default NULL,
  `updated_on` datetime default NULL,
  `is_amt_changeable` varchar(2) NOT NULL default '1',
  PRIMARY KEY  (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_cart_items_details`
--

LOCK TABLES `ri_cart_items_details` WRITE;
/*!40000 ALTER TABLE `ri_cart_items_details` DISABLE KEYS */;
INSERT INTO `ri_cart_items_details` VALUES (0,3,'1','0','0','5','1',NULL,NULL,NULL,NULL,'1','Abhi','Abhi',NULL,'2018-08-10 19:11:21','2018-08-10 19:11:21','1'),(0,4,'1','0','0','5','1',NULL,NULL,NULL,NULL,'1','Abhi','Abhi',NULL,'2018-08-13 12:43:58','2018-08-13 12:43:58','1'),(0,40,'1','0','0','4','1',NULL,NULL,NULL,NULL,'1','Abhi','Abhi',NULL,'2018-08-23 14:49:05','2018-08-23 14:49:05','1'),(0,41,'1','0','0','3','2',NULL,NULL,NULL,NULL,'1','Abhi','Abhi',NULL,'2018-08-23 14:49:08','2018-08-23 14:49:08','1'),(0,42,'1','0','0','3','1',NULL,NULL,NULL,NULL,'1','Abhi','Abhi',NULL,'2018-08-23 14:58:11','2018-08-23 14:58:11','1'),(0,43,'1','0','0','4','1',NULL,NULL,NULL,NULL,'1','Abhi','Abhi',NULL,'2018-08-23 14:58:13','2018-08-23 14:58:13','1'),(0,44,'1','0','0','3','2',NULL,NULL,NULL,NULL,'1','Abhi','Abhi',NULL,'2018-08-23 14:58:15','2018-08-23 14:58:15','1'),(0,45,'1','0','0','3','1',NULL,NULL,NULL,NULL,'1','Abhi','Abhi',NULL,'2018-08-23 15:59:28','2018-08-23 15:59:28','1'),(0,46,'1','0','0','3','2',NULL,NULL,NULL,NULL,'1','Abhi','Abhi',NULL,'2018-08-23 15:59:30','2018-08-23 15:59:30','1'),(0,47,'1','0','0','4','1',NULL,NULL,NULL,NULL,'1','Abhi','Abhi',NULL,'2018-08-23 15:59:32','2018-08-23 15:59:32','1'),(0,48,'1','0','0','4','1',NULL,NULL,NULL,NULL,'1','Abhi','Abhi',NULL,'2018-08-23 15:59:35','2018-08-23 15:59:35','1'),(0,49,'1','0','0','4','1',NULL,NULL,NULL,NULL,'1','Abhi','Abhi',NULL,'2018-09-03 17:47:21','2018-09-03 17:47:21','1'),(0,50,'1','0','0','3','1',NULL,NULL,NULL,NULL,'1','Abhi','Abhi',NULL,'2018-09-06 12:55:56','2018-09-06 12:55:56','1'),(0,51,'1','0','0','3','1',NULL,NULL,NULL,NULL,'1','Abhi','Abhi',NULL,'2018-10-11 15:50:15','2018-10-11 15:50:15','1'),(0,52,'1','0','0','4','1',NULL,NULL,NULL,NULL,'1','Abhi','Abhi',NULL,'2018-10-18 15:35:24','2018-10-18 15:35:24','1');
/*!40000 ALTER TABLE `ri_cart_items_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_cities`
--

DROP TABLE IF EXISTS `ri_cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_cities` (
  `Id` int(11) NOT NULL default '0',
  `cityname` varchar(100) default NULL,
  `State` char(20) NOT NULL default '',
  `Popular` varchar(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_cities`
--

LOCK TABLES `ri_cities` WRITE;
/*!40000 ALTER TABLE `ri_cities` DISABLE KEYS */;
INSERT INTO `ri_cities` VALUES (1024,'Mumbai (Bombay)','Maharashtra','1'),(1025,'Delhi','Delhi','11'),(1026,'Calcutta [Kolkata]','West Bengali','1'),(1027,'Chennai (Madras)','Tamil Nadu','1'),(1028,'Hyderabad','Andhra Pradesh','1'),(1029,'Ahmedabad','Gujarat','1'),(1030,'Bangalore','Karnataka','10'),(1031,'Kanpur','Uttar Pradesh','1'),(1032,'Nagpur','Maharashtra','0'),(1033,'Lucknow','Uttar Pradesh','0'),(1034,'Pune','Maharashtra','0'),(1035,'Surat','Gujarat','0'),(1036,'Jaipur','Rajasthan','0'),(1037,'Indore','Madhya Pradesh','0'),(1038,'Bhopal','Madhya Pradesh','0'),(1039,'Ludhiana','Punjab','0'),(1040,'Vadodara (Baroda)','Gujarat','0'),(1041,'Kalyan','Maharashtra','0'),(1042,'Madurai','Tamil Nadu','0'),(1043,'Haora (Howrah)','West Bengali','0'),(1044,'Varanasi (Benares)','Uttar Pradesh','5'),(1045,'Patna','Bihar','0'),(1046,'Srinagar','Jammu and Kashmir','0'),(1047,'Agra','Uttar Pradesh','0'),(1048,'Coimbatore','Tamil Nadu','0'),(1049,'Thane (Thana)','Maharashtra','0'),(1050,'Allahabad','Uttar Pradesh','0'),(1051,'Meerut','Uttar Pradesh','0'),(1052,'Vishakhapatnam','Andhra Pradesh','0'),(1053,'Jabalpur','Madhya Pradesh','0'),(1054,'Amritsar','Punjab','8'),(1055,'Faridabad','Haryana','0'),(1056,'Vijayawada','Andhra Pradesh','0'),(1057,'Gwalior','Madhya Pradesh','0'),(1058,'Jodhpur','Rajasthan','0'),(1059,'Nashik (Nasik)','Maharashtra','0'),(1060,'Hubli-Dharwad','Karnataka','0'),(1061,'Solapur (Sholapur)','Maharashtra','0'),(1062,'Ranchi','Jharkhand','0'),(1063,'Bareilly','Uttar Pradesh','0'),(1064,'Guwahati (Gauhati)','Assam','0'),(1065,'Shambajinagar (Aurangabad)','Maharashtra','0'),(1066,'Cochin (Kochi)','Kerala','0'),(1067,'Rajkot','Gujarat','0'),(1068,'Kota','Rajasthan','0'),(1069,'Thiruvananthapuram (Trivandrum','Kerala','0'),(1070,'Pimpri-Chinchwad','Maharashtra','0'),(1071,'Jalandhar (Jullundur)','Punjab','0'),(1072,'Gorakhpur','Uttar Pradesh','0'),(1073,'Chandigarh','Chandigarh','0'),(1074,'Mysore','Karnataka','0'),(1075,'Aligarh','Uttar Pradesh','0'),(1076,'Guntur','Andhra Pradesh','0'),(1077,'Jamshedpur','Jharkhand','0'),(1078,'Ghaziabad','Uttar Pradesh','0'),(1079,'Warangal','Andhra Pradesh','0'),(1080,'Raipur','Chhatisgarh','0'),(1081,'Moradabad','Uttar Pradesh','0'),(1082,'Durgapur','West Bengali','0'),(1083,'Amravati','Maharashtra','0'),(1084,'Calicut (Kozhikode)','Kerala','0'),(1085,'Bikaner','Rajasthan','0'),(1086,'Bhubaneswar','Orissa','0'),(1087,'Kolhapur','Maharashtra','0'),(1088,'Kataka (Cuttack)','Orissa','0'),(1089,'Ajmer','Rajasthan','0'),(1090,'Bhavnagar','Gujarat','0'),(1091,'Tiruchirapalli','Tamil Nadu','0'),(1092,'Bhilai','Chhatisgarh','0'),(1093,'Bhiwandi','Maharashtra','0'),(1094,'Saharanpur','Uttar Pradesh','0'),(1095,'Ulhasnagar','Maharashtra','0'),(1096,'Salem','Tamil Nadu','0'),(1097,'Ujjain','Madhya Pradesh','0'),(1098,'Malegaon','Maharashtra','0'),(1099,'Jamnagar','Gujarat','0'),(1100,'Bokaro Steel City','Jharkhand','0'),(1101,'Akola','Maharashtra','0'),(1102,'Belgaum','Karnataka','0'),(1103,'Rajahmundry','Andhra Pradesh','0'),(1104,'Nellore','Andhra Pradesh','0'),(1105,'Udaipur','Rajasthan','0'),(1106,'New Bombay','Maharashtra','0'),(1107,'Bhatpara','West Bengali','0'),(1108,'Gulbarga','Karnataka','0'),(1109,'New Delhi','Delhi','0'),(1110,'Jhansi','Uttar Pradesh','0'),(1111,'Gaya','Bihar','0'),(1112,'Kakinada','Andhra Pradesh','0'),(1113,'Dhule (Dhulia)','Maharashtra','0'),(1114,'Panihati','West Bengali','0'),(1115,'Nanded (Nander)','Maharashtra','0'),(1116,'Mangalore','Karnataka','0'),(1117,'Dehra Dun','Uttaranchal','0'),(1118,'Kamarhati','West Bengali','0'),(1119,'Davangere','Karnataka','0'),(1120,'Asansol','West Bengali','0'),(1121,'Bhagalpur','Bihar','0'),(1122,'Bellary','Karnataka','0'),(1123,'Barddhaman (Burdwan)','West Bengali','0'),(1124,'Rampur','Uttar Pradesh','0'),(1125,'Jalgaon','Maharashtra','0'),(1126,'Muzaffarpur','Bihar','0'),(1127,'Nizamabad','Andhra Pradesh','0'),(1128,'Muzaffarnagar','Uttar Pradesh','0'),(1129,'Patiala','Punjab','0'),(1130,'Shahjahanpur','Uttar Pradesh','0'),(1131,'Kurnool','Andhra Pradesh','0'),(1132,'Tiruppur (Tirupper)','Tamil Nadu','0'),(1133,'Rohtak','Haryana','0'),(1134,'South Dum Dum','West Bengali','0'),(1135,'Mathura','Uttar Pradesh','0'),(1136,'Chandrapur','Maharashtra','0'),(1137,'Barahanagar (Baranagar)','West Bengali','0'),(1138,'Darbhanga','Bihar','0'),(1139,'Siliguri (Shiliguri)','West Bengali','0'),(1140,'Raurkela','Orissa','0'),(1141,'Ambattur','Tamil Nadu','0'),(1142,'Panipat','Haryana','0'),(1143,'Firozabad','Uttar Pradesh','0'),(1144,'Ichalkaranji','Maharashtra','0'),(1145,'Jammu','Jammu and Kashmir','0'),(1146,'Ramagundam','Andhra Pradesh','0'),(1147,'Eluru','Andhra Pradesh','0'),(1148,'Brahmapur','Orissa','0'),(1149,'Alwar','Rajasthan','0'),(1150,'Pondicherry','Pondicherry','0'),(1151,'Thanjavur','Tamil Nadu','0'),(1152,'Bihar Sharif','Bihar','0'),(1153,'Tuticorin','Tamil Nadu','0'),(1154,'Imphal','Manipur','0'),(1155,'Latur','Maharashtra','0'),(1156,'Sagar','Madhya Pradesh','0'),(1157,'Farrukhabad-cum-Fatehgarh','Uttar Pradesh','0'),(1158,'Sangli','Maharashtra','0'),(1159,'Parbhani','Maharashtra','0'),(1160,'Nagar Coil','Tamil Nadu','0'),(1161,'Bijapur','Karnataka','0'),(1162,'Kukatpalle','Andhra Pradesh','0'),(1163,'Bally','West Bengali','0'),(1164,'Bhilwara','Rajasthan','0'),(1165,'Ratlam','Madhya Pradesh','0'),(1166,'Avadi','Tamil Nadu','0'),(1167,'Dindigul','Tamil Nadu','0'),(1168,'Ahmadnagar','Maharashtra','0'),(1169,'Bilaspur','Chhatisgarh','0'),(1170,'Shimoga','Karnataka','0'),(1171,'Kharagpur','West Bengali','0'),(1172,'Mira Bhayandar','Maharashtra','0'),(1173,'Vellore','Tamil Nadu','0'),(1174,'Jalna','Maharashtra','0'),(1175,'Burnpur','West Bengali','0'),(1176,'Anantapur','Andhra Pradesh','0'),(1177,'Allappuzha (Alleppey)','Kerala','0'),(1178,'Tirupati','Andhra Pradesh','0'),(1179,'Karnal','Haryana','0'),(1180,'Burhanpur','Madhya Pradesh','0'),(1181,'Hisar (Hissar)','Haryana','0'),(1182,'Tiruvottiyur','Tamil Nadu','0'),(1183,'Mirzapur-cum-Vindhyachal','Uttar Pradesh','0'),(1184,'Secunderabad','Andhra Pradesh','0'),(1185,'Nadiad','Gujarat','0'),(1186,'Dewas','Madhya Pradesh','0'),(1187,'Murwara (Katni)','Madhya Pradesh','0'),(1188,'Ganganagar','Rajasthan','0'),(1189,'Vizianagaram','Andhra Pradesh','0'),(1190,'Erode','Tamil Nadu','0'),(1191,'Machilipatnam (Masulipatam)','Andhra Pradesh','0'),(1192,'Bhatinda (Bathinda)','Punjab','0'),(1193,'Raichur','Karnataka','0'),(1194,'Agartala','Tripura','0'),(1195,'Arrah (Ara)','Bihar','0'),(1196,'Satna','Madhya Pradesh','0'),(1197,'Lalbahadur Nagar','Andhra Pradesh','0'),(1198,'Aizawl','Mizoram','0'),(1199,'Uluberia','West Bengali','0'),(1200,'Katihar','Bihar','0'),(1201,'Cuddalore','Tamil Nadu','0'),(1202,'Hugli-Chinsurah','West Bengali','0'),(1203,'Dhanbad','Jharkhand','0'),(1204,'Raiganj','West Bengali','0'),(1205,'Sambhal','Uttar Pradesh','0'),(1206,'Durg','Chhatisgarh','0'),(1207,'Munger (Monghyr)','Bihar','0'),(1208,'Kanchipuram','Tamil Nadu','0'),(1209,'North Dum Dum','West Bengali','0'),(1210,'Karimnagar','Andhra Pradesh','0'),(1211,'Bharatpur','Rajasthan','0'),(1212,'Sikar','Rajasthan','0'),(1213,'Hardwar (Haridwar)','Uttaranchal','0'),(1214,'Dabgram','West Bengali','0'),(1215,'Morena','Madhya Pradesh','0'),(1216,'Noida','Uttar Pradesh','0'),(1217,'Hapur','Uttar Pradesh','0'),(1218,'Bhusawal','Maharashtra','0'),(1219,'Khandwa','Madhya Pradesh','0'),(1220,'Yamuna Nagar','Haryana','0'),(1221,'Sonipat (Sonepat)','Haryana','0'),(1222,'Tenali','Andhra Pradesh','0'),(1223,'Raurkela Civil Township','Orissa','0'),(1224,'Kollam (Quilon)','Kerala','0'),(1225,'Kumbakonam','Tamil Nadu','0'),(1226,'Ingraj Bazar (English Bazar)','West Bengali','0'),(1227,'Timkur','Karnataka','0'),(1228,'Amroha','Uttar Pradesh','0'),(1229,'Serampore','West Bengali','0'),(1230,'Chapra','Bihar','0'),(1231,'Pali','Rajasthan','0'),(1232,'Maunath Bhanjan','Uttar Pradesh','0'),(1233,'Adoni','Andhra Pradesh','0'),(1234,'Jaunpur','Uttar Pradesh','0'),(1235,'Tirunelveli','Tamil Nadu','0'),(1236,'Bahraich','Uttar Pradesh','0'),(1237,'Gadag Betigeri','Karnataka','0'),(1238,'Proddatur','Andhra Pradesh','0'),(1239,'Chittoor','Andhra Pradesh','0'),(1240,'Barrackpur','West Bengali','0'),(1241,'Bharuch (Broach)','Gujarat','0'),(1242,'Naihati','West Bengali','0'),(1243,'Shillong','Meghalaya','0'),(1244,'Sambalpur','Orissa','0'),(1245,'Junagadh','Gujarat','0'),(1246,'Rae Bareli','Uttar Pradesh','0'),(1247,'Rewa','Madhya Pradesh','0'),(1248,'Gurgaon','Haryana','0'),(1249,'Khammam','Andhra Pradesh','0'),(1250,'Bulandshahr','Uttar Pradesh','0'),(1251,'Navsari','Gujarat','0'),(1252,'Malkajgiri','Andhra Pradesh','0'),(1253,'Midnapore (Medinipur)','West Bengali','0'),(1254,'Miraj','Maharashtra','0'),(1255,'Raj Nandgaon','Chhatisgarh','0'),(1256,'Alandur','Tamil Nadu','0'),(1257,'Puri','Orissa','0'),(1258,'Navadwip','West Bengali','0'),(1259,'Sirsa','Haryana','0'),(1260,'Korba','Chhatisgarh','0'),(1261,'Faizabad','Uttar Pradesh','0'),(1262,'Etawah','Uttar Pradesh','0'),(1263,'Pathankot','Punjab','0'),(1264,'Gandhinagar','Gujarat','0'),(1265,'Palghat (Palakkad)','Kerala','0'),(1266,'Veraval','Gujarat','0'),(1267,'Hoshiarpur','Punjab','0'),(1268,'Ambala','Haryana','0'),(1269,'Sitapur','Uttar Pradesh','0'),(1270,'Bhiwani','Haryana','0'),(1271,'Cuddapah','Andhra Pradesh','0'),(1272,'Bhimavaram','Andhra Pradesh','0'),(1273,'Krishnanagar','West Bengali','0'),(1274,'Chandannagar','West Bengali','0'),(1275,'Mandya','Karnataka','0'),(1276,'Dibrugarh','Assam','0'),(1277,'Nandyal','Andhra Pradesh','0'),(1278,'Balurghat','West Bengali','0'),(1279,'Neyveli','Tamil Nadu','0'),(1280,'Fatehpur','Uttar Pradesh','0'),(1281,'Mahbubnagar','Andhra Pradesh','0'),(1282,'Budaun','Uttar Pradesh','0'),(1283,'Porbandar','Gujarat','0'),(1284,'Silchar','Assam','0'),(1285,'Berhampore (Baharampur)','West Bengali','0'),(1286,'Purnea (Purnia)','Jharkhand','0'),(1287,'Bankura','West Bengali','0'),(1288,'Rajapalaiyam','Tamil Nadu','0'),(1289,'Titagarh','West Bengali','0'),(1290,'Halisahar','West Bengali','0'),(1291,'Hathras','Uttar Pradesh','0'),(1292,'Bhir (Bid)','Maharashtra','0'),(1293,'Pallavaram','Tamil Nadu','0'),(1294,'Anand','Gujarat','0'),(1295,'Mango','Jharkhand','0'),(1296,'Santipur','West Bengali','0'),(1297,'Bhind','Madhya Pradesh','0'),(1298,'Gondiya','Maharashtra','0'),(1299,'Tiruvannamalai','Tamil Nadu','0'),(1300,'Yeotmal (Yavatmal)','Maharashtra','0'),(1301,'Kulti-Barakar','West Bengali','0'),(1302,'Moga','Punjab','0'),(1303,'Shivapuri','Madhya Pradesh','0'),(1304,'Bidar','Karnataka','0'),(1305,'Guntakal','Andhra Pradesh','0'),(1306,'Unnao','Uttar Pradesh','0'),(1307,'Barasat','West Bengali','0'),(1308,'Tambaram','Tamil Nadu','0'),(1309,'Abohar','Punjab','0'),(1310,'Pilibhit','Uttar Pradesh','0'),(1311,'Valparai','Tamil Nadu','0'),(1312,'Gonda','Uttar Pradesh','0'),(1313,'Surendranagar','Gujarat','0'),(1314,'Qutubullapur','Andhra Pradesh','0'),(1315,'Beawar','Rajasthan','0'),(1316,'Hindupur','Andhra Pradesh','0'),(1317,'Gandhidham','Gujarat','0'),(1318,'Haldwani-cum-Kathgodam','Uttaranchal','0'),(1319,'Tellicherry (Thalassery)','Kerala','0'),(1320,'Wardha','Maharashtra','0'),(1321,'Rishra','West Bengali','0'),(1322,'Bhuj','Gujarat','0'),(1323,'Modinagar','Uttar Pradesh','0'),(1324,'Gudivada','Andhra Pradesh','0'),(1325,'Basirhat','West Bengali','0'),(1326,'Uttarpara-Kotrung','West Bengali','0'),(1327,'Ongole','Andhra Pradesh','0'),(1328,'North Barrackpur','West Bengali','0'),(1329,'Guna','Madhya Pradesh','0'),(1330,'Haldia','West Bengali','0'),(1331,'Habra','West Bengali','0'),(1332,'Kanchrapara','West Bengali','0'),(1333,'Tonk','Rajasthan','0'),(1334,'Champdani','West Bengali','0'),(1335,'Orai','Uttar Pradesh','0'),(1336,'Pudukkottai','Tamil Nadu','0'),(1337,'Sasaram','Bihar','0'),(1338,'Hazaribag','Jharkhand','0'),(1339,'Palayankottai','Tamil Nadu','0'),(1340,'Banda','Uttar Pradesh','0'),(1341,'Godhra','Gujarat','0'),(1342,'Hospet','Karnataka','0'),(1343,'Ashoknagar-Kalyangarh','West Bengali','0'),(1344,'Achalpur','Maharashtra','0'),(1345,'Patan','Gujarat','0'),(1346,'Mandasor','Madhya Pradesh','0'),(1347,'Damoh','Madhya Pradesh','0'),(1348,'Satara','Maharashtra','0'),(1349,'Meerut Cantonment','Uttar Pradesh','0'),(1350,'Dehri','Bihar','0'),(1351,'Delhi Cantonment','Delhi','0'),(1352,'Chhindwara','Madhya Pradesh','0'),(1353,'Bansberia','West Bengali','0'),(1354,'Nagaon','Assam','0'),(1355,'Kanpur Cantonment','Uttar Pradesh','0'),(1356,'Vidisha','Madhya Pradesh','0'),(1357,'Bettiah','Bihar','0'),(1358,'Purulia','Jharkhand','0'),(1359,'Hassan','Karnataka','0'),(1360,'Ambala Sadar','Haryana','0'),(1361,'Baidyabati','West Bengali','0'),(1362,'Morvi','Gujarat','0'),(1363,'Raigarh','Chhatisgarh','0'),(1364,'Vejalpur','Gujarat','0'),(1365,'Chamoli','Uttarakhand','1'),(1366,'Jalandhar','Punjab','0'),(1366,'Shimla','Himachal Pradesh','9');
/*!40000 ALTER TABLE `ri_cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_customer_reviews`
--

DROP TABLE IF EXISTS `ri_customer_reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_customer_reviews` (
  `VERSION_ID` int(11) default NULL,
  `REVIEW_ID` double NOT NULL auto_increment,
  `RATING` varchar(20) NOT NULL,
  `USER_REVIEW_ABOUT` varchar(150) default NULL,
  `USER_REVIEW_DESC` text,
  `PANDIT_ID` varchar(20) default NULL,
  `POOJA_ID` varchar(20) default NULL,
  `USER_ID` varchar(20) default NULL,
  `BOOKING_ID` varchar(20) default NULL,
  `BOOKING_TYPE` varchar(10) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`REVIEW_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_customer_reviews`
--

LOCK TABLES `ri_customer_reviews` WRITE;
/*!40000 ALTER TABLE `ri_customer_reviews` DISABLE KEYS */;
INSERT INTO `ri_customer_reviews` VALUES (0,1,'4','Well organized and clean.The fact that volunteers run it so well is commendable.	 xyz','Clean and well organized',NULL,'5','26','1',NULL,'1','Abhi','2018-05-23 17:52:38','Abhi','2018-05-23 17:52:38'),(0,2,'4','Well organized and clean.The fact that volunteers run it so well is commendable.	 xyz','Clean and well organized',NULL,'5','26','1',NULL,'1','Abhi','2018-05-23 17:52:53','Abhi','2018-05-23 17:52:53'),(0,3,'4','Well organized and clean.The fact that volunteers run it so well is commendable.	 xyz','Clean and well organized','5',NULL,'26',NULL,NULL,'1','Abhi','2018-05-23 17:53:13','Abhi','2018-05-23 17:53:13'),(0,4,'4','Well organized and clean.The fact that volunteers run it so well is commendable.	 xyz','Clean and well organized','5',NULL,'26',NULL,NULL,'1','Abhi','2018-05-23 19:33:58','Abhi','2018-05-23 19:33:58'),(0,6,'3','Quite knowledgble man','Good Knowledge of veds','1',NULL,'26',NULL,NULL,'1','Abhi','2018-05-24 13:44:31','Abhi','2018-05-24 13:44:31'),(0,7,'4','tesr','aasdddd','5',NULL,'26',NULL,NULL,'1','Abhi','2018-06-04 13:22:06','Abhi','2018-06-04 13:22:06'),(0,8,'2','qwe23143','err','5',NULL,'26',NULL,NULL,'1','Abhi','2018-06-04 13:24:47','Abhi','2018-06-04 13:24:47'),(0,9,'3','QUite knowledgble man','Good Knowledge of veds','5',NULL,'26',NULL,NULL,'1','Abhi','2018-07-12 16:28:15','Abhi','2018-07-12 16:28:15'),(0,10,'5','pandit','good ','1',NULL,'26',NULL,NULL,'1','Abhi','2018-09-20 15:48:55','Abhi','2018-09-20 15:48:55'),(0,11,'3','test','Test Review','1',NULL,'26',NULL,NULL,'1','Abhi','2018-10-11 15:17:49','Abhi','2018-10-11 15:17:49');
/*!40000 ALTER TABLE `ri_customer_reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_event_bookings_details`
--

DROP TABLE IF EXISTS `ri_event_bookings_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_event_bookings_details` (
  `VERSION_ID` varchar(20) NOT NULL default '',
  `EVENT_BOOKING_ID` varchar(20) NOT NULL default '',
  `USER_ID` varchar(20) default NULL,
  `EVENT_SERVICE_CATEGORY_ID` varchar(20) default NULL,
  `EVENT_SERVICE_SUB_CATEGORY_ID_1` varchar(20) default NULL,
  `EVENT_SERVICE_SUB_CATEGORY_ID_2` varchar(20) default NULL,
  `EVENT_AMOUNT` varchar(20) default NULL,
  `PAYMENT_ID` varchar(20) default NULL,
  `DATE_CONDUCTED` datetime default NULL,
  `DATE_BOOKED` datetime default NULL,
  `EVENT_STATUS_ID` varchar(20) default NULL,
  `USER_REVIEW_ID` varchar(20) default NULL,
  `EVENT_TYPE` varchar(20) default NULL,
  `CANCELLATION_ID` varchar(20) default NULL,
  `DATE_COMPLETED` datetime default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`EVENT_BOOKING_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_event_bookings_details`
--

LOCK TABLES `ri_event_bookings_details` WRITE;
/*!40000 ALTER TABLE `ri_event_bookings_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_event_bookings_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_famous_thoughts`
--

DROP TABLE IF EXISTS `ri_famous_thoughts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_famous_thoughts` (
  `THOUGHT_ID` varchar(20) NOT NULL default '',
  `THOUGHT_TITLE` varchar(300) character set utf8 default NULL,
  `THOUGHT_DESC` varchar(300) character set utf8 default NULL,
  `THOUGHT_REFRENCE` varchar(100) character set utf8 default NULL,
  `THOUGHT_AUTHOR` varchar(50) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`THOUGHT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_famous_thoughts`
--

LOCK TABLES `ri_famous_thoughts` WRITE;
/*!40000 ALTER TABLE `ri_famous_thoughts` DISABLE KEYS */;
INSERT INTO `ri_famous_thoughts` VALUES ('1','अपर्याप्तं तदस्माकं बलं भीष्माभिरक्षितम्‌।\r <br> पर्याप्तं त्विदमेतेषां बलं भीमाभिरक्षितम्‌ ॥','','श्रीमद्भगवद्गीता (द्वितीय अध्याय, श्लोक 23)','Shri Krishna','abhi','2018-03-30 12:09:07','','2018-03-30 12:09:07'),('2',' परित्राणाय साधूनाम् विनाशाय च दुष्कृताम्। <br> धर्मसंस्थापनार्थाय सम्भवामि युगे-युगे॥ ','','श्श्रीमद्भगवद्गीता (चतुर्थ अध्याय, श्लोक 8)','Shri Krishna','abhi','2018-03-30 12:25:28','','2018-03-30 12:25:28'),('3',' परित्राणाय साधूनाम् विनाशाय च दुष्कृताम्। <br> धर्मसंस्थापनार्थाय सम्भवामि युगे-युगे॥ ','','श्श्रीमद्भगवद्गीता (चतुर्थ अध्याय, श्लोक 8)','Shri Krishna','abhi','2018-03-30 14:13:45','','2018-03-30 14:13:45'),('4',' कर्मण्येवाधिकारस्ते मा फलेषु कदाचन।<br> मा कर्मफलहेतुर्भूर्मा ते सङ्गोऽस्त्वकर्मणि॥ ','','श्रीमद्भगवद्गीता (द्वितीय अध्याय, श्लोक 47)','Shri Krishna','abhi','2018-03-30 14:36:25','','2018-03-30 14:36:25');
/*!40000 ALTER TABLE `ri_famous_thoughts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_home_banner`
--

DROP TABLE IF EXISTS `ri_home_banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_home_banner` (
  `IMAGE_ID` varchar(20) default NULL,
  `BANNER_NAME` varchar(100) default NULL,
  `ITEM_ID` varchar(20) default NULL,
  `SUB_ITEM_ID` varchar(20) default NULL,
  `DATA_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  `BANNER_DESC` varchar(100) default NULL,
  `IS_Temple` varchar(2) default '0',
  `IS_Pandit` varchar(2) default '0',
  `IS_Event` varchar(2) default '0',
  `Temple_Id` varchar(20) default NULL,
  `Pandit_Id` varchar(20) default NULL,
  `Event_Id` varchar(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_home_banner`
--

LOCK TABLES `ri_home_banner` WRITE;
/*!40000 ALTER TABLE `ri_home_banner` DISABLE KEYS */;
INSERT INTO `ri_home_banner` VALUES ('2','Har ki Pauri','1','1','','1','abhi','2018-03-29 18:18:45','','2018-03-29 18:18:45','Visit Haridwar, Mansa Devi Temple & Ganga Aarti at Har Ki Pauri','0','0','0',NULL,NULL,NULL),('4','Badrinath Temple','2','1','','1','abhi','2018-03-29 18:30:04','','2018-03-29 18:30:04','A Hindu temple dedicated to Vishnu','1','0','0','2',NULL,NULL),('11','Kalkaji Mandir','3','3',NULL,'1','abhi',NULL,NULL,NULL,NULL,'1','0','0','4',NULL,NULL),('3','Meenakshi Amman Temple','4','2',NULL,'1',NULL,NULL,NULL,NULL,NULL,'1','0','0','12',NULL,NULL),('56','Vaishno Devi','10','1',NULL,'1','abhi','2018-08-29 11:05:13','abhi','2018-08-29 11:05:13','Vaishno Devi, also known as Mata Rani, Trikuta and Vaishnavi','1','0','0','13',NULL,NULL),('55','Ramanathaswamy Temple','10','1',NULL,'1','abhi','2018-08-29 11:05:13','abhi','2018-08-29 11:05:13','It is also one of the twelve Jyotirlinga temples.','1','0','0','12',NULL,NULL),('54','Gufa Wala Mandir','10','1',NULL,'1','abhi','2018-08-29 11:05:13','abhi','2018-08-29 11:05:13','Gufa Wala Mandir is in New Delhi','1','0','0','11',NULL,NULL),('53','Mahakaleshwar','10','1',NULL,'1','abhi','2018-08-29 11:05:13','abhi','2018-08-29 11:05:13','The temple is situated on the side of the Rudra Sagar lake.','1','0','0','10',NULL,NULL),('52','Tirupati','9','1',NULL,'1','abhi','2018-08-29 11:05:13','abhi','2018-08-29 11:05:13','The Temple is dedicated to Lord Sri Venkateswara, an incarnation of Vishnu','1','0','0','9',NULL,NULL),('51','Bankebihari','8','1',NULL,'1','abhi','2018-08-29 11:05:13','abhi','2018-08-29 11:05:13','This temple is among the 7 temples of Thakur of Vrindavan','1','0','0','8',NULL,NULL),('50','Somnath-Temple','7','1',NULL,'1','abhi','2018-08-29 11:05:13','abhi','2018-08-29 11:05:13','It is believed to be the first among the twelve jyotirlinga shrines of Shiva.','1','0','0','7',NULL,NULL),('49','Birla-Mandir','6','2',NULL,'1','abhi','2018-08-29 11:05:13','abhi','2018-08-29 11:05:13','Birla Mandir (Birla Temple) refers to different Hindu temples or Mandirs built by the Birla family.','1','0','0','6',NULL,NULL),('48','Delhi Iskcon Temple','5','3',NULL,'1','abhi','2018-08-29 11:05:13','abhi','2018-08-29 11:05:13','ISKCON Delhi temple, is a well known Vaishnav temple of Lord Krishna and Radharani','1','0','0','5',NULL,NULL);
/*!40000 ALTER TABLE `ri_home_banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_image`
--

DROP TABLE IF EXISTS `ri_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_image` (
  `Image_ID` varchar(20) NOT NULL default '',
  `CATEGORY` varchar(20) default NULL,
  `IMAGE_TYPE` varchar(20) default NULL,
  `IMAGE_PATH` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_image`
--

LOCK TABLES `ri_image` WRITE;
/*!40000 ALTER TABLE `ri_image` DISABLE KEYS */;
INSERT INTO `ri_image` VALUES ('2','temple','jpg','images/2.jpg'),('3','temple','jpg','images/3.jpg'),('4','temple','jpg','images/4.jpg'),('5','temple','jpg','images/5.jpg'),('6','history','jpg','images/Golden_Temple.jpg'),('8','service','jpg','images/langar.jpg'),('7','Guru-Image','jpg','images/guru-nanak.jpg'),('9','Guru-Image','jpg','images/Hargovind.jpg'),('10','Guru-Image','jpg','images/Guru_Amar_Das.jpg'),('11','temple','jpg','images/kalka-ji-mandir.jpg'),('12','User','jpg','images/user.jpg'),('13','Cloth donation','jpg','images/cloth_donation.jpg'),('15','Food donation','jpg','images/langar_food.jpg'),('14','Food donation','jpg','images/food_donation.jpg'),('16','Education','jpg','images/edu.jpg'),('17','Pooja','jpg','images/Hola-Mohalla-Diyan-Vadhaiyan.jpg'),('18','Pooja','jpg','images/Sangrand.jpg'),('19','Pooja','jpg','images/Mahamritunjya_Puja.jpg'),('20','Pandit','jpg','images/Pandit_ji.jpg'),('21','Pandit','jpg','images/panditji.jpg'),('22','Temple','jpg','images/Golden_Temple_1.jpg'),('23','Temple','jpg','images/Golden_Temple_2.jpg'),('24','Temple','jpg','images/Golden_Temple_3.jpg'),('25','Temple','jpg','images/Golden_Temple_4.jpg'),('26','Temple','jpg','images/Golden_Temple_5.jpg'),('27','Temple','jpg','images/Golden_Temple_6.jpg'),('28','Temple','jpg','images/Golden_Temple_7.jpg'),('29','Temple','jpg','images/Golden_Temple_8.jpg'),('30','Temple','jpg','images/Golden_Temple_9.jpg'),('31','Temple','jpg','images/Golden_Temple_10.jpg'),('32','Temple','jpg','images/Golden_Temple_11.jpg'),('33','Temple','jpg','images/Golden_Temple_12.jpg'),('34','Temple','jpg','images/Golden_Temple_13.jpg'),('35','Temple','jpg','images/Golden_Temple_14.jpg'),('36','Temple','jpg','images/Golden_Temple_15.jpg'),('40','Temple','jpeg','images/user_1.jpeg'),('41','User','jpeg','images/user_2.jpeg'),('37','Awards','jpg','images/award_1.jpg'),('38','Awards','jpg','images/award_2.jpg'),('45','Pooja','jpg','images/navgrah.jpg'),('46','Pooja','jpg','images/Pitra_Dosh_Nivaran_Puja.jpg'),('47','Pooja','jpg','images/Shani_Jaap_Pooja.jpg'),('48','Temple','jpg','images/Delhi-Iskcon_Temple.jpg'),('49','Temple','jpg','images/Birla-Mandir.jpg'),('50','Temple','jpg','images/Somnath-Temple.jpg '),('51','Temple','png','images/Bankebihari.png'),('52','Temple','jpg','images/Tirupati.jpg'),('53','Temple','jpg','images/Mahakaleshwar.jpg '),('54','Temple','jpg','images/Gufa_Wala_Mandir.jpg'),('55','Temple','jpg','images/Ramanathaswamy_Temple.jpg '),('56','Temple','jpg','images/Vaishno_Devi.jpg'),('Rel152','temple','jpg','images/XYZTue Sep 25 11:47:50 IST 2018'),('Rel153','temple','jpg','images/XYZWed Sep 26 13:27:16 IST 2018'),('Rel154','temple','jpg','images/XYZWed Sep 26 13:28:34 IST 2018'),('Rel155','temple','jpg','images/XYZWed Sep 26 14:26:15 IST 2018'),('Rel156','temple','jpg','images/XYZWed Sep 26 14:27:30 IST 2018'),('Rel157','temple','jpg','images/XYZWed Sep 26 15:01:13 IST 2018'),('Rel158','temple','jpg','images/XYZWed Sep 26 15:33:58 IST 2018'),('Rel159','temple','jpg','images/XYZWed Sep 26 15:35:59 IST 2018'),('Rel160','temple','jpg','images/JK TempleWed Sep 26 16:02:19 IST 2018'),('Rel161','temple','jpg','images/JK TempleWed Sep 26 16:05:47 IST 2018'),('Rel162','temple','jpg','images/JK TempleWed Sep 26 16:13:10 IST 2018'),('Rel163','temple','jpg','images/TempleWed Sep 26 16:13:40 IST 2018'),('Rel164','temple','jpg','images/TempleWed Sep 26 16:14:28 IST 2018'),('Rel165','temple','jpg','images/JKTempleWed Sep 26 16:14:59 IST 2018'),('Rel166','temple','jpg','images/JKTempleWed Sep 26 18:21:13 IST 2018'),('Rel167','temple','jpg','images/JKTempleWed Sep 26 18:26:03 IST 2018'),('Rel168','temple','jpg','images/JKTempleWed Sep 26 18:53:35 IST 2018'),('Rel169','temple','jpg','images/JKTempleWed Sep 26 18:53:39 IST 2018'),('Rel170','temple','jpg','images/JKTempleWed Sep 26 18:54:05 IST 2018'),('Rel171','temple','jpg','images/JKTempleWed Sep 26 18:55:51 IST 2018'),('Rel172','temple','jpg','images/JKTempleThu Sep 27 11:19:05 IST 2018'),('Rel173','Temple','jpg','images/JKTemple'),('Rel174','Temple','jpg','images/NewTemple'),('Rel175','Temple','jpg','images/VaishnoDevi'),('Rel176','Temple','jpg','images/NewTemple'),('Rel177','Temple','.jpg','images/images/test.jpg'),('Rel178','','.jpg','test.jpg'),('Rel179','','.jpg','test.jpg'),('Rel180','','.jpg','test.jpg'),('Rel181','','.jpg','test.jpg'),('Rel182','','.jpg','test.jpg'),('Rel183','','.jpg','pexels-photo-225284.jpeg'),('Rel184','','.jpg','pexels-photo-225284.jpeg'),('Rel185','','.jpg','pexels-photo-225284.jpeg'),('Rel186','','.jpg','pexels-photo-225284.jpeg'),('Rel187','','.jpg','pexels-photo-225284.jpeg'),('Rel188','','.jpg','pexels-photo-225284.jpeg'),('Rel189','','.jpg','pexels-photo-225284.jpeg'),('Rel190','','.jpg','pexels-photo-225284.jpeg'),('Rel191','','.jpg','pexels-photo-225284.jpeg'),('Rel192','','.jpg','pexels-photo-225284.jpeg'),('Rel193','','.jpg','pexels-photo-225284.jpeg'),('Rel194','','.jpg','pexels-photo-225284.jpeg'),('Rel195','','.jpg','pexels-photo-225284.jpeg'),('Rel196','Temple','.jpg','images/test.jpg'),('Rel197','','.jpg','pexels-photo-225284.jpeg'),('Rel198','','.jpg','pexels-photo-225284.jpeg'),('Rel199','','.jpg','pexels-photo-225284.jpeg'),('Rel200','','.jpg','pexels-photo-225284.jpeg'),('Rel201','','.jpg','pexels-photo-225284.jpeg'),('Rel202','','.jpg','pexels-photo-225284.jpeg'),('Rel203','','.jpg','pexels-photo-225284.jpeg'),('Rel204','','.jpg','pexels-photo-225284.jpeg'),('Rel205','','.jpg','pexels-photo-225284.jpeg'),('Rel206','','.jpg','pexels-photo-225284.jpeg'),('Rel207','','.jpg','pexels-photo-225284.jpeg'),('Rel208','','.jpg','RO.png'),('Rel209','','.jpg','pexels-photo-225284.jpeg'),('Rel210','','.jpg','pexels-photo-225284.jpeg'),('Rel211','','.jpg','pexels-photo-225284.jpeg'),('Rel212','','.jpg','pexels-photo-225284.jpeg'),('Rel213','','.jpg','pexels-photo-225284.jpeg'),('Rel214','','.jpg','pexels-photo-225284.jpeg'),('Rel215','','.jpg','mansa-devi.jfif'),('Rel216','','.jpg','download.jfif'),('Rel217','','.jpg','download.jfif'),('Rel218','','.jpg','download.jfif'),('Rel219','','.jpg','download.jfif'),('Rel220','','.jpg','mansa-devi-temple-4102039.jpg'),('Rel221','','.jpg','image-1.jfif'),('Rel222','','.jpg','download.jfif'),('Rel223','','.jpg','download.jfif'),('Rel224','','.jpg','download.jfif'),('Rel225','','.jpg','download.jfif'),('Rel226','','.jpg','download.jfif'),('Rel227','','.jpg','download.jfif'),('Rel228','','.jpg','download.jfif'),('Rel229','','.jpg','download.jfif'),('Rel230','Temple','.jpg','images/download.jfif'),('Rel231','','.jpg','download.jfif'),('Rel232','','.jpg','image-1.jfif'),('Rel233','','.jpg','image-1.jfif'),('Rel234','','.jpg','download.jfif'),('Rel235','','.jpg','image-1.jfif'),('Rel236','','.jpg','mansa-devi.jfif'),('Rel237','','.jpg','mansa-devi-temple-4102039.jpg'),('Rel238','','.jpg','image-1.jfif'),('Rel239','User','.png','images/jindal12.png'),('Rel240','','.jpg','image-1.jfif'),('Rel241','','.jpg','mansa-devi.jfif'),('Rel242','','.jpg','mansa-devi-temple-4102039.jpg'),('Rel243','','.jpg','pexels-photo-225284.jpeg'),('Rel244','','.jpg','download.jfif'),('Rel245','','.jpg','download.jfif'),('Rel246','','.jpg','image-1.jfif'),('Rel247','','.jpg','mansa-devi.jfif'),('Rel248','','.jpg','mansa-devi-temple-4102039.jpg'),('Rel249','','.jpg','pexels-photo-225284.jpeg'),('Rel250','','.jpg','image-1.jfif'),('Rel251','','.jpg','download.jfif'),('Rel252','','.jpg','image-1.jfif'),('Rel253','','.jpg','mansa-devi-temple-4102039.jpg'),('Rel254','','.jpg','pexels-photo-225284.jpeg'),('Rel255','','.jpg','image-1.jfif'),('Rel256','','.jpg','mansa-devi.jfif'),('Rel257','','.jpg','mansa-devi-temple-4102039.jpg'),('Rel258','','.jpg','image-1.jfif'),('Rel259','','.jpg','mansa-devi.jfif'),('Rel260','','.jpg','mansa-devi-temple-4102039.jpg'),('Rel261','','.jpg','image-1.jfif'),('Rel262','','.jpg','image-1.jfif'),('Rel263','','.jpg','mansa-devi.jfif'),('Rel264','','.jpg','mansa-devi-temple-4102039.jpg'),('Rel265','','.jpg','image-1.jfif'),('Rel266','','.jpg','image-1.jfif'),('Rel267','','.jpg','mansa-devi.jfif'),('Rel268','','.jpg','mansa-devi-temple-4102039.jpg'),('Rel269','','.jpg','image-1.jfif'),('Rel270','','.jpg','image-1.jfif'),('Rel271','','.jpg','mansa-devi.jfif'),('Rel272','','.jpg','mansa-devi-temple-4102039.jpg'),('Rel273','','.jpg','image-1.jfif'),('Rel274','','.jpg','mansa-devi.jfif'),('Rel275','','.jpg','mansa-devi-temple-4102039.jpg'),('Rel276','','.jpg','pexels-photo-225284.jpeg'),('Rel277','','.jpg','mansa-devi.jfif'),('Rel278','','.jpg','mansa-devi.jfif'),('Rel279','','.jpg','mansa-devi-temple-4102039.jpg'),('Rel280','','.jpg','pexels-photo-225284.jpeg'),('Rel281','','.jpg','image-1.jfif'),('Rel282','','.jpg','mansa-devi.jfif'),('Rel283','','.jpg','mansa-devi-temple-4102039.jpg'),('Rel284','','.jpg','image-1.jfif'),('Rel285','','.jpg','image-1.jfif'),('Rel286','','.jpg','mansa-devi.jfif'),('Rel287','','.jpg','mansa-devi-temple-4102039.jpg'),('Rel288','','.jpg','mansa-devi.jfif'),('Rel289','','.jpg','mansa-devi.jfif'),('Rel290','','.jpg','mansa-devi.jfif'),('Rel291','','.jpg','mansa-devi-temple-4102039.jpg'),('Rel292','','.jpg','image-1.jfif'),('Rel293','','.jpg','mansa-devi.jfif'),('Rel294','','.jpg','mansa-devi-temple-4102039.jpg'),('Rel295','','.jpg','image-1.jfif'),('Rel296','','.jpg','mansa-devi.jfif'),('Rel297','','.jpg','mansa-devi-temple-4102039.jpg'),('Rel298','','.jpg','image-1.jfif'),('Rel299','','.jpg','mansa-devi.jfif'),('Rel300','','.jpg','mansa-devi-temple-4102039.jpg'),('Rel301','','.jpg','image-1.jfif'),('Rel302','','.jpg','image-1.jfif'),('Rel303','','.jpg','INNO.png'),('Rel304','','.jpg','mansa-devi.jfif'),('Rel305','','.jpg','image-1.jfif'),('Rel306','','.jpg','mansa-devi.jfif'),('Rel307','','.jpg','INNO.png'),('Rel308','','.jpg','image-1.jfif'),('Rel309','','.jpg','mansa-devi.jfif'),('Rel310','','.jpg','mansa-devi-temple-4102039.jpg'),('Rel311','','.jpg','INNO.png'),('Rel312','','.jpg','image-1.jfif'),('Rel312','','.jpg','mansa-devi.jfif'),('Rel314','','.jpg','mansa-devi-temple-4102039.jpg'),('Rel315','','.jpg','image-1.jfif'),('Rel316','','.jpg','image-1.jfif'),('Rel317','','.jpg','image-1.jfif'),('Rel318','','.jpg','mov_bbb.mp4'),('Rel319','','.jpg','mov_bbb.mp4'),('Rel320','','.jpg','mov_bbb.mp4'),('Rel321','','.jpg','mov_bbb.mp4'),('Rel322','','.jpg','mov_bbb.mp4'),('Rel323','','.jpg','mov_bbb.mp4'),('Rel324','','.jpg','citi.PNG'),('Rel325','Temple','.jpg','images/citi.PNG');
/*!40000 ALTER TABLE `ri_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_language_id`
--

DROP TABLE IF EXISTS `ri_language_id`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_language_id` (
  `Version_Id` int(11) NOT NULL default '0',
  `Language_Id` int(11) NOT NULL default '0',
  `LANGUAGE_NAME` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`Language_Id`,`Version_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_language_id`
--

LOCK TABLES `ri_language_id` WRITE;
/*!40000 ALTER TABLE `ri_language_id` DISABLE KEYS */;
INSERT INTO `ri_language_id` VALUES (0,1,'Hindhi','1','abhi',NULL,NULL,NULL),(0,2,'Sanskrit','1','abhi',NULL,NULL,NULL);
/*!40000 ALTER TABLE `ri_language_id` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_login_details`
--

DROP TABLE IF EXISTS `ri_login_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_login_details` (
  `PASS` varchar(150) default NULL,
  `USER_ID` varchar(70) NOT NULL default '',
  `LOGIN_TYPE_ID` varchar(50) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  `PASS_HISTORY` text,
  `ACCESS_KEY` varchar(10) default NULL,
  PRIMARY KEY  (`USER_ID`),
  UNIQUE KEY `USER_ID` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_login_details`
--

LOCK TABLES `ri_login_details` WRITE;
/*!40000 ALTER TABLE `ri_login_details` DISABLE KEYS */;
INSERT INTO `ri_login_details` VALUES ('$2a$10$EekLCoEaoFlmudA9NNcfPOVAqLCV.FzeIrCzCr9vEqlRaX1i6hnWe','abhi12@religiousIndia.com','4','1','Abhi','2018-06-28 15:00:51','Abhi','2018-06-28 15:00:51','[{\"pass\":\"$2a$10$EekLCoEaoFlmudA9NNcfPOVAqLCV.FzeIrCzCr9vEqlRaX1i6hnWe\"}]',NULL),('$2a$10$yNwlPJP7OyZ/1qM7MiTTeu/RC4DLSfKVl//JsvVDAdtp8MpJ8PVCq','abhi@religiousIndia.com','4','1','Abhi','2018-06-28 14:54:13','Abhi','2018-06-28 14:54:13','[{\"pass\":\"$2a$10$yNwlPJP7OyZ/1qM7MiTTeu/RC4DLSfKVl//JsvVDAdtp8MpJ8PVCq\"}]',NULL),('$2a$10$zIH2rtO/.413e5ZpvPHqFuhHbMPLxd3GfgD9h8PE02yR17WxEPVFi','ak121@religiousIndia.com','4','1','Abhi','2018-06-28 14:27:03','Abhi','2018-06-28 14:27:03','[{\"pass\":\"$2a$10$zIH2rtO/.413e5ZpvPHqFuhHbMPLxd3GfgD9h8PE02yR17WxEPVFi\"}]',NULL),('$2a$10$VbvLoiXkZk0n5JamjZxW7.vH0mao3hbb3ihQAzzWypQf85QHqcAKq','iris12@religiousIndia.com','4','1','Abhi','2018-07-12 16:52:23','Abhi','2018-07-12 16:52:23','[{\"pass\":\"$2a$10$VbvLoiXkZk0n5JamjZxW7.vH0mao3hbb3ihQAzzWypQf85QHqcAKq\"}]',NULL),('$2a$10$5ElGqVbF19GxNU2/7V5GmOsiv55j42Tn9MVmaKutWXjb8tfg9QJB2','iris@religiousIndia.com','4','1','Abhi','2018-07-12 16:36:18','Abhi','2018-07-12 16:36:20','[{\"pass\":\"$2a$10$5ElGqVbF19GxNU2/7V5GmOsiv55j42Tn9MVmaKutWXjb8tfg9QJB2\"}]',NULL),('$2a$10$n7dTiQ/1NYWiA46yHVR2xue1xZB5ok0liDanOHRKbJUS6a2PZ.4KG','mayank.jindal@irissoftware.com',NULL,'1','Abhi','2018-07-18 13:31:13','Abhi','2018-07-18 13:31:13','[{\"pass\":\"$2a$10$n7dTiQ/1NYWiA46yHVR2xue1xZB5ok0liDanOHRKbJUS6a2PZ.4KG\"}]',NULL),('$2a$10$wwZ6FQuk7RG0BYfgEG91PuQCO5EhhOW8Gp774b0ma3LdQwJNJxeWG','mayank@religiousIndia.com','4','1','Abhi','2018-10-24 13:34:18','Abhi','2018-10-24 13:34:18','[{\"pass\":\"$2a$10$wwZ6FQuk7RG0BYfgEG91PuQCO5EhhOW8Gp774b0ma3LdQwJNJxeWG\"}]',NULL),('$2a$10$CmYrjSD.rDAF88gdf.OFKOGFz/dc/XfJcEmhoF13kiQhB.6Z.btWO','namail@religiousIndia.com','4','1','Abhi','2018-06-28 15:02:38','Abhi','2018-06-28 15:02:38','[{\"pass\":\"$2a$10$CmYrjSD.rDAF88gdf.OFKOGFz/dc/XfJcEmhoF13kiQhB.6Z.btWO\"}]',NULL),('$2a$10$SM3Mwwe7Kr.kBDUqFWfX5OFevYVT/8AaYluJmWmOak0Mwyl.HE70e','newMail@religiousIndia.com','4','1','Abhi','2018-06-29 14:54:14','Abhi','2018-06-29 14:54:14','[{\"pass\":\"$2a$10$SM3Mwwe7Kr.kBDUqFWfX5OFevYVT/8AaYluJmWmOak0Mwyl.HE70e\"}]',NULL),('$2a$10$KMoYzUZ6h/rx.4t0VmJZP.VvvHV8O9iPtFt34ULiij600LBQhLV2W','nomail@religiousIndia.com','4','1','Abhi','2018-06-28 15:18:35','Abhi','2018-06-28 15:18:35','[{\"pass\":\"$2a$10$KMoYzUZ6h/rx.4t0VmJZP.VvvHV8O9iPtFt34ULiij600LBQhLV2W\"}]',NULL),('$2a$10$vDJjcWnYSFXVJqbYCH6qpOZ6IDfJDn.Wtxh1IpanVrVn6eKt9Dp.m','rtyagi@iris.com',NULL,'1','Abhi','2018-09-18 11:39:10','Abhi','2018-09-20 17:35:23','[{\"pass\":\"$2a$10$vDJjcWnYSFXVJqbYCH6qpOZ6IDfJDn.Wtxh1IpanVrVn6eKt9Dp.m\"},{\"pass\":\"$2a$10$THc542IFbIXjI1qWgC34su//f72lB/ZsLA38hoBRlldVJ/rTjlTrS\"},{\"pass\":\"$2a$10$NxlcoYEDkZ/TsFTQI7L5iOqhvJDYGti4dfHCEr.uO4jzToueN7Qs.\"}]','C0M9'),('$2a$10$ySDe7X54cFInMleIaBzunOMh0ah8m6spudriPQ6W3cQUrCnqMGokG','shanu12@religiousIndia.com','4','1','Abhi','2018-06-29 15:01:52','Abhi','2018-09-17 15:16:18','[{\"pass\":\"$2a$10$ySDe7X54cFInMleIaBzunOMh0ah8m6spudriPQ6W3cQUrCnqMGokG\"},{\"pass\":\"$2a$10$yEQPxHsIpjZYUwO.JeRazOT8drnfEOpfF12dTjPf.52OQO7RP/HsK\"},{\"pass\":\"$2a$10$krKaYQb8PZzKSr1I44WBj.rBk/JRGCT1dtM9lYkl7apSg5Y5YH4Ge\"}]',NULL),('$2a$10$N9vrCQFAGe3tAB/d6NMJLuIzSVtp2NxBUkKg1mNW808QHARc/Iyjq','test12@religiousIndia.com','4','1','Abhi','2018-07-18 13:10:13','Abhi','2018-07-18 13:10:13','[{\"pass\":\"$2a$10$N9vrCQFAGe3tAB/d6NMJLuIzSVtp2NxBUkKg1mNW808QHARc/Iyjq\"}]',NULL),('$2a$10$ACTjB7CFRKMsS6S2KGJmZuRn/tTtM0TqridtYkno5G1TVNF9mFmf.','testId@religiousIndia.com','4','1','Abhi','2018-07-23 19:03:51','Abhi','2018-07-25 15:54:31','[{\"pass\":\"$2a$10$ACTjB7CFRKMsS6S2KGJmZuRn/tTtM0TqridtYkno5G1TVNF9mFmf.\"},{\"pass\":\"$2a$10$zl4gEjWwc3B8xMjpb5u2oO4gKzkQ1IpihoieCB7133VcJTM0phamG\"}]',NULL),('$2a$10$Dq.nsD7cpM5GnYcEj.jOXeujQFJj2Rgryep3s7FFSJQNd7b1PqqJK','Userr@religiousIndia.com','4','1','Abhi','2018-08-14 14:45:30','Abhi','2018-08-14 14:45:30','[{\"pass\":\"$2a$10$Dq.nsD7cpM5GnYcEj.jOXeujQFJj2Rgryep3s7FFSJQNd7b1PqqJK\"}]',NULL),('$2a$10$gbPJAyaZ2bm/yuVINaKTqeWdqG0qwGgKq4Whz706ARhEzX2L3Cgjy','vivek@religiousIndia.com','4','1','Abhi','2018-10-29 15:20:56','Abhi','2018-10-29 15:20:56','[{\"pass\":\"$2a$10$gbPJAyaZ2bm/yuVINaKTqeWdqG0qwGgKq4Whz706ARhEzX2L3Cgjy\"}]',NULL);
/*!40000 ALTER TABLE `ri_login_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_login_types`
--

DROP TABLE IF EXISTS `ri_login_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_login_types` (
  `LOGIN_TYPE_ID` varchar(20) NOT NULL default '',
  `LOGIN_TYPE` varchar(50) default NULL,
  `TYPE_DESC` varchar(100) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`LOGIN_TYPE_ID`),
  UNIQUE KEY `LOGIN_TYPE` (`LOGIN_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_login_types`
--

LOCK TABLES `ri_login_types` WRITE;
/*!40000 ALTER TABLE `ri_login_types` DISABLE KEYS */;
INSERT INTO `ri_login_types` VALUES ('1','FACEBOOK','login credentials used on  Facebook','1','abhi',NULL,NULL,NULL),('2','GOOGLE+','login credentials used on Google+','1','abhi',NULL,NULL,NULL),('3','TWITTER','login credentials used on Twitter','1','abhi',NULL,NULL,NULL),('4','CUSTOM','login credentials used on Religious India website','1','abhi',NULL,NULL,NULL),('5','INSTAGRAM','login credentials used on Instagram','1','abhi',NULL,NULL,NULL);
/*!40000 ALTER TABLE `ri_login_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_main_menu_items`
--

DROP TABLE IF EXISTS `ri_main_menu_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_main_menu_items` (
  `ITEM_ID` varchar(20) NOT NULL default '',
  `ITEM_NAME` varchar(50) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` char(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  `url` varchar(100) default NULL,
  PRIMARY KEY  (`ITEM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_main_menu_items`
--

LOCK TABLES `ri_main_menu_items` WRITE;
/*!40000 ALTER TABLE `ri_main_menu_items` DISABLE KEYS */;
INSERT INTO `ri_main_menu_items` VALUES ('1','TEMPLE DONATIONS','1','ABhi','2018-03-29 14:21:36','','2018-03-29 14:21:36','/temple-donations'),('2','BOOK PANDIT','1','','2018-03-29 14:22:06','','2018-03-29 14:22:06','/book-pandit'),('3','POOJA SERVICES','1','','2018-03-29 14:22:40','','2018-03-29 14:22:40','/pooja-services'),('4','EVENTS & FESTIVALS','1','','2018-03-29 14:23:22','','2018-03-29 14:23:22','events-festivals'),('5','LIVE DARSHAN','1','','2018-03-29 14:23:59','','2018-03-29 14:23:59','/live-darshan'),('6','BLOG','1','','2018-03-29 14:24:28','','2018-03-29 14:24:28','/blog');
/*!40000 ALTER TABLE `ri_main_menu_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_main_menu_subitems`
--

DROP TABLE IF EXISTS `ri_main_menu_subitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_main_menu_subitems` (
  `ITEM_ID` varchar(20) default NULL,
  `SUB_ITEM_ID` varchar(20) NOT NULL default '',
  `SUB_ITEM_NAME` varchar(50) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` char(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`SUB_ITEM_ID`),
  KEY `ITEM_ID` (`ITEM_ID`),
  CONSTRAINT `ri_main_menu_subitems_ibfk_1` FOREIGN KEY (`ITEM_ID`) REFERENCES `ri_main_menu_items` (`ITEM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_main_menu_subitems`
--

LOCK TABLES `ri_main_menu_subitems` WRITE;
/*!40000 ALTER TABLE `ri_main_menu_subitems` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_main_menu_subitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_months`
--

DROP TABLE IF EXISTS `ri_months`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_months` (
  `MONTH_ID` varchar(20) NOT NULL default '',
  `MONTH_NAME` varchar(50) default NULL,
  PRIMARY KEY  (`MONTH_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_months`
--

LOCK TABLES `ri_months` WRITE;
/*!40000 ALTER TABLE `ri_months` DISABLE KEYS */;
INSERT INTO `ri_months` VALUES ('1','JAN'),('10','OCT'),('11','NOV'),('12','DEC'),('2','FEB'),('3','MAR'),('4','APR'),('5','MAY'),('6','JUN'),('7','JUL'),('8','AUG'),('9','SEP');
/*!40000 ALTER TABLE `ri_months` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_order_details`
--

DROP TABLE IF EXISTS `ri_order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_order_details` (
  `VERSION_ID` varchar(20) NOT NULL default '',
  `ORDER_ID` varchar(20) NOT NULL default '',
  `USER_ID` varchar(20) default NULL,
  `BOOKING_ID` varchar(20) default NULL,
  `BOOKING_TYPE` varchar(20) default NULL,
  `ORDER_STATUS_ID` varchar(20) default NULL,
  `DATE_COMPLETED` datetime default NULL,
  `DATE_BOOKED` datetime default NULL,
  `USER_REVIEW_ID` varchar(20) default NULL,
  `CANCELLATION_ID` varchar(20) default NULL,
  `TOTAL_MRP` varchar(20) default NULL,
  `TOTAL_AMOUND_TO_BE_PAID` varchar(20) default NULL,
  `WALLET_AMOUNT_USED` varchar(20) default NULL,
  `WALLET_ID` varchar(20) default NULL,
  `FINAL_AMOUNT_PAID` varchar(20) default NULL,
  `PAYMENT_DATE` datetime default NULL,
  `PAYMENT_STATUS` varchar(20) default NULL,
  `PAYMENT_MODE` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`ORDER_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_order_details`
--

LOCK TABLES `ri_order_details` WRITE;
/*!40000 ALTER TABLE `ri_order_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_order_status`
--

DROP TABLE IF EXISTS `ri_order_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_order_status` (
  `STATUS_ID` varchar(20) NOT NULL default '',
  `STATUS_NAME` varchar(50) default NULL,
  `STATUS_DESC` varchar(100) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`STATUS_ID`),
  UNIQUE KEY `STATUS_NAME` (`STATUS_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_order_status`
--

LOCK TABLES `ri_order_status` WRITE;
/*!40000 ALTER TABLE `ri_order_status` DISABLE KEYS */;
INSERT INTO `ri_order_status` VALUES ('',NULL,NULL,'','',NULL,NULL,NULL),('1','INTITAITED','The transaction has been started but not completed','1','abhi',NULL,NULL,NULL),('10','MODIFIED','The order has been modified','1','abhi',NULL,NULL,NULL),('11','COMPLETED','The transaction is settled and complete','1','abhi',NULL,NULL,NULL),('2','CONFIRMED','The order has been succesfully placed & confirmed','1','abhi',NULL,NULL,NULL),('3','REJECTED','The order has been rejected due to unavailability or other reason','1','abhi',NULL,NULL,NULL),('4','CANCELLED','The order has been cancelled by the client','1','abhi',NULL,NULL,NULL),('5','REBOOKED','The order has been rebooked','1','abhi',NULL,NULL,NULL),('6','SHIPPED','The order has been shipped','1','abhi',NULL,NULL,NULL),('7','REFUNDED','The order amount has been refunded','1','abhi',NULL,NULL,NULL),('8','FAILED','The Transaction is failed and is not confirmed/Initiated','1','abhi',NULL,NULL,NULL),('9','UNDERDISPUTE','A dispute for the transaction has been raised.','1','abhi',NULL,NULL,NULL);
/*!40000 ALTER TABLE `ri_order_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pandit_bookings_details`
--

DROP TABLE IF EXISTS `ri_pandit_bookings_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pandit_bookings_details` (
  `VERSION` int(11) default NULL,
  `PANDIT_BOOKING_ID` varchar(20) default NULL,
  `POOJA_PACKAGE_CATEGORY_ID` varchar(20) NOT NULL default '',
  `PACAKAGE_NAME` varchar(50) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`POOJA_PACKAGE_CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pandit_bookings_details`
--

LOCK TABLES `ri_pandit_bookings_details` WRITE;
/*!40000 ALTER TABLE `ri_pandit_bookings_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_pandit_bookings_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pandit_daily_availibility_timings`
--

DROP TABLE IF EXISTS `ri_pandit_daily_availibility_timings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pandit_daily_availibility_timings` (
  `VERSION_ID` int(11) default NULL,
  `PANDIT_DAILY_AVAILABILITY_TIMINGS_ID` double NOT NULL default '0',
  `MONDAY` varchar(200) default NULL,
  `TUESDAY` varchar(200) default NULL,
  `WEDNESDAY` varchar(200) default NULL,
  `THURSDAY` varchar(200) default NULL,
  `FRIDAY` varchar(200) default NULL,
  `SATURDAY` varchar(200) default NULL,
  `SUNDAY` varchar(200) default NULL,
  `IS_AVAILABLE_ON_ALL_DAYS` varchar(2) default NULL,
  `GENERAL_AVAILABILITY_TIMING` text,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`PANDIT_DAILY_AVAILABILITY_TIMINGS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pandit_daily_availibility_timings`
--

LOCK TABLES `ri_pandit_daily_availibility_timings` WRITE;
/*!40000 ALTER TABLE `ri_pandit_daily_availibility_timings` DISABLE KEYS */;
INSERT INTO `ri_pandit_daily_availibility_timings` VALUES (0,1,'10-20',NULL,'10-20','8-16','5-21',NULL,'9-21','0',NULL,'1','abhi',NULL,NULL,NULL),(0,2,'',NULL,NULL,NULL,NULL,NULL,NULL,'1','8-20','1','abhi',NULL,NULL,NULL);
/*!40000 ALTER TABLE `ri_pandit_daily_availibility_timings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pandit_details`
--

DROP TABLE IF EXISTS `ri_pandit_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pandit_details` (
  `VERSION_ID` int(11) NOT NULL default '0',
  `PANDIT_ID` varchar(20) NOT NULL default '',
  `USER_ID` mediumtext,
  `SUBSCRIPTION_DETAILS_ID` varchar(20) default NULL,
  `PANDIT_CATEGORY_ID` varchar(20) default NULL,
  `PANDIT_EDUCATIONAL_DETAILS` text,
  `TYPE_OF_AVAILABILITY` varchar(20) default NULL,
  `IS_ASSOCIATED_WITH_TEMPLE` varchar(2) default NULL,
  `IS_FREE_LANCER` varchar(2) default NULL,
  `Specilaization` text,
  `SPECILAIZATION_POOJA` varchar(20) default NULL,
  `PANDIT_EXP_START_DATE` datetime default NULL,
  `PANDIT_PROFESSIONAL_RESUME` text,
  `PANDIT_DAILY_AVAILABILITY_TIMINGS_ID` varchar(20) default NULL,
  `BOOKS_PUBLISHED_DETAILS` varchar(100) default NULL,
  `FAMOUS_ARTICLES_LINK` text,
  `MAGZINE_ASSOCIATION_DETAILS` varchar(250) default NULL,
  `Award_received_Details` text,
  `VIDEO_ID_DETAILS` varchar(200) default NULL,
  `PHOTO_ID_DETAILS` varchar(200) default NULL,
  `RI_PANDIT_RATING` mediumtext,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  `IMAGE_ID` varchar(20) default NULL,
  `Reviewers` int(11) default NULL,
  `Temple_Id` varchar(50) default NULL,
  `Pandit_Desc` varchar(500) default NULL,
  `Total_Clients` int(11) default '0',
  PRIMARY KEY  (`PANDIT_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pandit_details`
--

LOCK TABLES `ri_pandit_details` WRITE;
/*!40000 ALTER TABLE `ri_pandit_details` DISABLE KEYS */;
INSERT INTO `ri_pandit_details` VALUES (2,'1','26',NULL,'NEW','MA (Hindi Literature)','PERSONAL','1','0','Astrology Services,Monthly Horoscopes,Life Consulting and Remedies','Astrology Service',NULL,NULL,'1.0',NULL,'[{\'Article_Name\':\'A Bud That Is Healthy Will Blossom\',\'URL\':\'\'},{\'Article_Name\':\'Love purifies you!!\',\'URL\':\'\'},{\'Article_Name\':\'Sacred Space- Who Is Corrupt?\',\'URL\':\'\'},{\'Article_Name\':\'Celebrate, Feel The Joy, Because Life Is Light\',\'URL\':\'\'}]',NULL,'[{\'Image_Id\':\'37\',\'Name\':\'SAKSHAM-2016 Award\',\'Desc\':\'Most recently in the first week of November 2016, globally celebrated astrologer Pandit Ankit Sharma received another prestigious award in the field of Astrology, during a mega and momentous astrological seminar named as the Akhil Bhartiya Jyotish Sammelan - SAKSHAM. Organized by a reputed social organization of Ambala Cantt., the Jyotish Shakti Sangh, this grand event was held at BPC Jain Hall, Jagadhari Road, Ambala Cantt (Haryana) from 5th to 6th November 2016.\'},{\'Image_Id\':\'38\',\'Name\':\'Jyotish Prangan Certificate and Award\',\'Desc\':\'In October 2016, globally renowned astrologer Pandit Ankit Sharma was given the during a massive event named as URJA, which was a highly significant mega event on Astrology and Ayurveda. Held from 14th to 16th October 2016 at sector-34 of Chandigarh, URJA was organized jointly by a prestigious social organization Jyotish Prangan (located in Panchkula, Haryana), and the Planet Ayurveda. Over 100 internationally famous Astrologers, Vastu Shastra Specialists, Ayurveda Specialists, professional Psychic Readers, Tarot Card Readers, etc. pertaining to India and abroad, had actively participated in URJA.\'}]',NULL,NULL,'4.133333333333334','1',NULL,NULL,'Abhi','2018-10-11 15:17:49','20',6,'1','A learned and well-versed Panditji. Available for all Bengali rituals.',0),(3,'5','11',NULL,'VIP','BA (Hindi Literature)','VIDEO','1','0','Astrology Services,Monthly Horoscopes,Life Consulting and Remedies,Vashikaran Mantras,Horoscope Specialist,Know Future by DOB','Horoscope Specialist',NULL,NULL,'2.0',NULL,'[{\'Article_Name\':\'A Bud That Is Healthy Will Blossom\',\'URL\':\'\'},{\'Article_Name\':\'Love purifies you!!\',\'URL\':\'\'},{\'Article_Name\':\'Sacred Space- Who Is Corrupt?\',\'URL\':\'\'},{\'Article_Name\':\'Celebrate, Feel The Joy, Because Life Is Light\',\'URL\':\'\'}]',NULL,'[{\'Image_Id\':\'37\',\'Name\':\'SAKSHAM-2016 Award\',\'Desc\':\'Most recently in the first week of November 2016, globally celebrated astrologer Pandit Ankit Sharma received another prestigious award in the field of Astrology, during a mega and momentous astrological seminar named as the Akhil Bhartiya Jyotish Sammelan - SAKSHAM. Organized by a reputed social organization of Ambala Cantt., the Jyotish Shakti Sangh, this grand event was held at BPC Jain Hall, Jagadhari Road, Ambala Cantt (Haryana) from 5th to 6th November 2016.\'},{\'Image_Id\':\'38\',\'Name\':\'Jyotish Prangan Certificate and Award\',\'Desc\':\'In October 2016, globally renowned astrologer Pandit Ankit Sharma was given the during a massive event named as URJA, which was a highly significant mega event on Astrology and Ayurveda. Held from 14th to 16th October 2016 at sector-34 of Chandigarh, URJA was organized jointly by a prestigious social organization Jyotish Prangan (located in Panchkula, Haryana), and the Planet Ayurveda. Over 100 internationally famous Astrologers, Vastu Shastra Specialists, Ayurveda Specialists, professional Psychic Readers, Tarot Card Readers, etc. pertaining to India and abroad, had actively participated in URJA.\'}]',NULL,NULL,'3.35','1',NULL,NULL,'Abhi','2018-07-12 16:28:16','21',6,'1','This is the official profile of Sri Sri Ravi Shankar on Speaking Tree. Sri Sri is a universally revered spiritual and humanitarian leader. His vision of violence-free and stress-free society through the awakening of human values has inspired millions to broaden their spheres of responsibility and work towards the betterment of the world.',0);
/*!40000 ALTER TABLE `ri_pandit_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pandit_details_temp`
--

DROP TABLE IF EXISTS `ri_pandit_details_temp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pandit_details_temp` (
  `VERSION_ID` int(11) NOT NULL default '0',
  `PANDIT_ID` varchar(20) NOT NULL default '',
  `USER_ID` mediumtext,
  `PANDIT_CATEGORY_ID` varchar(20) default NULL,
  `PANDIT_EDUCATIONAL_DETAILS` varchar(100) default NULL,
  `TYPE_OF_AVAILABILITY` varchar(80) default NULL,
  `IS_ASSOCIATED_WITH_TEMPLE` varchar(2) default NULL,
  `IS_FREE_LANCER` varchar(2) default NULL,
  `Specilaization` text,
  `SPECILAIZATION_POOJA` varchar(500) default NULL,
  `PANDIT_EXP_START_DATE` datetime default NULL,
  `PANDIT_PROFESSIONAL_RESUME` text,
  `PANDIT_DAILY_AVAILABILITY_TIMINGS` text,
  `BOOKS_PUBLISHED_DETAILS` varchar(100) default NULL,
  `FAMOUS_ARTICLES_LINK` text,
  `MAGZINE_ASSOCIATION_DETAILS` varchar(250) default NULL,
  `Award_received_Details` text,
  `VIDEO_ID_DETAILS` varchar(200) default NULL,
  `PHOTO_ID_DETAILS` varchar(200) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  `IMAGE_ID` varchar(20) default NULL,
  `Temple_Id` varchar(50) default NULL,
  `Pandit_Desc` varchar(500) default NULL,
  `is_available_on_all_days` varchar(2) default '1',
  `general_availablity_timing` varchar(20) default NULL,
  `Is_New_User` varchar(2) default '0',
  PRIMARY KEY  (`PANDIT_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pandit_details_temp`
--

LOCK TABLES `ri_pandit_details_temp` WRITE;
/*!40000 ALTER TABLE `ri_pandit_details_temp` DISABLE KEYS */;
INSERT INTO `ri_pandit_details_temp` VALUES (0,'Pandit101','321',NULL,'BA(Sanskrit)',NULL,'1','0','Astrology Services,Know Future by DOB,Life Consulting and Remedies','Mahamritunjya Puja,Navratri pooja',NULL,NULL,'[{\"THU\":\"10-21\",\"TUE\":\"\",\"WED\":\"8-21\",\"SAT\":\"\",\"FRI\":\"8-21\",\"Mon\":\"8-21\",\"SUN\":\"\"}]',NULL,'[{\"Article_Name\":\"Pitra Dosh\",\"URL\":\"\"}]',NULL,'[{\"Desc\":\"A wasrd for pandit ji who worked for so long for the welfare of the society\",\"Image_Id\":\"38\",\"Name\":\"All Hindu Brahman shrestha\"}]',NULL,NULL,'Abhi','2018-10-25 15:40:54','Abhi','2018-10-25 15:40:54',NULL,'10','A well trained Pandit','0','','0'),(0,'Pandit102','321',NULL,'BA(Sanskrit)',NULL,'1',NULL,'Astrology Services,Know Future by DOB,Life Consulting and Remedies','Mahamritunjya Puja,Navratri pooja',NULL,NULL,'[{\"THU\":\"10-21\",\"TUE\":\"\",\"WED\":\"8-21\",\"SAT\":\"\",\"FRI\":\"8-21\",\"Mon\":\"8-21\",\"SUN\":\"\"}]',NULL,'[{\"Article_Name\":\"Pitra Dosh\",\"URL\":\"\"}]',NULL,'[{\"Desc\":\"A wasrd for pandit ji who worked for so long for the welfare of the society\",\"Image_Id\":\"38\",\"Name\":\"All Hindu Brahman shrestha\"}]',NULL,NULL,'Abhi','2018-10-25 18:59:10','Abhi','2018-10-25 18:59:10',NULL,'10','A well trained Pandit',NULL,NULL,'0'),(0,'Pandit103','321',NULL,'BA(Sanskrit)',NULL,'1',NULL,'Astrology Services,Know Future by DOB,Life Consulting and Remedies','Mahamritunjya Puja,Navratri pooja',NULL,NULL,'[{\"THU\":\"10-21\",\"TUE\":\"\",\"WED\":\"8-21\",\"SAT\":\"\",\"FRI\":\"8-21\",\"Mon\":\"8-21\",\"SUN\":\"\"}]',NULL,'[{\"Article_Name\":\"Pitra Dosh\",\"URL\":\"\"}]',NULL,'[{\"Desc\":\"A wasrd for pandit ji who worked for so long for the welfare of the society\",\"Image_Id\":\"38\",\"Name\":\"All Hindu Brahman shrestha\"}]',NULL,NULL,'Abhi','2018-10-29 14:12:40','Abhi','2018-10-29 14:12:40',NULL,'10','A well trained Pandit',NULL,NULL,NULL),(0,'Pandit104','37',NULL,'BA(Sanskrit)',NULL,'1',NULL,'Astrology Services,Know Future by DOB,Life Consulting and Remedies','Mahamritunjya Puja,Navratri pooja',NULL,NULL,'[{\"THU\":\"10-21\",\"TUE\":\"\",\"WED\":\"8-21\",\"SAT\":\"\",\"FRI\":\"8-21\",\"Mon\":\"8-21\",\"SUN\":\"\"}]',NULL,'[{\"Article_Name\":\"Pitra Dosh\",\"URL\":\"\"}]',NULL,'[{\"Desc\":\"A wasrd for pandit ji who worked for so long for the welfare of the society\",\"Image_Id\":\"38\",\"Name\":\"All Hindu Brahman shrestha\"}]',NULL,NULL,'Abhi','2018-10-29 15:20:56','Abhi','2018-10-29 15:20:56',NULL,'10','A well trained Pandit',NULL,NULL,NULL);
/*!40000 ALTER TABLE `ri_pandit_details_temp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pandit_language_mapping`
--

DROP TABLE IF EXISTS `ri_pandit_language_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pandit_language_mapping` (
  `VERSION_ID` int(11) default NULL,
  `id` int(11) NOT NULL default '0',
  `LANGUAGE_ID` int(11) default NULL,
  `PANDIT_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pandit_language_mapping`
--

LOCK TABLES `ri_pandit_language_mapping` WRITE;
/*!40000 ALTER TABLE `ri_pandit_language_mapping` DISABLE KEYS */;
INSERT INTO `ri_pandit_language_mapping` VALUES (0,1,1,'5','1','abhi',NULL,'abhi',NULL),(0,2,2,'5','1','abhi',NULL,'abhi',NULL),(0,3,2,'1','1','abhi',NULL,'abhi',NULL);
/*!40000 ALTER TABLE `ri_pandit_language_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pandit_media_association`
--

DROP TABLE IF EXISTS `ri_pandit_media_association`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pandit_media_association` (
  `VERSION_ID` varchar(20) NOT NULL default '',
  `ID` varchar(20) NOT NULL default '',
  `PANDIT_ID` varchar(20) default NULL,
  `NEWS_CHANNEL_NAME` varchar(50) default NULL,
  `PROGRAM_NAME` varchar(50) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pandit_media_association`
--

LOCK TABLES `ri_pandit_media_association` WRITE;
/*!40000 ALTER TABLE `ri_pandit_media_association` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_pandit_media_association` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pandit_subscription_details`
--

DROP TABLE IF EXISTS `ri_pandit_subscription_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pandit_subscription_details` (
  `VERSION_ID` varchar(20) NOT NULL default '',
  `SUBSCRIPTION_DETAILS_ID` varchar(20) NOT NULL default '',
  `SUBSCRIPTION_PLAN_OFFER_ID` varchar(20) default NULL,
  `SUBSCRIPTION_PLAN_ID` varchar(20) default NULL,
  `START_DATE` datetime default NULL,
  `END_DATE` datetime default NULL,
  `PANDIT_ID` varchar(20) default NULL,
  `USER_ID` varchar(20) default NULL,
  `SUBSCRIPTION_PAYMENT_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`SUBSCRIPTION_DETAILS_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pandit_subscription_details`
--

LOCK TABLES `ri_pandit_subscription_details` WRITE;
/*!40000 ALTER TABLE `ri_pandit_subscription_details` DISABLE KEYS */;
INSERT INTO `ri_pandit_subscription_details` VALUES ('1.0','4',NULL,'1',NULL,NULL,'1','2',NULL,'1','abhi',NULL,NULL,NULL);
/*!40000 ALTER TABLE `ri_pandit_subscription_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pandit_subscription_payment_details`
--

DROP TABLE IF EXISTS `ri_pandit_subscription_payment_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pandit_subscription_payment_details` (
  `VERSION_ID` varchar(20) NOT NULL default '',
  `SUBSCRIPTION_PAYMENT_ID` varchar(20) NOT NULL default '',
  `SUBSCRIPTION_DETAILS_ID` varchar(20) default NULL,
  `PAYMENT_DATE` datetime default NULL,
  `PAYMENT_STATUS_ID` varchar(20) default NULL,
  `MRP` varchar(20) default NULL,
  `DISCOUNT` varchar(20) default NULL,
  `VAT_GST` varchar(20) default NULL,
  `CONVENIENCE_FEES` varchar(20) default NULL,
  `AMOUNT_PAID` varchar(20) default NULL,
  `COMMENTS` varchar(200) default NULL,
  `PAYMENT_MODE` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`SUBSCRIPTION_PAYMENT_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pandit_subscription_payment_details`
--

LOCK TABLES `ri_pandit_subscription_payment_details` WRITE;
/*!40000 ALTER TABLE `ri_pandit_subscription_payment_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_pandit_subscription_payment_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pandit_subscription_plans`
--

DROP TABLE IF EXISTS `ri_pandit_subscription_plans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pandit_subscription_plans` (
  `VERSION_ID` varchar(20) NOT NULL default '',
  `SUBSCRIPTION_PLAN_ID` varchar(20) NOT NULL default '',
  `SUBSCRIPTION_PLAN_NAME` varchar(20) default NULL,
  `SUBSCRIPTION_PLAN_DETAILS` varchar(100) default NULL,
  `SUBSCRIPTION_PLAN_DURATION` datetime default NULL,
  `SUBSCRIPTION_PLAN_CHARGES` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`SUBSCRIPTION_PLAN_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pandit_subscription_plans`
--

LOCK TABLES `ri_pandit_subscription_plans` WRITE;
/*!40000 ALTER TABLE `ri_pandit_subscription_plans` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_pandit_subscription_plans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pandit_subscription_plans_offers`
--

DROP TABLE IF EXISTS `ri_pandit_subscription_plans_offers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pandit_subscription_plans_offers` (
  `VERSION_ID` varchar(20) NOT NULL default '',
  `SUBSCRIPTION_PLAN_OFFER_ID` varchar(20) default NULL,
  `SUBSCRIPTION_PLAN_ID` varchar(20) NOT NULL default '',
  `SUBSCRIPTION_PLAN_OFFER_NAME` varchar(50) default NULL,
  `SUBSCRIPTION_PLAN_OFFER_DETAILS` varchar(150) default NULL,
  `DISCOUNT_PERCENTAGE` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`SUBSCRIPTION_PLAN_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pandit_subscription_plans_offers`
--

LOCK TABLES `ri_pandit_subscription_plans_offers` WRITE;
/*!40000 ALTER TABLE `ri_pandit_subscription_plans_offers` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_pandit_subscription_plans_offers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pandit_temple_association`
--

DROP TABLE IF EXISTS `ri_pandit_temple_association`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pandit_temple_association` (
  `VERSION_ID` int(11) NOT NULL default '0',
  `ID` varchar(20) NOT NULL default '',
  `PANDIT_ID` varchar(20) default NULL,
  `TEMPLE_ID` varchar(20) default NULL,
  `IS_LISTED_TEMPLE` varchar(20) default NULL,
  `PANDIT_POST_IN_TEMPLE` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pandit_temple_association`
--

LOCK TABLES `ri_pandit_temple_association` WRITE;
/*!40000 ALTER TABLE `ri_pandit_temple_association` DISABLE KEYS */;
INSERT INTO `ri_pandit_temple_association` VALUES (0,'1','1','1','1','Head','1',NULL,NULL,NULL,NULL),(0,'2','5','1','1','','1',NULL,NULL,NULL,NULL),(0,'3','6','2','1','','1',NULL,NULL,NULL,NULL),(0,'4','7','4','1','','1',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `ri_pandit_temple_association` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pandit_unavailability_details`
--

DROP TABLE IF EXISTS `ri_pandit_unavailability_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pandit_unavailability_details` (
  `VERSION_ID` varchar(20) default NULL,
  `ID` double NOT NULL default '0',
  `PANDIT_ID` varchar(20) default NULL,
  `UNAVAILABLE_FROM_DATE` datetime default NULL,
  `UNAVAILABLE_TO_DATE` datetime default NULL,
  `REASON_FOR_UNAVAILABILITY` text,
  `IS_PERSONAL_BOOKING` varchar(2) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pandit_unavailability_details`
--

LOCK TABLES `ri_pandit_unavailability_details` WRITE;
/*!40000 ALTER TABLE `ri_pandit_unavailability_details` DISABLE KEYS */;
INSERT INTO `ri_pandit_unavailability_details` VALUES ('0',1,'5','2018-05-31 15:00:00','2018-06-02 23:59:59','Out of town','0','1','abhi','2018-05-29 15:08:44','abhi','2018-05-29 15:08:44'),('0',2,'5','2018-06-05 16:00:20','2018-06-15 16:00:20','Out of town','0','1','abhi','2018-06-02 16:00:20','abhi','2018-06-02 16:00:20');
/*!40000 ALTER TABLE `ri_pandit_unavailability_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_payment_refund_details`
--

DROP TABLE IF EXISTS `ri_payment_refund_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_payment_refund_details` (
  `VERSION_ID` varchar(20) NOT NULL default '',
  `REFUND_ID` varchar(20) NOT NULL default '',
  `REFUND_STATUS` varchar(20) default NULL,
  `REFUND_START_DATE` datetime default NULL,
  `REFUND_END_DATE` datetime default NULL,
  `REFUND_AMOUNT` varchar(20) default NULL,
  `REFUND_PAYMENT_MODE` varchar(20) default NULL,
  `ORDER_ID` varchar(20) default NULL,
  `COMMENTS` varchar(200) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`REFUND_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_payment_refund_details`
--

LOCK TABLES `ri_payment_refund_details` WRITE;
/*!40000 ALTER TABLE `ri_payment_refund_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_payment_refund_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pooja_add_on_details`
--

DROP TABLE IF EXISTS `ri_pooja_add_on_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pooja_add_on_details` (
  `VERSION_ID` varchar(20) default NULL,
  `POOJA_ADD_ON_ID` varchar(20) NOT NULL default '',
  `BOOKING_ID` varchar(20) default NULL,
  `BOOKING_TYPE` varchar(20) default NULL,
  `POOJA_SAMAGRI` text,
  `POOJA_PHOTOS` varchar(200) default NULL,
  `POOJA_VIDEO` varchar(200) default NULL,
  `POOJA_MEDIA_CONENT_ONLINE` varchar(20) default NULL,
  `LIVE_POOJA_VIDEO_STREAM` varchar(200) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`POOJA_ADD_ON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pooja_add_on_details`
--

LOCK TABLES `ri_pooja_add_on_details` WRITE;
/*!40000 ALTER TABLE `ri_pooja_add_on_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_pooja_add_on_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pooja_bookings_details`
--

DROP TABLE IF EXISTS `ri_pooja_bookings_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pooja_bookings_details` (
  `VERSION_ID` int(11) default NULL,
  `POOJA_BOOKING_ID` int(11) NOT NULL auto_increment,
  `USER_ID` varchar(20) NOT NULL,
  `POOJA_SERVICE_SUB_CATEGORY_ID_1` varchar(20) default NULL,
  `POOJA_SERVICE_SUB_CATEGORY_ID_2` varchar(20) default NULL,
  `PANDIT_ID` varchar(20) NOT NULL,
  `POOJA_ADD_ON_ID` varchar(20) default NULL,
  `POOJA_MODE_ID` varchar(20) default NULL,
  `POOJA_MEDIA_DETAILS_ID` varchar(20) default NULL,
  `POOJA_COMMUNICATION_ID` varchar(20) default NULL,
  `DATE_CONDUCTED` datetime default NULL,
  `DATE_BOOKED` datetime default NULL,
  `Timing` varchar(100) default NULL,
  `Is_Multi_Days` varchar(2) default '0',
  `No_Of_Days` varchar(2) default '1',
  `PAYMENT_ID` varchar(20) default NULL,
  `Is_Out_Station` varchar(2) default NULL,
  `OUTSTATION_LOCATION` varchar(100) default NULL,
  `POOJA_STATUS_ID` varchar(20) default NULL,
  `POOJA_LANGUAGE` varchar(50) default NULL,
  `USER_REVIEW_ID` varchar(20) default NULL,
  `DATE_COMPLETED` datetime default NULL,
  `CANCELLATION_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  `pooja_desc` varchar(150) default NULL,
  PRIMARY KEY  (`POOJA_BOOKING_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pooja_bookings_details`
--

LOCK TABLES `ri_pooja_bookings_details` WRITE;
/*!40000 ALTER TABLE `ri_pooja_bookings_details` DISABLE KEYS */;
INSERT INTO `ri_pooja_bookings_details` VALUES (0,1,'11',NULL,NULL,'1',NULL,'1',NULL,NULL,'2018-06-11 00:00:00','2018-05-29 00:00:00','6-9','1','3','11','0',NULL,NULL,'1','10','2018-06-13 14:26:26',NULL,'1','Abhi','2018-05-30 14:26:26','Abhi','2018-05-30 14:26:26','3 Days complete \'grah shanti puja\''),(0,2,'10',NULL,NULL,'5',NULL,NULL,NULL,NULL,'2018-06-12 00:00:00','2018-06-04 15:45:28','11-15','1','4','12','0',NULL,NULL,'1','9','2018-06-15 15:45:28',NULL,'1','Abhi','2018-06-05 15:45:28','Abhi','2018-06-05 15:45:28','Special Pooja for \'shop inauguration\'');
/*!40000 ALTER TABLE `ri_pooja_bookings_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pooja_communication_details`
--

DROP TABLE IF EXISTS `ri_pooja_communication_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pooja_communication_details` (
  `VERSION_ID` varchar(20) default NULL,
  `COMMUNICATION_ID` varchar(20) NOT NULL default '',
  `PHONE_CONTACT` varchar(12) default NULL,
  `ADDRESS_LINE1` varchar(200) default NULL,
  `ADDRESS_LINE2` varchar(200) default NULL,
  `CITY` varchar(20) default NULL,
  `STATE_PROVINCE` varchar(20) default NULL,
  `POSTAL_CODE` varchar(7) default NULL,
  `COUNTRY` varchar(20) default NULL,
  `LANDMARK` varchar(100) default NULL,
  `CONTACT_PERSON_FULL_NAME` varchar(100) default NULL,
  `EMAIL` varchar(100) default NULL,
  `BOOKING_ID` varchar(20) default NULL,
  `BOOKING_TYPE` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`COMMUNICATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pooja_communication_details`
--

LOCK TABLES `ri_pooja_communication_details` WRITE;
/*!40000 ALTER TABLE `ri_pooja_communication_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_pooja_communication_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pooja_media_details`
--

DROP TABLE IF EXISTS `ri_pooja_media_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pooja_media_details` (
  `MEDIA_DETAILS_ID` varchar(20) NOT NULL default '',
  `PHOTOS_DETAILS` text,
  `VIDEOS_DETAILS` text,
  `BOOKING_ID` varchar(20) default NULL,
  `BOOKING_TYPE` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`MEDIA_DETAILS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pooja_media_details`
--

LOCK TABLES `ri_pooja_media_details` WRITE;
/*!40000 ALTER TABLE `ri_pooja_media_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_pooja_media_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pooja_mode_details`
--

DROP TABLE IF EXISTS `ri_pooja_mode_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pooja_mode_details` (
  `VERSION_ID` int(11) default NULL,
  `POOJA_MODE_ID` double NOT NULL default '0',
  `POOJA_MODE_NAME` varchar(100) default NULL,
  `POOJA_MODE_DESC` varchar(200) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`POOJA_MODE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pooja_mode_details`
--

LOCK TABLES `ri_pooja_mode_details` WRITE;
/*!40000 ALTER TABLE `ri_pooja_mode_details` DISABLE KEYS */;
INSERT INTO `ri_pooja_mode_details` VALUES (0,1,'PERSONALY','Will be on site.','1','abhi',NULL,NULL,NULL);
/*!40000 ALTER TABLE `ri_pooja_mode_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pooja_package_features`
--

DROP TABLE IF EXISTS `ri_pooja_package_features`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pooja_package_features` (
  `VERSION_ID` varchar(20) default NULL,
  `POOJA_PACKAGE_CATEGORY_ID` varchar(20) NOT NULL default '',
  `POOJA_INCLUDED` varchar(50) default NULL,
  `POOJA_SAMAGRI_INCLUDED` varchar(50) default NULL,
  `POOJA_VIDEO_INCLUDED` varchar(50) default NULL,
  `POOJA_PHOTOS_INCLUDED` varchar(50) default NULL,
  `POOJA_MEDIA_CONTENT_ONLINE_UPLOAD` varchar(20) default NULL,
  `CUSTOMER_SUPPORT` varchar(100) default NULL,
  `PACKAGE_DESCRIPTION` text,
  `REWARD_POINTS` varchar(50) default NULL,
  `LIVE_POOJA_VIDEO_STREAM` varchar(100) default NULL,
  `DISCOUNT_ON_NEXT_SERVICE` varchar(100) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`POOJA_PACKAGE_CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pooja_package_features`
--

LOCK TABLES `ri_pooja_package_features` WRITE;
/*!40000 ALTER TABLE `ri_pooja_package_features` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_pooja_package_features` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pooja_package_types`
--

DROP TABLE IF EXISTS `ri_pooja_package_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pooja_package_types` (
  `VERSION_ID` varchar(20) default NULL,
  `POOJA_PACKAGE_CATEGORY_ID` varchar(20) NOT NULL default '',
  `PACAKAGE_NAME` varchar(50) default NULL,
  `PACKAGE_DESCRIPTION` varchar(250) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`POOJA_PACKAGE_CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pooja_package_types`
--

LOCK TABLES `ri_pooja_package_types` WRITE;
/*!40000 ALTER TABLE `ri_pooja_package_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_pooja_package_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pooja_services`
--

DROP TABLE IF EXISTS `ri_pooja_services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pooja_services` (
  `SERVICE_ID` varchar(20) NOT NULL default '',
  `SERVICE_NAME` varchar(70) default NULL,
  `PANDIT_ID` varchar(20) default NULL,
  `TEMPLE_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  `Service_Desc` text,
  `IMAGE_ID` varchar(20) default NULL,
  PRIMARY KEY  (`SERVICE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pooja_services`
--

LOCK TABLES `ri_pooja_services` WRITE;
/*!40000 ALTER TABLE `ri_pooja_services` DISABLE KEYS */;
INSERT INTO `ri_pooja_services` VALUES ('1','Bhoomi Poojan','10','3','1','abhi',NULL,NULL,NULL,NULL,NULL),('2','Rudrabhishek','10','3','1','abhi',NULL,NULL,NULL,NULL,NULL),('3','Maha Abhishek',NULL,'2','1','abhi',NULL,NULL,NULL,NULL,NULL),('4','Hola Mohalla','5','1','1','abhi',NULL,NULL,NULL,'Military exercises swordsmanship and horse riding like are displayed by Nihang Singhs. ','17'),('5','Sangrand','5','1','1','abhi',NULL,NULL,NULL,'It marks the beginning of a new month. At the Gurudwara','18'),('6','Mahamritunjya Puja','1',NULL,'1','abhi',NULL,NULL,NULL,'The power of Mahamrityunjaya Jaap is such that an individual can achieve Moksha by chanting it','19'),('7','Navagraha Pujas','5','1','1','abhi','2018-04-16 17:19:07',NULL,NULL,'Navgrah puja can be performed anytime to please the nine planets and get their blessings. Navgrah puja is done during the housewarming ceremony, during marriages, child naming ceremonies and all the important events in life','45'),('8','Pitra Dosh Nivaran Puja','5','1','1','abhi',NULL,NULL,NULL,'This puja relieves the souls of the deceased ancestors, It helps in nullifying Pitra Rin','46'),('9','Shani Jaap for Shani Dosha Shanti','5','1','1','abhi',NULL,NULL,NULL,'If you are burdened with Saturn, it will bring disappointments, sorrow, miseries, delays, difficulties, disputes and disharmony.','47');
/*!40000 ALTER TABLE `ri_pooja_services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_pooja_services_pricing`
--

DROP TABLE IF EXISTS `ri_pooja_services_pricing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_pooja_services_pricing` (
  `VERSION_ID` int(11) default NULL,
  `SERVICE_ID` varchar(20) NOT NULL default '',
  `PRICE` double default NULL,
  `DISCOUNT` double default NULL,
  `POOJA_MODE_ID` varchar(20) default NULL,
  `POOJA_PACKAGE_CATEGORY_ID` varchar(20) NOT NULL default '',
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`SERVICE_ID`,`POOJA_PACKAGE_CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_pooja_services_pricing`
--

LOCK TABLES `ri_pooja_services_pricing` WRITE;
/*!40000 ALTER TABLE `ri_pooja_services_pricing` DISABLE KEYS */;
INSERT INTO `ri_pooja_services_pricing` VALUES (1,'4',1300,300,'1','3','1',NULL,NULL,NULL,NULL),(1,'5',1800,200,'1','1','1',NULL,NULL,NULL,NULL),(1,'5',1850,200,'1','3','1',NULL,NULL,NULL,NULL),(0,'6',1850,200,'1','3','1',NULL,NULL,NULL,NULL),(0,'7',1300,150,'1','3','1',NULL,NULL,NULL,NULL),(0,'8',1100,0,'1','3','1',NULL,NULL,NULL,NULL),(0,'9',5100,350,'1','3','1',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `ri_pooja_services_pricing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_season`
--

DROP TABLE IF EXISTS `ri_season`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_season` (
  `SEASON_ID` varchar(20) NOT NULL default '',
  `SEASON_NAME` varchar(50) default NULL,
  `MONTHS_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`SEASON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_season`
--

LOCK TABLES `ri_season` WRITE;
/*!40000 ALTER TABLE `ri_season` DISABLE KEYS */;
INSERT INTO `ri_season` VALUES ('1','Monsoon','7,8,9','1','abhi','2018-04-04 11:39:29','','2018-04-04 11:39:29'),('2','Winter','12,1,2','1','abhi','2018-04-04 13:06:18','','2018-04-04 13:06:18'),('3','Summer','3,4,5,6','1','abhi','2018-04-04 11:40:21','','2018-04-04 11:40:21'),('4','Post Monsoon','10,11','1','abhi','2018-04-04 13:06:43','','2018-04-04 13:06:43');
/*!40000 ALTER TABLE `ri_season` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_service_cancellation_reviews`
--

DROP TABLE IF EXISTS `ri_service_cancellation_reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_service_cancellation_reviews` (
  `VERSION_ID` varchar(20) NOT NULL default '',
  `SERVICE_CANCELLATION_ID` varchar(20) NOT NULL default '',
  `CANCELLATION_REASON_ID` varchar(20) default NULL,
  `CUSTOM_CANCELLATION_REASON` varchar(250) default NULL,
  `CANCELLATION_DATE` datetime default NULL,
  `CANCELLED_BY_USER_ID` varchar(20) default NULL,
  `IS_CANCELLED_BY_PANDIT` varchar(2) default NULL,
  `PANDIT_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`SERVICE_CANCELLATION_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_service_cancellation_reviews`
--

LOCK TABLES `ri_service_cancellation_reviews` WRITE;
/*!40000 ALTER TABLE `ri_service_cancellation_reviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_service_cancellation_reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_temple`
--

DROP TABLE IF EXISTS `ri_temple`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_temple` (
  `TEMPLE_ID` varchar(250) NOT NULL default '',
  `TEMPLE_NAME` varchar(100) default NULL,
  `TEMPLE_DESC` varchar(500) default NULL,
  `TEMPLE_ADDRESS_ID` varchar(20) default NULL,
  `AUTH_CHANNEL_PARTNER` varchar(2) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  `MAIN_IMAGE_ID` varchar(50) default NULL,
  `CONTACT_NO` varchar(12) default NULL,
  `Image_Gallery` text,
  `Hits_Count` int(10) unsigned zerofill NOT NULL default '0000000000',
  PRIMARY KEY  (`TEMPLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_temple`
--

LOCK TABLES `ri_temple` WRITE;
/*!40000 ALTER TABLE `ri_temple` DISABLE KEYS */;
INSERT INTO `ri_temple` VALUES ('1','Golden Temple','This temple is in the punjab(amritsar)','2','0','1','abhi','2018-04-04 11:26:56','Abhi','2018-10-18 15:35:02','5','1122112211','[{\"imageId\":\"22\"},{\"imageId\":\"23\"},{\"imageId\":\"24\"},{\"imageId\":\"25\"},{\"imageId\":\"26\"},{\"imageId\":\"27\"},{\"imageId\":\"28\"},{\"imageId\":\"29\"},{\"imageId\":\"30\"},{\"imageId\":\"31\"},{\"imageId\":\"32\"},{\"imageId\":\"33\"},{\"imageId\":\"34\"},{\"imageId\":\"35\"},{\"imageId\":\"36\"}]',0000000099),('10','Mahakaleshwar','Mahakaaleshwar Jyotirlinga is a Hindu temple dedicated to Lord Shiva and one of the twelve Jyotirlingams, shrines which are said to be the most sacred abodes of Lord Shiva','21','0','1','abhi',NULL,NULL,NULL,'53','8525364125',NULL,0000000000),('11','Gufa Wala Mandir','Gufa Wala Mandir is in Bhopal','22','0','1','abhi',NULL,'Abhi','2018-10-18 12:24:25','54','8975486914',NULL,0000000040),('12','Ramanathaswamy Temple','The primary deity of the temple is Ramanathaswamy (Shiva) in the form of lingam.[2] There are two lingams inside the sanctum - one built by Sita, from sand, residing as the main deity, Ramalingam and the one brought by Hanuman from Kailash called Vishwalingam.','23','0','1','abhi',NULL,NULL,NULL,'55','9852364198',NULL,0000000000),('13','Vaishno Devi','The words \"\"maa\" and \"mata\" are commonly used in India for \"mother\", and thus are often used in connection with Vaishno Devi. Vaishno Devi Mandir is a Hindu temple dedicated to the Hindu Goddess, located in Katra at the Trikuta Mountains','24','0','1','abhi',NULL,NULL,NULL,'56','7549681534',NULL,0000000005),('2','Badrinath Temple','This temple is a hindu temple of lord vishnu','1','1','1','abhi','2018-04-04 11:28:15','Abhi','2018-10-18 12:59:35','4','0000000011',NULL,0000000003),('3','kashi vishwanath','Land of Shiva','3','0','1','abhi','2018-04-16 17:12:10','','2018-04-16 17:12:10','2','12121212',NULL,0000000000),('4','kalka ji mandir','Kalka Ji Mandir is one of the oldest temples in the country and in Delhi as it was built in 1764 AD and is dedicated to goddess Kali','4','0','1','abhi',NULL,'Abhi','2018-10-18 12:59:59','11',NULL,NULL,0000000039),('5','Delhi Iskcon Temple','Sri Sri Radha Parthasarathi Mandir, generally known as the ISKCON Delhi temple, is a well known Vaishnav temple of Lord Krishna and Radharani in the form of Radha Parthasarathi.','16','1','1','abhi',NULL,'Abhi','2018-10-18 12:16:04','48','7826523641',NULL,0000000035),('6','Birla-Mandir','Birla Mandir (Birla Temple) refers to different Hindu temples or Mandirs built by the Birla family, in different cities. All these temples are magnificently built, some of them in white marble or in sandstone. The temples are generally located in a prominent location','17','1','1','abhi',NULL,NULL,NULL,'49','7825152010',NULL,0000000068),('7','Somnath-Temple','The temple is considered sacred due to the various legends connected to it. Somnath means \"Lord of the Soma\", an epithet of Shiva.','18','0','1','abhi',NULL,'Abhi','2018-10-18 12:30:07','50','1425367485',NULL,0000000002),('8','Bankebihari','Shri Bankey Bihari Mandir is a Hindu temple dedicated to Lord Krishna, in the holy city of Vrindavan in the Mathura district of Uttar Pradesh. It is situated near Shri RadhaVallabh Temple.','19','0','1','abhi',NULL,NULL,NULL,'51','8696745825',NULL,0000000000),('9','Tirupati','The Temple is constructed in Dravidian architecture and is believed to be constructed over a period of time starting from 300 AD. The Garbagriha (Sanctum Sanctorum) is called AnandaNilayam.','20','0','1','abhi',NULL,'Abhi','2018-10-18 13:00:18','52','9452143652',NULL,0000000002),('Temple102','New Temple','hasgf',NULL,NULL,'1',NULL,NULL,'Abhi','2018-10-04 15:21:33','Rel174','8452120412',NULL,0000000000),('Temple103','Vaishno Devi','dsdsad',NULL,NULL,'1',NULL,NULL,'Abhi','2018-10-04 15:27:31','Rel175','7835851375',NULL,0000000000),('Temple104','Ramendra','test','69',NULL,'1','Abhi','2018-10-18 18:22:05','Abhi','2018-10-18 18:22:05','Rel230','7835851375',NULL,0000000000),('Temple105','Dummy Temple','Hello ','68',NULL,'1','Abhi','2018-10-18 18:21:54','Abhi','2018-10-18 18:21:54','Rel177','7835851375','[{\"imageId\":\"Rel225\"},{\"imageId\":\"Rel226\"},{\"imageId\":\"Rel227\"}]',0000000000),('Temple108','Test Temple5','Hello ','66',NULL,'1','Abhi','2018-10-18 15:56:28','Abhi','2018-10-18 15:56:28','Rel177','7835851375','[{\"imageId\":\"Rel225\"},{\"imageId\":\"Rel226\"},{\"imageId\":\"Rel227\"}]',0000000000),('Temple109','Dummy','Hello ','67',NULL,'1','Abhi','2018-10-18 16:04:48','Abhi','2018-10-18 16:04:48','Rel177','7835851375','[{\"imageId\":\"Rel225\"},{\"imageId\":\"Rel226\"},{\"imageId\":\"Rel227\"}]',0000000000),('Temple121','Dummy Temple2','Hello ','71',NULL,'1','Abhi','2018-10-23 14:21:18','Abhi','2018-10-23 14:21:18','Rel177','7835851375','[{\"imageId\":\"Rel225\"},{\"imageId\":\"Rel226\"},{\"imageId\":\"Rel227\"}]',0000000000),('Temple122','Vaishno Devi','Hello ','72',NULL,'1','Abhi','2018-10-23 15:15:17','Abhi','2018-10-26 10:43:21','Rel196','7835851375',NULL,0000000001),('Temple123','MahaKaal2','tst','84',NULL,'1','Abhi','2018-10-24 12:52:37','Abhi','2018-10-24 12:52:37','Rel325','7835851375',NULL,0000000000);
/*!40000 ALTER TABLE `ri_temple` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_temple_connectivity`
--

DROP TABLE IF EXISTS `ri_temple_connectivity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_temple_connectivity` (
  `ADDRESS_ID` varchar(20) default NULL,
  `PARKING_LOT_DESC` varchar(100) default NULL,
  `NEAREST_BUS_STAND` varchar(100) default NULL,
  `NEAREST_RAILWAY_STATION` varchar(100) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  `NEAREST_AIRPORT` varchar(100) default NULL,
  KEY `ADDRESS_ID` (`ADDRESS_ID`),
  CONSTRAINT `ri_temple_connectivity_ibfk_1` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `ri_address_test2` (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_temple_connectivity`
--

LOCK TABLES `ri_temple_connectivity` WRITE;
/*!40000 ALTER TABLE `ri_temple_connectivity` DISABLE KEYS */;
INSERT INTO `ri_temple_connectivity` VALUES ('1','','Kedarnath Road, Khumera','No railway station in the 50Km range','1','abhi','2018-04-09 14:45:43','','2018-04-09 14:45:43','Army Helipad Badrinath'),('2','','Grand Trunk Road, Near Panj Peer, New Golden Avenue, Golden Avenue, Amritsar','Amritsar','1','abhi','2018-04-16 12:07:58','','2018-04-16 12:07:58','Allama Iqbal International Airport'),('3','','Jaitpura, Varanasi','Varanasi City','1','abhi','2018-04-16 17:19:07','','2018-04-16 17:19:07','Lal Bahadur Shastri International Airport'),(NULL,'','',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(NULL,' ',' ',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('17','','Timarpur Marg, West Vinod Nagar, Nawada, Timarpur, Delhi','New Delhi','1',NULL,NULL,NULL,NULL,'Indira Gandhi International Airport'),('22','','Timarpur Marg, West Vinod Nagar, Nawada, Timarpur, Delhi','Anand Vihar Terminal','1',NULL,NULL,NULL,NULL,'Indira Gandhi International Airport'),('16','','Timarpur Marg, West Vinod Nagar, Nawada, Timarpur, Delhi','Moolchand Metro Station','1',NULL,NULL,NULL,NULL,'Indira Gandhi International Airport'),('4','','Timarpur Marg, West Vinod Nagar, Nawada, Timarpur, Delhi','Moolchand Metro Station','1',NULL,NULL,NULL,NULL,'Indira Gandhi International Airport'),('24','','Nalla Ghorian','Reasi Station','1',NULL,NULL,NULL,NULL,'Jammu Airport'),('18','','Rayon Housing Society, Jobanpura, Veraval','Somnath','1',NULL,NULL,NULL,NULL,'Keshod Airport'),('20','','Mangalam, Tirupati','Tirupati Main','1',NULL,NULL,NULL,NULL,'Tirupati International Airport');
/*!40000 ALTER TABLE `ri_temple_connectivity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_temple_donation_category`
--

DROP TABLE IF EXISTS `ri_temple_donation_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_temple_donation_category` (
  `DONATION_CATEGORY_ID` varchar(20) NOT NULL,
  `DONATION_CATEGORY_NAME` varchar(30) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`DONATION_CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_temple_donation_category`
--

LOCK TABLES `ri_temple_donation_category` WRITE;
/*!40000 ALTER TABLE `ri_temple_donation_category` DISABLE KEYS */;
INSERT INTO `ri_temple_donation_category` VALUES ('1','Temple Needs','1','abhi',NULL,'abhi',NULL),('2','Medicine','1','abhi',NULL,NULL,NULL),('3','Food Donation','1','abhi',NULL,NULL,NULL),('4','Education','1','abhi',NULL,NULL,NULL),('5','Clothes','1','abhi',NULL,NULL,NULL),('6','Girl Child Marriage','1','abhi',NULL,NULL,NULL);
/*!40000 ALTER TABLE `ri_temple_donation_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_temple_donation_clothes`
--

DROP TABLE IF EXISTS `ri_temple_donation_clothes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_temple_donation_clothes` (
  `DONATION_SUB_CATEGORY_ID` varchar(20) NOT NULL,
  `DONATION_SUB_CATEGORY_NAME` varchar(30) default NULL,
  `DESCRIPTION` varchar(250) default NULL,
  `STARTDATE` datetime default NULL,
  `ENDDATE` datetime default NULL,
  `REQUIRED_MONEY` double default NULL,
  `COLLECTED_MONEY` double default NULL,
  `NO_OF_CONTIBUITORS` int(11) default NULL,
  `TEMPLE_ID` varchar(20) default NULL,
  `TEMPLE_DONATION_CATEGORY_ID` varchar(20) default NULL,
  `IMAGE_ID` varchar(20) default NULL,
  `ADDRESS_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`DONATION_SUB_CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_temple_donation_clothes`
--

LOCK TABLES `ri_temple_donation_clothes` WRITE;
/*!40000 ALTER TABLE `ri_temple_donation_clothes` DISABLE KEYS */;
INSERT INTO `ri_temple_donation_clothes` VALUES ('1','','You can chip in and help the Clean Clothes Campaign!',NULL,'2018-05-14 07:26:29',1020.2,1020.2,9,'4','5','20','1','1','abhi',NULL,NULL,NULL);
/*!40000 ALTER TABLE `ri_temple_donation_clothes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_temple_donation_education`
--

DROP TABLE IF EXISTS `ri_temple_donation_education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_temple_donation_education` (
  `DONATION_SUB_CATEGORY_ID` varchar(20) NOT NULL,
  `DONATION_SUB_CATEGORY_NAME` varchar(30) default NULL,
  `DESCRIPTION` varchar(250) default NULL,
  `STARTDATE` datetime default NULL,
  `ENDDATE` datetime default NULL,
  `REQUIRED_MONEY` double default NULL,
  `COLLECTED_MONEY` double default NULL,
  `NO_OF_CONTIBUITORS` int(11) default NULL,
  `TEMPLE_ID` varchar(20) default NULL,
  `TEMPLE_DONATION_CATEGORY_ID` varchar(20) default NULL,
  `IMAGE_ID` varchar(20) default NULL,
  `ADDRESS_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`DONATION_SUB_CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_temple_donation_education`
--

LOCK TABLES `ri_temple_donation_education` WRITE;
/*!40000 ALTER TABLE `ri_temple_donation_education` DISABLE KEYS */;
INSERT INTO `ri_temple_donation_education` VALUES ('1','Support a classroom','My students are hard workers. They are among the rare teens that love school; they are good at it.','2018-05-14 12:01:14','2018-05-12 12:01:14',20000,500,1,'1','4','16',NULL,'1','abhi',NULL,NULL,NULL);
/*!40000 ALTER TABLE `ri_temple_donation_education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_temple_donation_food_donation`
--

DROP TABLE IF EXISTS `ri_temple_donation_food_donation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_temple_donation_food_donation` (
  `DONATION_SUB_CATEGORY_ID` varchar(20) NOT NULL,
  `DONATION_SUB_CATEGORY_NAME` varchar(30) default NULL,
  `DESCRIPTION` varchar(250) default NULL,
  `STARTDATE` datetime default NULL,
  `ENDDATE` datetime default NULL,
  `REQUIRED_MONEY` double default NULL,
  `COLLECTED_MONEY` double default NULL,
  `NO_OF_CONTIBUITORS` int(11) default NULL,
  `TEMPLE_ID` varchar(20) default NULL,
  `TEMPLE_DONATION_CATEGORY_ID` varchar(20) default NULL,
  `IMAGE_ID` varchar(20) default NULL,
  `ADDRESS_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`DONATION_SUB_CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_temple_donation_food_donation`
--

LOCK TABLES `ri_temple_donation_food_donation` WRITE;
/*!40000 ALTER TABLE `ri_temple_donation_food_donation` DISABLE KEYS */;
INSERT INTO `ri_temple_donation_food_donation` VALUES ('1','Food Donation At An Orphanage','It is unfortunate that scores of children are homeless and have no family members to look after them. Such children living in orphanages as well as other institutions','2018-05-12 07:26:29','2018-05-14 07:26:29',10000,8100,15,'1','3','8','2','1','abhi',NULL,NULL,NULL),('2','Food Donation At A Gurudwara','Sikhism has always championed the cause of donation and seva. The very fundamental belief is to give back to the society and uplift those who are in need.','2018-05-11 07:26:29','2018-05-14 07:26:29',12500,600,2,'1','3','14','1','1','abhi',NULL,NULL,NULL),('3','Food Donation At Old Age Home','Not everyone in life is fortunate to be surrounded by loved ones and family members.','2018-05-13 07:26:29','2018-05-14 07:26:29',5000,0,0,'1','3','15','1','1','abhi',NULL,NULL,NULL);
/*!40000 ALTER TABLE `ri_temple_donation_food_donation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_temple_donation_girl_child_marriage`
--

DROP TABLE IF EXISTS `ri_temple_donation_girl_child_marriage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_temple_donation_girl_child_marriage` (
  `DONATION_SUB_CATEGORY_ID` varchar(20) NOT NULL,
  `DONATION_SUB_CATEGORY_NAME` varchar(30) default NULL,
  `DESCRIPTION` varchar(250) default NULL,
  `STARTDATE` datetime default NULL,
  `ENDDATE` datetime default NULL,
  `REQUIRED_MONEY` double default NULL,
  `COLLECTED_MONEY` double default NULL,
  `NO_OF_CONTIBUITORS` int(11) default NULL,
  `TEMPLE_ID` varchar(20) default NULL,
  `TEMPLE_DONATION_CATEGORY_ID` varchar(20) default NULL,
  `IMAGE_ID` varchar(20) default NULL,
  `ADDRESS_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`DONATION_SUB_CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_temple_donation_girl_child_marriage`
--

LOCK TABLES `ri_temple_donation_girl_child_marriage` WRITE;
/*!40000 ALTER TABLE `ri_temple_donation_girl_child_marriage` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_temple_donation_girl_child_marriage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_temple_donation_medicine`
--

DROP TABLE IF EXISTS `ri_temple_donation_medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_temple_donation_medicine` (
  `DONATION_SUB_CATEGORY_ID` varchar(20) NOT NULL,
  `DONATION_SUB_CATEGORY_NAME` varchar(30) default NULL,
  `DESCRIPTION` varchar(250) default NULL,
  `STARTDATE` datetime default NULL,
  `ENDDATE` datetime default NULL,
  `REQUIRED_MONEY` double default NULL,
  `COLLECTED_MONEY` double default NULL,
  `NO_OF_CONTIBUITORS` int(11) default NULL,
  `TEMPLE_ID` varchar(20) default NULL,
  `TEMPLE_DONATION_CATEGORY_ID` varchar(20) default NULL,
  `IMAGE_ID` varchar(20) default NULL,
  `ADDRESS_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`DONATION_SUB_CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_temple_donation_medicine`
--

LOCK TABLES `ri_temple_donation_medicine` WRITE;
/*!40000 ALTER TABLE `ri_temple_donation_medicine` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_temple_donation_medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_temple_donation_temple_needs`
--

DROP TABLE IF EXISTS `ri_temple_donation_temple_needs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_temple_donation_temple_needs` (
  `DONATION_SUB_CATEGORY_ID` varchar(20) NOT NULL,
  `DONATION_SUB_CATEGORY_NAME` varchar(30) default NULL,
  `DESCRIPTION` varchar(250) default NULL,
  `STARTDATE` datetime default NULL,
  `ENDDATE` datetime default NULL,
  `REQUIRED_MONEY` double default NULL,
  `COLLECTED_MONEY` double default NULL,
  `NO_OF_CONTIBUITORS` int(11) default NULL,
  `TEMPLE_ID` varchar(20) default NULL,
  `TEMPLE_DONATION_CATEGORY_ID` varchar(20) default NULL,
  `IMAGE_ID` varchar(20) default NULL,
  `ADDRESS_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`DONATION_SUB_CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_temple_donation_temple_needs`
--

LOCK TABLES `ri_temple_donation_temple_needs` WRITE;
/*!40000 ALTER TABLE `ri_temple_donation_temple_needs` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_temple_donation_temple_needs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_temple_donations_details`
--

DROP TABLE IF EXISTS `ri_temple_donations_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_temple_donations_details` (
  `VERSION_ID` varchar(20) NOT NULL default '',
  `DONATION_ID` varchar(20) NOT NULL default '',
  `TEMPLE_ID` varchar(20) default NULL,
  `DONATION_CATEGORY_ID` varchar(20) default NULL,
  `DONATION_SUB_CATEGORY_ID` varchar(20) default NULL,
  `USER_ID` varchar(20) default NULL,
  `AMOUNT_DONATED` varchar(10) default NULL,
  `PAYMENT_ID` varchar(20) default NULL,
  `DONATION_DATE` datetime default NULL,
  `DONATION_STATUS_ID` varchar(20) default NULL,
  `DATE_COMPLETED` datetime default NULL,
  `USER_REVIEW_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`DONATION_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_temple_donations_details`
--

LOCK TABLES `ri_temple_donations_details` WRITE;
/*!40000 ALTER TABLE `ri_temple_donations_details` DISABLE KEYS */;
INSERT INTO `ri_temple_donations_details` VALUES ('1','1','1','1','1','1','123','1234',NULL,'1',NULL,'1','1',NULL,NULL,NULL,NULL),('1','2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'3',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('1','5',NULL,'2',NULL,NULL,'10000.0','44',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Abhi','2018-05-11 15:07:24');
/*!40000 ALTER TABLE `ri_temple_donations_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_temple_overview`
--

DROP TABLE IF EXISTS `ri_temple_overview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_temple_overview` (
  `TEMPLE_ID` varchar(20) NOT NULL default '',
  `TEMPLE_HISTORY` text,
  `TEMPLE_HAS_VIDEO` varchar(2) default NULL,
  `Temple_VIDEO_LINK` varchar(50) default NULL,
  `TEMPLE_HISTORY_IMAGE` varchar(10) default NULL,
  `TEMPLE_INTRO_LINE` varchar(50) default NULL,
  `TEMPLE_INTRO_DETAILS` text,
  `TEMPLE_MISSION_STMT_DETAILS` text,
  `TEMPLE_SPECIAL_SERVICES_DETAILS` text,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`TEMPLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_temple_overview`
--

LOCK TABLES `ri_temple_overview` WRITE;
/*!40000 ALTER TABLE `ri_temple_overview` DISABLE KEYS */;
INSERT INTO `ri_temple_overview` VALUES ('1','The construction of Harmandir Sahib was intended to build a place of worship for men and women from all walks of life and all religions to worship God equally.[2][6] The four entrances (representing the four directions) to get into the Harmandir Sahib also symbolise the openness of the Sikhs towards all people and religions.[7] Over 100,000 people visit the shrine daily for worship, and also partake jointly in the free community kitchen and meal (Langar) regardless of any distinctions, a tradition that is a hallmark of all Sikh Gurdwaras.','0',NULL,'6','Golden Temple','[{\'Image\':7,\'Desc\':\'Guru Nanak\'},{\'Image\':9,\'Desc\':\'HarGovind\'},{\'Image\':10,\'Desc\':\'Guru Amar Das\'}]','[{\'Image\':8,\'Desc\':\"Langar\"}]',NULL,'1','abhi',NULL,NULL,NULL);
/*!40000 ALTER TABLE `ri_temple_overview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_temple_reviews`
--

DROP TABLE IF EXISTS `ri_temple_reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_temple_reviews` (
  `VERSION_ID` int(11) default NULL,
  `REVIEW_ID` int(11) NOT NULL auto_increment,
  `RATING` varchar(20) NOT NULL,
  `USER_REVIEW_ABOUT` varchar(150) default NULL,
  `USER_REVIEW_DESC` text,
  `USER_ID` varchar(20) default NULL,
  `TEMPLE_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`REVIEW_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_temple_reviews`
--

LOCK TABLES `ri_temple_reviews` WRITE;
/*!40000 ALTER TABLE `ri_temple_reviews` DISABLE KEYS */;
INSERT INTO `ri_temple_reviews` VALUES (0,1,'2','Well organized and clean.The fact that volunteers run it so well is commendable.	 xyz','Clean and well organized','12','1','1','Abhi','2018-05-30 15:22:49','Abhi','2018-05-30 15:22:49'),(1,3,'5','Clean and well organized','2133131221321312123','12','1','1',NULL,NULL,'Abhi','2018-05-30 15:25:24'),(0,4,'2','Well organized and clean.The fact that volunteers run it so well is commendable.	 xyz','Clean and well organized','12','1','1','Abhi','2018-05-30 15:28:56','Abhi','2018-05-30 15:28:56'),(0,5,'2','Well organized and clean.The fact that volunteers run it so well is commendable.	 xyz','ZHXHJSXB ','12','1','1','Abhi','2018-05-30 15:29:14','Abhi','2018-05-30 15:29:14'),(0,6,'5','ydgds','sdffffffewewr234324342','12','1','1','Abhi','2018-05-30 15:31:08','Abhi','2018-05-30 15:31:08'),(0,7,'4','qwe','qweeee','12','1','1','Abhi','2018-05-30 15:33:19','Abhi','2018-05-30 15:33:19'),(0,8,'1','new one','testnew','12','1','1','Abhi','2018-05-30 15:34:44','Abhi','2018-05-30 15:34:44');
/*!40000 ALTER TABLE `ri_temple_reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_temple_temp`
--

DROP TABLE IF EXISTS `ri_temple_temp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_temple_temp` (
  `TEMPLE_ID` varchar(250) NOT NULL default '',
  `TEMPLE_NAME` varchar(100) default NULL,
  `TEMPLE_DESC` varchar(500) default NULL,
  `TEMPLE_ADDRESS_Detail` text,
  `AUTH_CHANNEL_PARTNER` varchar(2) default '0',
  `IS_Verified` varchar(2) default '1',
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  `Main_Image_Detail` text,
  `CONTACT_NO` varchar(12) NOT NULL,
  `Image_Gallery` text,
  `Hits_Count` int(10) unsigned zerofill NOT NULL default '0000000000',
  `image_detail` text,
  `Temple_Timing` varchar(50) default NULL,
  `Aarti_Timing` varchar(50) default NULL,
  PRIMARY KEY  (`TEMPLE_ID`),
  UNIQUE KEY `TEMPLE_ID_UNIQUE` (`TEMPLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_temple_temp`
--

LOCK TABLES `ri_temple_temp` WRITE;
/*!40000 ALTER TABLE `ri_temple_temp` DISABLE KEYS */;
INSERT INTO `ri_temple_temp` VALUES ('Temple101','MahaKaal','tst','{\'addressID\':\'null\', \'state\':\'Madhya Pradesh\', \'dist\':\'Ujjain\', \'city\':\'Ujjain\', \'addressContactNo\':\'7835851375\', \'addressDetail\':\'Mahakaal \', \'isTempleAddress\':\'1\', \'isActive\':\'0\', \'pincode\':\'null\', \'cityId\':\'null\'}','0','0','Abhi','2018-10-23 15:16:37','Abhi','2018-10-23 15:16:37','Rel312','7835851375','Rel312,Rel314',0000000000,NULL,'03:00,05:00','03:00,05:00');
/*!40000 ALTER TABLE `ri_temple_temp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_temple_timings`
--

DROP TABLE IF EXISTS `ri_temple_timings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_temple_timings` (
  `TEMPLE_ID` varchar(20) NOT NULL default '',
  `TEMPLE_TIME` varchar(200) default NULL,
  `SEASON_ID` varchar(20) NOT NULL default '',
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`TEMPLE_ID`,`SEASON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_temple_timings`
--

LOCK TABLES `ri_temple_timings` WRITE;
/*!40000 ALTER TABLE `ri_temple_timings` DISABLE KEYS */;
INSERT INTO `ri_temple_timings` VALUES ('1','6-11,17-20','1','1','abhi','2018-04-04 17:52:36','','2018-04-04 17:52:36'),('1','7-10,16-21','2','1','abhi','2018-04-04 17:53:27','','2018-04-04 17:53:27'),('10','7-11,17-21','1','1','abhi',NULL,NULL,NULL),('11','7-11,17-21','1','1','abhi',NULL,NULL,NULL),('12','7-11,17-21','1','1','abhi',NULL,NULL,NULL),('13','7-11,17-21','1','1','abhi',NULL,NULL,NULL),('2','7-10,16-21','1','1','abhi','2018-04-04 17:53:12','','2018-04-04 17:53:12'),('3','5-14,17-21','1','1','abhi','2018-04-16 17:23:22','','2018-04-16 17:23:22'),('4','7-11,17-21','1','1','abhi','2018-04-16 17:23:22',NULL,'2018-04-16 17:23:22'),('5','7-11,17-21','1','1','abhi',NULL,NULL,NULL),('6','7-11,17-21','1','1','abhi',NULL,NULL,NULL),('7','7-11,17-21','1','1','abhi',NULL,NULL,NULL),('8','7-11,17-21','1','1','abhi',NULL,NULL,NULL),('9','7-11,17-21','1','1','abhi',NULL,NULL,NULL);
/*!40000 ALTER TABLE `ri_temple_timings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_user_address_mapping`
--

DROP TABLE IF EXISTS `ri_user_address_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_user_address_mapping` (
  `ADDRESS_ID` varchar(20) NOT NULL default '',
  `USER_ID` varchar(20) NOT NULL default '',
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`ADDRESS_ID`,`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_user_address_mapping`
--

LOCK TABLES `ri_user_address_mapping` WRITE;
/*!40000 ALTER TABLE `ri_user_address_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_user_address_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_user_bank_account_details`
--

DROP TABLE IF EXISTS `ri_user_bank_account_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_user_bank_account_details` (
  `VERSION_ID` varchar(20) NOT NULL default '',
  `BANK_DETAILS_ID` varchar(20) NOT NULL default '',
  `USER_ID` varchar(20) default NULL,
  `BANK_NAME` varchar(50) default NULL,
  `NAME_BANK_ACCOUNT` varchar(50) default NULL,
  `BANK_ACCOUNT_NUMBER` varchar(20) default NULL,
  `IFSC_CODE` varchar(20) default NULL,
  `COMMENTS` varchar(150) default NULL,
  `ALIAS_NAME` varchar(20) default NULL,
  `ACCOUNT_CATEGORY` varchar(20) default NULL,
  `ACCOUNT_TYPE` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`BANK_DETAILS_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_user_bank_account_details`
--

LOCK TABLES `ri_user_bank_account_details` WRITE;
/*!40000 ALTER TABLE `ri_user_bank_account_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_user_bank_account_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_user_cart`
--

DROP TABLE IF EXISTS `ri_user_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_user_cart` (
  `version_id` int(11) default NULL,
  `cart_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) NOT NULL,
  `address_id` varchar(20) default NULL,
  `items_details` text,
  `CREATED_BY` varchar(50) default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `Created_On` datetime default NULL,
  `Updated_On` datetime default NULL,
  PRIMARY KEY  (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_user_cart`
--

LOCK TABLES `ri_user_cart` WRITE;
/*!40000 ALTER TABLE `ri_user_cart` DISABLE KEYS */;
INSERT INTO `ri_user_cart` VALUES (174,1,10,'12','[{\"Price\":500,\"Item_Id\":40},{\"Price\":500,\"Item_Id\":50},{\"Price\":1000,\"Item_Id\":51},{\"Price\":1000,\"Item_Id\":52}]','Abhi','Abhi','2018-08-06 18:38:57','2018-10-18 15:35:24'),(2,3,12,'12','[{\"Price\":300,\"Item_Id\":3},{\"Price\":400,\"Item_Id\":4}]','Abhi','Abhi','2018-08-09 17:02:43','2018-08-13 12:43:58');
/*!40000 ALTER TABLE `ri_user_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_user_cashback_details`
--

DROP TABLE IF EXISTS `ri_user_cashback_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_user_cashback_details` (
  `VERSION_ID` varchar(20) NOT NULL default '',
  `CASHBACK_ID` varchar(20) NOT NULL default '',
  `USER_ID` varchar(20) default NULL,
  `TOTAL_AVAILABLE_CASHBACK` varchar(20) default NULL,
  `PREVIOUS_AVAILABLE_CASHBACK` varchar(20) default NULL,
  `CASHBACK_EARNED` varchar(20) default NULL,
  `EARNED_ORDER_ID` varchar(20) default NULL,
  `CASHBACK_USED` varchar(20) default NULL,
  `USING_ORDER_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`CASHBACK_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_user_cashback_details`
--

LOCK TABLES `ri_user_cashback_details` WRITE;
/*!40000 ALTER TABLE `ri_user_cashback_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_user_cashback_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_user_details`
--

DROP TABLE IF EXISTS `ri_user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_user_details` (
  `USER_ID` int(11) NOT NULL auto_increment,
  `LOCATION` varchar(50) default NULL,
  `FIRSTNAME` varchar(100) default NULL,
  `MIDDLENAME` varchar(100) default NULL,
  `LASTNAME` varchar(100) default NULL,
  `GENDER` varchar(10) default NULL,
  `DOB` date default NULL,
  `PRIMARY_PHONE` varchar(12) default NULL,
  `SECONDARY_PHONE` varchar(12) default NULL,
  `USER_ROLE_ID` varchar(20) default '1',
  `EMAIL` varchar(70) NOT NULL,
  `PHOTO_ID` varchar(20) default NULL,
  `PANCARD` varchar(10) default NULL,
  `AADHARCARD` varchar(20) default NULL,
  `VOTERID` varchar(20) default NULL,
  `TEMPLE_ID` varchar(20) default NULL,
  `PANDIT_ID` varchar(20) default NULL,
  `EVENT_ID` varchar(20) default NULL,
  `POOJA_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default '1',
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  `Address_Id` varchar(20) default NULL,
  `Other_Delievery_Address` varchar(150) default NULL,
  PRIMARY KEY  (`USER_ID`),
  UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_user_details`
--

LOCK TABLES `ri_user_details` WRITE;
/*!40000 ALTER TABLE `ri_user_details` DISABLE KEYS */;
INSERT INTO `ri_user_details` VALUES (1,NULL,'Abhishek','Kumar','Gupta','Male',NULL,NULL,NULL,'5','ak121@religiousIndia.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,NULL,'Abhishek','Kumar','Gupta','Male',NULL,NULL,NULL,'5','abhi@religiousIndia.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,NULL,'Abhishek','Kumar','Gupta','Male',NULL,NULL,NULL,'5','abhi12@religiousIndia.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,NULL,'Abhishek','Kumar','Gupta','Male',NULL,NULL,NULL,'5','namail@religiousIndia.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,NULL,'Abhishek','Kumar','Gupta','Male',NULL,NULL,NULL,'4','nomail@religiousIndia.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,NULL,'Abhishek','Kumar','Gupta','Male',NULL,NULL,NULL,'5','newMail@religiousIndia.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,NULL,'Abhishek','Kumar','Gupta','Male',NULL,NULL,NULL,'2','shanu@religiousIndia.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,NULL,'Abhishek','Kumar','Gupta','Male',NULL,'8725153600',NULL,'5','shanu12@religiousIndia.com','12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','abhi',NULL,'abhi',NULL,'26','26,11'),(22,NULL,'Abhishek','','Gupta','Male',NULL,NULL,NULL,'3','iris@religiousIndia.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(23,NULL,'Abhishek','','Gupta','Male',NULL,NULL,NULL,'3','iris12@religiousIndia.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(25,NULL,'Abhishek','Kumar','Gupta','Male',NULL,NULL,NULL,'5','testId@religiousIndia.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26,'Delhi','Naresh','','Shasti','Male',NULL,'8385852512',NULL,'3','shastriji@religiousIndia.com','20',NULL,NULL,NULL,'5','1',NULL,NULL,'1','abhi',NULL,NULL,NULL,'15',NULL),(32,'Delhi','Test','','User','Male',NULL,NULL,NULL,'4','Userr@religiousIndia.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(33,NULL,'Ramendra','','Tyagi','Male',NULL,NULL,NULL,NULL,'rtyagi@iris.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(34,'Delhi','Narendra','','Mishra','Male',NULL,'8385852201',NULL,'3','mishraJiiji@religiousIndia.com','20',NULL,NULL,NULL,'5','5',NULL,NULL,'1','abhi',NULL,NULL,NULL,'15',NULL),(36,'Delhi','Mayank','','jindal','Male',NULL,'8545251525',NULL,'5','mayank@religiousIndia.com','Rel239',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,'85',NULL),(37,NULL,'Vivek','','dubey','Male',NULL,NULL,NULL,'5','vivek@religiousIndia.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `ri_user_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_user_password_otp`
--

DROP TABLE IF EXISTS `ri_user_password_otp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_user_password_otp` (
  `ID` int(11) NOT NULL auto_increment,
  `USER_ID` varchar(100) default NULL,
  `OTP` varchar(6) default NULL,
  `CREATED_ON` datetime default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_user_password_otp`
--

LOCK TABLES `ri_user_password_otp` WRITE;
/*!40000 ALTER TABLE `ri_user_password_otp` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_user_password_otp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_user_payment_details`
--

DROP TABLE IF EXISTS `ri_user_payment_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_user_payment_details` (
  `VERSION_ID` varchar(20) NOT NULL default '',
  `PAYMENT_ID` varchar(20) NOT NULL default '',
  `ORDER_ID` varchar(20) default NULL,
  `BOOKING_ID` varchar(20) default NULL,
  `MRP` varchar(20) default NULL,
  `ITEM_DISCOUNT` varchar(20) default NULL,
  `COUPON_DISCOUNT` varchar(20) default NULL,
  `OTHER_DISCOUNT` varchar(20) default NULL,
  `VAT_GST` varchar(20) default NULL,
  `CONVENIENCE_FEES` varchar(20) default NULL,
  `CANCELLATION_FEES` varchar(20) default NULL,
  `RESCHEDULE_FEES` varchar(20) default NULL,
  `REFUND_ID` varchar(20) default NULL,
  `ADD_ON_ITEM_CHARGES` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`PAYMENT_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_user_payment_details`
--

LOCK TABLES `ri_user_payment_details` WRITE;
/*!40000 ALTER TABLE `ri_user_payment_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_user_payment_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_user_reward_points_details`
--

DROP TABLE IF EXISTS `ri_user_reward_points_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_user_reward_points_details` (
  `VERSION_ID` varchar(20) NOT NULL default '',
  `REWARD_POINTS_ID` varchar(20) NOT NULL default '',
  `USER_ID` varchar(20) default NULL,
  `TOTAL_AVAILABLE_REWARD_POINTS` varchar(20) default NULL,
  `PREVIOUS_REWARD_POINTS` varchar(20) default NULL,
  `REWARD_POINTS_EARNED` varchar(20) default NULL,
  `EARNED_ORDER_ID` varchar(20) default NULL,
  `REWARD_POINTS_USED` varchar(20) default NULL,
  `USING_ORDER_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`REWARD_POINTS_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_user_reward_points_details`
--

LOCK TABLES `ri_user_reward_points_details` WRITE;
/*!40000 ALTER TABLE `ri_user_reward_points_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_user_reward_points_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_user_roles`
--

DROP TABLE IF EXISTS `ri_user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_user_roles` (
  `ROLE_ID` varchar(20) NOT NULL default '',
  `USER_ROLE` varchar(50) default NULL,
  `ROLE_DESC` varchar(100) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`ROLE_ID`),
  UNIQUE KEY `USER_ROLE` (`USER_ROLE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_user_roles`
--

LOCK TABLES `ri_user_roles` WRITE;
/*!40000 ALTER TABLE `ri_user_roles` DISABLE KEYS */;
INSERT INTO `ri_user_roles` VALUES ('1','ROLE_USER','Represents the general user of the website','1','abhi',NULL,NULL,NULL),('2','ROLE_PANDIT','Represents the pandit user of the website','1','abhi',NULL,NULL,NULL),('3','ROLE_TEMPLE','Represents the temple user of the website','1','abhi',NULL,NULL,NULL),('4','ROLE_ADMIN','Represents the admin user of the website','1','abhi',NULL,NULL,NULL),('5','ROLE_SUPER_ADMIN','Represents the super admin user of the website','1','abhi',NULL,NULL,NULL);
/*!40000 ALTER TABLE `ri_user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_user_saved_cards`
--

DROP TABLE IF EXISTS `ri_user_saved_cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_user_saved_cards` (
  `VERSION_ID` varchar(20) NOT NULL default '',
  `CARD_ID` varchar(20) NOT NULL default '',
  `USER_ID` varchar(20) default NULL,
  `CARD_TYPE` varchar(20) default NULL,
  `CARD_NUMBER` varchar(20) default NULL,
  `EXPIRY_DATE` date default NULL,
  `NAME_ON_CARD` varchar(50) default NULL,
  `IS_PREFFERED_CARD` varchar(2) default NULL,
  `CARD_ALIAS_NAME` varchar(20) default NULL,
  `ISSUER_BANK` varchar(20) default NULL,
  `COMMENTS` varchar(150) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`CARD_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_user_saved_cards`
--

LOCK TABLES `ri_user_saved_cards` WRITE;
/*!40000 ALTER TABLE `ri_user_saved_cards` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_user_saved_cards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_user_temple_subscription`
--

DROP TABLE IF EXISTS `ri_user_temple_subscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_user_temple_subscription` (
  `VERSION_ID` varchar(20) NOT NULL default '',
  `TEMPLE_SUBSCRIPTION_ID` varchar(20) NOT NULL default '',
  `USER_ID` varchar(20) default NULL,
  `TEMPLE_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`TEMPLE_SUBSCRIPTION_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_user_temple_subscription`
--

LOCK TABLES `ri_user_temple_subscription` WRITE;
/*!40000 ALTER TABLE `ri_user_temple_subscription` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_user_temple_subscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_user_wallet_balance`
--

DROP TABLE IF EXISTS `ri_user_wallet_balance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_user_wallet_balance` (
  `VERSION_ID` varchar(20) NOT NULL default '',
  `WALLET_ID` varchar(20) NOT NULL default '',
  `WALLET_BALANCE` varchar(20) default NULL,
  `WALLET_BALANCE_USED` varchar(20) default NULL,
  `PREVIOUS_WALLET_BALANCE` varchar(20) default NULL,
  `CASHBACK_ID` varchar(20) default NULL,
  `REWARD_POINTS_ID` varchar(20) default NULL,
  `USER_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`WALLET_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_user_wallet_balance`
--

LOCK TABLES `ri_user_wallet_balance` WRITE;
/*!40000 ALTER TABLE `ri_user_wallet_balance` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_user_wallet_balance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_user_wishlist`
--

DROP TABLE IF EXISTS `ri_user_wishlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_user_wishlist` (
  `version_id` int(11) default NULL,
  `wishlist_id` int(11) NOT NULL auto_increment,
  `item` text,
  `user_id` int(11) default NULL,
  `created_by` varchar(20) default NULL,
  `updated_by` varchar(20) default NULL,
  `created_on` datetime default NULL,
  `updated_on` datetime default NULL,
  PRIMARY KEY  (`wishlist_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_user_wishlist`
--

LOCK TABLES `ri_user_wishlist` WRITE;
/*!40000 ALTER TABLE `ri_user_wishlist` DISABLE KEYS */;
INSERT INTO `ri_user_wishlist` VALUES (32,5,'[{\"Price\":500,\"Item_Id\":49}]',10,'Abhi','Abhi','2018-08-23 18:31:04','2018-09-06 13:02:10');
/*!40000 ALTER TABLE `ri_user_wishlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_user_wishlist_event_festival`
--

DROP TABLE IF EXISTS `ri_user_wishlist_event_festival`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_user_wishlist_event_festival` (
  `VERSION_ID` varchar(20) NOT NULL default '',
  `WISHLIST_ID` varchar(20) NOT NULL default '',
  `USER_ID` varchar(20) default NULL,
  `EVENT_SERVICE_CATEGORY_ID` varchar(20) default NULL,
  `EVENT_SERVICE_SUB_CATEGORY_ID_1` varchar(20) default NULL,
  `EVENT_SERVICE_SUB_CATEGORY_ID_2` varchar(20) default NULL,
  `EVENT_TYPE` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`WISHLIST_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_user_wishlist_event_festival`
--

LOCK TABLES `ri_user_wishlist_event_festival` WRITE;
/*!40000 ALTER TABLE `ri_user_wishlist_event_festival` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_user_wishlist_event_festival` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_user_wishlist_pandit`
--

DROP TABLE IF EXISTS `ri_user_wishlist_pandit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_user_wishlist_pandit` (
  `VERSION_ID` varchar(20) NOT NULL default '',
  `WISHLIST_ID` varchar(20) NOT NULL default '',
  `USER_ID` varchar(20) default NULL,
  `PANDIT_USER_ID` varchar(20) default NULL,
  `POOJA_SERVICE_CATEGORY_ID` varchar(20) default NULL,
  `POOJA_SERVICE_SUBCATEGORY_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`WISHLIST_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_user_wishlist_pandit`
--

LOCK TABLES `ri_user_wishlist_pandit` WRITE;
/*!40000 ALTER TABLE `ri_user_wishlist_pandit` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_user_wishlist_pandit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_user_wishlist_pooja_services`
--

DROP TABLE IF EXISTS `ri_user_wishlist_pooja_services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_user_wishlist_pooja_services` (
  `VERSION_ID` varchar(20) NOT NULL default '',
  `WISHLIST_ID` varchar(20) NOT NULL default '',
  `USER_ID` varchar(20) default NULL,
  `POOJA_SERVICE_CATEGORY_ID` varchar(20) default NULL,
  `POOJA_SERVICE_SUB_CATEGORY_ID_1` varchar(20) default NULL,
  `POOJA_SERVICE_SUB_CATEGORY_ID_2` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`WISHLIST_ID`,`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_user_wishlist_pooja_services`
--

LOCK TABLES `ri_user_wishlist_pooja_services` WRITE;
/*!40000 ALTER TABLE `ri_user_wishlist_pooja_services` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_user_wishlist_pooja_services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ri_user_wishlist_temple_donations`
--

DROP TABLE IF EXISTS `ri_user_wishlist_temple_donations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ri_user_wishlist_temple_donations` (
  `VERSION_ID` int(11) NOT NULL auto_increment,
  `WISHLIST_ID` varchar(20) NOT NULL default '',
  `TEMPLE_ID` varchar(20) default NULL,
  `DONATION_CATEGORY_ID` varchar(20) default NULL,
  `DONATION_SUB_CATEGORY_ID` varchar(20) default NULL,
  `USER_ID` varchar(20) default NULL,
  `IS_ACTIVE` varchar(2) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `CREATED_ON` datetime default NULL,
  `UPDATED_BY` varchar(50) default NULL,
  `UPDATED_ON` datetime default NULL,
  PRIMARY KEY  (`WISHLIST_ID`,`VERSION_ID`),
  UNIQUE KEY `VERSION_ID` (`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ri_user_wishlist_temple_donations`
--

LOCK TABLES `ri_user_wishlist_temple_donations` WRITE;
/*!40000 ALTER TABLE `ri_user_wishlist_temple_donations` DISABLE KEYS */;
/*!40000 ALTER TABLE `ri_user_wishlist_temple_donations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL auto_increment,
  `role_name` varchar(20) default NULL,
  `ROLE_DESC` varchar(200) NOT NULL default '""',
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_USER','Represents the general user of the website'),(2,'ROLE_PANDIT','Represents the pandit user of the website'),(3,'ROLE_TEMPLE','Represents the temple user of the website'),(4,'ROLE_ADMIN','Represents the admin user of the website'),(5,'ROLE_SUPER_ADMIN','Represents the super admin user of the website');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `user_id` varchar(150) NOT NULL,
  `role_id` int(11) NOT NULL default '0',
  PRIMARY KEY  (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES ('3',1),('4',1),('5',1),('6',1),('iris12@religiousIndia.com',3),('iris@religiousIndia.com',3),('itstestid@religiousIndia.com',5),('mayank.jindal@irissoftware.com',1),('mayank@religiousIndia.com',5),('newMail@religiousIndia.com',1),('rtyagi@iris.com',1),('shanu12@religiousIndia.com',4),('shanu12@religiousIndia.com',5),('shanu@religiousIndia.com',2),('test12@religiousIndia.com',5),('testId@religiousIndia.com',5),('testUser@religiousIndia.com',5),('Userr@religiousIndia.com',4),('vivek@religiousIndia.com',5);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL auto_increment,
  `user_name` varchar(50) default NULL,
  `first_name` varchar(50) default NULL,
  `email` varchar(50) default NULL,
  `pwd` varchar(100) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (3,'a4141','abhi','nomail@mymail.com','$2a$10$PT/0Fq18Wu5saDRqC7OMPObkTBbyf8ooqCzQL5SHYxxpi5PLSMJj6'),(4,'a4242','abhishek','mymail@mymail.com','$2a$10$80qs/OiFXn9uyzCKhKNc9u5YIwPqjKUCaLZcGq8u9xaUbk90KK1TG'),(5,'abh123','abhi shanu','nomail12@gmail.com','$2a$10$BAZVofE6O2M/J5F0HJ9zZ.QiV.7vDlT1JOUVSWI4EIgN7Cq7x2hNa'),(6,'ab12','abhi shanu','nomail25@gmail.com','$2a$10$YItVVOaFwhSYr5hOoc7Jr.ztfc37cCMqvxt2gKVUw/rs9OdwCpDLi');
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

-- Dump completed on 2018-10-29 16:45:06
