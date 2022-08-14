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
  `idcuahang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `idmonan` int NOT NULL,
  PRIMARY KEY (`idbinhluan`),
  KEY `fk_binhluan_user1_idx` (`iduser`),
  KEY `fk_binhluan_cuahang1_idx` (`idcuahang`),
  KEY `fk_binhluan_monan1_idx` (`idmonan`),
  CONSTRAINT `fk_binhluan_cuahang1` FOREIGN KEY (`idcuahang`) REFERENCES `cuahang` (`idcuahang`),
  CONSTRAINT `fk_binhluan_monan1` FOREIGN KEY (`idmonan`) REFERENCES `monan` (`idmonan`),
  CONSTRAINT `fk_binhluan_user1` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `binhluan`
--

LOCK TABLES `binhluan` WRITE;
/*!40000 ALTER TABLE `binhluan` DISABLE KEYS */;
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
  PRIMARY KEY (`idcuahang`),
  KEY `fk_cuahang_user_idx` (`iduser`),
  CONSTRAINT `fk_cuahang_user` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuahang`
--

LOCK TABLES `cuahang` WRITE;
/*!40000 ALTER TABLE `cuahang` DISABLE KEYS */;
INSERT INTO `cuahang` VALUES ('1','Cháo Húp','371 Nguyễn Kiệm','1',1,'https://res.cloudinary.com/trongbui/image/upload/v1658997162/cld-sample-4.jpg'),('2','Bean','371 Nguyễn Kiệm','1',1,'https://res.cloudinary.com/trongbui/image/upload/v1658997162/cld-sample-4.jpg');
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
  PRIMARY KEY (`iddanhgia`),
  KEY `fk_danhgia_monan1_idx` (`idmonan`),
  KEY `fk_danhgia_cuahang1_idx` (`idcuahang`),
  KEY `fk_danhgia_user1_idx` (`iduser`),
  CONSTRAINT `fk_danhgia_cuahang1` FOREIGN KEY (`idcuahang`) REFERENCES `cuahang` (`idcuahang`),
  CONSTRAINT `fk_danhgia_monan1` FOREIGN KEY (`idmonan`) REFERENCES `monan` (`idmonan`),
  CONSTRAINT `fk_danhgia_user1` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhgia`
--

LOCK TABLES `danhgia` WRITE;
/*!40000 ALTER TABLE `danhgia` DISABLE KEYS */;
INSERT INTO `danhgia` VALUES (1,5,1,NULL,'1'),(2,10,4,NULL,'1'),(3,1,3,NULL,'1'),(4,11,2,NULL,'1'),(5,2,5,NULL,'1'),(6,9,NULL,'1','1'),(7,1,NULL,'2','1'),(8,7,NULL,'2','2'),(9,22,7,NULL,'2'),(10,22,8,NULL,'2'),(11,22,9,NULL,'2');
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
  PRIMARY KEY (`iddonhang`),
  KEY `fk_donhang_user1_idx` (`iduser`),
  CONSTRAINT `fk_donhang_user1` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donhang`
--

LOCK TABLES `donhang` WRITE;
/*!40000 ALTER TABLE `donhang` DISABLE KEYS */;
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
  CONSTRAINT `fk_donhang_has_monan_donhang1` FOREIGN KEY (`iddonhang`) REFERENCES `donhang` (`iddonhang`),
  CONSTRAINT `fk_donhang_has_monan_monan1` FOREIGN KEY (`idmonan`) REFERENCES `monan` (`idmonan`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donhang_monan`
--

LOCK TABLES `donhang_monan` WRITE;
/*!40000 ALTER TABLE `donhang_monan` DISABLE KEYS */;
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
  PRIMARY KEY (`idloaimonan`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaimonan`
--

LOCK TABLES `loaimonan` WRITE;
/*!40000 ALTER TABLE `loaimonan` DISABLE KEYS */;
INSERT INTO `loaimonan` VALUES (1,'Ăn chơi',1,'https://res.cloudinary.com/trongbui/image/upload/v1659002907/kuakata_dtuybb.png'),(2,'Nhanh',1,'https://res.cloudinary.com/trongbui/image/upload/v1659002907/kuakata_dtuybb.png'),(3,'Bò',1,'https://res.cloudinary.com/trongbui/image/upload/v1659002907/kuakata_dtuybb.png'),(4,'Gà',1,'https://res.cloudinary.com/trongbui/image/upload/v1659002907/kuakata_dtuybb.png'),(5,'Cơm',1,'https://res.cloudinary.com/trongbui/image/upload/v1659002907/kuakata_dtuybb.png'),(6,'Lẩu',1,'https://res.cloudinary.com/trongbui/image/upload/v1659002907/kuakata_dtuybb.png');
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
  `active` tinyint(1) NOT NULL,
  `idcuahang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`idmenuthucan`),
  KEY `fk_menuthucan_cuahang1_idx` (`idcuahang`),
  CONSTRAINT `fk_menuthucan_cuahang1` FOREIGN KEY (`idcuahang`) REFERENCES `cuahang` (`idcuahang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menuthucan`
--

LOCK TABLES `menuthucan` WRITE;
/*!40000 ALTER TABLE `menuthucan` DISABLE KEYS */;
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
  CONSTRAINT `fk_menuthucan_has_monan_menuthucan1` FOREIGN KEY (`idmenuthucan`) REFERENCES `menuthucan` (`idmenuthucan`),
  CONSTRAINT `fk_menuthucan_has_monan_monan1` FOREIGN KEY (`idmonan`) REFERENCES `monan` (`idmonan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menuthucan_monan`
--

LOCK TABLES `menuthucan_monan` WRITE;
/*!40000 ALTER TABLE `menuthucan_monan` DISABLE KEYS */;
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
  PRIMARY KEY (`idmonan`),
  KEY `fk_monan_cuahang1_idx` (`idcuahang`),
  CONSTRAINT `fk_monan_cuahang1` FOREIGN KEY (`idcuahang`) REFERENCES `cuahang` (`idcuahang`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monan`
--

LOCK TABLES `monan` WRITE;
/*!40000 ALTER TABLE `monan` DISABLE KEYS */;
INSERT INTO `monan` VALUES (1,'Bánh',20000,12,'2022-07-30 00:00:00','2022-08-12 00:00:00',1,1,'2','https://res.cloudinary.com/trongbui/image/upload/v1659002907/kuakata_dtuybb.png'),(2,'Cơm',32000,33,'2022-07-30 00:00:00','2022-08-12 00:00:00',1,1,'1','https://res.cloudinary.com/trongbui/image/upload/v1659002907/kuakata_dtuybb.png'),(3,'Bánh Tráng',10000,22,'2022-07-31 00:00:00','2022-09-12 00:00:00',1,1,'1','https://res.cloudinary.com/trongbui/image/upload/v1659002907/kuakata_dtuybb.png'),(4,'Bún Chả',10000,12,'2022-07-31 00:00:00','2022-09-13 00:00:00',1,1,'1','https://res.cloudinary.com/trongbui/image/upload/v1659002907/kuakata_dtuybb.png'),(5,'Hủ Tiếu',10000,10000,'2022-08-13 00:00:00','2022-09-13 00:00:00',1,1,'1','https://res.cloudinary.com/trongbui/image/upload/v1659002907/kuakata_dtuybb.png'),(6,'Bánh',20000,12,'2022-07-30 00:00:00','2022-08-12 00:00:00',1,1,'2','https://res.cloudinary.com/trongbui/image/upload/v1659002907/kuakata_dtuybb.png'),(7,'Cơm',32000,33,'2022-07-30 00:00:00','2022-08-12 00:00:00',1,1,'1','https://res.cloudinary.com/trongbui/image/upload/v1659002907/kuakata_dtuybb.png'),(8,'Bánh Tráng',10000,22,'2022-07-31 00:00:00','2022-09-12 00:00:00',1,1,'1','https://res.cloudinary.com/trongbui/image/upload/v1659002907/kuakata_dtuybb.png'),(9,'Bún Chả',10000,12,'2022-07-31 00:00:00','2022-09-13 00:00:00',1,1,'1','https://res.cloudinary.com/trongbui/image/upload/v1659002907/kuakata_dtuybb.png'),(10,'Hủ Tiếu',10000,10000,'2022-08-13 00:00:00','2022-09-13 00:00:00',1,1,'1','https://res.cloudinary.com/trongbui/image/upload/v1659002907/kuakata_dtuybb.png');
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
  CONSTRAINT `fk_monan_has_loaimonan_loaimonan1` FOREIGN KEY (`idloaimonan`) REFERENCES `loaimonan` (`idloaimonan`),
  CONSTRAINT `fk_monan_has_loaimonan_monan1` FOREIGN KEY (`idmonan`) REFERENCES `monan` (`idmonan`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monan_loaimonan`
--

LOCK TABLES `monan_loaimonan` WRITE;
/*!40000 ALTER TABLE `monan_loaimonan` DISABLE KEYS */;
INSERT INTO `monan_loaimonan` VALUES (1,1,1),(2,2,2);
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
  `noidung` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `iduser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `idcuahang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`idquidinh`),
  KEY `fk_quidinh_user1_idx` (`iduser`),
  KEY `fk_quidinh_cuahang1_idx` (`idcuahang`),
  CONSTRAINT `fk_quidinh_cuahang1` FOREIGN KEY (`idcuahang`) REFERENCES `cuahang` (`idcuahang`),
  CONSTRAINT `fk_quidinh_user1` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quidinh`
--

LOCK TABLES `quidinh` WRITE;
/*!40000 ALTER TABLE `quidinh` DISABLE KEYS */;
INSERT INTO `quidinh` VALUES (1,'vanchuyen','32000','1','1',1),(2,'vanchuyen','11000','1','2',1);
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
  CONSTRAINT `fk_user_has_cuahang_cuahang1` FOREIGN KEY (`idcuahang`) REFERENCES `cuahang` (`idcuahang`),
  CONSTRAINT `fk_user_has_cuahang_user1` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theodoi`
--

LOCK TABLES `theodoi` WRITE;
/*!40000 ALTER TABLE `theodoi` DISABLE KEYS */;
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
  CONSTRAINT `fk_thongbao_user` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thongbao`
--

LOCK TABLES `thongbao` WRITE;
/*!40000 ALTER TABLE `thongbao` DISABLE KEYS */;
INSERT INTO `thongbao` VALUES (3,'Đăng ký cửa hàng',1,'34aa82d9-4f8e-4858-a9be-e52f63898b21'),(4,'Đăng ký cửa hàng',1,'34aa82d9-4f8e-4858-a9be-e52f63898b21'),(5,'Đăng ký cửa hàng',1,'2');
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
INSERT INTO `user` VALUES ('1','trong','trong123','$2a$10$dGpeIWOJbLJ7YG3AJwcOPu88i8a6/LCmIgwkohzrhp.XXvAcU9B3O','nam','âmmama',123456789,'sda','2022-02-02 00:00:00',1,'QUANLY',NULL),('2','sang','trong2','$2a$10$dGpeIWOJbLJ7YG3AJwcOPu88i8a6/LCmIgwkohzrhp.XXvAcU9B3O','nam','âmmamas',1234567,'sda','2022-02-02 00:00:00',1,'NGUOIDUNG','https://res.cloudinary.com/trongbui/image/upload/v1659634275/nigzp5moxi1ohz4hkstl.png'),('34aa82d9-4f8e-4858-a9be-e52f63898b21','Bùi Minh Trong','re','$2a$10$OmRqy9Wuuf0ICZUAjRuo7ecaq5oy1bs00M/ymLYP7ks5orqciQiNC',NULL,'pppppp@gmail.com',112233,'123112','2022-08-05 00:00:00',1,'NGUOIDUNG','https://res.cloudinary.com/trongbui/image/upload/v1659634275/nigzp5moxi1ohz4hkstl.png'),('7c22e979-f649-421c-8125-2dc8bd33afb0','Minh Thùy','thuy','$2a$10$OmRqy9Wuuf0ICZUAjRuo7ecaq5oy1bs00M/ymLYP7ks5orqciQiNC',NULL,'thuy@gmail.com',1123112312,'dâdasdadsad','2022-08-11 00:00:00',1,'NGUOIDUNG','https://res.cloudinary.com/trongbui/image/upload/v1660215129/fr7gyzyqofi78ioclhz0.png');
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

-- Dump completed on 2022-08-11 23:16:22
