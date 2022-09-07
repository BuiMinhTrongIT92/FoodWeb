-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: fooddb
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `binhluan`
--

DROP TABLE IF EXISTS `binhluan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `binhluan` (
  `idbinhluan` int NOT NULL AUTO_INCREMENT,
  `noidung` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `iduser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `idcuahang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `idmonan` int DEFAULT NULL,
  `thoigian` datetime DEFAULT NULL,
  PRIMARY KEY (`idbinhluan`),
  KEY `fk_binhluan_user1_idx` (`iduser`),
  KEY `fk_binhluan_cuahang1_idx` (`idcuahang`),
  KEY `fk_binhluan_monan1_idx` (`idmonan`),
  CONSTRAINT `fk_binhluan_cuahang1` FOREIGN KEY (`idcuahang`) REFERENCES `cuahang` (`idcuahang`) ON DELETE CASCADE,
  CONSTRAINT `fk_binhluan_monan1` FOREIGN KEY (`idmonan`) REFERENCES `monan` (`idmonan`) ON DELETE CASCADE,
  CONSTRAINT `fk_binhluan_user1` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `binhluan`
--

LOCK TABLES `binhluan` WRITE;
/*!40000 ALTER TABLE `binhluan` DISABLE KEYS */;
INSERT INTO `binhluan` VALUES (11,'ok','65de5641-cbe9-46dd-b9b8-a42a82518e79',NULL,25,'2022-08-29 22:52:49'),(12,'Ngon','65de5641-cbe9-46dd-b9b8-a42a82518e79',NULL,25,'2022-08-29 22:52:55'),(13,'trong','65de5641-cbe9-46dd-b9b8-a42a82518e79','650fda46-2dfb-4990-8e64-78e2cc2407c8',NULL,'2022-09-04 23:17:11'),(14,'123','65de5641-cbe9-46dd-b9b8-a42a82518e79','650fda46-2dfb-4990-8e64-78e2cc2407c8',NULL,'2022-09-04 23:20:45'),(15,'sss','65de5641-cbe9-46dd-b9b8-a42a82518e79',NULL,25,'2022-09-04 23:24:02'),(16,'sssss','65de5641-cbe9-46dd-b9b8-a42a82518e79','650fda46-2dfb-4990-8e64-78e2cc2407c8',NULL,'2022-09-04 23:25:38'),(17,'ss','65de5641-cbe9-46dd-b9b8-a42a82518e79','650fda46-2dfb-4990-8e64-78e2cc2407c8',NULL,'2022-09-04 23:51:03'),(18,'ss','65de5641-cbe9-46dd-b9b8-a42a82518e79','650fda46-2dfb-4990-8e64-78e2cc2407c8',NULL,'2022-09-04 23:55:50'),(19,'sss','65de5641-cbe9-46dd-b9b8-a42a82518e79','650fda46-2dfb-4990-8e64-78e2cc2407c8',NULL,'2022-09-05 00:14:11'),(20,'sss','65de5641-cbe9-46dd-b9b8-a42a82518e79','650fda46-2dfb-4990-8e64-78e2cc2407c8',NULL,'2022-09-05 00:15:17'),(21,'sss','65de5641-cbe9-46dd-b9b8-a42a82518e79','650fda46-2dfb-4990-8e64-78e2cc2407c8',NULL,'2022-09-05 00:17:34'),(22,'ss','65de5641-cbe9-46dd-b9b8-a42a82518e79','650fda46-2dfb-4990-8e64-78e2cc2407c8',NULL,'2022-09-05 00:18:42'),(23,'ok đó','65de5641-cbe9-46dd-b9b8-a42a82518e79',NULL,26,'2022-09-05 11:46:21'),(24,'Làm sao','65de5641-cbe9-46dd-b9b8-a42a82518e79','650fda46-2dfb-4990-8e64-78e2cc2407c8',NULL,'2022-09-05 11:46:45'),(25,'ổn\n','65de5641-cbe9-46dd-b9b8-a42a82518e79','650fda46-2dfb-4990-8e64-78e2cc2407c8',NULL,'2022-09-07 11:02:00');
/*!40000 ALTER TABLE `binhluan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuahang`
--

DROP TABLE IF EXISTS `cuahang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuahang` (
  `idcuahang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tencuahang` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `diachi` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `iduser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `active` tinyint(1) NOT NULL,
  `logo` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `vitri` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idcuahang`),
  KEY `fk_cuahang_user_idx` (`iduser`),
  CONSTRAINT `fk_cuahang_user` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuahang`
--

LOCK TABLES `cuahang` WRITE;
/*!40000 ALTER TABLE `cuahang` DISABLE KEYS */;
INSERT INTO `cuahang` VALUES ('650fda46-2dfb-4990-8e64-78e2cc2407c8','Bánh Ngọt','371 ','65de5641-cbe9-46dd-b9b8-a42a82518e79',1,'https://res.cloudinary.com/trongbui/image/upload/v1661787994/byiitjjvf3agsu3aviin.png','10.90067010000001,        106.6251620693192'),('a288ba69-e6cc-4f81-a11e-133198487348','Bean','31','64c09c54-b070-4795-9704-b46392203965',1,'https://res.cloudinary.com/trongbui/image/upload/v1658997161/cld-sample-2.jpg','10.799952126537633, 106.64748911534039'),('a8c22088-41e2-4ccd-b578-69a0fed8e449','qqqq','3123','64c09c54-b070-4795-9704-b46392203965',1,'https://res.cloudinary.com/trongbui/image/upload/v1658997161/cld-sample-2.jpg','10.774510941042582, 106.68946256136157'),('e8cd2633-d709-4103-bcfd-7728c44d4cea','Cơm','371 Nguyễn Kiệm','64c09c54-b070-4795-9704-b46392203965',1,'https://res.cloudinary.com/trongbui/image/upload/v1662523958/jwm1m9ppcgklw1gkioho.jpg','10.774510941042582, 106.68946256136157');
/*!40000 ALTER TABLE `cuahang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danhgia`
--

DROP TABLE IF EXISTS `danhgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danhgia` (
  `iddanhgia` int NOT NULL AUTO_INCREMENT,
  `sao` double NOT NULL,
  `idmonan` int DEFAULT NULL,
  `idcuahang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `iduser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `thoigian` datetime NOT NULL,
  PRIMARY KEY (`iddanhgia`),
  KEY `fk_danhgia_monan1_idx` (`idmonan`),
  KEY `fk_danhgia_cuahang1_idx` (`idcuahang`),
  KEY `fk_danhgia_user1_idx` (`iduser`),
  CONSTRAINT `fk_danhgia_cuahang1` FOREIGN KEY (`idcuahang`) REFERENCES `cuahang` (`idcuahang`) ON DELETE CASCADE,
  CONSTRAINT `fk_danhgia_monan1` FOREIGN KEY (`idmonan`) REFERENCES `monan` (`idmonan`) ON DELETE CASCADE,
  CONSTRAINT `fk_danhgia_user1` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhgia`
--

LOCK TABLES `danhgia` WRITE;
/*!40000 ALTER TABLE `danhgia` DISABLE KEYS */;
INSERT INTO `danhgia` VALUES (12,4,NULL,'650fda46-2dfb-4990-8e64-78e2cc2407c8','65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-04 23:14:15'),(13,4,NULL,'650fda46-2dfb-4990-8e64-78e2cc2407c8','65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-04 23:17:03'),(14,3.5,NULL,'650fda46-2dfb-4990-8e64-78e2cc2407c8','65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-04 23:22:49'),(15,4.5,NULL,'650fda46-2dfb-4990-8e64-78e2cc2407c8','65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-04 23:28:28'),(16,4.5,NULL,'650fda46-2dfb-4990-8e64-78e2cc2407c8','65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-04 23:29:10'),(17,4,NULL,'650fda46-2dfb-4990-8e64-78e2cc2407c8','65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-04 23:32:17'),(18,3.5,NULL,'650fda46-2dfb-4990-8e64-78e2cc2407c8','65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-04 23:37:52'),(19,4,NULL,'650fda46-2dfb-4990-8e64-78e2cc2407c8','65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-04 23:38:00'),(20,3.5,NULL,'650fda46-2dfb-4990-8e64-78e2cc2407c8','65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-04 23:39:09'),(21,3.5,NULL,'650fda46-2dfb-4990-8e64-78e2cc2407c8','65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-04 23:45:48'),(22,4,NULL,'650fda46-2dfb-4990-8e64-78e2cc2407c8','65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-04 23:56:33'),(23,4,NULL,'650fda46-2dfb-4990-8e64-78e2cc2407c8','65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-04 23:56:45'),(24,3.5,NULL,'650fda46-2dfb-4990-8e64-78e2cc2407c8','65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-05 00:04:14'),(25,3.5,NULL,'a288ba69-e6cc-4f81-a11e-133198487348','65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-05 00:04:55'),(26,3.5,NULL,'a288ba69-e6cc-4f81-a11e-133198487348','65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-05 00:08:53'),(27,3.5,NULL,'a288ba69-e6cc-4f81-a11e-133198487348','65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-05 00:14:02'),(28,4,25,NULL,'65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-05 00:29:00'),(29,5,25,NULL,'65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-05 00:29:17'),(30,3.5,26,NULL,'65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-05 11:46:14'),(31,4,NULL,'650fda46-2dfb-4990-8e64-78e2cc2407c8','65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-05 11:46:37'),(32,0.5,NULL,'650fda46-2dfb-4990-8e64-78e2cc2407c8','65de5641-cbe9-46dd-b9b8-a42a82518e79','2022-09-07 11:01:50');
/*!40000 ALTER TABLE `danhgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donhang`
--

DROP TABLE IF EXISTS `donhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donhang` (
  `iddonhang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngaytao` datetime NOT NULL,
  `khuyenmai` double DEFAULT NULL,
  `trangthai` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `iduser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tongtien` double NOT NULL,
  `idcuahang` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`iddonhang`),
  KEY `fk_donhang_user1_idx` (`iduser`) /*!80000 INVISIBLE */,
  KEY `fk_donhang_cuahang` (`idcuahang`),
  CONSTRAINT `fk_donhang_cuahang` FOREIGN KEY (`idcuahang`) REFERENCES `cuahang` (`idcuahang`) ON DELETE CASCADE,
  CONSTRAINT `fk_donhang_user1` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donhang`
--

LOCK TABLES `donhang` WRITE;
/*!40000 ALTER TABLE `donhang` DISABLE KEYS */;
INSERT INTO `donhang` VALUES ('70718b22-f462-4dd9-a1a2-431b3bed3ac8','2022-08-31 00:00:00',NULL,'thanhcong','64c09c54-b070-4795-9704-b46392203965',31000,'e8cd2633-d709-4103-bcfd-7728c44d4cea'),('8ed8f9ea-0a3f-4567-b449-70e96789b0f1','2022-08-31 00:00:00',NULL,'thanhcong','64c09c54-b070-4795-9704-b46392203965',86000,'e8cd2633-d709-4103-bcfd-7728c44d4cea'),('9eca6f67-b6db-4a55-bead-bf78645a754c','2022-09-06 00:00:00',NULL,'choduyet','65de5641-cbe9-46dd-b9b8-a42a82518e79',21000,'e8cd2633-d709-4103-bcfd-7728c44d4cea'),('a5d29f08-b938-4efa-9bac-52c66eb4941b','2022-08-31 00:00:00',NULL,'thanhcong','65de5641-cbe9-46dd-b9b8-a42a82518e79',41000,'e8cd2633-d709-4103-bcfd-7728c44d4cea'),('a98c8c1f-92f9-4b7b-9b67-f77671dedf9f','2022-08-29 00:00:00',NULL,'thanhcong','65de5641-cbe9-46dd-b9b8-a42a82518e79',51000,'650fda46-2dfb-4990-8e64-78e2cc2407c8'),('b8c0a700-a8e3-4e11-a29d-f1cd42f401ff','2022-08-31 00:00:00',NULL,'thanhcong','64c09c54-b070-4795-9704-b46392203965',111000,'650fda46-2dfb-4990-8e64-78e2cc2407c8'),('f6d36b9a-48a0-45c8-bb68-837a7ded0710','2022-08-31 00:00:00',NULL,'thanhcong','65de5641-cbe9-46dd-b9b8-a42a82518e79',41000,'e8cd2633-d709-4103-bcfd-7728c44d4cea');
/*!40000 ALTER TABLE `donhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donhang_monan`
--

DROP TABLE IF EXISTS `donhang_monan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donhang_monan` (
  `iddonhangmonan` int NOT NULL AUTO_INCREMENT,
  `iddonhang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `idmonan` int NOT NULL,
  `soluong` int NOT NULL,
  `gia` double NOT NULL,
  `tongtien` double NOT NULL,
  PRIMARY KEY (`iddonhangmonan`),
  KEY `fk_donhang_has_monan_monan1_idx` (`idmonan`),
  KEY `fk_donhang_has_monan_donhang1_idx` (`iddonhang`),
  CONSTRAINT `fk_donhang_has_monan_donhang1` FOREIGN KEY (`iddonhang`) REFERENCES `donhang` (`iddonhang`) ON DELETE CASCADE,
  CONSTRAINT `fk_donhang_has_monan_monan1` FOREIGN KEY (`idmonan`) REFERENCES `monan` (`idmonan`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donhang_monan`
--

LOCK TABLES `donhang_monan` WRITE;
/*!40000 ALTER TABLE `donhang_monan` DISABLE KEYS */;
INSERT INTO `donhang_monan` VALUES (122,'a98c8c1f-92f9-4b7b-9b67-f77671dedf9f',25,2,20000,40000),(123,'b8c0a700-a8e3-4e11-a29d-f1cd42f401ff',25,5,20000,100000),(124,'f6d36b9a-48a0-45c8-bb68-837a7ded0710',26,3,10000,30000),(125,'a5d29f08-b938-4efa-9bac-52c66eb4941b',26,3,10000,30000),(126,'70718b22-f462-4dd9-a1a2-431b3bed3ac8',26,2,10000,20000),(127,'8ed8f9ea-0a3f-4567-b449-70e96789b0f1',27,5,15000,75000),(128,'9eca6f67-b6db-4a55-bead-bf78645a754c',26,1,10000,10000);
/*!40000 ALTER TABLE `donhang_monan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaimonan`
--

DROP TABLE IF EXISTS `loaimonan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaimonan` (
  `idloaimonan` int NOT NULL AUTO_INCREMENT,
  `tenloai` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `active` tinyint(1) NOT NULL,
  `anhloaimonan` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `iduser` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idloaimonan`),
  KEY `fk_loaimonan_user` (`iduser`),
  CONSTRAINT `fk_loaimonan_user` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaimonan`
--

LOCK TABLES `loaimonan` WRITE;
/*!40000 ALTER TABLE `loaimonan` DISABLE KEYS */;
INSERT INTO `loaimonan` VALUES (15,'Trẻ em',1,'https://res.cloudinary.com/trongbui/image/upload/v1661788094/zhyh5qlnz8fk2i3hgkdf.png','64c09c54-b070-4795-9704-b46392203965'),(19,'Nước ngọt',1,'https://res.cloudinary.com/trongbui/image/upload/v1661788094/zhyh5qlnz8fk2i3hgkdf.png','64c09c54-b070-4795-9704-b46392203965'),(20,'Kẹo dẻo',1,'https://res.cloudinary.com/trongbui/image/upload/v1658997161/cld-sample-2.jpg','64c09c54-b070-4795-9704-b46392203965');
/*!40000 ALTER TABLE `loaimonan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menuthucan`
--

DROP TABLE IF EXISTS `menuthucan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menuthucan` (
  `idmenuthucan` int NOT NULL AUTO_INCREMENT,
  `tenmenu` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `active` tinyint(1) NOT NULL,
  `idcuahang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `thoidiembatdau` datetime DEFAULT NULL,
  `thoidiemketthuc` datetime DEFAULT NULL,
  PRIMARY KEY (`idmenuthucan`),
  KEY `fk_menuthucan_cuahang1_idx` (`idcuahang`),
  CONSTRAINT `fk_menuthucan_cuahang1` FOREIGN KEY (`idcuahang`) REFERENCES `cuahang` (`idcuahang`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menuthucan`
--

LOCK TABLES `menuthucan` WRITE;
/*!40000 ALTER TABLE `menuthucan` DISABLE KEYS */;
INSERT INTO `menuthucan` VALUES (19,'Menu1',1,'a288ba69-e6cc-4f81-a11e-133198487348','2022-08-17 11:33:00','2022-09-07 11:33:00'),(20,'Menu2',1,'650fda46-2dfb-4990-8e64-78e2cc2407c8','2022-09-01 00:01:00','2022-10-01 00:01:00'),(22,'Menu3',1,'650fda46-2dfb-4990-8e64-78e2cc2407c8','2022-09-01 14:12:00','2022-10-07 14:12:00'),(24,'MENUU',1,'e8cd2633-d709-4103-bcfd-7728c44d4cea','2022-09-05 00:33:00','2022-10-29 00:33:00');
/*!40000 ALTER TABLE `menuthucan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menuthucan_monan`
--

DROP TABLE IF EXISTS `menuthucan_monan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menuthucan_monan` (
  `idmenuthucanmonan` int NOT NULL AUTO_INCREMENT,
  `idmenuthucan` int NOT NULL,
  `idmonan` int NOT NULL,
  PRIMARY KEY (`idmenuthucanmonan`),
  KEY `fk_menuthucan_has_monan_monan1_idx` (`idmonan`),
  KEY `fk_menuthucan_has_monan_menuthucan1_idx` (`idmenuthucan`),
  CONSTRAINT `fk_menuthucan_has_monan_menuthucan1` FOREIGN KEY (`idmenuthucan`) REFERENCES `menuthucan` (`idmenuthucan`) ON DELETE CASCADE,
  CONSTRAINT `fk_menuthucan_has_monan_monan1` FOREIGN KEY (`idmonan`) REFERENCES `monan` (`idmonan`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menuthucan_monan`
--

LOCK TABLES `menuthucan_monan` WRITE;
/*!40000 ALTER TABLE `menuthucan_monan` DISABLE KEYS */;
INSERT INTO `menuthucan_monan` VALUES (23,20,25),(24,20,29),(25,22,25),(26,22,29),(29,24,27),(31,24,26),(32,19,31),(33,19,32);
/*!40000 ALTER TABLE `menuthucan_monan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monan`
--

DROP TABLE IF EXISTS `monan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monan` (
  `idmonan` int NOT NULL AUTO_INCREMENT,
  `tenmonan` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `gia` double NOT NULL,
  `soluong` double DEFAULT NULL,
  `thoidiemban` datetime DEFAULT NULL,
  `thoidiemketthuc` datetime DEFAULT NULL,
  `trangthai` tinyint(1) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `idcuahang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `anhmonan` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mota` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idmonan`),
  KEY `fk_monan_cuahang1_idx` (`idcuahang`),
  CONSTRAINT `fk_monan_cuahang1` FOREIGN KEY (`idcuahang`) REFERENCES `cuahang` (`idcuahang`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monan`
--

LOCK TABLES `monan` WRITE;
/*!40000 ALTER TABLE `monan` DISABLE KEYS */;
INSERT INTO `monan` VALUES (25,'Bánh trứng',20000,12,'2022-08-28 22:48:00','2022-09-29 23:48:00',1,1,'650fda46-2dfb-4990-8e64-78e2cc2407c8','https://res.cloudinary.com/trongbui/image/upload/v1661788135/lqkm3ixddectjqfftbr6.png',NULL),(26,'Mì trẻ em',10000,10,'2022-08-09 12:21:00','2022-09-10 12:21:00',1,1,'e8cd2633-d709-4103-bcfd-7728c44d4cea','https://res.cloudinary.com/trongbui/image/upload/v1662481696/iozk4tphi2tpxwbdw0ar.png',NULL),(27,'Kẹo Doraemon',15000,22,'2022-08-31 13:13:00','2022-09-10 13:13:00',1,1,'e8cd2633-d709-4103-bcfd-7728c44d4cea','https://res.cloudinary.com/trongbui/image/upload/v1662481696/iozk4tphi2tpxwbdw0ar.png',NULL),(29,'Cơm gà',120000,11,'2022-09-12 13:28:00','2022-09-24 13:28:00',1,1,'650fda46-2dfb-4990-8e64-78e2cc2407c8','https://res.cloudinary.com/trongbui/image/upload/v1658997161/cld-sample-2.jpg',NULL),(31,'Kẹo dẻo',20000,15,'2022-09-06 20:12:00','2022-09-16 20:12:00',1,1,'a288ba69-e6cc-4f81-a11e-133198487348','https://res.cloudinary.com/trongbui/image/upload/v1662556333/h0uwiyager4mufgogfpn.jpg',NULL),(32,'Coca',10000,10,'2022-09-05 20:12:00','2022-10-02 20:12:00',1,1,'a288ba69-e6cc-4f81-a11e-133198487348','https://res.cloudinary.com/trongbui/image/upload/v1662556359/vjbnurcq9drsj1yx1oc0.png',NULL);
/*!40000 ALTER TABLE `monan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monan_loaimonan`
--

DROP TABLE IF EXISTS `monan_loaimonan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monan_loaimonan` (
  `idmonanloaimonan` int NOT NULL AUTO_INCREMENT,
  `idmonan` int NOT NULL,
  `idloaimonan` int NOT NULL,
  PRIMARY KEY (`idmonanloaimonan`),
  KEY `fk_monan_has_loaimonan_loaimonan1_idx` (`idloaimonan`),
  KEY `fk_monan_has_loaimonan_monan1_idx` (`idmonan`),
  CONSTRAINT `fk_monan_has_loaimonan_loaimonan1` FOREIGN KEY (`idloaimonan`) REFERENCES `loaimonan` (`idloaimonan`) ON DELETE CASCADE,
  CONSTRAINT `fk_monan_has_loaimonan_monan1` FOREIGN KEY (`idmonan`) REFERENCES `monan` (`idmonan`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monan_loaimonan`
--

LOCK TABLES `monan_loaimonan` WRITE;
/*!40000 ALTER TABLE `monan_loaimonan` DISABLE KEYS */;
INSERT INTO `monan_loaimonan` VALUES (12,25,19),(13,26,15),(14,27,20),(16,29,19),(18,31,15),(19,32,19);
/*!40000 ALTER TABLE `monan_loaimonan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quidinh`
--

DROP TABLE IF EXISTS `quidinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quidinh` (
  `idquidinh` int NOT NULL AUTO_INCREMENT,
  `tenquidinh` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `noidung` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `iduser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `idcuahang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`idquidinh`),
  KEY `fk_quidinh_user1_idx` (`iduser`),
  KEY `fk_quidinh_cuahang1_idx` (`idcuahang`),
  CONSTRAINT `fk_quidinh_cuahang1` FOREIGN KEY (`idcuahang`) REFERENCES `cuahang` (`idcuahang`) ON DELETE SET NULL ON UPDATE RESTRICT,
  CONSTRAINT `fk_quidinh_user1` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quidinh`
--

LOCK TABLES `quidinh` WRITE;
/*!40000 ALTER TABLE `quidinh` DISABLE KEYS */;
INSERT INTO `quidinh` VALUES (3,'vanchuyen','11000','64c09c54-b070-4795-9704-b46392203965','e8cd2633-d709-4103-bcfd-7728c44d4cea',1),(4,'vanchuyen','20000','65de5641-cbe9-46dd-b9b8-a42a82518e79','a288ba69-e6cc-4f81-a11e-133198487348',1);
/*!40000 ALTER TABLE `quidinh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theodoi`
--

DROP TABLE IF EXISTS `theodoi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theodoi` (
  `idtheodoi` int NOT NULL AUTO_INCREMENT,
  `iduser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `idcuahang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `trangthai` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idtheodoi`),
  KEY `fk_user_has_cuahang_cuahang1_idx` (`idcuahang`),
  KEY `fk_user_has_cuahang_user1_idx` (`iduser`),
  CONSTRAINT `fk_user_has_cuahang_cuahang1` FOREIGN KEY (`idcuahang`) REFERENCES `cuahang` (`idcuahang`) ON DELETE CASCADE,
  CONSTRAINT `fk_user_has_cuahang_user1` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theodoi`
--

LOCK TABLES `theodoi` WRITE;
/*!40000 ALTER TABLE `theodoi` DISABLE KEYS */;
INSERT INTO `theodoi` VALUES (13,'7effceb0-4714-46be-8322-70e5788f96b0','a288ba69-e6cc-4f81-a11e-133198487348',1),(27,'64c09c54-b070-4795-9704-b46392203965','a288ba69-e6cc-4f81-a11e-133198487348',1);
/*!40000 ALTER TABLE `theodoi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thongbao`
--

DROP TABLE IF EXISTS `thongbao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thongbao` (
  `idthongbao` int NOT NULL AUTO_INCREMENT,
  `noidung` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '0',
  `iduser` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idthongbao`),
  KEY `fk_thongbao_user` (`iduser`),
  CONSTRAINT `fk_thongbao_user` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thongbao`
--

LOCK TABLES `thongbao` WRITE;
/*!40000 ALTER TABLE `thongbao` DISABLE KEYS */;
INSERT INTO `thongbao` VALUES (18,'Đăng ký cửa hàng',1,'64c09c54-b070-4795-9704-b46392203965');
/*!40000 ALTER TABLE `thongbao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tennguoidung` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `taikhoan` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `matkhau` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `gioitinh` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `sdt` int DEFAULT NULL,
  `diachi` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ngaytao` datetime NOT NULL,
  `active` tinyint(1) NOT NULL,
  `role` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `avatar` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Email_UNIQUE` (`email`),
  UNIQUE KEY `taikhoan_UNIQUE` (`taikhoan`),
  UNIQUE KEY `SDT_UNIQUE` (`sdt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('64c09c54-b070-4795-9704-b46392203965','Nguyễn Sang','sang','$2a$10$r7LzIJuFT/eHaQtWeAWBX.dzMbO8z.Mz2XybOdvNSdpb4WdLah8Hy','Nam','trongbui0927@gmail.com',1231231231,'371 Nguyễn Kiệm','2022-08-31 00:00:00',1,'ROLE_QUANLY','https://res.cloudinary.com/trongbui/image/upload/v1662296729/axcwmkleglbk4ph4vc8c.png'),('65de5641-cbe9-46dd-b9b8-a42a82518e79','Bùi Minh Trong','trong123','$2a$10$r7LzIJuFT/eHaQtWeAWBX.dzMbO8z.Mz2XybOdvNSdpb4WdLah8Hy','Nam','trongbuiou@gmail.com',123456789,'371 Nguyễn Kiệm','2022-08-29 00:00:00',1,'ROLE_ADMIN','https://res.cloudinary.com/trongbui/image/upload/v1662296992/tkzokxrxviw23bv6izq3.jpg'),('7effceb0-4714-46be-8322-70e5788f96b0','Tiến','tien1243','$2a$10$.X03ucCNE5LQgy5blnd/..ihqAahUrlEdt6U1FthTfncKcMZOIVny','Nam','ducphuc7559@gmail.com',1111111,'371 Nguyễn Kiệm22','2022-08-29 00:00:00',1,'ROLE_NGUOIDUNG','https://res.cloudinary.com/trongbui/image/upload/v1662296729/axcwmkleglbk4ph4vc8c.png');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-07 22:08:28
