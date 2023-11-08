-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-10-2023 a las 17:19:01
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
-- Base de datos: `proyectof2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `idAdmin` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `cedula` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`idAdmin`, `nombre`, `apellido`, `cedula`, `telefono`, `correo`, `direccion`) VALUES
(1, 'samuel', 'Rey', '1032677426', '3138790366', 'samuelreyco@gmail', 'cr4'),
(2, 'sofia', 'gonzalez', '1032677418', '3138653241', 'sofi@gmail', 'c9');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `auditoria`
--

CREATE TABLE `auditoria` (
  `idAuditoria` int(11) NOT NULL,
  `detalleAuditoria` varchar(45) DEFAULT NULL,
  `idUsuarioAuditoria` varchar(45) DEFAULT NULL,
  `fechaAuditoria` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `idC` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `cedula` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `clave` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idC`, `nombre`, `apellido`, `cedula`, `telefono`, `correo`, `direccion`,`clave`) VALUES
(1, 'Lady Paola', 'Camacho', '536474758', '3425678998', 'Lady@gmail.com', 'c3','c3'),
(2, 'Samuelito', 'Rey', '1032677456', '3142567849', 'samuelreyco@gmail', 'cr2','c3'),
(5, 'Sofia', 'Gonzalez', '1345677889', '4467238949', 'sofi@gmail', 'cr2','c3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallec`
--

CREATE TABLE `detallec` (
  `idDC` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL DEFAULT 1,
  `subTotal` int(11) DEFAULT NULL,
  `idProd` int(11) NOT NULL,
  `idF` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallev`
--

CREATE TABLE `detallev` (
  `idDV` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL DEFAULT 1,
  `subTotal` int(11) DEFAULT NULL,
  `idProd` int(11) NOT NULL,
  `idFV` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturacomp`
--

CREATE TABLE `facturacomp` (
  `idF` int(11) NOT NULL,
  `dtoF` int(11) DEFAULT NULL,
  `Descripcion` varchar(60) NOT NULL,
  `fechaF` date DEFAULT NULL,
  `totalF` int(11) DEFAULT NULL,
  `idAdmin` int(11) NOT NULL,
  `idProv` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `facturacomp`
--

INSERT INTO `facturacomp` (`idF`, `dtoF`, `Descripcion`, `fechaF`, `totalF`, `idAdmin`, `idProv`) VALUES
(1, 5, 'audifonos', '2023-08-09', 200000, 1, 2),
(2, 12, 'Computador', '2023-08-01', 10000055, 1, 2),
(3, 2, 'Portatil', '2022-12-22', 200000, 2, 2),
(4, 25, 'Televisor', '2023-08-02', 3200000, 2, 2),
(5, 2, 'Aire Acondicionado', '2023-07-31', 10000000, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturavent`
--

CREATE TABLE `facturavent` (
  `idFV` int(11) NOT NULL,
  `dtoF` int(11) DEFAULT NULL,
  `fechaF` date DEFAULT NULL,
  `totalF` int(11) DEFAULT NULL,
  `idAdmin` int(11) NOT NULL,
  `idC` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProd` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `precio` varchar(45) DEFAULT NULL,
  `cantidad` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProd`, `nombre`, `descripcion`, `precio`, `cantidad`) VALUES
(1, 'Cafe', 'Cafeina', '20000', '50'),
(2, 'Oreo', 'Galletas', '5000', '25');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `idProv` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `nit` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idProv`, `nombre`, `nit`, `telefono`, `correo`) VALUES
(1, 'Alpina', '103982746', '637000', 'alpin@gmail'),
(2, 'Asus', '1092837465', '539992', 'asus@gmail'),
(4, 'apple', '777666555444', '3208541509', 'apple@gmail');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`idAdmin`);

--
-- Indices de la tabla `auditoria`
--
ALTER TABLE `auditoria`
  ADD PRIMARY KEY (`idAuditoria`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idC`);

--
-- Indices de la tabla `detallec`
--
ALTER TABLE `detallec`
  ADD PRIMARY KEY (`idDC`),
  ADD KEY `fk_DetalleC_Producto1_idx` (`idProd`),
  ADD KEY `fk_DetalleC_FacturaComp1_idx` (`idF`);

--
-- Indices de la tabla `detallev`
--
ALTER TABLE `detallev`
  ADD PRIMARY KEY (`idDV`),
  ADD KEY `fk_DetalleV_Producto1_idx` (`idProd`),
  ADD KEY `fk_DetalleV_FacturaVent1_idx` (`idFV`);

--
-- Indices de la tabla `facturacomp`
--
ALTER TABLE `facturacomp`
  ADD PRIMARY KEY (`idF`),
  ADD KEY `fk_FacturaComp_Administrador1_idx` (`idAdmin`),
  ADD KEY `fk_FacturaComp_Proveedor1_idx` (`idProv`);

--
-- Indices de la tabla `facturavent`
--
ALTER TABLE `facturavent`
  ADD PRIMARY KEY (`idFV`),
  ADD KEY `fk_Factura_Administrador1_idx` (`idAdmin`),
  ADD KEY `fk_Factura_Usuario1_idx` (`idC`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProd`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`idProv`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrador`
--
ALTER TABLE `administrador`
  MODIFY `idAdmin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `auditoria`
--
ALTER TABLE `auditoria`
  MODIFY `idAuditoria` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `idC` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `detallec`
--
ALTER TABLE `detallec`
  MODIFY `idDC` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detallev`
--
ALTER TABLE `detallev`
  MODIFY `idDV` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `facturacomp`
--
ALTER TABLE `facturacomp`
  MODIFY `idF` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `facturavent`
--
ALTER TABLE `facturavent`
  MODIFY `idFV` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `idProv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detallec`
--
ALTER TABLE `detallec`
  ADD CONSTRAINT `fk_DetalleC_FacturaComp1` FOREIGN KEY (`idF`) REFERENCES `facturacomp` (`idF`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_DetalleC_Producto1` FOREIGN KEY (`idProd`) REFERENCES `producto` (`idProd`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detallev`
--
ALTER TABLE `detallev`
  ADD CONSTRAINT `fk_DetalleV_FacturaVent1` FOREIGN KEY (`idFV`) REFERENCES `facturavent` (`idFV`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_DetalleV_Producto1` FOREIGN KEY (`idProd`) REFERENCES `producto` (`idProd`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `facturacomp`
--
ALTER TABLE `facturacomp`
  ADD CONSTRAINT `fk_FacturaComp_Administrador1` FOREIGN KEY (`idAdmin`) REFERENCES `administrador` (`idAdmin`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_FacturaComp_Proveedor1` FOREIGN KEY (`idProv`) REFERENCES `proveedor` (`idProv`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `facturavent`
--
ALTER TABLE `facturavent`
  ADD CONSTRAINT `fk_Factura_Administrador1` FOREIGN KEY (`idAdmin`) REFERENCES `administrador` (`idAdmin`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Factura_Usuario1` FOREIGN KEY (`idC`) REFERENCES `clientes` (`idC`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
