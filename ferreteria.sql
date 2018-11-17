-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-11-2018 a las 17:51:35
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ferreteria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `codigo` int(4) NOT NULL,
  `cliente` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `deuda` int(11) NOT NULL,
  `pagoclientescodigo` int(11) NOT NULL,
  `descripcion` text COLLATE latin1_spanish_ci NOT NULL,
  `fechaPago` date NOT NULL,
  `pago` varchar(15) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`codigo`, `cliente`, `deuda`, `pagoclientescodigo`, `descripcion`, `fechaPago`, `pago`) VALUES
(1, 'Juan', 1500, 1, 'Debe', '2018-10-22', 'ya'),
(4, 'ya funciona', 200, 1, 'Arena', '2018-10-28', 'casi'),
(5, 'Daniel', 1200, 1, 'Compro muchos clavos x2', '2018-11-01', 'esta'),
(6, 'Jose Alfredo', 1800, 0, 'Compro muchos clavos', '2018-10-08', 'No pagado'),
(7, 'Jose Alfredo', 1200, 12, 'si', '2018-10-01', 'No pagado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `numeroPedido` int(4) NOT NULL,
  `descripcionPedido` text COLLATE latin1_spanish_ci NOT NULL,
  `fechaLlegada` date NOT NULL,
  `entrega` varchar(30) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`numeroPedido`, `descripcionPedido`, `fechaLlegada`, `entrega`) VALUES
(1, 'prueba 2.0', '2018-10-22', 'Entregado despues de la fecha'),
(2, 'prueba', '2018-10-31', 'si'),
(3, 'tg', '2018-10-30', 'Entregado despues de la fecha');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigo` int(4) NOT NULL,
  `nombre` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  `descripcionProducto` text COLLATE latin1_spanish_ci NOT NULL,
  `categoria` varchar(40) COLLATE latin1_spanish_ci NOT NULL,
  `ubicacion` char(20) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo`, `nombre`, `cantidad`, `precio`, `descripcionProducto`, `categoria`, `ubicacion`) VALUES
(1, 'Martillo', 23, 200, 'material para custruir casas', '12', 'Ferreteria Centro'),
(2, 'dew', 31, 23, 'wdd', 'Accesorios', 'Ferreteria Centro'),
(4, 'ws', 21, 212, 'ws', 'ed', 'ew'),
(7, 'Entonces', 21, 34, 'ya', 'termine', 'el proyecto'),
(8, 'Arena', 1000, 21, '21 el Kg, 2100 Tonelada ', 'Tierra', 'Ferreteria Centro'),
(10, 'swq', 23, 23, 'wqe', 'Material de Construcción', 'Ferreteria Centro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `viajes`
--

CREATE TABLE `viajes` (
  `codigo` int(4) NOT NULL,
  `nombreCliente` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `fechaEntrega` datetime DEFAULT NULL,
  `materiales` text COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` text COLLATE latin1_spanish_ci NOT NULL,
  `dinero` int(11) NOT NULL,
  `entrega` varchar(15) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `viajes`
--

INSERT INTO `viajes` (`codigo`, `nombreCliente`, `fechaEntrega`, `materiales`, `descripcion`, `dinero`, `entrega`) VALUES
(1, 'Jose Alfredo', '2018-10-22 10:35:00', 'Cemento', 'Arena', 1220, 'no'),
(2, 'xfg', '2018-10-31 00:00:00', '1', '2', 231, 'si'),
(3, 'San', '2018-10-01 00:00:00', 'Block', 'wsdw', 2000, 'Entregado');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`numeroPedido`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `viajes`
--
ALTER TABLE `viajes`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `codigo` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `numeroPedido` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `codigo` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `viajes`
--
ALTER TABLE `viajes`
  MODIFY `codigo` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
