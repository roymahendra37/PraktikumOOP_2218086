-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 17, 2023 at 08:24 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oop_2218086`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_batalsewa`
--

CREATE TABLE `tb_batalsewa` (
  `id` int NOT NULL,
  `nama` varchar(100) NOT NULL,
  `durasi` int NOT NULL,
  `denda` int NOT NULL,
  `admin` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tb_batalsewa`
--

INSERT INTO `tb_batalsewa` (`id`, `nama`, `durasi`, `denda`, `admin`) VALUES
(10, 'Leonardo', 2, 10000, 'Doni');

-- --------------------------------------------------------

--
-- Table structure for table `tb_mahasiswa`
--

CREATE TABLE `tb_mahasiswa` (
  `id` int NOT NULL,
  `nim` varchar(7) COLLATE utf8mb4_general_ci NOT NULL,
  `nama` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `jk` varchar(1) COLLATE utf8mb4_general_ci NOT NULL,
  `prodi` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `th_angkatan` varchar(4) COLLATE utf8mb4_general_ci NOT NULL,
  `alamat` varchar(250) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tb_mahasiswa`
--

INSERT INTO `tb_mahasiswa` (`id`, `nim`, `nama`, `jk`, `prodi`, `th_angkatan`, `alamat`) VALUES
(1, '2218086', 'Roy', 'L', 'Informatika', '2022', 'SIdoarjo'),
(3, '2218085', 'Paul', 'L', 'Informatika', '2022', 'Batu'),
(4, '2218084', 'Leonardo', 'L', 'Informatika', '2022', 'Malang');

-- --------------------------------------------------------

--
-- Table structure for table `tb_matkul`
--

CREATE TABLE `tb_matkul` (
  `id` int NOT NULL,
  `kode_mk` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `matakuliah` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `dosenpengajar` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `jmlsks` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tb_matkul`
--

INSERT INTO `tb_matkul` (`id`, `kode_mk`, `matakuliah`, `dosenpengajar`, `jmlsks`) VALUES
(3, 'IF403', 'Object Oriented Programming', 'Yosef Agus', 4);

-- --------------------------------------------------------

--
-- Table structure for table `tb_nilai`
--

CREATE TABLE `tb_nilai` (
  `id` int NOT NULL,
  `Nim` varchar(7) COLLATE utf8mb4_general_ci NOT NULL,
  `kd_mk` varchar(6) COLLATE utf8mb4_general_ci NOT NULL,
  `NP1` int NOT NULL,
  `NP2` int NOT NULL,
  `UTS` int NOT NULL,
  `NP3` int NOT NULL,
  `prak` int NOT NULL,
  `UAS` int NOT NULL,
  `NA` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tb_nilai`
--

INSERT INTO `tb_nilai` (`id`, `Nim`, `kd_mk`, `NP1`, `NP2`, `UTS`, `NP3`, `prak`, `UAS`, `NA`) VALUES
(1, '2218086', 'IF403', 80, 85, 85, 85, 85, 85, 88),
(2, '2218084', 'IF403', 80, 80, 80, 80, 80, 80, 80);

-- --------------------------------------------------------

--
-- Table structure for table `tb_sewastudio`
--

CREATE TABLE `tb_sewastudio` (
  `id` int NOT NULL,
  `nama` varchar(100) NOT NULL,
  `tlp` varchar(13) NOT NULL,
  `tgl` varchar(2) NOT NULL,
  `bln` varchar(20) NOT NULL,
  `thn` varchar(4) NOT NULL,
  `jam` varchar(10) NOT NULL,
  `durasi` int NOT NULL,
  `jenis` varchar(10) NOT NULL,
  `biaya` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tb_sewastudio`
--

INSERT INTO `tb_sewastudio` (`id`, `nama`, `tlp`, `tgl`, `bln`, `thn`, `jam`, `durasi`, `jenis`, `biaya`) VALUES
(1, 'Roy', '08885343', '23', 'desember', '2023', '10.00', 2, 'Biasa', 90000),
(4, 'Paul', '085688743', '12', 'januari', '2024', '18.00', 1, 'Lengkap', 55000),
(5, 'Leonardo', '088823643', '02', 'januari', '2024', '09.00', 2, 'Lengkap', 110000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_batalsewa`
--
ALTER TABLE `tb_batalsewa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_mahasiswa`
--
ALTER TABLE `tb_mahasiswa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_matkul`
--
ALTER TABLE `tb_matkul`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_nilai`
--
ALTER TABLE `tb_nilai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_sewastudio`
--
ALTER TABLE `tb_sewastudio`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_batalsewa`
--
ALTER TABLE `tb_batalsewa`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `tb_mahasiswa`
--
ALTER TABLE `tb_mahasiswa`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tb_matkul`
--
ALTER TABLE `tb_matkul`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tb_nilai`
--
ALTER TABLE `tb_nilai`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tb_sewastudio`
--
ALTER TABLE `tb_sewastudio`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
