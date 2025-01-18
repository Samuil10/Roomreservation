SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE DATABASE reserveroom;
USE reserveroom;

-- Създаване на таблица `admin`
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Вмъкване на данни в таблица `admin`
INSERT INTO `admin` (`id`, `person_id`) VALUES
(1, 1), (2, 2), (3, 3), (4, 4), (5, 5),
(6, 6), (7, 7), (8, 8), (9, 9), (10, 10);

-- Създаване на таблица `person`
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Вмъкване на данни в таблица `person`
INSERT INTO `person` (`id`, `name`, `username`, `password`) VALUES
(1, 'Admin 1', 'admin1', 'password1'), (2, 'Admin 2', 'admin2', 'password2'),
(3, 'Admin 3', 'admin3', 'password3'), (4, 'Admin 4', 'admin4', 'password4'),
(5, 'Admin 5', 'admin5', 'password5'), (6, 'Admin 6', 'admin6', 'password6'),
(7, 'Admin 7', 'admin7', 'password7'), (8, 'Admin 8', 'admin8', 'password8'),
(9, 'Admin 9', 'admin9', 'password9'), (10, 'Admin 10', 'admin10', 'password10'),
(11, 'User 1', 'user1', 'password1'), (12, 'User 2', 'user2', 'password2'),
(13, 'User 3', 'user3', 'password3'), (14, 'User 4', 'user4', 'password4'),
(15, 'User 5', 'user5', 'password5'), (16, 'User 6', 'user6', 'password6'),
(17, 'User 7', 'user7', 'password7'), (18, 'User 8', 'user8', 'password8'),
(19, 'User 9', 'user9', 'password9'), (20, 'User 10', 'user10', 'password10');

-- Създаване на таблица `request`
CREATE TABLE `request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` datetime NOT NULL,
  `date` date NOT NULL,
  `room_number` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Вмъкване на данни в таблица `request`
INSERT INTO `request` (`id`, `time`, `date`, `room_number`) VALUES
(1, '2024-12-11 09:00:00', '2024-12-12', '101'),
(2, '2024-12-11 10:00:00', '2024-12-13', '102'),
(3, '2024-12-11 11:00:00', '2024-12-14', '103'),
(4, '2024-12-11 12:00:00', '2024-12-15', '104'),
(5, '2024-12-11 13:00:00', '2024-12-16', '105');

-- Създаване на таблица `user`
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Вмъкване на данни в таблица `user`
INSERT INTO `user` (`id`, `person_id`) VALUES
(1, 11), (2, 12), (3, 13), (4, 14), (5, 15),
(6, 16), (7, 17), (8, 18), (9, 19), (10, 20);

-- Добавяне на външни ключове
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`id`) REFERENCES `person` (`id`) ON DELETE CASCADE;

ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id`) REFERENCES `person` (`id`) ON DELETE CASCADE;

-- Промяна на стойности за AUTO_INCREMENT
ALTER TABLE `person`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

ALTER TABLE `request`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

COMMIT;
