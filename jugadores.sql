-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 09-09-2019 a las 00:32:49
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `neoris`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugadores`
--

CREATE TABLE IF NOT EXISTS `jugadores` (
  `nombre` varchar(30) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `posicion` varchar(20) DEFAULT NULL,
  `altura` float DEFAULT NULL,
  `peso` float DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `Puntaje` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `jugadores`
--

INSERT INTO `jugadores` (`nombre`, `apellido`, `posicion`, `altura`, `peso`, `edad`, `Puntaje`) VALUES
('Andres', 'Barrales', 'Ala', 2, 94, 33, 88),
('Juan', 'Garrido', 'Ala', 2, 99.4, 33, 2),
('Adrián', 'Perez', 'Ala', 3, 3, 33, 33),
('Adrián', 'Paes', 'Base', 3, 3, 33, 55),
('Andres', 'Paes', 'Base', 11, 11, 11, 22),
('Adrián', 'Paes', 'Base', 22, 22, 22, 55),
('Jose', 'Larreta', 'Base', 1, 1, 1, 44),
('Juan', 'gonzalez', 'AlaPivot', 12, 12, 12, 99),
('jorge', 'gonzalez', 'AlaPivot', 1, 1, 1, 22),
('Juan', 'Larreta', 'AlaPivot', 1, 1, 1, 88),
('Juan', 'Larreta', 'Pivot', 3, 98, 33, 88),
('Nahuel', 'Perez', 'Pivot', 11, 11, 11, NULL),
('Andres', 'Macri', 'Pivot', 11, 11, 11, 55),
('Adrián', 'Paes', 'Ala', 11, 94, 33, 55),
('Brian', 'Sarmiento', 'AlaPivot', 1.87, 88, 19, NULL),
('Sebastian', 'Rambert', 'Pivot', 1.93, 99.4, 55, 32),
('Adrián', 'Bastian', 'AyudaBase', 1.93, 99.4, 33, NULL),
('Jacinto', 'gonzalez', 'AyudaBase', 1.99, 209, 31, 78),
('jorge', 'Caceres', 'AyudaBase', 3, 3, 33, NULL),
('Cristian', 'Perez', 'AyudaBase', 1.87, 95.6, 18, NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
