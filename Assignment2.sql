CREATE DATABASE  IF NOT EXISTS `assignment2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `assignment2`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: assignment2
-- ------------------------------------------------------
-- Server version	8.0.27

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
  `ID` int NOT NULL AUTO_INCREMENT,
  `EmployeeID` int NOT NULL,
  `CustomerCodeCust` int NOT NULL,
  `UserName` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKAccount626543` (`CustomerCodeCust`),
  KEY `FKAccount18981` (`EmployeeID`),
  CONSTRAINT `FKAccount18981` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKAccount626543` FOREIGN KEY (`CustomerCodeCust`) REFERENCES `customer` (`CodeCust`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `EmployeeID` int NOT NULL,
  `CustomerCodeCust` int NOT NULL,
  `NoHouse` int NOT NULL,
  `Street` varchar(255) DEFAULT NULL,
  `District` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKAddress999690` (`CustomerCodeCust`),
  KEY `FKAddress392128` (`EmployeeID`),
  CONSTRAINT `FKAddress392128` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKAddress999690` FOREIGN KEY (`CustomerCodeCust`) REFERENCES `customer` (`CodeCust`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `author` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Biography` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'Hoàng Văn Vân, Nguyễn Thị Chi, Lê Kim Dung, Phan Chí Nghĩa, Vũ Mai Trang, Lương Quỳnh Trang, Nguyễn Quốc Tuấn, David Kaye',NULL),(2,'Hoàng Văn Vân, Nguyễn Thị Chi, Lê Kim Dung, Phan Chí Nghĩa, Vũ Mai Trang, Lương Quỳnh Trang',NULL),(3,'Boris Pasternak',NULL),(4,'Agatha Christie',NULL),(5,'John L. Hennessy, David A. Patterson',NULL),(6,'William Stallings',NULL);
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `ISBN` varchar(255) NOT NULL,
  `CategoryID` int NOT NULL,
  `PublisherID` int NOT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Summary` varchar(255) DEFAULT NULL,
  `PublicationDate` date DEFAULT NULL,
  `NumOfPages` int NOT NULL,
  `Language` varchar(255) DEFAULT NULL,
  `Dimensions` varchar(255) DEFAULT NULL,
  `Weight` float NOT NULL,
  `Edition` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ISBN`),
  KEY `FKBook221643` (`PublisherID`),
  KEY `FKBook738236` (`CategoryID`),
  CONSTRAINT `FKBook221643` FOREIGN KEY (`PublisherID`) REFERENCES `publisher` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKBook738236` FOREIGN KEY (`CategoryID`) REFERENCES `category` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES ('978-0-099-54124-0',2,2,'Doctor Zhivago (Bác sĩ Zhivago)','Bác sĩ Zhivago - Bản dịch tiếng Anh của Richard Pevear và Larissa Volokhonsky','2011-01-01',514,'Tiếng Anh','13 x 19.5 cm',360,'1'),('978-0-12-811905-1',3,4,'Computer Architecture - A Quantitative Approach (6th ed.)','Computer Architecture - A Quantitative Approach - ấn bản lần thứ 6','2017-12-07',936,'Tiếng Anh','19.05 x 4.57 x 23.37 cm',1791,'6'),('978-0-13-467095-9',3,5,'Operating Systems: Internals and Design Principles (9th ed.)','Operating Systems: Internals and Design Principles (ấn bản lần thứ 9)','2017-03-13',800,'Tiếng Anh','18.54 x 3.56 x 23.75 cm',1120,'9'),('978-604-0-00835-0',1,1,'Tiếng Anh 7 - Sách Học Sinh - Tập 1','Sách giáo khoa Tiếng Anh 7 tập 1 cho học sinh','2015-11-09',71,'Tiếng Anh','19 x 26.5 cm',250,'1'),('978-604-0-25873-1',1,1,'Tiếng Anh 6 - Tập 1 - Sách học sinh (Global Success)','Sách giáo khoa Tiếng Anh 6 tập 1 cho học sinh (Global Success)','2021-05-07',71,'Tiếng Anh','20 x 28 cm',250,'1'),('978-604-1-07222-0',2,3,'Chuỗi án mạng A.B.C','Chuỗi án mạng A.B.C - Bản dịch tiếng Việt của Võ Thị Hương Lan','2015-04-15',298,'Tiếng Việt','13 x 20 cm',300,'1'),('978-604-1-07777-5',2,3,'Những chiếc đồng hồ kỳ lạ','Những chiếc đồng hồ kỳ lạ - Bản dịch tiếng Việt của Trần Hữu Kham','2015-12-10',367,'Tiếng Việt','13 x 20 cm',325,'2');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_author`
--

DROP TABLE IF EXISTS `book_author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_author` (
  `BookISBN` varchar(255) NOT NULL,
  `AuthorID` int NOT NULL,
  PRIMARY KEY (`BookISBN`,`AuthorID`),
  KEY `FKBook_Autho438413` (`AuthorID`),
  CONSTRAINT `FKBook_Autho396816` FOREIGN KEY (`BookISBN`) REFERENCES `book` (`ISBN`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKBook_Autho438413` FOREIGN KEY (`AuthorID`) REFERENCES `author` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_author`
--

LOCK TABLES `book_author` WRITE;
/*!40000 ALTER TABLE `book_author` DISABLE KEYS */;
INSERT INTO `book_author` VALUES ('978-604-0-00835-0',1),('978-604-0-25873-1',2),('978-0-099-54124-0',3),('978-604-1-07222-0',4),('978-604-1-07777-5',4),('978-0-12-811905-1',5),('978-0-13-467095-9',6);
/*!40000 ALTER TABLE `book_author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boot`
--

DROP TABLE IF EXISTS `boot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boot` (
  `Type` varchar(255) DEFAULT NULL,
  `BootOpening` float NOT NULL,
  `HeelHeight` float NOT NULL,
  `ShaftMeasure` float NOT NULL,
  `ShoesID` int NOT NULL,
  PRIMARY KEY (`ShoesID`),
  CONSTRAINT `FKBoot602825` FOREIGN KEY (`ShoesID`) REFERENCES `shoes` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boot`
--

LOCK TABLES `boot` WRITE;
/*!40000 ALTER TABLE `boot` DISABLE KEYS */;
/*!40000 ALTER TABLE `boot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `businessshoes`
--

DROP TABLE IF EXISTS `businessshoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `businessshoes` (
  `HeelHeight` float NOT NULL,
  `HeelMeasure` float NOT NULL,
  `ShoesID` int NOT NULL,
  PRIMARY KEY (`ShoesID`),
  CONSTRAINT `FKBusinessSh921875` FOREIGN KEY (`ShoesID`) REFERENCES `shoes` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `businessshoes`
--

LOCK TABLES `businessshoes` WRITE;
/*!40000 ALTER TABLE `businessshoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `businessshoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `OrderID` int NOT NULL,
  `Amount` int NOT NULL,
  `TotalPrice` float NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKCart92266` (`OrderID`),
  CONSTRAINT `FKCart92266` FOREIGN KEY (`OrderID`) REFERENCES `order` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cash`
--

DROP TABLE IF EXISTS `cash`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cash` (
  `CashTendered` float NOT NULL,
  `PaymentID` int NOT NULL,
  PRIMARY KEY (`PaymentID`),
  CONSTRAINT `FKCash453060` FOREIGN KEY (`PaymentID`) REFERENCES `payment` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cash`
--

LOCK TABLES `cash` WRITE;
/*!40000 ALTER TABLE `cash` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Giáo dục'),(2,'Văn học'),(3,'Khoa học - Công nghệ');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `CustomerCodeCust` int NOT NULL,
  `Content` varchar(255) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKChat862377` (`CustomerCodeCust`),
  CONSTRAINT `FKChat862377` FOREIGN KEY (`CustomerCodeCust`) REFERENCES `customer` (`CodeCust`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat_employee`
--

DROP TABLE IF EXISTS `chat_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat_employee` (
  `ChatID` int NOT NULL,
  `EmployeeID` int NOT NULL,
  PRIMARY KEY (`ChatID`,`EmployeeID`),
  KEY `FKChat_Emplo506589` (`EmployeeID`),
  CONSTRAINT `FKChat_Emplo153541` FOREIGN KEY (`ChatID`) REFERENCES `chat` (`ID`),
  CONSTRAINT `FKChat_Emplo506589` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_employee`
--

LOCK TABLES `chat_employee` WRITE;
/*!40000 ALTER TABLE `chat_employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `chat_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clothes`
--

DROP TABLE IF EXISTS `clothes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clothes` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Brand` varchar(255) DEFAULT NULL,
  `Color` varchar(255) DEFAULT NULL,
  `ManufactureDate` date DEFAULT NULL,
  `Material` varchar(255) DEFAULT NULL,
  `Department` varchar(255) DEFAULT NULL,
  `Size` varchar(255) DEFAULT NULL,
  `SizeCountry` varchar(255) DEFAULT NULL,
  `WashingType` varchar(255) DEFAULT NULL,
  `Weight` float NOT NULL,
  `FitType` varchar(255) DEFAULT NULL,
  `ClosureType` varchar(255) DEFAULT NULL,
  `Dimensions` varchar(255) DEFAULT NULL,
  `CountryOrigin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clothes`
--

LOCK TABLES `clothes` WRITE;
/*!40000 ALTER TABLE `clothes` DISABLE KEYS */;
/*!40000 ALTER TABLE `clothes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coat`
--

DROP TABLE IF EXISTS `coat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coat` (
  `WaterResistant` int NOT NULL,
  `MoistureWicking` int NOT NULL,
  `PocketNumber` int NOT NULL,
  `ClothesID` int NOT NULL,
  PRIMARY KEY (`ClothesID`),
  CONSTRAINT `FKCoat236171` FOREIGN KEY (`ClothesID`) REFERENCES `clothes` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coat`
--

LOCK TABLES `coat` WRITE;
/*!40000 ALTER TABLE `coat` DISABLE KEYS */;
/*!40000 ALTER TABLE `coat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credit`
--

DROP TABLE IF EXISTS `credit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credit` (
  `Number` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `ExpDate` date DEFAULT NULL,
  `PaymentID` int NOT NULL,
  PRIMARY KEY (`PaymentID`),
  CONSTRAINT `FKCredit998953` FOREIGN KEY (`PaymentID`) REFERENCES `payment` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit`
--

LOCK TABLES `credit` WRITE;
/*!40000 ALTER TABLE `credit` DISABLE KEYS */;
/*!40000 ALTER TABLE `credit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `CodeCust` int NOT NULL AUTO_INCREMENT,
  `Tel` varchar(255) DEFAULT NULL,
  `DateOfBirth` date DEFAULT NULL,
  PRIMARY KEY (`CodeCust`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customermember`
--

DROP TABLE IF EXISTS `customermember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customermember` (
  `Card` varchar(255) DEFAULT NULL,
  `Duration` float NOT NULL,
  `Level` varchar(255) DEFAULT NULL,
  `CustomerCodeCust` int NOT NULL,
  PRIMARY KEY (`CustomerCodeCust`),
  CONSTRAINT `FKCustomerMe129612` FOREIGN KEY (`CustomerCodeCust`) REFERENCES `customer` (`CodeCust`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customermember`
--

LOCK TABLES `customermember` WRITE;
/*!40000 ALTER TABLE `customermember` DISABLE KEYS */;
/*!40000 ALTER TABLE `customermember` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customernew`
--

DROP TABLE IF EXISTS `customernew`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customernew` (
  `IntroductionCode` varchar(255) DEFAULT NULL,
  `CustomerCodeCust` int NOT NULL,
  PRIMARY KEY (`CustomerCodeCust`),
  CONSTRAINT `FKCustomerNe170762` FOREIGN KEY (`CustomerCodeCust`) REFERENCES `customer` (`CodeCust`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customernew`
--

LOCK TABLES `customernew` WRITE;
/*!40000 ALTER TABLE `customernew` DISABLE KEYS */;
/*!40000 ALTER TABLE `customernew` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `electronics`
--

DROP TABLE IF EXISTS `electronics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `electronics` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Manufacturer` varchar(255) DEFAULT NULL,
  `ManufactureDate` date DEFAULT NULL,
  `Weight` float NOT NULL,
  `Color` varchar(255) DEFAULT NULL,
  `Warranty` int NOT NULL,
  `Dimensions` varchar(255) DEFAULT NULL,
  `CountryOrigin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `electronics`
--

LOCK TABLES `electronics` WRITE;
/*!40000 ALTER TABLE `electronics` DISABLE KEYS */;
/*!40000 ALTER TABLE `electronics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Type` varchar(255) DEFAULT NULL,
  `Tel` varchar(255) DEFAULT NULL,
  `DateOfBirth` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Nhap hang','0912345678','1999-07-25');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `EmployeeID` int NOT NULL,
  `CustomerCodeCust` int NOT NULL,
  `Content` varchar(255) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Response` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKFeedback818877` (`CustomerCodeCust`),
  KEY `FKFeedback211315` (`EmployeeID`),
  CONSTRAINT `FKFeedback211315` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKFeedback818877` FOREIGN KEY (`CustomerCodeCust`) REFERENCES `customer` (`CodeCust`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fullname`
--

DROP TABLE IF EXISTS `fullname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fullname` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `EmployeeID` int NOT NULL,
  `CustomerCodeCust` int NOT NULL,
  `FirstName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `MidName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKFullName463638` (`CustomerCodeCust`),
  KEY `FKFullName143924` (`EmployeeID`),
  CONSTRAINT `FKFullName143924` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKFullName463638` FOREIGN KEY (`CustomerCodeCust`) REFERENCES `customer` (`CodeCust`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fullname`
--

LOCK TABLES `fullname` WRITE;
/*!40000 ALTER TABLE `fullname` DISABLE KEYS */;
/*!40000 ALTER TABLE `fullname` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hairdryer`
--

DROP TABLE IF EXISTS `hairdryer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hairdryer` (
  `HairType` varchar(255) DEFAULT NULL,
  `Wattage` float NOT NULL,
  `Material` varchar(255) DEFAULT NULL,
  `Voltage` int NOT NULL,
  `SpeedSettings` int NOT NULL,
  `HeatSettings` int NOT NULL,
  `ElectronicsID` int NOT NULL,
  PRIMARY KEY (`ElectronicsID`),
  CONSTRAINT `FKHairdryer403917` FOREIGN KEY (`ElectronicsID`) REFERENCES `electronics` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hairdryer`
--

LOCK TABLES `hairdryer` WRITE;
/*!40000 ALTER TABLE `hairdryer` DISABLE KEYS */;
/*!40000 ALTER TABLE `hairdryer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itembook`
--

DROP TABLE IF EXISTS `itembook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itembook` (
  `Barcode` varchar(255) NOT NULL,
  `EmployeeID` int NOT NULL,
  `FeedbackID` int DEFAULT NULL,
  `CartID` int DEFAULT NULL,
  `BookISBN` varchar(255) NOT NULL,
  `Price` float NOT NULL,
  `Discount` varchar(255) DEFAULT NULL,
  `PromoText` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Barcode`),
  KEY `FKItemBook68250` (`BookISBN`),
  KEY `FKItemBook279292` (`EmployeeID`),
  KEY `FKItemBook8988` (`FeedbackID`),
  KEY `FKItemBook996573` (`CartID`),
  CONSTRAINT `FKItemBook279292` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKItemBook68250` FOREIGN KEY (`BookISBN`) REFERENCES `book` (`ISBN`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKItemBook8988` FOREIGN KEY (`FeedbackID`) REFERENCES `feedback` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKItemBook996573` FOREIGN KEY (`CartID`) REFERENCES `cart` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itembook`
--

LOCK TABLES `itembook` WRITE;
/*!40000 ALTER TABLE `itembook` DISABLE KEYS */;
INSERT INTO `itembook` VALUES ('1',1,NULL,NULL,'978-604-0-00835-0',40000,'0',NULL,'Sách tiếng Anh 7 tập 1 cho học sinh','img/TiengAnh7_SHS_1.jpg'),('2',1,NULL,NULL,'978-604-0-25873-1',48000,'0',NULL,'Sách tiếng Anh 6 (Global Success) tập 1 cho học sinh','img/TiengAnh6_SHS_1.jpg'),('3',1,NULL,NULL,'978-0-099-54124-0',232000,'0',NULL,'Bác sĩ Zhivago (Vintage UK) - Bản dịch của Richard Pevear và Larissa Volokhonsky ','img/DoctorZhivago.jpg'),('4',1,NULL,NULL,'978-604-1-07222-0',95000,'0',NULL,'Chuỗi án mạng A.B.C - Bản dịch của Võ Thi Hương Lan','img/ABCMurders.jpg'),('5',1,NULL,NULL,'978-604-1-07777-5',107000,'0',NULL,'Những chiếc đồng hồ kỳ lạ - Bản dịch của Trần Hữu Kham','img/StrangeClocks.jpg'),('6',1,NULL,NULL,'978-0-12-811905-1',1769000,'0',NULL,'Computer Architecture - A Quantitative Approach (ấn bản lần thứ 6)','img/ComputerArchitecture_Quantitative_6.jpg'),('7',1,NULL,NULL,'978-0-13-467095-9',4096000,'0',NULL,'Operating Systems: Internals and Design Principles (ấn bản lần thứ 9)','img/OS_Internals_9.jpg');
/*!40000 ALTER TABLE `itembook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemclothes`
--

DROP TABLE IF EXISTS `itemclothes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itemclothes` (
  `Barcode` varchar(255) NOT NULL,
  `EmployeeID` int NOT NULL,
  `FeedbackID` int DEFAULT NULL,
  `ClothesID` int NOT NULL,
  `CartID` int DEFAULT NULL,
  `Price` float NOT NULL,
  `Discount` varchar(255) DEFAULT NULL,
  `PromoText` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Barcode`),
  KEY `FKItemClothe180633` (`ClothesID`),
  KEY `FKItemClothe168716` (`EmployeeID`),
  KEY `FKItemClothe107150` (`CartID`),
  KEY `FKItemClothe880435` (`FeedbackID`),
  CONSTRAINT `FKItemClothe107150` FOREIGN KEY (`CartID`) REFERENCES `cart` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKItemClothe168716` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKItemClothe180633` FOREIGN KEY (`ClothesID`) REFERENCES `clothes` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKItemClothe880435` FOREIGN KEY (`FeedbackID`) REFERENCES `feedback` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemclothes`
--

LOCK TABLES `itemclothes` WRITE;
/*!40000 ALTER TABLE `itemclothes` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemclothes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemelectronics`
--

DROP TABLE IF EXISTS `itemelectronics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itemelectronics` (
  `Barcode` varchar(255) NOT NULL,
  `EmployeeID` int NOT NULL,
  `FeedbackID` int DEFAULT NULL,
  `CartID` int DEFAULT NULL,
  `ElectronicsID` int NOT NULL,
  `Price` float NOT NULL,
  `Discount` varchar(255) DEFAULT NULL,
  `PromoText` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Barcode`),
  KEY `FKItemElectr958846` (`ElectronicsID`),
  KEY `FKItemElectr395721` (`EmployeeID`),
  KEY `FKItemElectr300003` (`CartID`),
  KEY `FKItemElectr684001` (`FeedbackID`),
  CONSTRAINT `FKItemElectr300003` FOREIGN KEY (`CartID`) REFERENCES `cart` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKItemElectr395721` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKItemElectr684001` FOREIGN KEY (`FeedbackID`) REFERENCES `feedback` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKItemElectr958846` FOREIGN KEY (`ElectronicsID`) REFERENCES `electronics` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemelectronics`
--

LOCK TABLES `itemelectronics` WRITE;
/*!40000 ALTER TABLE `itemelectronics` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemelectronics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemshoes`
--

DROP TABLE IF EXISTS `itemshoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itemshoes` (
  `Barcode` varchar(255) NOT NULL,
  `EmployeeID` int NOT NULL,
  `FeedbackID` int DEFAULT NULL,
  `ShoesID` int NOT NULL,
  `CartID` int DEFAULT NULL,
  `Price` float NOT NULL,
  `Discount` varchar(255) DEFAULT NULL,
  `PromoText` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Barcode`),
  KEY `FKItemShoes303933` (`ShoesID`),
  KEY `FKItemShoes978552` (`EmployeeID`),
  KEY `FKItemShoes266833` (`FeedbackID`),
  KEY `FKItemShoes717171` (`CartID`),
  CONSTRAINT `FKItemShoes266833` FOREIGN KEY (`FeedbackID`) REFERENCES `feedback` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKItemShoes303933` FOREIGN KEY (`ShoesID`) REFERENCES `shoes` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKItemShoes717171` FOREIGN KEY (`CartID`) REFERENCES `cart` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKItemShoes978552` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemshoes`
--

LOCK TABLES `itemshoes` WRITE;
/*!40000 ALTER TABLE `itemshoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemshoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jeans`
--

DROP TABLE IF EXISTS `jeans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jeans` (
  `Waist` float NOT NULL,
  `FrontRise` float NOT NULL,
  `BackRise` float NOT NULL,
  `UpperThigh` float NOT NULL,
  `Inseam` float NOT NULL,
  `LegOpening` float NOT NULL,
  `PocketNumber` int NOT NULL,
  `ClothesID` int NOT NULL,
  PRIMARY KEY (`ClothesID`),
  CONSTRAINT `FKJeans895705` FOREIGN KEY (`ClothesID`) REFERENCES `clothes` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jeans`
--

LOCK TABLES `jeans` WRITE;
/*!40000 ALTER TABLE `jeans` DISABLE KEYS */;
/*!40000 ALTER TABLE `jeans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laptop`
--

DROP TABLE IF EXISTS `laptop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laptop` (
  `Cpu` varchar(255) DEFAULT NULL,
  `Gpu` varchar(255) DEFAULT NULL,
  `StorageSize` int NOT NULL,
  `StorageType` varchar(255) DEFAULT NULL,
  `ScreenSize` float NOT NULL,
  `ScreenResolution` varchar(255) DEFAULT NULL,
  `RamSize` int NOT NULL,
  `RamType` varchar(255) DEFAULT NULL,
  `Connections` varchar(255) DEFAULT NULL,
  `Interfaces` varchar(255) DEFAULT NULL,
  `Battery` varchar(255) DEFAULT NULL,
  `Os` varchar(255) DEFAULT NULL,
  `Speaker` varchar(255) DEFAULT NULL,
  `ElectronicsID` int NOT NULL,
  PRIMARY KEY (`ElectronicsID`),
  CONSTRAINT `FKLaptop879998` FOREIGN KEY (`ElectronicsID`) REFERENCES `electronics` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laptop`
--

LOCK TABLES `laptop` WRITE;
/*!40000 ALTER TABLE `laptop` DISABLE KEYS */;
/*!40000 ALTER TABLE `laptop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mobilephone`
--

DROP TABLE IF EXISTS `mobilephone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mobilephone` (
  `Cpu` varchar(255) DEFAULT NULL,
  `Gpu` varchar(255) DEFAULT NULL,
  `StorageSize` int NOT NULL,
  `ScreenSize` float NOT NULL,
  `ScreenResolution` varchar(255) DEFAULT NULL,
  `RamSize` int NOT NULL,
  `Connections` varchar(255) DEFAULT NULL,
  `Intefaces` varchar(255) DEFAULT NULL,
  `Battery` varchar(255) DEFAULT NULL,
  `Os` varchar(255) DEFAULT NULL,
  `FrontCamera` varchar(255) DEFAULT NULL,
  `RearCamera` varchar(255) DEFAULT NULL,
  `Speaker` varchar(255) DEFAULT NULL,
  `ElectronicsID` int NOT NULL,
  PRIMARY KEY (`ElectronicsID`),
  CONSTRAINT `FKMobilePhon69688` FOREIGN KEY (`ElectronicsID`) REFERENCES `electronics` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mobilephone`
--

LOCK TABLES `mobilephone` WRITE;
/*!40000 ALTER TABLE `mobilephone` DISABLE KEYS */;
/*!40000 ALTER TABLE `mobilephone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `EmployeeID` int NOT NULL,
  `CustomerCodeCust` int NOT NULL,
  `TotalPrice` float NOT NULL,
  `Tax` float NOT NULL,
  `Status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKOrder507689` (`CustomerCodeCust`),
  KEY `FKOrder900126` (`EmployeeID`),
  CONSTRAINT `FKOrder507689` FOREIGN KEY (`CustomerCodeCust`) REFERENCES `customer` (`CodeCust`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKOrder900126` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `CartID` int NOT NULL,
  `ShipmentID` int NOT NULL,
  `OrderID` int NOT NULL,
  `Method` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKPayment972219` (`OrderID`),
  KEY `FKPayment767140` (`ShipmentID`),
  KEY `FKPayment656927` (`CartID`),
  CONSTRAINT `FKPayment656927` FOREIGN KEY (`CartID`) REFERENCES `cart` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKPayment767140` FOREIGN KEY (`ShipmentID`) REFERENCES `shipment` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKPayment972219` FOREIGN KEY (`OrderID`) REFERENCES `order` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pc`
--

DROP TABLE IF EXISTS `pc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pc` (
  `Cpu` varchar(255) DEFAULT NULL,
  `Gpu` varchar(255) DEFAULT NULL,
  `StorageSize` int NOT NULL,
  `StorageType` varchar(255) DEFAULT NULL,
  `RamSize` int NOT NULL,
  `RamType` varchar(255) DEFAULT NULL,
  `Connections` varchar(255) DEFAULT NULL,
  `Interaces` varchar(255) DEFAULT NULL,
  `Os` varchar(255) DEFAULT NULL,
  `ElectronicsID` int NOT NULL,
  PRIMARY KEY (`ElectronicsID`),
  CONSTRAINT `FKPC3234` FOREIGN KEY (`ElectronicsID`) REFERENCES `electronics` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pc`
--

LOCK TABLES `pc` WRITE;
/*!40000 ALTER TABLE `pc` DISABLE KEYS */;
/*!40000 ALTER TABLE `pc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `EmployeeID` int NOT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Content` varchar(255) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKPost860246` (`EmployeeID`),
  CONSTRAINT `FKPost860246` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisher`
--

DROP TABLE IF EXISTS `publisher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publisher` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisher`
--

LOCK TABLES `publisher` WRITE;
/*!40000 ALTER TABLE `publisher` DISABLE KEYS */;
INSERT INTO `publisher` VALUES (1,'NXB Giáo dục Việt Nam','81 Trần Hưng Đạo, Hoàn Kiếm, Hà Nội'),(2,'Vingate UK Random House','20 Vauxhall Bridge Roadd, London, SW1V 2SA, UK'),(3,'NXB Trẻ','Phòng 602, 209 P. Giảng Võ, Chợ Dừa, Đống Đa, Hà Nội'),(4,'Morgan Kaufmann (Elsevier)','50 Hampshire Street, 5th Floor, Cambridge, MA 02139, United States'),(5,'Pearson','330 Hudson Street, New York NY 10013');
/*!40000 ALTER TABLE `publisher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `runningshoes`
--

DROP TABLE IF EXISTS `runningshoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `runningshoes` (
  `NightReflect` int NOT NULL,
  `Durability` varchar(255) DEFAULT NULL,
  `ShockAbsorb` int NOT NULL,
  `Ventilation` int NOT NULL,
  `AnkleSupport` int NOT NULL,
  `ShoesID` int NOT NULL,
  PRIMARY KEY (`ShoesID`),
  CONSTRAINT `FKRunningSho425740` FOREIGN KEY (`ShoesID`) REFERENCES `shoes` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `runningshoes`
--

LOCK TABLES `runningshoes` WRITE;
/*!40000 ALTER TABLE `runningshoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `runningshoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment`
--

DROP TABLE IF EXISTS `shipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipment` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `OrderID` int NOT NULL,
  `Method` varchar(255) DEFAULT NULL,
  `Cost` float NOT NULL,
  `ShippingAddress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKShipment314014` (`OrderID`),
  CONSTRAINT `FKShipment314014` FOREIGN KEY (`OrderID`) REFERENCES `order` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment`
--

LOCK TABLES `shipment` WRITE;
/*!40000 ALTER TABLE `shipment` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoes`
--

DROP TABLE IF EXISTS `shoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shoes` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Size` float NOT NULL,
  `SizeCountry` varchar(255) DEFAULT NULL,
  `Brand` varchar(255) DEFAULT NULL,
  `Color` varchar(255) DEFAULT NULL,
  `Weight` float NOT NULL,
  `ManufactureDate` date DEFAULT NULL,
  `CountryOrigin` varchar(255) DEFAULT NULL,
  `Department` varchar(255) DEFAULT NULL,
  `UpperMaterial` varchar(255) DEFAULT NULL,
  `SoleMaterial` varchar(255) DEFAULT NULL,
  `LiningMaterial` varchar(255) DEFAULT NULL,
  `Dimensions` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoes`
--

LOCK TABLES `shoes` WRITE;
/*!40000 ALTER TABLE `shoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shorts`
--

DROP TABLE IF EXISTS `shorts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shorts` (
  `PocketNumber` int NOT NULL,
  `MoistureWicking` int NOT NULL,
  `Breathable` int NOT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Inseam` float NOT NULL,
  `Outseam` float NOT NULL,
  `ClothesID` int NOT NULL,
  PRIMARY KEY (`ClothesID`),
  CONSTRAINT `FKShorts625296` FOREIGN KEY (`ClothesID`) REFERENCES `clothes` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shorts`
--

LOCK TABLES `shorts` WRITE;
/*!40000 ALTER TABLE `shorts` DISABLE KEYS */;
/*!40000 ALTER TABLE `shorts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sneaker`
--

DROP TABLE IF EXISTS `sneaker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sneaker` (
  `NightReflect` int NOT NULL,
  `HeelHeight` float NOT NULL,
  `ShoesID` int NOT NULL,
  PRIMARY KEY (`ShoesID`),
  CONSTRAINT `FKSneaker807437` FOREIGN KEY (`ShoesID`) REFERENCES `shoes` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sneaker`
--

LOCK TABLES `sneaker` WRITE;
/*!40000 ALTER TABLE `sneaker` DISABLE KEYS */;
/*!40000 ALTER TABLE `sneaker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t-shirt`
--

DROP TABLE IF EXISTS `t-shirt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t-shirt` (
  `TagFree` int NOT NULL,
  `LayFlat` int NOT NULL,
  `SleeveHem` float NOT NULL,
  `MoistureWicking` int NOT NULL,
  `TapedNeck` int NOT NULL,
  `BottemHem` float NOT NULL,
  `ClothesID` int NOT NULL,
  PRIMARY KEY (`ClothesID`),
  CONSTRAINT `FKT-Shirt278622` FOREIGN KEY (`ClothesID`) REFERENCES `clothes` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t-shirt`
--

LOCK TABLES `t-shirt` WRITE;
/*!40000 ALTER TABLE `t-shirt` DISABLE KEYS */;
/*!40000 ALTER TABLE `t-shirt` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-24  1:11:10
