-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: vaccine_management
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `account_id` int NOT NULL AUTO_INCREMENT,
  `encrypt_pw` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `is_enabled` bit(1) DEFAULT NULL,
  `verification_code` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu',NULL,'admin',_binary '',NULL,'khoa.trananh2@gmail.com'),(10,'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu',NULL,'khoa.trananh2@gmail.com',_binary '','','khoa.trananh2@gmail.com'),(11,'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu',NULL,'vitkykeycap@gmail.com',_binary '','','vitkykeycap@gmail.com'),(12,'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu',NULL,'user',_binary '',NULL,'vitky.dad@gmail.com');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_role`
--

DROP TABLE IF EXISTS `account_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_role` (
  `account_role_id` int NOT NULL AUTO_INCREMENT,
  `account_id` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`account_role_id`),
  KEY `FK1f8y4iy71kb1arff79s71j0dh` (`account_id`),
  KEY `FKrs2s3m3039h0xt8d5yhwbuyam` (`role_id`),
  CONSTRAINT `FK1f8y4iy71kb1arff79s71j0dh` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `FKrs2s3m3039h0xt8d5yhwbuyam` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_role`
--

LOCK TABLES `account_role` WRITE;
/*!40000 ALTER TABLE `account_role` DISABLE KEYS */;
INSERT INTO `account_role` VALUES (1,1,2),(10,10,2),(11,11,2),(12,12,1);
/*!40000 ALTER TABLE `account_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `delete_flag` bit(1) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `account_id` int DEFAULT NULL,
  `position_id` int NOT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `account_id_UNIQUE` (`account_id`),
  KEY `FKbc8rdko9o9n1ri9bpdyxv3x7i` (`position_id`),
  CONSTRAINT `FKbc8rdko9o9n1ri9bpdyxv3x7i` FOREIGN KEY (`position_id`) REFERENCES `position` (`position_id`),
  CONSTRAINT `FKcfg6ajo8oske94exynxpf7tf9` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (9,'Da nang','1996-02-02',_binary '\0','123456789','Tuan Anh','0901234567',10,3);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `import_and_export`
--

DROP TABLE IF EXISTS `import_and_export`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `import_and_export` (
  `import_and_export_id` int NOT NULL AUTO_INCREMENT,
  `action` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `delete_flag` bit(1) DEFAULT NULL,
  `price` bigint DEFAULT NULL,
  `quantity` bigint DEFAULT NULL,
  `account_id` int NOT NULL,
  `storage_id` int NOT NULL,
  PRIMARY KEY (`import_and_export_id`),
  KEY `FK7uc236wuf1jg6bl69ynqxm1o9` (`account_id`),
  KEY `FK8g8mo9l69snxgsdpmw14yqvhj` (`storage_id`),
  CONSTRAINT `FK7uc236wuf1jg6bl69ynqxm1o9` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `FK8g8mo9l69snxgsdpmw14yqvhj` FOREIGN KEY (`storage_id`) REFERENCES `storage` (`storage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import_and_export`
--

LOCK TABLES `import_and_export` WRITE;
/*!40000 ALTER TABLE `import_and_export` DISABLE KEYS */;
INSERT INTO `import_and_export` VALUES (2,'import','2021-01-19',NULL,50000,100,1,1),(3,'export','2021-01-19',NULL,50000,50,1,2),(4,'import','2021-01-19',NULL,70000,75,1,3),(5,'export','2021-01-19',NULL,90000,80,1,6),(6,'import','2021-01-19',NULL,120000,100,1,4),(7,'export','2021-01-19',NULL,150000,100,1,5);
/*!40000 ALTER TABLE `import_and_export` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `invoice_id` int NOT NULL AUTO_INCREMENT,
  `delete_flag` bit(1) DEFAULT NULL,
  `expired` date DEFAULT NULL,
  `price` bigint DEFAULT NULL,
  `quantity` bigint DEFAULT NULL,
  `transaction_date` varchar(255) DEFAULT NULL,
  `provider_id` int NOT NULL,
  `vaccine_id` int NOT NULL,
  PRIMARY KEY (`invoice_id`),
  KEY `FK58r2cn5a7iok8r0domo3925p0` (`provider_id`),
  KEY `FKtealfhfp2mmkpinck9yrh8ows` (`vaccine_id`),
  CONSTRAINT `FK58r2cn5a7iok8r0domo3925p0` FOREIGN KEY (`provider_id`) REFERENCES `provider` (`provider_id`),
  CONSTRAINT `FKtealfhfp2mmkpinck9yrh8ows` FOREIGN KEY (`vaccine_id`) REFERENCES `vaccine` (`vaccine_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (1,_binary '\0','2020-12-12',50000,200,'2020-01-19',1,1),(2,_binary '\0','2020-12-12',50000,200,'2020-01-19',1,1),(3,_binary '\0','2020-12-12',50000,200,'2020-01-19',1,2),(4,_binary '\0','2020-12-12',50000,200,'2020-01-19',2,3),(5,_binary '\0','2020-12-12',50000,200,'2020-01-19',3,4),(6,_binary '\0','2020-12-12',50000,200,'2020-01-19',5,6),(7,_binary '\0','2020-12-12',50000,200,'2020-01-19',4,7),(8,_binary '\0','2022-02-03',100000,1000,'2021-02-03',7,12),(9,_binary '\0','2021-04-30',10000000,3,'2021-04-05',8,13),(10,_binary '\0','2021-04-09',5,3,'2021-04-04',8,14),(11,_binary '\0','2021-04-30',1000000,9,'2021-04-04',8,15);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `location_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'TTYT Hòa Khánh - Liên Chiểu'),(2,'TTYT Hòa Khánh - Liên Chiểu'),(3,'TTYT Thạch Thang - Hải Châu'),(4,'TTYT Hòa Khê - Thanh Khê'),(5,'TTYT An Hải Bắc - Sơn Trà'),(6,'TTYT Hòa Thọ Đông - Cẩm Lệ'),(7,'TTYT Hòa Quý - Ngũ Hành Sơn'),(8,'TTYT Hoà Ninh - Hòa Vang'),(9,'TTYT Đà Nẵng - Hùng Vương');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `message_id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `patient_id` int NOT NULL,
  PRIMARY KEY (`message_id`),
  KEY `FKsmibfq4v794n42pcma2qk554o` (`patient_id`),
  CONSTRAINT `FKsmibfq4v794n42pcma2qk554o` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `patient_id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `delete_flag` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `guardian` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `account_id` int DEFAULT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `UK_l9ukwhag1wtyyw0vf6xu8b6xl` (`account_id`),
  CONSTRAINT `FKn6atqtmaryxq3o213gi3or1ij` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (51,'Đà Nẵng','2000-12-06',_binary '\0','tien.nguyen@codegym.vn','Nam','Trần Anh Khoa','Trần Duy Minh','0123123111',11),(52,'Đà Nẵng','2013-01-01',_binary '\0','vitky.dad@gmail.com','Nam','Trần Anh Khoa','Trần Minh Huy','0935680083',12);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `position_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'Y tá'),(2,'Y tá'),(3,'Bác sĩ'),(4,'Hộ lý'),(5,'Thủ kho'),(6,'Kế toán'),(7,'CSKH');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provider`
--

DROP TABLE IF EXISTS `provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provider` (
  `provider_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`provider_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provider`
--

LOCK TABLES `provider` WRITE;
/*!40000 ALTER TABLE `provider` DISABLE KEYS */;
INSERT INTO `provider` VALUES (1,'Thiên Nam Quốc'),(2,'Thiên Nam Quốc'),(3,'Hưng Thịnh'),(4,'Công Quán'),(5,'Một Quả Chuối'),(6,'Hai Hạt Mít'),(7,'Daphaco'),(8,'Việt Nam');
/*!40000 ALTER TABLE `provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storage`
--

DROP TABLE IF EXISTS `storage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `storage` (
  `storage_id` int NOT NULL AUTO_INCREMENT,
  `quantity` bigint DEFAULT NULL,
  `vaccine_id` int NOT NULL,
  PRIMARY KEY (`storage_id`),
  KEY `FKh7bqfa90ng575w1w3qcsp1fd7` (`vaccine_id`),
  CONSTRAINT `FKh7bqfa90ng575w1w3qcsp1fd7` FOREIGN KEY (`vaccine_id`) REFERENCES `vaccine` (`vaccine_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage`
--

LOCK TABLES `storage` WRITE;
/*!40000 ALTER TABLE `storage` DISABLE KEYS */;
INSERT INTO `storage` VALUES (1,70,1),(2,100,2),(3,100,3),(4,100,4),(5,100,5),(6,100,6),(7,100,7),(8,100,8),(9,100,9),(10,100,10),(11,1000,12),(12,3,13),(13,3,14),(14,9,15);
/*!40000 ALTER TABLE `storage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaccination`
--

DROP TABLE IF EXISTS `vaccination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vaccination` (
  `vaccination_id` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `delete_flag` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `location_id` int NOT NULL,
  `vaccination_type_id` int NOT NULL,
  `vaccine_id` int NOT NULL,
  `duration` int DEFAULT NULL,
  `times` int DEFAULT NULL,
  PRIMARY KEY (`vaccination_id`),
  KEY `FKbe8a9yn6ih1xswcwx0v67yd1v` (`location_id`),
  KEY `FKs1h1qr3dpipq3b7l1ja0fc0kh` (`vaccination_type_id`),
  KEY `FK7nk56xtl6qs5t4sbo13tp0ua6` (`vaccine_id`),
  CONSTRAINT `FK7nk56xtl6qs5t4sbo13tp0ua6` FOREIGN KEY (`vaccine_id`) REFERENCES `vaccine` (`vaccine_id`),
  CONSTRAINT `FKbe8a9yn6ih1xswcwx0v67yd1v` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`),
  CONSTRAINT `FKs1h1qr3dpipq3b7l1ja0fc0kh` FOREIGN KEY (`vaccination_type_id`) REFERENCES `vaccination_type` (`vaccination_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaccination`
--

LOCK TABLES `vaccination` WRITE;
/*!40000 ALTER TABLE `vaccination` DISABLE KEYS */;
INSERT INTO `vaccination` VALUES (2,'2022-01-22',_binary '\0','Miễn Phí','17:00:00','09:00:00',_binary '',1,1,2,NULL,NULL),(13,'2021-10-01',_binary '\0','Miễn Phí','11:30:00','08:00:00',_binary '\0',1,1,7,NULL,NULL),(16,'2021-10-01',_binary '\0','Miễn Phí','11:30:00','08:00:00',_binary '\0',1,1,4,NULL,NULL),(17,'2021-10-01',_binary '\0','Miễn Phí','11:30:00','07:00:00',_binary '\0',1,1,8,NULL,NULL),(119,'2022-10-08',_binary '\0','Tiêm nhắc','11:30:00','08:00:00',_binary '\0',2,2,4,NULL,NULL),(120,'2022-10-15',_binary '\0','Tiêm nhắc','11:30:00','08:00:00',_binary '\0',2,2,4,NULL,NULL),(121,'2022-10-22',_binary '\0','Tiêm nhắc','11:30:00','08:00:00',_binary '\0',2,2,4,NULL,NULL),(122,'2021-02-03',_binary '\0',NULL,'09:30:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(123,'2021-02-13',_binary '\0','Tiêm nhắc','09:30:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(124,'2021-02-23',_binary '\0','Tiêm nhắc','09:30:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(125,'2021-03-05',_binary '\0','Tiêm nhắc','09:30:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(126,'2021-03-15',_binary '\0','Tiêm nhắc','09:30:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(127,'2021-02-03',_binary '\0',NULL,'09:30:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(128,'2021-02-13',_binary '\0','Tiêm nhắc','09:30:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(129,'2021-02-23',_binary '\0','Tiêm nhắc','09:30:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(130,'2021-03-05',_binary '\0','Tiêm nhắc','09:30:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(131,'2021-03-15',_binary '\0','Tiêm nhắc','09:30:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(132,'2021-02-06',_binary '\0','Miễn phí','17:50:00','08:00:00',_binary '\0',1,1,12,NULL,NULL),(133,'2021-02-13',_binary '\0','Tiêm nhắc','17:50:00','08:00:00',_binary '\0',1,2,12,NULL,NULL),(134,'2021-02-20',_binary '\0','Tiêm nhắc','17:50:00','08:00:00',_binary '\0',1,2,12,NULL,NULL),(135,'2021-02-27',_binary '\0','Tiêm nhắc','17:50:00','08:00:00',_binary '\0',1,2,12,NULL,NULL),(136,'2021-03-06',_binary '\0','Tiêm nhắc','17:50:00','08:00:00',_binary '\0',1,2,12,NULL,NULL),(137,'2021-02-01',_binary '\0','Miễn phí','17:30:00','08:00:00',_binary '\0',1,1,4,NULL,NULL),(138,'2021-02-06',_binary '\0','Miễn phí','09:30:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(139,'2021-02-16',_binary '\0','Tiêm nhắc','09:30:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(140,'2021-02-26',_binary '\0','Tiêm nhắc','09:30:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(141,'2021-03-08',_binary '\0','Tiêm nhắc','09:30:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(142,'2021-03-18',_binary '\0','Tiêm nhắc','09:30:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(143,'2021-02-14',_binary '\0','Miễn phí','17:00:00','07:30:00',_binary '\0',1,1,4,NULL,NULL),(144,'2021-02-07',_binary '\0','Miễn phí','17:00:00','07:30:00',_binary '\0',1,1,9,NULL,NULL),(145,'2021-02-06',_binary '\0',NULL,'11:00:00','09:30:00',_binary '\0',1,2,1,NULL,NULL),(146,'2021-02-16',_binary '\0','Tiêm nhắc','11:00:00','09:30:00',_binary '\0',1,2,1,NULL,NULL),(147,'2021-02-26',_binary '\0','Tiêm nhắc','11:00:00','09:30:00',_binary '\0',1,2,1,NULL,NULL),(148,'2021-03-08',_binary '\0','Tiêm nhắc','11:00:00','09:30:00',_binary '\0',1,2,1,NULL,NULL),(149,'2021-03-18',_binary '\0','Tiêm nhắc','11:00:00','09:30:00',_binary '\0',1,2,1,NULL,NULL),(150,'2021-10-08',_binary '\0','Tiêm nhắc','11:30:00','08:00:00',_binary '\0',1,2,4,NULL,NULL),(151,'2021-10-15',_binary '\0','Tiêm nhắc','11:30:00','08:00:00',_binary '\0',1,2,4,NULL,NULL),(152,'2021-10-22',_binary '\0','Tiêm nhắc','11:30:00','08:00:00',_binary '\0',1,2,4,NULL,NULL),(153,'2021-02-05',_binary '\0',NULL,'08:20:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(154,'2021-02-15',_binary '\0','Tiêm nhắc','08:20:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(155,'2021-02-25',_binary '\0','Tiêm nhắc','08:20:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(156,'2021-03-07',_binary '\0','Tiêm nhắc','08:20:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(157,'2021-03-17',_binary '\0','Tiêm nhắc','08:20:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(158,'2021-02-05',_binary '\0',NULL,'08:40:00','08:20:00',_binary '\0',1,2,1,NULL,NULL),(159,'2021-02-15',_binary '\0','Tiêm nhắc','08:40:00','08:20:00',_binary '\0',1,2,1,NULL,NULL),(160,'2021-02-25',_binary '\0','Tiêm nhắc','08:40:00','08:20:00',_binary '\0',1,2,1,NULL,NULL),(161,'2021-03-07',_binary '\0','Tiêm nhắc','08:40:00','08:20:00',_binary '\0',1,2,1,NULL,NULL),(162,'2021-03-17',_binary '\0','Tiêm nhắc','08:40:00','08:20:00',_binary '\0',1,2,1,NULL,NULL),(163,'2021-02-05',_binary '\0',NULL,'09:00:00','08:40:00',_binary '\0',1,2,1,NULL,NULL),(164,'2021-02-15',_binary '\0','Tiêm nhắc','09:00:00','08:40:00',_binary '\0',1,2,1,NULL,NULL),(165,'2021-02-25',_binary '\0','Tiêm nhắc','09:00:00','08:40:00',_binary '\0',1,2,1,NULL,NULL),(166,'2021-03-07',_binary '\0','Tiêm nhắc','09:00:00','08:40:00',_binary '\0',1,2,1,NULL,NULL),(167,'2021-03-17',_binary '\0','Tiêm nhắc','09:00:00','08:40:00',_binary '\0',1,2,1,NULL,NULL),(168,'2021-02-12',_binary '\0',NULL,'08:20:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(169,'2021-02-22',_binary '\0','Tiêm nhắc','08:20:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(170,'2021-03-04',_binary '\0','Tiêm nhắc','08:20:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(171,'2021-03-14',_binary '\0','Tiêm nhắc','08:20:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(172,'2021-03-24',_binary '\0','Tiêm nhắc','08:20:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(173,'2021-02-19',_binary '\0',NULL,'10:40:00','10:20:00',_binary '\0',1,2,1,NULL,NULL),(174,'2021-03-01',_binary '\0','Tiêm nhắc','10:40:00','10:20:00',_binary '\0',1,2,1,NULL,NULL),(175,'2021-03-11',_binary '\0','Tiêm nhắc','10:40:00','10:20:00',_binary '\0',1,2,1,NULL,NULL),(176,'2021-03-21',_binary '\0','Tiêm nhắc','10:40:00','10:20:00',_binary '\0',1,2,1,NULL,NULL),(177,'2021-03-31',_binary '\0','Tiêm nhắc','10:40:00','10:20:00',_binary '\0',1,2,1,NULL,NULL),(178,'2021-02-13',_binary '\0',NULL,'14:40:00','14:20:00',_binary '\0',1,2,1,NULL,NULL),(179,'2021-02-23',_binary '\0','Tiêm nhắc','14:40:00','14:20:00',_binary '\0',1,2,1,NULL,NULL),(180,'2021-03-05',_binary '\0','Tiêm nhắc','14:40:00','14:20:00',_binary '\0',1,2,1,NULL,NULL),(181,'2021-03-15',_binary '\0','Tiêm nhắc','14:40:00','14:20:00',_binary '\0',1,2,1,NULL,NULL),(182,'2021-03-25',_binary '\0','Tiêm nhắc','14:40:00','14:20:00',_binary '\0',1,2,1,NULL,NULL),(183,'2021-02-05',_binary '\0',NULL,'09:40:00','09:20:00',_binary '\0',1,2,5,NULL,NULL),(184,'2021-02-10',_binary '\0','Tiêm nhắc','09:40:00','09:20:00',_binary '\0',1,2,5,NULL,NULL),(185,'2021-02-15',_binary '\0','Tiêm nhắc','09:40:00','09:20:00',_binary '\0',1,2,5,NULL,NULL),(186,'2021-02-20',_binary '\0','Tiêm nhắc','09:40:00','09:20:00',_binary '\0',1,2,5,NULL,NULL),(187,'2021-02-25',_binary '\0','Tiêm nhắc','09:40:00','09:20:00',_binary '\0',1,2,5,NULL,NULL),(188,'2021-02-06',_binary '\0',NULL,'08:40:00','08:20:00',_binary '\0',1,2,12,NULL,NULL),(189,'2021-02-13',_binary '\0','Tiêm nhắc','08:40:00','08:20:00',_binary '\0',1,2,12,NULL,NULL),(190,'2021-02-20',_binary '\0','Tiêm nhắc','08:40:00','08:20:00',_binary '\0',1,2,12,NULL,NULL),(191,'2021-02-27',_binary '\0','Tiêm nhắc','08:40:00','08:20:00',_binary '\0',1,2,12,NULL,NULL),(192,'2021-03-06',_binary '\0','Tiêm nhắc','08:40:00','08:20:00',_binary '\0',1,2,12,NULL,NULL),(193,'2022-01-22',_binary '\0',NULL,'09:20:00','09:00:00',_binary '\0',1,2,1,NULL,NULL),(194,'2022-02-01',_binary '\0','Tiêm nhắc','09:20:00','09:00:00',_binary '\0',1,2,1,NULL,NULL),(195,'2022-02-11',_binary '\0','Tiêm nhắc','09:20:00','09:00:00',_binary '\0',1,2,1,NULL,NULL),(196,'2022-02-21',_binary '\0','Tiêm nhắc','09:20:00','09:00:00',_binary '\0',1,2,1,NULL,NULL),(197,'2022-03-03',_binary '\0','Tiêm nhắc','09:20:00','09:00:00',_binary '\0',1,2,1,NULL,NULL),(198,'2021-10-06',_binary '\0','Tiêm nhắc','11:30:00','08:00:00',_binary '\0',1,2,7,NULL,NULL),(199,'2021-10-11',_binary '\0','Tiêm nhắc','11:30:00','08:00:00',_binary '\0',1,2,7,NULL,NULL),(200,'2021-02-06',_binary '\0',NULL,'08:20:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(201,'2021-02-16',_binary '\0','Tiêm nhắc','08:20:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(202,'2021-02-26',_binary '\0','Tiêm nhắc','08:20:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(203,'2021-03-08',_binary '\0','Tiêm nhắc','08:20:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(204,'2021-03-18',_binary '\0','Tiêm nhắc','08:20:00','08:00:00',_binary '\0',1,2,1,NULL,NULL),(205,'2021-02-06',_binary '\0',NULL,'08:40:00','08:20:00',_binary '\0',1,2,2,NULL,NULL),(206,'2021-02-13',_binary '\0','Tiêm nhắc','08:40:00','08:20:00',_binary '\0',1,2,2,NULL,NULL),(207,'2022-01-29',_binary '\0','Tiêm nhắc','17:00:00','09:00:00',_binary '\0',1,2,2,NULL,NULL),(208,'2022-01-29',_binary '\0','Tiêm nhắc','17:00:00','09:00:00',_binary '\0',1,2,2,NULL,NULL),(209,'2021-10-06',_binary '\0','Tiêm nhắc','11:30:00','08:00:00',_binary '\0',1,2,7,NULL,NULL),(210,'2021-10-11',_binary '\0','Tiêm nhắc','11:30:00','08:00:00',_binary '\0',1,2,7,NULL,NULL),(211,'2021-10-08',_binary '\0','Tiêm nhắc','11:30:00','08:00:00',_binary '\0',1,2,4,NULL,NULL),(212,'2021-10-15',_binary '\0','Tiêm nhắc','11:30:00','08:00:00',_binary '\0',1,2,4,NULL,NULL),(213,'2021-10-22',_binary '\0','Tiêm nhắc','11:30:00','08:00:00',_binary '\0',1,2,4,NULL,NULL),(214,'2021-02-08',_binary '\0',NULL,'08:20:00','08:00:00',_binary '\0',1,2,5,NULL,NULL),(215,'2021-02-13',_binary '\0','Tiêm nhắc','08:20:00','08:00:00',_binary '\0',1,2,5,NULL,NULL),(216,'2021-02-18',_binary '\0','Tiêm nhắc','08:20:00','08:00:00',_binary '\0',1,2,5,NULL,NULL),(217,'2021-02-23',_binary '\0','Tiêm nhắc','08:20:00','08:00:00',_binary '\0',1,2,5,NULL,NULL),(218,'2021-02-28',_binary '\0','Tiêm nhắc','08:20:00','08:00:00',_binary '\0',1,2,5,NULL,NULL),(219,'2021-02-25',_binary '\0','Miễn Phí','17:00:00','08:00:00',_binary '\0',1,1,8,NULL,NULL),(220,'2021-10-08',_binary '\0','Tiêm nhắc','11:30:00','08:00:00',_binary '\0',1,2,4,NULL,NULL),(221,'2021-10-15',_binary '\0','Tiêm nhắc','11:30:00','08:00:00',_binary '\0',1,2,4,NULL,NULL),(222,'2021-10-22',_binary '\0','Tiêm nhắc','11:30:00','08:00:00',_binary '\0',1,2,4,NULL,NULL);
/*!40000 ALTER TABLE `vaccination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaccination_history`
--

DROP TABLE IF EXISTS `vaccination_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vaccination_history` (
  `vaccination_history_id` int NOT NULL AUTO_INCREMENT,
  `after_status` varchar(255) DEFAULT NULL,
  `dosage` double DEFAULT NULL,
  `pre_status` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `patient_id` int NOT NULL,
  `vaccination_id` int NOT NULL,
  `delete_flag` bit(1) DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `vaccination_times` int DEFAULT NULL,
  PRIMARY KEY (`vaccination_history_id`),
  KEY `FKbaj9i3m7767ikyr7bk89r3yib` (`patient_id`),
  KEY `FKqy8p7e13vr6mntiikku0dkgp0` (`vaccination_id`),
  CONSTRAINT `FKbaj9i3m7767ikyr7bk89r3yib` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`),
  CONSTRAINT `FKqy8p7e13vr6mntiikku0dkgp0` FOREIGN KEY (`vaccination_id`) REFERENCES `vaccination` (`vaccination_id`)
) ENGINE=InnoDB AUTO_INCREMENT=265 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaccination_history`
--

LOCK TABLES `vaccination_history` WRITE;
/*!40000 ALTER TABLE `vaccination_history` DISABLE KEYS */;
INSERT INTO `vaccination_history` VALUES (261,NULL,NULL,NULL,NULL,51,220,_binary '\0','08:20:00','08:00:00',2),(262,NULL,NULL,NULL,NULL,51,221,_binary '\0','08:20:00','08:00:00',3),(263,NULL,NULL,NULL,NULL,51,222,_binary '\0','08:20:00','08:00:00',4),(264,'sốt nhẹ',NULL,'Bình thường',_binary '',51,16,_binary '\0','08:20:00','08:00:00',1);
/*!40000 ALTER TABLE `vaccination_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaccination_transaction`
--

DROP TABLE IF EXISTS `vaccination_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vaccination_transaction` (
  `vaccination_transaction_id` int NOT NULL AUTO_INCREMENT,
  `price` double DEFAULT NULL,
  `quantity` bigint DEFAULT NULL,
  `vaccination_history_id` int DEFAULT NULL,
  PRIMARY KEY (`vaccination_transaction_id`),
  KEY `FK2x49dtq7mmn7fbgceauf4lmpi` (`vaccination_history_id`),
  CONSTRAINT `FK2x49dtq7mmn7fbgceauf4lmpi` FOREIGN KEY (`vaccination_history_id`) REFERENCES `vaccination_history` (`vaccination_history_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaccination_transaction`
--

LOCK TABLES `vaccination_transaction` WRITE;
/*!40000 ALTER TABLE `vaccination_transaction` DISABLE KEYS */;
INSERT INTO `vaccination_transaction` VALUES (5,600000,1,262);
/*!40000 ALTER TABLE `vaccination_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaccination_type`
--

DROP TABLE IF EXISTS `vaccination_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vaccination_type` (
  `vaccination_type_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vaccination_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaccination_type`
--

LOCK TABLES `vaccination_type` WRITE;
/*!40000 ALTER TABLE `vaccination_type` DISABLE KEYS */;
INSERT INTO `vaccination_type` VALUES (1,'Tiêm chủng định kỳ'),(2,'Tiêm chủng đăng ký');
/*!40000 ALTER TABLE `vaccination_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaccine`
--

DROP TABLE IF EXISTS `vaccine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vaccine` (
  `vaccine_id` int NOT NULL AUTO_INCREMENT,
  `age` varchar(255) DEFAULT NULL,
  `delete_flag` bit(1) DEFAULT NULL,
  `dosage` double DEFAULT NULL,
  `expired` date DEFAULT NULL,
  `license_code` varchar(255) DEFAULT NULL,
  `maintenance` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `quantity` bigint DEFAULT NULL,
  `vaccine_type_id` int NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `duration` int DEFAULT NULL,
  `times` int DEFAULT NULL,
  PRIMARY KEY (`vaccine_id`),
  KEY `FKsh9t3bn44kyxqlhm696iukmvo` (`vaccine_type_id`),
  CONSTRAINT `FKsh9t3bn44kyxqlhm696iukmvo` FOREIGN KEY (`vaccine_type_id`) REFERENCES `vaccine_type` (`vaccine_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaccine`
--

LOCK TABLES `vaccine` WRITE;
/*!40000 ALTER TABLE `vaccine` DISABLE KEYS */;
INSERT INTO `vaccine` VALUES (1,'Trên 6 tuổi',_binary '\0',0.1,'2020-12-12','ABC','0 độ C','Tiêu chảy do rota virus','GSK/Bỉ',100,1,'https://vinmec-prod.s3.amazonaws.com/images/20191029_054638_552977_rotarix.max-800x800.jpg',10,5),(2,'Trên 6 tuổi',_binary '\0',0.1,'2020-12-12','ABC','0 độ C','Tiêu chảy do rota virus','GSK/Bỉ',100,1,'https://vinmec-prod.s3.amazonaws.com/images/20191029_054638_552977_rotarix.max-800x800.jpg',7,2),(3,'10 đến 20 tuổi',_binary '\0',0.25,'2020-12-12','ABC','0 độ C','Ho gà, bạch hầu, uốn ván, bại liệt, viêm gan B và các bệnh do Hib','GSK/Bỉ',100,2,'https://vnvc.vn/wp-content/uploads/2018/06/vc-hexaxim.jpg',7,3),(4,'Trên 6 tuổi',_binary '\0',0.5,'2020-12-12','ABC','0 độ C','Hội chứng nhiễm trùng, viêm màng não, viêm phổi, nhiễm khuẩn huyết, viêm tai giữa do phế cầu','GSK/Bỉ',100,3,'https://sakurahanoi.com/uploads/synflorix-packshot.jpg',7,4),(5,'Trên 8 tuổi',_binary '\0',0.1,'2020-12-12','ABC','0 độ C','Sởi','GSK/Bỉ',100,4,'https://ykhoahopnhan.vn/wp-content/uploads/2019/06/9-03.png',5,5),(6,'Dưới 6 tuổi',_binary '\0',0.1,'2020-12-12','ABC','0 độ C','Sởi – Quai bị – Rubella','GSK/Bỉ',100,5,'https://ykhoahopnhan.vn/wp-content/uploads/2019/05/MMR-II.jpg',5,2),(7,'Dưới 6 tuổi',_binary '\0',0.25,'2020-12-12','ABC','0 độ C','Viêm màng não do mô cầu tuýp B và C','GSK/Bỉ',100,6,'https://vinmec-prod.s3.amazonaws.com/images/20191122_053002_978289_vac-xin-phong-nao-m.max-1800x1800.jpg',5,3),(8,'Trên 3 tháng tuổi',_binary '\0',0.1,'2020-12-12','ABC','0 độ C','Thủy đậu','GSK/Bỉ',100,7,'https://vinmec-prod.s3.amazonaws.com/images/20191201_004806_774758_vacxin-thuy-dau-var.max-1800x1800.jpg',3,1),(9,'Trên 6 tuổi',_binary '\0',0.1,'2020-12-12','ABC','0 độ C','Viêm não Nhật Bản','GSK/Bỉ',100,8,'https://vinmec-prod.s3.amazonaws.com/images/20190917_025338_958125_javax-2.max-800x800.jpg',10,2),(10,'6 đến 20 tuổi',_binary '\0',0.25,'2020-12-12','ABC','0 độ C','Thương hàn','GSK/Bỉ',100,9,'https://vnvc.vn/wp-content/uploads/2017/04/TYPHIM.jpg',4,3),(11,'Trên 6 tuổi',_binary '\0',0.1,'2020-12-12','ABC','0 độ C','Viêm màng não do mô cầu tuýp ACYW','GSK/Bỉ',100,10,'https://afamilycdn.com/zoom/640_400/150157425591193600/2020/5/19/vc-15898803049221240739258-39-0-539-800-crop-1589880870542930920217.png',6,4),(12,'< 80 tuổi',_binary '',10,'2022-02-03','123123123','-40 độ C','Covid-19','Mỹ',1000,12,'https://lh3.googleusercontent.com/proxy/dH9qGMM9MhmwRVfHD8Pxxkcv2sy043yIz9AgXOSikQ2jKpfXDNL5bgsX29n50pXnbgWoI63jTnKErohIbYwdM1KNE-67BOYnesF60DpKDH3lmd9gk-96aRwUzbYLjQVHNZALR5OZ32Kht4qyNs5kVaHudfE',7,5),(13,'18',_binary '',1000,'2021-04-30','213213','abc','COVID-2019','Việt Nam',3,13,NULL,1,3),(14,'18',_binary '',1000,'2021-04-09','4','abc','COVID-2020','Việt Nam',3,14,NULL,2,3),(15,'18',_binary '\0',1000,'2021-04-30','15','lạnh','COVID-2021','Việt Nam',9,15,NULL,4,5);
/*!40000 ALTER TABLE `vaccine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaccine_type`
--

DROP TABLE IF EXISTS `vaccine_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vaccine_type` (
  `vaccine_type_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vaccine_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaccine_type`
--

LOCK TABLES `vaccine_type` WRITE;
/*!40000 ALTER TABLE `vaccine_type` DISABLE KEYS */;
INSERT INTO `vaccine_type` VALUES (1,'Rotarix'),(2,'Rotarix'),(3,'Hexaxim'),(4,'Synflorix'),(5,'Mvvac'),(6,'MMR-II'),(7,'VA Mengoc BC'),(8,'Varivax'),(9,'Imojev'),(10,'Typhoid Vi'),(11,'Menactra'),(12,'Covid'),(13,'2019'),(14,'2020'),(15,'2021');
/*!40000 ALTER TABLE `vaccine_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-16 17:15:27
