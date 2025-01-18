-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Време на генериране: 18 яну 2025 в 13:08
-- Версия на сървъра: 10.4.32-MariaDB
-- Версия на PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данни: `reserveroom`
--

-- --------------------------------------------------------

--
-- Структура на таблица `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `person_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Схема на данните от таблица `admin`
--

INSERT INTO `admin` (`id`, `person_id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- --------------------------------------------------------

--
-- Структура на таблица `person`
--

CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Схема на данните от таблица `person`
--

INSERT INTO `person` (`id`, `name`, `username`, `password`) VALUES
(1, 'Admin 1', 'admin1', 'password1'),
(2, 'Admin 2', 'admin2', 'password2'),
(3, 'Admin 3', 'admin3', 'password3'),
(4, 'Admin 4', 'admin4', 'password4'),
(5, 'Admin 5', 'admin5', 'password5'),
(6, 'Admin 6', 'admin6', 'password6'),
(7, 'Admin 7', 'admin7', 'password7'),
(8, 'Admin 8', 'admin8', 'password8'),
(9, 'Admin 9', 'admin9', 'password9'),
(10, 'Admin 10', 'admin10', 'password10'),
(11, 'User 1', 'user1', 'password1'),
(12, 'User 2', 'user2', 'password2'),
(13, 'User 3', 'user3', 'password3'),
(14, 'User 4', 'user4', 'password4'),
(15, 'User 5', 'user5', 'password5'),
(16, 'User 6', 'user6', 'password6'),
(17, 'User 7', 'user7', 'password7'),
(18, 'User 8', 'user8', 'password8'),
(19, 'User 9', 'user9', 'password9'),
(20, 'User 10', 'user10', 'password10'),
(21, 'Johntra', 'Volta', 'dil'),
(22, 'Samy', 'Salami', 'dil'),
(23, 'Donald', 'Duck', 'dil'),
(24, 'samy', 'sami', 'samy'),
(25, 'Johny', 'Deep', 'dil');

-- --------------------------------------------------------

--
-- Структура на таблица `request`
--

CREATE TABLE `request` (
  `id` int(11) NOT NULL,
  `time` int(11) NOT NULL,
  `date` date NOT NULL,
  `room_number` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Схема на данните от таблица `request`
--

INSERT INTO `request` (`id`, `time`, `date`, `room_number`) VALUES
(1, 9, '2024-12-12', '101'),
(2, 10, '2024-12-13', '102'),
(3, 11, '2024-12-14', '103'),
(4, 12, '2024-12-15', '104'),
(5, 13, '2024-12-16', '105'),
(6, 15, '2024-10-10', '3'),
(7, 15, '2025-12-10', '106');

-- --------------------------------------------------------

--
-- Структура на таблица `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `person_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Схема на данните от таблица `user`
--

INSERT INTO `user` (`id`, `person_id`) VALUES
(1, 11),
(2, 12),
(3, 13),
(4, 14),
(5, 15),
(6, 16),
(7, 17),
(8, 18),
(9, 19),
(10, 20),
(11, 22),
(12, 23),
(13, 24),
(14, 25);

--
-- Indexes for dumped tables
--

--
-- Индекси за таблица `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Индекси за таблица `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Индекси за таблица `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`id`);

--
-- Индекси за таблица `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `request`
--
ALTER TABLE `request`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Ограничения за дъмпнати таблици
--

--
-- Ограничения за таблица `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`id`) REFERENCES `person` (`id`) ON DELETE CASCADE;

--
-- Ограничения за таблица `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id`) REFERENCES `person` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
