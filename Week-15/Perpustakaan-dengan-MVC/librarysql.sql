-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 13 Jan 2022 pada 06.03
-- Versi server: 10.4.20-MariaDB
-- Versi PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `kode` varchar(50) NOT NULL,
  `title` varchar(50) NOT NULL,
  `tersedia` int(11) DEFAULT 1,
  `lokasi` varchar(30) DEFAULT '-'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `books`
--

INSERT INTO `books` (`id`, `kode`, `title`, `tersedia`, `lokasi`) VALUES
(2, '1234', 'Ini budi', 1, '2C'),
(4, '12345', 'Ini ani', 2, '9B'),
(6, '132', 'buku apa', 2, '3C'),
(7, '123', 'entahlah', 1, '5D');

-- --------------------------------------------------------

--
-- Struktur dari tabel `cashiers`
--

CREATE TABLE `cashiers` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `no_ktp` varchar(50) NOT NULL,
  `adress` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `cashiers`
--

INSERT INTO `cashiers` (`id`, `nama`, `no_ktp`, `adress`, `username`, `password`) VALUES
(1, 'Budi', '0773', 'Ini budi, 37', '111', '12');

-- --------------------------------------------------------

--
-- Struktur dari tabel `list`
--

CREATE TABLE `list` (
  `id` int(11) NOT NULL,
  `kodeBuku` varchar(50) NOT NULL,
  `bookTitle` varchar(50) NOT NULL,
  `namaMember` varchar(50) NOT NULL,
  `noKtpMember` varchar(50) NOT NULL,
  `alamatMember` varchar(50) NOT NULL,
  `namaKasir` varchar(50) NOT NULL,
  `dayStart` varchar(50) NOT NULL,
  `dayEnd` varchar(50) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 1,
  `total` int(11) NOT NULL,
  `denda` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `list`
--

INSERT INTO `list` (`id`, `kodeBuku`, `bookTitle`, `namaMember`, `noKtpMember`, `alamatMember`, `namaKasir`, `dayStart`, `dayEnd`, `status`, `total`, `denda`) VALUES
(1, '12444', 'Bapak', 'Saya', '8127', 'Jalan 123', 'Budi', '2021-12-28', '2021-12-31', 1, 7500, 0),
(2, '123', 'entahlah', 'Saya', '8127', 'Jalan 123', 'Budi', '2022-01-11', '2022-01-14', 1, 3000, 0),
(3, '132', 'buku apa', 'Saya siapa?', '127', 'JL 22', 'Budi', '2022-01-11', '2022-01-16', 1, 15000, 0),
(4, '132', 'buku apa', 'Saya siapa?', '127', 'JL 22', 'Budi', '2022-01-11', '2022-01-14', 1, 15000, 0),
(5, '12345', 'Ini ani', 'tono', '9182', 'alamat1', 'Budi', '2022-01-11', '2022-01-14', 1, 3000, 0),
(6, '123', 'entahlah', 'Saya', '8127', 'Jalan 123', 'Budi', '2022-01-13', '2022-01-16', 1, 12000, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `members`
--

CREATE TABLE `members` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `no_ktp` varchar(50) NOT NULL,
  `adress` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `members`
--

INSERT INTO `members` (`id`, `name`, `no_ktp`, `adress`) VALUES
(1, 'Saya', '8127', 'Jalan 123'),
(3, 'Saya siapa?', '127', 'JL 22'),
(5, 'tono', '9182', 'alamat1'),
(6, 'Andhika', '7689', 'Jl apa');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `kode` (`kode`);

--
-- Indeks untuk tabel `cashiers`
--
ALTER TABLE `cashiers`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `list`
--
ALTER TABLE `list`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `no_ktp` (`no_ktp`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT untuk tabel `cashiers`
--
ALTER TABLE `cashiers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `list`
--
ALTER TABLE `list`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `members`
--
ALTER TABLE `members`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
