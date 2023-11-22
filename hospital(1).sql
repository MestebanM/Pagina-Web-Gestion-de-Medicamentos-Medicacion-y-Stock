-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-11-2023 a las 16:53:54
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hospital`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `farmaceuta`
--

CREATE TABLE `farmaceuta` (
  `nombre` varchar(200) NOT NULL,
  `apellido` varchar(200) NOT NULL,
  `edad` varchar(20) NOT NULL,
  `correo` varchar(300) NOT NULL,
  `usuario` varchar(200) NOT NULL,
  `contrasenia` varchar(200) NOT NULL,
  `confircontra` varchar(200) NOT NULL,
  `genero` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `farmaceuta`
--

INSERT INTO `farmaceuta` (`nombre`, `apellido`, `edad`, `correo`, `usuario`, `contrasenia`, `confircontra`, `genero`) VALUES
('leidy', 'giraldo', '25', 'adawda@gmail.com', 'leidyFarma', '1234', '1234', 'femenino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcionario`
--

CREATE TABLE `funcionario` (
  `nombre` varchar(200) NOT NULL,
  `apellido` varchar(200) NOT NULL,
  `edad` varchar(20) NOT NULL,
  `correo` varchar(300) NOT NULL,
  `usuario` varchar(200) NOT NULL,
  `contrasenia` varchar(200) NOT NULL,
  `confircontra` varchar(200) NOT NULL,
  `genero` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `funcionario`
--

INSERT INTO `funcionario` (`nombre`, `apellido`, `edad`, `correo`, `usuario`, `contrasenia`, `confircontra`, `genero`) VALUES
('santiago', 'herra', '45', 'aa@gmail.com', 'sant', '789', '789', 'genero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamento`
--

CREATE TABLE `medicamento` (
  `id` varchar(20) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `stock` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `medicamento`
--

INSERT INTO `medicamento` (`id`, `nombre`, `stock`) VALUES
('78999', 'dolex', '10'),
('123', 'dolex', '7'),
('1457', 'paracetamol', '4');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamentos`
--

CREATE TABLE `medicamentos` (
  `nombre_medicamento` varchar(200) NOT NULL,
  `stock_medicamento` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `medicamentos`
--

INSERT INTO `medicamentos` (`nombre_medicamento`, `stock_medicamento`) VALUES
('paracetamol', '25');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden`
--

CREATE TABLE `orden` (
  `nombre` varchar(200) NOT NULL,
  `stock` varchar(200) NOT NULL,
  `numero` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `orden`
--

INSERT INTO `orden` (`nombre`, `stock`, `numero`) VALUES
('dormir ', '5000', 'giraldo.leidy2004@gmail.com'),
('dolex', '10', 'giraldo.leidy2004@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `nombre` varchar(200) NOT NULL,
  `apellido` varchar(200) NOT NULL,
  `edad` varchar(20) NOT NULL,
  `correo` varchar(300) NOT NULL,
  `usuario` varchar(200) NOT NULL,
  `contrasenia` varchar(200) NOT NULL,
  `confircontra` varchar(200) NOT NULL,
  `genero` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`nombre`, `apellido`, `edad`, `correo`, `usuario`, `contrasenia`, `confircontra`, `genero`) VALUES
('Leidy ', 'Giraldo', '12', 'saddad@gmail.com', 'hola', '12', '12', 'hombre'),
('Leidy ', 'Giraldo', '12', 'rasdaww@gmail.com', 'leidyyyy', '12345', '12345', 'mujer'),
('Leidy ', 'Giraldo', '12', 'rjkkkk@gmail.com', 'leidy12', '123', '123', 'mujer');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
