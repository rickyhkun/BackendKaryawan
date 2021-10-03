-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 03, 2021 at 04:10 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `karyawan`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_karyawan`
--

CREATE TABLE `tbl_karyawan` (
  `kode_karyawan` varchar(20) NOT NULL,
  `nama_karyawan` varchar(50) NOT NULL,
  `tgl_masuk` date NOT NULL,
  `no_hp` varchar(20) NOT NULL,
  `limit_reimbursement` int(11) NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_karyawan`
--

INSERT INTO `tbl_karyawan` (`kode_karyawan`, `nama_karyawan`, `tgl_masuk`, `no_hp`, `limit_reimbursement`, `created_date`, `updated_date`) VALUES
('K-000', 'Kristianto', '2021-09-01', '089111222333', 2000000, '2021-09-01 00:00:00', '2021-09-30 14:16:25'),
('K-001', 'Ricky Hadi', '2021-09-02', '089222333444', 2000000, '2021-09-02 00:00:00', '2021-09-30 14:17:07'),
('K-002', 'Putri', '2021-09-02', '089333444555', 2000000, '2021-09-30 12:57:11', '2021-09-30 14:17:55'),
('K-003', 'Ricky', '2021-09-02', '089333444555', 2000000, '2021-10-03 13:34:01', '2021-10-03 13:34:01');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_karyawan`
--
ALTER TABLE `tbl_karyawan`
  ADD PRIMARY KEY (`kode_karyawan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
