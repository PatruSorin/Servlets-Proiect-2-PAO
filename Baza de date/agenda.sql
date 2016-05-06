-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 06 Mai 2016 la 23:51
-- Versiune server: 10.1.10-MariaDB
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `agenda`
--

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `contacte`
--

CREATE TABLE `contacte` (
  `id` int(11) NOT NULL,
  `nume` text,
  `prenume` text,
  `telefon_mobil` text,
  `telefon_fix` text,
  `email` text,
  `adresa` text,
  `oras` text,
  `judet` text,
  `cod_postal` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `contacte`
--

INSERT INTO `contacte` (`id`, `nume`, `prenume`, `telefon_mobil`, `telefon_fix`, `email`, `adresa`, `oras`, `judet`, `cod_postal`) VALUES
(5, 'Patru', 'Catalin', '0785sdf', '', 'dskjfajd@gmail.com', '', 'sdkjfkasj', 'ksjfs', ''),
(7, 'Cojocaru', 'Malin', '0484152', '088554874', 'exemplu@gmi.com', 'casa lui', 'fdjsa', '', ''),
(8, 'Radu', 'Cristian', '000', '111', 'q@zzz.com', 'casa lui', 'fdjsa', '', ''),
(9, 'Manea', 'Valoare', '988', '2445', '1q@zzz.com', 'palatul lui', 'Bucuresti', 'Bucuresti', '02888'),
(10, 'Patru', 'Sorin', '07numar', '07alt_numar', 'me@sorin.com', 'Strada din fata casei mele', 'Bucuresti', 'Bucuresti', '0784895');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contacte`
--
ALTER TABLE `contacte`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contacte`
--
ALTER TABLE `contacte`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
