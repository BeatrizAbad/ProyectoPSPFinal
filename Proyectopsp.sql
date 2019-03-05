-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 05-03-2019 a las 08:29:30
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `proyectopsp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE IF NOT EXISTS `administrador` (
  `idadr` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`idadr`) VALUES
(1),
(3),
(2),
(5),
(9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tickets`
--

CREATE TABLE IF NOT EXISTS `tickets` (
  `idticket` int(10) NOT NULL,
  `idcaso` int(10) NOT NULL,
  `idadr` int(10) NOT NULL,
  `fecha` varchar(100) NOT NULL,
  `asunto` varchar(100) NOT NULL,
  `prioridad` varchar(100) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `estado` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tickets`
--

INSERT INTO `tickets` (`idticket`, `idcaso`, `idadr`, `fecha`, `asunto`, `prioridad`, `descripcion`, `estado`) VALUES
(123, 123, 1, 'Thu Feb 14 12:01:50 CET 2019', 'ddddd', 'Baja', 'aaaaaaa', 'Abierto'),
(12345, 22, 3, 'Thu Feb 14 12:01:50 CET 2019', 'aaaaaaaaaaa', 'Baja', 'ggggggggggggg', 'Abierto'),
(321, 22, 2, 'Thu Feb 14 12:01:50 CET 2019', 'aaaaaaaaaaa', 'Baja', 'ggggggggggggg', 'Abierto'),
(555, 123, 5, 'Thu Feb 14 13:34:36 CET 2019', 'kkkkkkkk', 'Baja', 'kkkkkkkkkkk', 'Abierto'),
(687, 321, 5, 'Thu Feb 14 13:37:16 CET 2019', 'xxer', 'Baja', 'cdrcrcd', 'Abierto'),
(699, 123, 9, 'Fri Feb 15 14:16:13 CET 2019', 'jjjjj', 'Media', 'jjjjj', 'Pendiente'),
(8, 1, 1, 'Wed Feb 27 08:30:02 CET 2019', 'Ticket nuevo', 'Alta', 'ya no está pendiente', 'Cerrado'),
(4, 1, 1, 'Wed Feb 27 08:46:32 CET 2019', 'avcxzv', 'Media', 'fesdfs ya no está pendiente', 'Cerrado'),
(454, 1, 1, 'Wed Feb 27 12:13:27 CET 2019', 'prueba', 'Alta', 'ya no está pendiente', 'Cerrado');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
