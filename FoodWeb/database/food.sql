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
  `IDBinhLuan` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `NoiDung` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `IDUser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `IDCuaHang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `IDMonAn` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`IDBinhLuan`,`IDUser`,`IDCuaHang`,`IDMonAn`),
  KEY `fk_binhluan_user1_idx` (`IDUser`),
  KEY `fk_binhluan_cuahang1_idx` (`IDCuaHang`),
  KEY `fk_binhluan_monan1_idx` (`IDMonAn`),
  CONSTRAINT `fk_binhluan_cuahang1` FOREIGN KEY (`IDCuaHang`) REFERENCES `cuahang` (`IDCuaHang`),
  CONSTRAINT `fk_binhluan_monan1` FOREIGN KEY (`IDMonAn`) REFERENCES `monan` (`IDMonAn`),
  CONSTRAINT `fk_binhluan_user1` FOREIGN KEY (`IDUser`) REFERENCES `user` (`ID`)
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
  `IDCuaHang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenCuaHang` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `DiaChi` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `IDUser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`IDCuaHang`,`IDUser`),
  KEY `fk_cuahang_user_idx` (`IDUser`),
  CONSTRAINT `fk_cuahang_user` FOREIGN KEY (`IDUser`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuahang`
--

LOCK TABLES `cuahang` WRITE;
/*!40000 ALTER TABLE `cuahang` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuahang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danhgia`
--

DROP TABLE IF EXISTS `danhgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danhgia` (
  `IDDanhGia` int NOT NULL,
  `Sao` double NOT NULL,
  `IDMonAn` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `IDCuaHang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `IDUser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`IDDanhGia`,`IDMonAn`,`IDCuaHang`,`IDUser`),
  KEY `fk_danhgia_monan1_idx` (`IDMonAn`),
  KEY `fk_danhgia_cuahang1_idx` (`IDCuaHang`),
  KEY `fk_danhgia_user1_idx` (`IDUser`),
  CONSTRAINT `fk_danhgia_cuahang1` FOREIGN KEY (`IDCuaHang`) REFERENCES `cuahang` (`IDCuaHang`),
  CONSTRAINT `fk_danhgia_monan1` FOREIGN KEY (`IDMonAn`) REFERENCES `monan` (`IDMonAn`),
  CONSTRAINT `fk_danhgia_user1` FOREIGN KEY (`IDUser`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhgia`
--

LOCK TABLES `danhgia` WRITE;
/*!40000 ALTER TABLE `danhgia` DISABLE KEYS */;
/*!40000 ALTER TABLE `danhgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donhang`
--

DROP TABLE IF EXISTS `donhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donhang` (
  `IDDonHang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgayTao` datetime NOT NULL,
  `SoLuong` double NOT NULL,
  `ThanhTien` double NOT NULL,
  `KhuyenMai` double DEFAULT NULL,
  `TrangThai` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `IDUser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `IDCuaHang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`IDDonHang`,`IDUser`,`IDCuaHang`),
  KEY `fk_donhang_user1_idx` (`IDUser`),
  KEY `fk_donhang_cuahang1_idx` (`IDCuaHang`),
  CONSTRAINT `fk_donhang_cuahang1` FOREIGN KEY (`IDCuaHang`) REFERENCES `cuahang` (`IDCuaHang`),
  CONSTRAINT `fk_donhang_user1` FOREIGN KEY (`IDUser`) REFERENCES `user` (`ID`)
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
  `IDDonHang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `IDMonAn` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoLuong` int NOT NULL,
  PRIMARY KEY (`IDDonHang`,`IDMonAn`),
  KEY `fk_donhang_has_monan_monan1_idx` (`IDMonAn`),
  KEY `fk_donhang_has_monan_donhang1_idx` (`IDDonHang`),
  CONSTRAINT `fk_donhang_has_monan_donhang1` FOREIGN KEY (`IDDonHang`) REFERENCES `donhang` (`IDDonHang`),
  CONSTRAINT `fk_donhang_has_monan_monan1` FOREIGN KEY (`IDMonAn`) REFERENCES `monan` (`IDMonAn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
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
  `IDLoaiMonAn` int NOT NULL,
  `TenLoai` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Active` tinyint(1) NOT NULL,
  PRIMARY KEY (`IDLoaiMonAn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaimonan`
--

LOCK TABLES `loaimonan` WRITE;
/*!40000 ALTER TABLE `loaimonan` DISABLE KEYS */;
/*!40000 ALTER TABLE `loaimonan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menuthucan`
--

DROP TABLE IF EXISTS `menuthucan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menuthucan` (
  `IDMenuThucAn` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Active` tinyint(1) NOT NULL,
  `IDCuaHang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`IDMenuThucAn`,`IDCuaHang`),
  KEY `fk_menuthucan_cuahang1_idx` (`IDCuaHang`),
  CONSTRAINT `fk_menuthucan_cuahang1` FOREIGN KEY (`IDCuaHang`) REFERENCES `cuahang` (`IDCuaHang`)
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
  `IDMenuThucAn` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `IDMonAn` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`IDMenuThucAn`,`IDMonAn`),
  KEY `fk_menuthucan_has_monan_monan1_idx` (`IDMonAn`),
  KEY `fk_menuthucan_has_monan_menuthucan1_idx` (`IDMenuThucAn`),
  CONSTRAINT `fk_menuthucan_has_monan_menuthucan1` FOREIGN KEY (`IDMenuThucAn`) REFERENCES `menuthucan` (`IDMenuThucAn`),
  CONSTRAINT `fk_menuthucan_has_monan_monan1` FOREIGN KEY (`IDMonAn`) REFERENCES `monan` (`IDMonAn`)
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
  `IDMonAn` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenMonAn` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Gia` double NOT NULL,
  `SoLuong` double DEFAULT NULL,
  `ThoiDiemBan` datetime DEFAULT NULL,
  `ThoiDiemKetThuc` double DEFAULT NULL,
  `TrangThai` tinyint(1) NOT NULL,
  `Active` tinyint(1) NOT NULL,
  `IDCuaHang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`IDMonAn`,`IDCuaHang`),
  KEY `fk_monan_cuahang1_idx` (`IDCuaHang`),
  CONSTRAINT `fk_monan_cuahang1` FOREIGN KEY (`IDCuaHang`) REFERENCES `cuahang` (`IDCuaHang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monan`
--

LOCK TABLES `monan` WRITE;
/*!40000 ALTER TABLE `monan` DISABLE KEYS */;
/*!40000 ALTER TABLE `monan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monan_loaimonan`
--

DROP TABLE IF EXISTS `monan_loaimonan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monan_loaimonan` (
  `IDMonAn` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `IDLoaiMonAn` int NOT NULL,
  PRIMARY KEY (`IDMonAn`,`IDLoaiMonAn`),
  KEY `fk_monan_has_loaimonan_loaimonan1_idx` (`IDLoaiMonAn`),
  KEY `fk_monan_has_loaimonan_monan1_idx` (`IDMonAn`),
  CONSTRAINT `fk_monan_has_loaimonan_loaimonan1` FOREIGN KEY (`IDLoaiMonAn`) REFERENCES `loaimonan` (`IDLoaiMonAn`),
  CONSTRAINT `fk_monan_has_loaimonan_monan1` FOREIGN KEY (`IDMonAn`) REFERENCES `monan` (`IDMonAn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monan_loaimonan`
--

LOCK TABLES `monan_loaimonan` WRITE;
/*!40000 ALTER TABLE `monan_loaimonan` DISABLE KEYS */;
/*!40000 ALTER TABLE `monan_loaimonan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quidinh`
--

DROP TABLE IF EXISTS `quidinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quidinh` (
  `IDQuiDinh` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenQuiDinh` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `NoiDung` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `IDUser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `IDCuaHang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`IDQuiDinh`,`IDUser`,`IDCuaHang`),
  KEY `fk_quidinh_user1_idx` (`IDUser`),
  KEY `fk_quidinh_cuahang1_idx` (`IDCuaHang`),
  CONSTRAINT `fk_quidinh_cuahang1` FOREIGN KEY (`IDCuaHang`) REFERENCES `cuahang` (`IDCuaHang`),
  CONSTRAINT `fk_quidinh_user1` FOREIGN KEY (`IDUser`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quidinh`
--

LOCK TABLES `quidinh` WRITE;
/*!40000 ALTER TABLE `quidinh` DISABLE KEYS */;
/*!40000 ALTER TABLE `quidinh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theodoi`
--

DROP TABLE IF EXISTS `theodoi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theodoi` (
  `IDUser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `IDCuaHang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `TrangThai` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`IDUser`,`IDCuaHang`),
  KEY `fk_user_has_cuahang_cuahang1_idx` (`IDCuaHang`),
  KEY `fk_user_has_cuahang_user1_idx` (`IDUser`),
  CONSTRAINT `fk_user_has_cuahang_cuahang1` FOREIGN KEY (`IDCuaHang`) REFERENCES `cuahang` (`IDCuaHang`),
  CONSTRAINT `fk_user_has_cuahang_user1` FOREIGN KEY (`IDUser`) REFERENCES `user` (`ID`)
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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenNguoiDung` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `TaiKhoan` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `MatKhau` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `GioiTinh` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `SDT` int DEFAULT NULL,
  `DiaChi` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `NgayTao` datetime NOT NULL,
  `Active` tinyint(1) NOT NULL,
  `Role` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Email_UNIQUE` (`Email`),
  UNIQUE KEY `SDT_UNIQUE` (`SDT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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

-- Dump completed on 2022-07-22 16:33:56
