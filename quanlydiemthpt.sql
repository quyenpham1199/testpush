-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 15, 2020 at 06:36 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlydiemthpt`
--

-- --------------------------------------------------------

--
-- Table structure for table `dangnhap`
--

CREATE TABLE `dangnhap` (
  `user` varchar(25) NOT NULL,
  `pass` varchar(25) NOT NULL,
  `loaitaikhoan` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dangnhap`
--

INSERT INTO `dangnhap` (`user`, `pass`, `loaitaikhoan`) VALUES
('admin', 'admin', 'ad'),
('GV1', 'GV1', 'chủ nhiệm'),
('GV2', 'GV2', 'bộ môn'),
('GV3', 'GV3', 'chủ nhiệm'),
('GV4', 'GV4', 'bộ môn'),
('GV5', 'GV5', 'bộ môn'),
('HS02', 'HS02', 'hocsinh'),
('HS03', 'HS03', 'hocsinh'),
('HS05', 'HS05', 'hocsinh'),
('HS06', 'HS06', 'hocsinh'),
('HS07', 'HS07', 'hocsinh'),
('totruong', 'totruong', 'totruong');

-- --------------------------------------------------------

--
-- Table structure for table `diem`
--

CREATE TABLE `diem` (
  `maM` varchar(25) NOT NULL,
  `maHS` varchar(25) NOT NULL,
  `hocky` varchar(25) NOT NULL,
  `diemmieng` float NOT NULL,
  `diem15` float NOT NULL,
  `diem45` float NOT NULL,
  `diemhocky` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `diem`
--

INSERT INTO `diem` (`maM`, `maHS`, `hocky`, `diemmieng`, `diem15`, `diem45`, `diemhocky`) VALUES
('M01', 'HS01', '1', 9, 9, 9, 8.5),
('M01', 'HS03', '1', 9, 9, 9, 8.5),
('M02', 'HS01', '1', 9, 9, 9, 8.5),
('M02', 'HS02', '1', 9, 9, 9, 8.5),
('M02', 'HS03', '1', 9, 9, 9, 8.5),
('M02', 'HS04', '1', 9, 9, 9, 8.5),
('M02', 'HS05', '1', 9, 9, 9, 8.5);

-- --------------------------------------------------------

--
-- Table structure for table `giaovien`
--

CREATE TABLE `giaovien` (
  `maGV` varchar(50) NOT NULL,
  `tenGV` varchar(25) NOT NULL,
  `ngaysinh` date NOT NULL,
  `diachi` varchar(25) NOT NULL,
  `gioitinh` varchar(10) NOT NULL,
  `sodienthoai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `giaovien`
--

INSERT INTO `giaovien` (`maGV`, `tenGV`, `ngaysinh`, `diachi`, `gioitinh`, `sodienthoai`) VALUES
('GV1', 'Trần Thu Trang', '2018-05-09', 'hà nội', 'Nữ', 9812356),
('GV2', 'Nguyễn Thị A', '1999-06-03', 'Văn Lâm', 'Nữ', 16465),
('GV3', 'Nguyễn Thị B', '1999-06-04', 'Văn Lâm', 'Nữ', 16465),
('GV4', 'Nguyễn Thị Kim', '1999-06-03', 'Hà Nội', 'Nữ', 16465123),
('GV5', 'Nguyễn Văn An', '1999-06-03', 'Hà Nội', 'Nam', 16465124);

--
-- Triggers `giaovien`
--
DELIMITER $$
CREATE TRIGGER `tg_giaovien_delete` AFTER DELETE ON `giaovien` FOR EACH ROW DELETE FROM dangnhap WHERE dangnhap.user=Old.maGV
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `tg_giaovien_insert` AFTER INSERT ON `giaovien` FOR EACH ROW Insert into dangnhap (`user`, `pass`, `loaitaikhoan`) VALUES(New.maGV,New.maGV,'giaovien')
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `hocky`
--

CREATE TABLE `hocky` (
  `hocky` varchar(4) NOT NULL,
  `maHS` varchar(25) NOT NULL,
  `renluyen` varchar(25) NOT NULL,
  `khenthuong` varchar(25) NOT NULL,
  `totnghiep` varchar(25) NOT NULL,
  `namhoc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hocky`
--

INSERT INTO `hocky` (`hocky`, `maHS`, `renluyen`, `khenthuong`, `totnghiep`, `namhoc`) VALUES
('1', 'HS01', 'Tot', 'Khá', 'Tot nghiep', 2020),
('1', 'HS02', 'tot', 'Gioi', 'tot nghiep', 2020),
('1', 'HS04', 'Tot', 'Gioi', 'Tot nghiep', 2020);

-- --------------------------------------------------------

--
-- Table structure for table `hocsinh`
--

CREATE TABLE `hocsinh` (
  `maHS` varchar(50) NOT NULL,
  `maLop` varchar(25) NOT NULL,
  `tenHS` varchar(25) NOT NULL,
  `ngaysinh` date NOT NULL,
  `diachi` varchar(25) NOT NULL,
  `maM` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hocsinh`
--

INSERT INTO `hocsinh` (`maHS`, `maLop`, `tenHS`, `ngaysinh`, `diachi`, `maM`) VALUES
('HS01', 'L01', 'Văn Nam', '1999-01-01', 'Văn Lâm', 'M01'),
('HS02', 'L01', 'Văn Lâm', '1999-06-03', 'Văn Lâm', 'M01'),
('HS03', 'L01', 'Văn Nam', '1999-06-03', 'Văn Lâm', 'M01'),
('HS04', 'L01', 'trần thu hằng', '2020-06-02', 'hà nội', 'M01'),
('HS05', 'L02', 'Nguyễn Văn B', '1999-06-03', 'Văn Lâm', 'M02'),
('HS06', 'L02', 'Nguyễn Văn C', '1999-12-04', 'Văn Lâm', 'M02'),
('HS07', 'L01', 'trần thu hằng', '2020-06-02', 'hà nội', 'M01');

--
-- Triggers `hocsinh`
--
DELIMITER $$
CREATE TRIGGER `tg_hocsinh_delete` AFTER DELETE ON `hocsinh` FOR EACH ROW DELETE FROM dangnhap WHERE dangnhap.USER=OLD.maHS
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `tg_hocsinh_insert` AFTER INSERT ON `hocsinh` FOR EACH ROW INSERT INTO dangnhap (`user`, `pass`, `loaitaikhoan`)VALUES(New.maHS,New.maHS,'hocsinh')
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `lop`
--

CREATE TABLE `lop` (
  `maLop` varchar(25) NOT NULL,
  `tenLop` varchar(25) NOT NULL,
  `maGV` varchar(50) NOT NULL,
  `siso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lop`
--

INSERT INTO `lop` (`maLop`, `tenLop`, `maGV`, `siso`) VALUES
('L01', '10A1', 'GV1', 30),
('L02', '10A2', 'GV1', 30),
('L03', '10A3', 'GV3', 31),
('L04', '10A4', 'GV4', 31);

-- --------------------------------------------------------

--
-- Table structure for table `mon`
--

CREATE TABLE `mon` (
  `maM` varchar(25) NOT NULL,
  `tenM` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mon`
--

INSERT INTO `mon` (`maM`, `tenM`) VALUES
('M01', 'Địa lý'),
('M02', 'Toán'),
('M03', 'Hoá'),
('M04', 'Vật lý'),
('M05', 'Tin học');

-- --------------------------------------------------------

--
-- Table structure for table `phancong`
--

CREATE TABLE `phancong` (
  `maGV` varchar(50) NOT NULL,
  `maLop` varchar(25) NOT NULL,
  `chucvu` varchar(50) NOT NULL,
  `maM` varchar(25) NOT NULL,
  `maPC` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `phancong`
--

INSERT INTO `phancong` (`maGV`, `maLop`, `chucvu`, `maM`, `maPC`) VALUES
('GV1', 'L01', 'chủ nhiệm', 'M01', 'PC01'),
('GV2', 'L01', 'bộ môn', 'M01', 'PC02'),
('GV3', 'L02', 'chủ nhiệm', 'M04', 'PC03'),
('GV4', 'L02', 'bộ môn', 'M05', 'PC04'),
('GV5', 'L02', 'bộ môn', 'M02', 'PC05');

--
-- Triggers `phancong`
--
DELIMITER $$
CREATE TRIGGER `tg_phancong_insert` AFTER INSERT ON `phancong` FOR EACH ROW UPDATE dangnhap set dangnhap.loaitaikhoan=NEW.chucvu WHERE NEW.maGV=dangnhap.user
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dangnhap`
--
ALTER TABLE `dangnhap`
  ADD PRIMARY KEY (`user`);

--
-- Indexes for table `diem`
--
ALTER TABLE `diem`
  ADD PRIMARY KEY (`maM`,`maHS`),
  ADD KEY `maHS` (`maHS`),
  ADD KEY `maM` (`maM`),
  ADD KEY `hocky` (`hocky`);

--
-- Indexes for table `giaovien`
--
ALTER TABLE `giaovien`
  ADD PRIMARY KEY (`maGV`);

--
-- Indexes for table `hocky`
--
ALTER TABLE `hocky`
  ADD PRIMARY KEY (`hocky`,`maHS`),
  ADD KEY `maHS` (`maHS`);

--
-- Indexes for table `hocsinh`
--
ALTER TABLE `hocsinh`
  ADD PRIMARY KEY (`maHS`),
  ADD KEY `maLop` (`maLop`),
  ADD KEY `maM` (`maM`);

--
-- Indexes for table `lop`
--
ALTER TABLE `lop`
  ADD PRIMARY KEY (`maLop`),
  ADD KEY `maGV` (`maGV`);

--
-- Indexes for table `mon`
--
ALTER TABLE `mon`
  ADD PRIMARY KEY (`maM`);

--
-- Indexes for table `phancong`
--
ALTER TABLE `phancong`
  ADD PRIMARY KEY (`maPC`),
  ADD KEY `maGV` (`maGV`),
  ADD KEY `maLop` (`maLop`),
  ADD KEY `maM` (`maM`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `diem`
--
ALTER TABLE `diem`
  ADD CONSTRAINT `diem_ibfk_1` FOREIGN KEY (`maM`) REFERENCES `mon` (`maM`),
  ADD CONSTRAINT `diem_ibfk_2` FOREIGN KEY (`maHS`) REFERENCES `hocsinh` (`maHS`);

--
-- Constraints for table `hocky`
--
ALTER TABLE `hocky`
  ADD CONSTRAINT `hocky_ibfk_1` FOREIGN KEY (`maHS`) REFERENCES `hocsinh` (`maHS`);

--
-- Constraints for table `hocsinh`
--
ALTER TABLE `hocsinh`
  ADD CONSTRAINT `hocsinh_ibfk_1` FOREIGN KEY (`maLop`) REFERENCES `lop` (`maLop`),
  ADD CONSTRAINT `hocsinh_ibfk_2` FOREIGN KEY (`maM`) REFERENCES `mon` (`maM`);

--
-- Constraints for table `lop`
--
ALTER TABLE `lop`
  ADD CONSTRAINT `lop_ibfk_1` FOREIGN KEY (`maGV`) REFERENCES `giaovien` (`maGV`);

--
-- Constraints for table `phancong`
--
ALTER TABLE `phancong`
  ADD CONSTRAINT `phancong_ibfk_1` FOREIGN KEY (`maGV`) REFERENCES `giaovien` (`maGV`),
  ADD CONSTRAINT `phancong_ibfk_2` FOREIGN KEY (`maLop`) REFERENCES `lop` (`maLop`),
  ADD CONSTRAINT `phancong_ibfk_3` FOREIGN KEY (`maM`) REFERENCES `mon` (`maM`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
