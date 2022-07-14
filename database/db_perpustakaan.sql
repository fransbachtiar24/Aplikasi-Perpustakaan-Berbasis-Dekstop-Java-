-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2022 at 07:01 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_perpustakaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id_buku` int(11) NOT NULL,
  `kode_buku` char(5) NOT NULL,
  `judul_buku` varchar(50) DEFAULT NULL,
  `penulis_buku` varchar(50) DEFAULT NULL,
  `penerbit_buku` varchar(50) NOT NULL,
  `tahun_terbit` char(4) NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id_buku`, `kode_buku`, `judul_buku`, `penulis_buku`, `penerbit_buku`, `tahun_terbit`, `stok`) VALUES
(34, 'B001', 'Apikasi Java Netbeans', 'Jhon Wick', 'PT.Media', '2021', 150),
(37, 'B002', 'Aplikasi IOS', 'Frans Bacthiar', 'PT.Media', '2020', 150),
(54, 'B003', 'Aplikasi Android', 'Google', 'Google,inc', '2008', 100),
(55, 'B004', 'FriendZone', 'Riki Chandra', 'PT.SADBOY', '2020', 100),
(63, 'B005', 'FriendZone V2', 'Riki Chandra', 'PT.SADBOY', '2021', 100);

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id_karyawan` int(11) NOT NULL,
  `nama_karyawan` varchar(50) DEFAULT NULL,
  `jabatan` varchar(50) DEFAULT NULL,
  `no_telp_karyawan` char(13) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id_karyawan`, `nama_karyawan`, `jabatan`, `no_telp_karyawan`, `alamat`, `username`, `password`) VALUES
(1, 'Riki Chandra', 'Admin', '085156284051', 'Jl.Kirangga', 'riki', '123');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id_member` int(11) NOT NULL,
  `kode_member` char(10) NOT NULL,
  `nama_member` varchar(50) DEFAULT NULL,
  `jenis_kelamin` varchar(100) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `pekerjaan_member` varchar(255) DEFAULT NULL,
  `no_telp_member` char(13) NOT NULL,
  `alamat_member` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id_member`, `kode_member`, `nama_member`, `jenis_kelamin`, `tgl_lahir`, `pekerjaan_member`, `no_telp_member`, `alamat_member`) VALUES
(1, 'M001', 'Riki', 'Laki-laki', '2022-01-04', 'sasdasd', '0902190381', 'adsasda'),
(2, 'M002', 'Dandi', 'Laki-laki', '2022-01-03', 'Ngangur', '0192013801309', 'Plaju');

-- --------------------------------------------------------

--
-- Table structure for table `meminjam`
--

CREATE TABLE `meminjam` (
  `kode_pinjam` varchar(255) NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `kd_buku` varchar(255) DEFAULT NULL,
  `judul` varchar(255) DEFAULT NULL,
  `tgl_pinjam` date NOT NULL,
  `tgl_kembali` date DEFAULT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `meminjam`
--

INSERT INTO `meminjam` (`kode_pinjam`, `nama`, `kd_buku`, `judul`, `tgl_pinjam`, `tgl_kembali`, `total`) VALUES
('P0001', 'Dandi', 'B005', 'FriendZone V2', '2022-01-03', '2022-01-04', 1),
('P0002', 'Riki', 'B001', 'Apikasi Java Netbeans', '2022-01-03', '2022-01-04', 1);

-- --------------------------------------------------------

--
-- Table structure for table `pengembalian`
--

CREATE TABLE `pengembalian` (
  `kode_peminjam` varchar(11) NOT NULL,
  `nama_peminjam` varchar(255) DEFAULT NULL,
  `judul_buku` varchar(255) NOT NULL,
  `tgl_kembali` date NOT NULL,
  `tgl_terima` date NOT NULL,
  `keterlambatan` int(50) NOT NULL,
  `total_buku` int(100) NOT NULL,
  `keterangan` varchar(255) NOT NULL,
  `denda` int(11) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengembalian`
--

INSERT INTO `pengembalian` (`kode_peminjam`, `nama_peminjam`, `judul_buku`, `tgl_kembali`, `tgl_terima`, `keterlambatan`, `total_buku`, `keterangan`, `denda`, `status`) VALUES
('P0001', 'Dandi', 'FriendZone V2', '2022-01-04', '2022-01-04', 0, 1, 'TEPAT WAKTU', 0, 'DI KEMBALIKAN'),
('P0002', 'Riki', 'Aplikasi Android', '2022-01-04', '2022-01-05', 1, 1, 'TEPAT WAKTU', 10000, 'DI KEMBALIKAN');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id_buku`),
  ADD UNIQUE KEY `kode_buku` (`kode_buku`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id_member`),
  ADD UNIQUE KEY `kode_member` (`kode_member`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
  MODIFY `id_buku` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id_karyawan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `id_member` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
