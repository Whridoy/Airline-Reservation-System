-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2021 at 10:49 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `airline`
--

-- --------------------------------------------------------

--
-- Table structure for table `addflight`
--

CREATE TABLE `addflight` (
  `flightname` varchar(255) NOT NULL,
  `flightserial` varchar(255) NOT NULL,
  `takeof` varchar(255) NOT NULL,
  `deprature` date NOT NULL,
  `back` date NOT NULL,
  `start` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `super` varchar(255) NOT NULL,
  `economy` varchar(255) NOT NULL,
  `business` varchar(255) NOT NULL,
  `premium` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `addflight`
--

INSERT INTO `addflight` (`flightname`, `flightserial`, `takeof`, `deprature`, `back`, `start`, `destination`, `super`, `economy`, `business`, `premium`) VALUES
('sdfsd', 'hjgkj', '2pm', '2021-06-03', '2021-06-08', 'Hazrat Shahjalal International Airport, Dhaka', 'Shah Amanat International Airport, Chattogram', '5324', '7213', '10246', '12554');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
