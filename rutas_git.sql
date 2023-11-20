-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-11-2023 a las 22:18:24
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `rutas_git`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `ID_Cliente` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Apellido` varchar(255) NOT NULL,
  `Coordenada_x` decimal(3,2) NOT NULL,
  `Coordenada_Y` decimal(3,2) NOT NULL,
  `Comentarios` varchar(255) DEFAULT NULL,
  `Telefono` varchar(15) NOT NULL,
  `Email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`ID_Cliente`, `Nombre`, `Apellido`, `Coordenada_x`, `Coordenada_Y`, `Comentarios`, `Telefono`, `Email`) VALUES
(1, 'Cliente1', 'Apellido1', 1.23, 4.56, 'Comentario1', '123456789', 'cliente1@email.com'),
(2, 'Cliente2', 'Apellido2', 7.89, 2.34, 'Comentario2', '987654321', 'cliente2@email.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entregas`
--

CREATE TABLE `entregas` (
  `ID_Entrega` int(11) NOT NULL,
  `ID_Cliente` int(11) DEFAULT NULL,
  `Fecha_Entrega` date DEFAULT NULL,
  `Litros_Entregados` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `entregas`
--

INSERT INTO `entregas` (`ID_Entrega`, `ID_Cliente`, `Fecha_Entrega`, `Litros_Entregados`) VALUES
(1, 1, '2023-11-19', 100.50),
(2, 2, '2023-11-20', 75.25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `ID_Rol` int(11) NOT NULL,
  `Nombre_Rol` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`ID_Rol`, `Nombre_Rol`) VALUES
(1, 'Admin'),
(2, 'Empleado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutas`
--

CREATE TABLE `rutas` (
  `ID_Ruta` int(11) NOT NULL,
  `ID_Entrega` int(11) DEFAULT NULL,
  `Secuencia_Entrega` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rutas`
--

INSERT INTO `rutas` (`ID_Ruta`, `ID_Entrega`, `Secuencia_Entrega`) VALUES
(1, 1, 1),
(2, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `totales`
--

CREATE TABLE `totales` (
  `ID_Totales` int(11) NOT NULL,
  `ID_Cliente` int(11) DEFAULT NULL,
  `Total_Litros_Entregados` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `totales`
--

INSERT INTO `totales` (`ID_Totales`, `ID_Cliente`, `Total_Litros_Entregados`) VALUES
(1, 1, 100.50),
(2, 2, 75.25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `ID_Usuario` int(11) NOT NULL,
  `NombreUsuario` varchar(50) NOT NULL,
  `Contrasena` varchar(255) NOT NULL,
  `NombreCompleto` varchar(100) NOT NULL,
  `ID_Rol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`ID_Usuario`, `NombreUsuario`, `Contrasena`, `NombreCompleto`, `ID_Rol`) VALUES
(1, 'admin', 'contrase?a_admin', 'Administrador', 1),
(2, 'empleado', 'contrase?a_empleado', 'Empleado', 2),
(6, 'admmin', 'contrasena_admin', 'Administrador', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`ID_Cliente`);

--
-- Indices de la tabla `entregas`
--
ALTER TABLE `entregas`
  ADD PRIMARY KEY (`ID_Entrega`),
  ADD KEY `ID_Cliente` (`ID_Cliente`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`ID_Rol`),
  ADD UNIQUE KEY `Nombre_Rol` (`Nombre_Rol`);

--
-- Indices de la tabla `rutas`
--
ALTER TABLE `rutas`
  ADD PRIMARY KEY (`ID_Ruta`),
  ADD KEY `ID_Entrega` (`ID_Entrega`);

--
-- Indices de la tabla `totales`
--
ALTER TABLE `totales`
  ADD PRIMARY KEY (`ID_Totales`),
  ADD KEY `ID_Cliente` (`ID_Cliente`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`ID_Usuario`),
  ADD UNIQUE KEY `NombreUsuario` (`NombreUsuario`),
  ADD KEY `ID_Rol` (`ID_Rol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `entregas`
--
ALTER TABLE `entregas`
  MODIFY `ID_Entrega` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `ID_Rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `rutas`
--
ALTER TABLE `rutas`
  MODIFY `ID_Ruta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `totales`
--
ALTER TABLE `totales`
  MODIFY `ID_Totales` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `entregas`
--
ALTER TABLE `entregas`
  ADD CONSTRAINT `entregas_ibfk_1` FOREIGN KEY (`ID_Cliente`) REFERENCES `clientes` (`ID_Cliente`);

--
-- Filtros para la tabla `rutas`
--
ALTER TABLE `rutas`
  ADD CONSTRAINT `rutas_ibfk_1` FOREIGN KEY (`ID_Entrega`) REFERENCES `entregas` (`ID_Entrega`);

--
-- Filtros para la tabla `totales`
--
ALTER TABLE `totales`
  ADD CONSTRAINT `totales_ibfk_1` FOREIGN KEY (`ID_Cliente`) REFERENCES `clientes` (`ID_Cliente`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`ID_Rol`) REFERENCES `roles` (`ID_Rol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
