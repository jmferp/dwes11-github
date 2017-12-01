-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-12-2017 a las 22:16:41
-- Versión del servidor: 5.5.39
-- Versión de PHP: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `catalogo11`
--
CREATE DATABASE IF NOT EXISTS `catalogo11` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci;
USE `catalogo11`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

CREATE TABLE IF NOT EXISTS `autor` (
  `id` varchar(10) COLLATE utf8mb4_spanish_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `nacionalidad` varchar(50) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `imag` text COLLATE utf8mb4_spanish_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `autor`
--

INSERT INTO `autor` (`id`, `nombre`, `nacionalidad`, `imag`) VALUES
('1', 'Ken Follett', 'Reino Unido', 'follett.jpg'),
('2', 'JK Rowling', 'Reino Unido', 'rowling.jpg'),
('3', 'Javier Sierra', 'España', 'sierra.jpg'),
('4', 'JRR Tolkien', 'Sudafrica', 'tolkien.jpg'),
('5', 'Miguel de Cervantes', 'España', 'cervantes.jpg'),
('6', 'Dan Brown', 'Estados Unidos', 'brown.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `obra`
--

CREATE TABLE IF NOT EXISTS `obra` (
  `id_obra` varchar(10) COLLATE utf8mb4_spanish_ci NOT NULL,
  `titulo` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `id_autor` varchar(10) COLLATE utf8mb4_spanish_ci NOT NULL,
  `genero` text COLLATE utf8mb4_spanish_ci,
  `descripcion` text COLLATE utf8mb4_spanish_ci,
  `año` year(4) DEFAULT NULL,
  `imagen` varchar(20) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `obra`
--

INSERT INTO `obra` (`id_obra`, `titulo`, `id_autor`, `genero`, `descripcion`, `año`, `imagen`) VALUES
('O1', 'Los pilares de la tierra', '1', 'historica', NULL, 1989, 'pilares.jpg'),
('O2', 'Harry Potter y el cáliz de fuego', '2', 'Ciencia Ficcion', NULL, 2000, 'potter.jpg'),
('O3', 'El codigo Da Vinci', '6', 'Novela', NULL, 2003, 'davinci.jpg'),
('O4', 'Inferno', '6', 'Novela', NULL, 2013, 'inferno.jpg'),
('O5', 'La cena secreta', '3', 'Novela', NULL, 2004, 'cenasecreta.jpg'),
('O6', 'El hobbit', '4', 'Ciencia ficcion', NULL, 1937, 'hobbit.jpg'),
('O7', 'El señor de los anillos', '4', 'Ciencia ficcion', NULL, 1954, 'anillos.jpg'),
('O8', 'Don Quijote de la Mancha', '5', 'Novela', NULL, NULL, 'quijote.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `login` varchar(10) COLLATE utf8mb4_spanish_ci NOT NULL,
  `password` varchar(15) COLLATE utf8mb4_spanish_ci NOT NULL,
  `nombre` varchar(25) COLLATE utf8mb4_spanish_ci NOT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  `descripcion` text COLLATE utf8mb4_spanish_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`login`, `password`, `nombre`, `admin`, `descripcion`) VALUES
('alberto', 'alberto', 'alberto', 0, NULL),
('jose', 'jose', 'jose', 1, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autor`
--
ALTER TABLE `autor`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `obra`
--
ALTER TABLE `obra`
 ADD PRIMARY KEY (`id_obra`), ADD KEY `libro-autor` (`id_autor`) USING BTREE;

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`login`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `obra`
--
ALTER TABLE `obra`
ADD CONSTRAINT `obra_ibfk_1` FOREIGN KEY (`id_autor`) REFERENCES `autor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
