-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2021 at 06:24 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paflab6`
--

-- --------------------------------------------------------

--
-- Table structure for table `researcher`
--

CREATE TABLE `researcher` (
  `reseacherID` int(10) NOT NULL,
  `researcherCode` varchar(30) NOT NULL,
  `researcherName` varchar(50) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `contactNo` int(10) NOT NULL,
  `projectCategory` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `researcher`
--

INSERT INTO `researcher` (`reseacherID`, `researcherCode`, `researcherName`, `Email`, `contactNo`, `projectCategory`) VALUES
(3, 'rid0020', 'Mr.Amal Perera', 'perera98@gmail.com', 412256469, 'Gems and Jewelry'),
(7, 'rid5406', 'Mr.Uthpala Samarakon', 'uthpalaS@gmail.com', 412250005, 'Robo Technology'),
(10, 'rid5522', 'Mr.Nadini Premadasa', 'nadiniP@gmail.com', 772117896, 'Hospital Management'),
(13, 'rid8006', 'Mr.Sarath Karunarathna', 'jagathW@gmail.com', 712389223, 'Vehicle Services and Fuel Stations'),
(14, 'rid3320', 'Mr.Amith Perera', 'amith@gmail.com', 772345991, 'Food Delivery'),
(15, 'rid2145', 'Mr.Batheesha Perera', 'Batheesha@gmail.com', 772345991, 'Digital Marketing'),
(16, 'rid2145', 'Mr.Thisum Samarasinhe', 'Thisum@gmail.com', 772345991, 'Digital Marketing'),
(17, 'rid1998', 'Mr.Dulan Ramanayaka', 'dulan@gmail.com', 772345991, 'Video Editing');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `researcher`
--
ALTER TABLE `researcher`
  ADD PRIMARY KEY (`reseacherID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `researcher`
--
ALTER TABLE `researcher`
  MODIFY `reseacherID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
