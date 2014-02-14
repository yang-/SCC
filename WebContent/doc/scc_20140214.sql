CREATE DATABASE  IF NOT EXISTS `scc` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `scc`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: scc
-- ------------------------------------------------------
-- Server version	5.5.25a

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
-- Table structure for table `major`
--

DROP TABLE IF EXISTS `major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `major` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Major_Short` varchar(256) NOT NULL,
  `Major_Name` varchar(256) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major`
--

LOCK TABLES `major` WRITE;
/*!40000 ALTER TABLE `major` DISABLE KEYS */;
INSERT INTO `major` VALUES (1,'UND','Undergraduate'),(2,'AFH','Africana Studies'),(3,'ANT','Anthropology'),(4,'AMS','Applied Mathematics'),(5,'ARH','Art History'),(6,'ARS','Art - Studio'),(7,'BCB','Biochem &amp; Cell Biology'),(8,'BME','Biomedical Engineering'),(9,'MBA','College of Business'),(10,'CHE','Chemistry'),(11,'CLCS','Comparative Literary'),(12,'CSE','Computer Science'),(13,'CWL','Creative Writing &amp; Literature'),(14,'BEE','Ecology &amp; Evolution'),(15,'ESE','Electrical &amp; Computer Engg.'),(16,'EGL','English'),(17,'EURO','European Languages'),(18,'GEO','Geosciences'),(19,'GSS','Geospatial Science'),(20,'SPN','Hispanic Languages'),(21,'HIS','History'),(22,'ISE','Information Systems'),(23,'JRN','Journalism'),(24,'LIN','Linguistics'),(25,'MAS','Marine Sciences'),(26,'ESM','Materials Science'),(27,'MAT','Mathematics'),(28,'MEC','Mechanical Engg.'),(29,'MH','Medical Humanities'),(30,'MUS','Music'),(31,'HDO','Oral Biology'),(32,'PHI','Philosophy'),(33,'PHY','Physics &amp; Astronomy'),(34,'HBY','Physiology &amp; Biophysics'),(35,'POL','Political Science'),(36,'publichealth','Public Health'),(37,'PUB','Public Policy'),(38,'PSY','Psychology'),(39,'SOC','Sociology'),(40,'ARS','Studio Arts'),(41,'EST','Technology and Society'),(42,'THR','Theatre Arts'),(43,'THR2',' Theatre, MFA'),(44,'WST','Women\'s Studies'),(45,'WRT','Writing and Rhetoric'),(46,'ohter','Others');
/*!40000 ALTER TABLE `major` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airline`
--

DROP TABLE IF EXISTS `airline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `airline` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Flight_Name` varchar(256) NOT NULL,
  `Arrival_Date` date NOT NULL,
  `Estimate_Arrival_Time` time NOT NULL,
  `Airport` varchar(256) NOT NULL,
  `Termination` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airline`
--

LOCK TABLES `airline` WRITE;
/*!40000 ALTER TABLE `airline` DISABLE KEYS */;
/*!40000 ALTER TABLE `airline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `new_student`
--

DROP TABLE IF EXISTS `new_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `new_student` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(256) CHARACTER SET utf8mb4 NOT NULL,
  `Last_Name` varchar(256) NOT NULL,
  `Email` varchar(256) NOT NULL,
  `Phone` varchar(256) NOT NULL,
  `Arrival_Date` date NOT NULL,
  `Flight_Number` varchar(256) NOT NULL,
  `Arrival_Time` time DEFAULT NULL,
  `Terminal` varchar(200) DEFAULT NULL,
  `Student_Id` varchar(256) NOT NULL,
  `Major_Id` int(11) NOT NULL,
  `QQ` varchar(256) DEFAULT NULL,
  `QQ_Name` varchar(256) DEFAULT NULL,
  `Campus_Address` varchar(256) DEFAULT NULL,
  `Off_Campus_Address` varchar(256) DEFAULT NULL,
  `Note` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `new_student`
--

LOCK TABLES `new_student` WRITE;
/*!40000 ALTER TABLE `new_student` DISABLE KEYS */;
INSERT INTO `new_student` VALUES (1,'阳','陈','cxfy123@gmail.com','12345767','2013-08-10','410','12:23:00','21323','1231',1,'12212','12121','chapin',NULL,'选填。请输入你的补充说明，如你的性别、体形、接机当天的着装、行李的数量等。选填。请输入你的补充说明，如你的性别、体形、接机当天的着装、行李的数量等。选填。请输入你的补充说明，如你的性别、体形、接机当天的着装、行李的数量等。选填。请输入你的补充说明，如你的性别、体形、接机当天的着装、行李的数量等。选填。请输入你的补充说明，如你的性别、体形、接机当天的着装、行李的数量等。选填。请输入你的补充说明，如你的性别、体形、接机当天的着装、行李的数量等。选填。请输入你的补充说明，如你的性别、体形、接机当天的着装、行李的数量等。选填。请输入你的补充说明，如你的性别、体形、接机当天的着装、行李的数量等。选填。请输入你的补充说明，如你的性别、体形、接机当天的着装、行李的数量等。选填。请输入你的补充说明，如你的性别、体形、接机当天的着装、行李的数量等。选填。请输入你的补充说明，如你的性别、体形、接机当天的着装、行李的数量等。选填。请输入你的补充说明，如你的性别、体形、接机当天的着装、行李的数量等。选填。请输入你的补充说明，如你的性别、体形、接机当天的着装、行李的数量等。选填。请输入你的补充说明，如你的性别、'),(2,'保存','baocuo','121212@1212.com','1212','2013-08-10','121','11:21:00','212','1212',17,'1212','1212','chapin',NULL,'121212'),(3,'阳','陈','1sds@com.com','12121','2013-08-10','12','12:12:00','12','121',19,'1212','12121','chapin',NULL,'施福基督教会 Suffolk Christian Church\r\n校园团契 Campus Fellowship'),(4,'阳','陈','cxfy123@gmail.com','075528185953','2013-08-10','CX880','09:41:00','7','108292118',15,'21852976','Wet','chapin',NULL,'段落。\r\n测试。'),(5,'阳','陈','cxdfy123@g.com','123','2013-08-17','12','11:22:00','12','1212',1,'1212','1212','chapin',NULL,'中文测试'),(6,'文','中','cxcx12@sds.com','1212','2013-08-18','1212','11:11:00','11212','212',17,'1212','ä¸­ææµç§°','chapin',NULL,'中文备注'),(7,'文','中','z12@www.com','1212','2013-08-17','11','11:11:00','111','111',1,'111','ä¸­æ','chapin',NULL,'中文'),(8,'中文','中文','sdsd@qwqw.com','1212','2013-08-10','12122','11:11:00','1212','1212',19,'1212','no chinese','chapin',NULL,'椎间盘更名为'),(9,'中文','中文','1212@121.com','121212','2013-08-23','111','11:11:00','1111','1111',18,'1111','1111','chapin',NULL,'中文'),(10,'中文','中文','1212@sdsd.com','121212','2013-08-24','1111','11:11:00','1111','1111',15,'1111','中文','chapin',NULL,'中文'),(11,'阳','陈','cxfy123@gmail.com','121212','2013-08-10','111','11:11:00','111','108292118',15,'21852976','wet','other','7 Melville Ct','中文备注。\r\n段落测试。'),(12,'asd','christian','asd@new.com','123121123','2013-08-15','121A','12:13:00','1','123123123',5,'13231323','nonon','chapin',NULL,'test'),(13,'hao','chen','xxx@sss.ddd','110','2013-08-10','MU587','12:22:00','1','100000000',29,'xcvd15e','haochen','west',NULL,''),(14,'Hao','Huang','vonlavia@hotmail.com','8620-12345678','2013-08-10','CA981','10:22:00','4','123456789',12,'120528347','CS-Hao','other','700 Health Sciences Dr.',''),(15,'测试','中午','1212@dsds.com','12121','2013-08-10','1111','11:11:00','1111','1111',2,'1111','1111','chapin',NULL,'测试'),(16,'阳','陈','cxfy123@gmail.com','12121','2013-08-10','1111','11:11:00','1111','1111',1,'1111','1111','chapin',NULL,'中午'),(17,'试','测','cxcx@wsdsd.com','112121','2013-08-10','121212','11:11:00','121212','121212',1,'121212','中文qq名字','chapin',NULL,'中文备注＋english+1234'),(18,'first','last','first.last@gmail.com','567890','2013-08-21','123','00:00:00','1','123',5,'1234','45','other','test address, city, state, NY 12345','test'),(19,'阳','陈','cxfy123@gmail.com','1212121','2013-08-10','1111','11:11:00','1111','1212',15,'1212','中文','chapin',NULL,'中文'),(20,'阳','陈','cxcxc@asdasd.com','123,; ./-','2013-08-17','1111','11:11:00','1111','111',17,'1111','测试','chapin',NULL,'测试 国内紧急联系电话 字符'),(21,'阳','陈','sdsd@sdsd.com','121212,.;/ 1121','2013-08-10','1111','11:11:00','1111','1111',11,'1111','1111','chapin',NULL,'国内紧急联系电话 :\r\n121212,.;/ 1121'),(22,'阳','陈','xcxcz@sdsd.com','12121','2013-08-17','1111','11:11:00','1111','11111',1,'1111','1111','chapin',NULL,'1111'),(23,'1212','1212','121@1212.co','2121','2013-08-29','1212','11:11:00','1121212','1212',16,'121212','121212','chapin',NULL,'121212'),(24,'阳','陈','cxcx@ssdd.com','121221','2013-08-10','1111','11:11:00','1111','111',18,'111','1111','chapin',NULL,'测试 5/11/2013 12:18AM'),(25,'测试','陈阳','11212@sdsd.com','12121','2013-08-13','1111','11:11:00','1111','1111',16,'1111','1111','chapin',NULL,'测试 5/11/2013 12:22AM'),(26,'xcxcxc','cxcxc','112@sdsd.com','22121','2013-08-29','1212','04:39:00','1212','1212',17,'12121','121212','chapin',NULL,'121212'),(27,'阳','陈','sdsd@sdsd.com','121212','2013-08-06','1111','11:11:00','1111','1111',18,'1111','1111','chapin',NULL,'1111'),(28,'sdsd','sdsad','sdsd@12121.com','121212121','2013-08-29','11111','11:11:00','1111','1111',19,'1111','1111','chapin',NULL,'1111'),(29,'测试','陈阳','cxfy123@gmail.com','0755-28185953','2013-08-10','Cx880','14:20:00','7','108292118',15,'21852976','Wetzai','other','7 Melville Ct2nd FloorStony Brook11790','测试新校外住址form'),(30,'阳','陈','cxfy123@gmail.com','0755-28185953','2013-08-10','Cx880','16:17:00','7','108292118',15,'21852976','陈阳测试','other','46 Vroom St, Apt 4, Jersey City, 07306','测试新校外住址格式。'),(31,'浩','陈','xxx@xxx.com','11111111111','2013-08-02','cc34','22:22:00','3','111086666',23,'435646','xxx','chapin',NULL,'ccccccc'),(32,'陈阳','测试','cxfy123@gmail.com','0755-28185953','2013-08-10','cx880','11:11:00','7','108292118',15,'21852976','陈阳','other','700 Health Sciences Drive, Chapin I 1125Cx, Stony Brook, 11790','测试'),(33,'陈阳','测试','cxfy123@gmail.com','11111111111111111111','2013-08-03','11111','11:11:00','2','111111111',16,'11111111111','1111111111','chapin',NULL,'111111111'),(34,'阳','陈','cxfy123@gmail.com','0755-28185953','2013-08-17','cx123','11:11:00','5','108292118',15,'21852976','WeiZai','other','700 HSD, Chapin I 1125Cx, Stony Brook, 07306','测试\r\n123\r\n测试'),(35,'阳','陈','cxfy123@gmail.com','1234567890123456','2013-08-10','ac123','11:11:00','5','108292118',15,'21852976','Yang','chapin',NULL,'测试\r\n测试\r\n测试'),(36,'阳','陈','cxfy123@gmail.com','0755-28185953','2013-08-10','CX111','11:11:00','7','108292118',26,'28185953','陈阳','west',NULL,'测试，\r\n测试、'),(37,'阳','陈','cxfy123@gmail.com','6875528185953','2013-08-10','cx880','11:22:00','7','108292118',15,'21852976','陈阳测试','other','46 Vroom St, Apt 4, Stony Brook, 07306','5/27 测试新网站'),(38,'阳','陈','cxfy123@gmail.com','6875528185953','2013-08-10','cx880','11:25:00','2','108292118',32,'21852976','陈阳测试','other','7 Melville Ct, , Stony Brook, 11790','测试 5/29'),(39,'志修','梁','liangzhixiu@gmail.com','15972216532','2013-08-10','MU587','13:30:00','2','104331485',10,'402361008','123','chapin',NULL,'TEST'),(40,'阳','陈','cxfy123@gmail.com','6316054085','2013-08-17','cn123','11:23:00','4','108292118',9,'21852976','Yang陈','chapin',NULL,'Lolololol'),(41,'信忠','钟','shinjong@gmail.com','13876789098','2013-08-09','F0989','04:30:00','1','198975283',1,'78788789','Zhong','chapin',NULL,'Hello Good for you.');
/*!40000 ALTER TABLE `new_student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-14 18:09:13
