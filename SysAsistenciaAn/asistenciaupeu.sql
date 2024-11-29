-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-04-2024 a las 14:54:18
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
-- Base de datos: `asistenciaupeu`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asis_actividad`
--

CREATE TABLE `asis_actividad` (
  `id` bigint(20) NOT NULL,
  `asis_subact` varchar(2) NOT NULL,
  `entsal` varchar(2) NOT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `evaluar` varchar(2) NOT NULL,
  `fecha` date NOT NULL,
  `horai` time(6) NOT NULL,
  `latitud` varchar(255) DEFAULT NULL,
  `longitud` varchar(255) DEFAULT NULL,
  `mater` varchar(200) DEFAULT NULL,
  `min_toler` time(6) NOT NULL,
  `nombre_actividad` varchar(255) NOT NULL,
  `offlinex` varchar(2) NOT NULL,
  `user_create` varchar(255) NOT NULL,
  `valid_insc` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `asis_actividad`
--

INSERT INTO `asis_actividad` (`id`, `asis_subact`, `entsal`, `estado`, `evaluar`, `fecha`, `horai`, `latitud`, `longitud`, `mater`, `min_toler`, `nombre_actividad`, `offlinex`, `user_create`, `valid_insc`) VALUES
(1, 'NO', 'SI', 'A', 'SI', '2023-10-25', '03:57:00.000000', '54444', '878744', 'Cuaderno, Plumon', '00:10:00.000000', 'Cultura', 'SI', 'mamanipari@gmail.com', 'NO'),
(15, 'SI', 'SI', 'A', 'SI', '2023-09-18', '10:31:00.000000', '37.4219983', '-122.084', 'Cuaderno, Morral', '00:10:00.000000', 'Act. Deportiva', 'SI', 'davidmp@upeu.edu.pe', 'SI'),
(25, 'SI', 'SI', 'A', 'SI', '2023-10-31', '08:40:00.000000', '37.421998333333335', '-122.08400000000002', 'Lapiz', '00:10:00.000000', 'Simposio 2', 'SI', 'dmamanipar@unsa.edu.pe', 'SI'),
(26, 'NO', 'NO', 'A', 'NO', '2023-10-31', '09:00:00.000000', '37.421998333333335', '-122.08400000000002', 'Cuaderno', '00:15:00.000000', 'Acividad 2P', 'SI', 'dmamanipar@unsa.edu.pe', 'SI'),
(28, 'SI', 'NO', 'A', 'SI', '2023-11-01', '13:00:00.000000', '37.421998333333335', '-122.08400000000002', 'Lapiz, Cuaderno', '00:15:00.000000', 'Envistidura PPP', 'SI', 'dmamanipar@unsa.edu.pe', 'SI'),
(29, 'SI', 'SI', 'Activo', 'SI', '2024-04-04', '11:22:00.000000', '37.4219983', '-122.084', 'Lapiz, Cuaderno', '11:22:00.000000', 'Cultura Find 2024', 'SI', 'davidmp@upeu.edu.pe', 'SI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asis_asistenciax`
--

CREATE TABLE `asis_asistenciax` (
  `id` bigint(20) NOT NULL,
  `calificacion` int(11) NOT NULL,
  `cui` varchar(20) NOT NULL,
  `entsal` varchar(2) NOT NULL,
  `fecha` date NOT NULL,
  `hora_reg` time(6) NOT NULL,
  `latituda` varchar(255) DEFAULT NULL,
  `longituda` varchar(255) DEFAULT NULL,
  `offlinex` varchar(2) NOT NULL,
  `subactasis_id` bigint(20) DEFAULT NULL,
  `tipo` varchar(20) NOT NULL,
  `tipo_cui` varchar(20) NOT NULL,
  `actividad_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `asis_asistenciax`
--

INSERT INTO `asis_asistenciax` (`id`, `calificacion`, `cui`, `entsal`, `fecha`, `hora_reg`, `latituda`, `longituda`, `offlinex`, `subactasis_id`, `tipo`, `tipo_cui`, `actividad_id`) VALUES
(1, 3, '43631917', 'SI', '2023-10-01', '10:41:00.000000', '37.4219983', '-122.084', 'SI', 1, 'T', 'CARNET', 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asis_evento`
--

CREATE TABLE `asis_evento` (
  `id` bigint(20) NOT NULL,
  `cui` varchar(20) NOT NULL,
  `fecha` date NOT NULL,
  `hora_reg` time(6) NOT NULL,
  `latituda` varchar(255) DEFAULT NULL,
  `longituda` varchar(255) DEFAULT NULL,
  `mater_entre` varchar(200) DEFAULT NULL,
  `mod_fh` date NOT NULL,
  `offlinex` varchar(2) NOT NULL,
  `tipo_cui` varchar(20) NOT NULL,
  `actividad_id` bigint(20) NOT NULL,
  `periodo_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asis_inscritos`
--

CREATE TABLE `asis_inscritos` (
  `id` bigint(20) NOT NULL,
  `cui` varchar(20) NOT NULL,
  `evidens_pay` varchar(100) NOT NULL,
  `offlinex` varchar(2) NOT NULL,
  `tipo_cui` varchar(20) NOT NULL,
  `actividad_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asis_materialesx`
--

CREATE TABLE `asis_materialesx` (
  `id` bigint(20) NOT NULL,
  `cui` varchar(20) NOT NULL,
  `fecha` date NOT NULL,
  `hora_reg` time(6) NOT NULL,
  `latituda` varchar(255) DEFAULT NULL,
  `longituda` varchar(255) DEFAULT NULL,
  `mater_entre` varchar(200) DEFAULT NULL,
  `mod_fh` date NOT NULL,
  `offlinex` varchar(2) NOT NULL,
  `tipo_cui` varchar(20) NOT NULL,
  `actividad_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `asis_materialesx`
--

INSERT INTO `asis_materialesx` (`id`, `cui`, `fecha`, `hora_reg`, `latituda`, `longituda`, `mater_entre`, `mod_fh`, `offlinex`, `tipo_cui`, `actividad_id`) VALUES
(1, '43631917', '2023-09-23', '03:57:00.000000', '545454', '78745454', 'Cuaderno, Morral', '2023-09-23', 'SI', 'DNI', 1),
(11, '43631917', '2023-09-24', '01:33:00.000000', '37.4219983', '-122.084', 'Cuaderno', '2023-09-24', 'NO', 'DNI', 15),
(12, '43631917', '2023-09-24', '01:41:00.000000', '37.4219983', '-122.084', 'Cuaderno', '2023-09-24', 'SI', 'DNI', 15),
(22, '43631817', '2023-09-25', '08:32:00.000000', '37.4219983', '-122.084', 'Cuaderno, Morral', '2023-09-25', 'SI', 'DNI', 15),
(23, '43631917', '2023-12-02', '21:32:07.000000', '37.421998333333335', '-122.08400000000002', 'Cuaderno, morral', '2023-12-02', 'SI', 'DNI', 15),
(24, '43631917', '2023-12-02', '21:33:54.000000', '37.421998333333335', '-122.08400000000002', 'Cuaderno', '2023-12-02', 'SI', 'DNI', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asis_produccion`
--

CREATE TABLE `asis_produccion` (
  `id` bigint(20) NOT NULL,
  `fecha` date NOT NULL,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `finca` varchar(255) DEFAULT NULL,
  `ganado` varchar(255) DEFAULT NULL,
  `litros_leche` varchar(255) DEFAULT NULL,
  `turno` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asis_subactasisx`
--

CREATE TABLE `asis_subactasisx` (
  `id` bigint(20) NOT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecha` date NOT NULL,
  `horasi` time(6) NOT NULL,
  `min_toler` time(6) NOT NULL,
  `offlinex` varchar(2) NOT NULL,
  `actividad_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `global_usuario_rol`
--

CREATE TABLE `global_usuario_rol` (
  `usuario_id` bigint(20) NOT NULL,
  `rol_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `global_usuario_rol`
--

INSERT INTO `global_usuario_rol` (`usuario_id`, `rol_id`) VALUES
(1, 1),
(1, 2),
(8, 1),
(8, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gobal_rol`
--

CREATE TABLE `gobal_rol` (
  `id` bigint(20) NOT NULL,
  `rol_nombre` enum('ROLE_ADMIN','ROLE_USER') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `gobal_rol`
--

INSERT INTO `gobal_rol` (`id`, `rol_nombre`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gobal_usuario`
--

CREATE TABLE `gobal_usuario` (
  `id` bigint(20) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `dni` varchar(255) NOT NULL,
  `estado` varchar(255) NOT NULL,
  `nombres` varchar(255) NOT NULL,
  `offlinex` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `perfil_prin` varchar(255) NOT NULL,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `gobal_usuario`
--

INSERT INTO `gobal_usuario` (`id`, `apellidos`, `correo`, `dni`, `estado`, `nombres`, `offlinex`, `password`, `perfil_prin`, `fecha_actualizacion`, `fecha_creacion`) VALUES
(1, 'Mamani Pari', 'davidmp@upeu.edu.pe', '43631917', 'Activo', 'David', 'SI', '$2a$10$XeTc0WESEycYxFrzLzT4jO/LTPndni8aoEkTdZyJwXzdWzJRR.pAC', 'upeu', NULL, NULL),
(8, 'Mamani Pari', 'eliasmp@upeu.edu.pe', '43631918', 'Activo', 'Elias', 'SI', '$2a$10$kD3JdRD68NGzKMzWPGucKOzyYviPagSDzHMyzlBZWPu6tzkFaDITq', 'upeu', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `images`
--

CREATE TABLE `images` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pic` blob DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `upeu_asistencia`
--

CREATE TABLE `upeu_asistencia` (
  `id` bigint(20) NOT NULL,
  `calificacion` int(11) NOT NULL,
  `entsal` varchar(2) NOT NULL,
  `fecha` date NOT NULL,
  `hora_reg` time(6) NOT NULL,
  `latituda` varchar(255) DEFAULT NULL,
  `longituda` varchar(255) DEFAULT NULL,
  `offlinex` varchar(2) NOT NULL,
  `subactasis_id` bigint(20) DEFAULT NULL,
  `tipo` varchar(20) NOT NULL,
  `tipo_reg` varchar(12) NOT NULL,
  `evento_id` bigint(20) NOT NULL,
  `matricula_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `upeu_escuela`
--

CREATE TABLE `upeu_escuela` (
  `id` bigint(20) NOT NULL,
  `estado` varchar(8) NOT NULL,
  `inicialeseap` varchar(8) NOT NULL,
  `nombreeap` varchar(255) NOT NULL,
  `facultad_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `upeu_escuela`
--

INSERT INTO `upeu_escuela` (`id`, `estado`, `inicialeseap`, `nombreeap`, `facultad_id`) VALUES
(1, 'Activo', 'SIS', 'Sistemas', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `upeu_evento`
--

CREATE TABLE `upeu_evento` (
  `id` bigint(20) NOT NULL,
  `asis_subact` varchar(2) NOT NULL,
  `entsal` varchar(2) NOT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `evaluar` varchar(2) NOT NULL,
  `fecha` date NOT NULL,
  `horai` time(6) NOT NULL,
  `latitud` varchar(255) DEFAULT NULL,
  `longitud` varchar(255) DEFAULT NULL,
  `mater` varchar(200) DEFAULT NULL,
  `min_toler` time(6) NOT NULL,
  `nombre_evento` varchar(255) NOT NULL,
  `offlinex` varchar(2) NOT NULL,
  `perfil_evento` varchar(20) NOT NULL,
  `user_create` varchar(100) NOT NULL,
  `valid_insc` varchar(2) NOT NULL,
  `periodo_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `upeu_evento`
--

INSERT INTO `upeu_evento` (`id`, `asis_subact`, `entsal`, `estado`, `evaluar`, `fecha`, `horai`, `latitud`, `longitud`, `mater`, `min_toler`, `nombre_evento`, `offlinex`, `perfil_evento`, `user_create`, `valid_insc`, `periodo_id`) VALUES
(2, 'SI', 'SI', 'Activo', 'SI', '2023-10-01', '01:02:20.000000', '15454', '5454', 'SI', '00:10:00.000000', 'DEsfile', 'SI', 'Todo', 'davidmp@upeu.edu.pe', 'SI', 31);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `upeu_facultad`
--

CREATE TABLE `upeu_facultad` (
  `id` bigint(20) NOT NULL,
  `estado` varchar(8) NOT NULL,
  `iniciales` varchar(8) NOT NULL,
  `nombrefac` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `upeu_facultad`
--

INSERT INTO `upeu_facultad` (`id`, `estado`, `iniciales`, `nombrefac`) VALUES
(1, 'Activo', 'FIA', 'FIA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `upeu_materiales`
--

CREATE TABLE `upeu_materiales` (
  `id` bigint(20) NOT NULL,
  `fecha` date NOT NULL,
  `hora_reg` time(6) NOT NULL,
  `latitud` varchar(255) DEFAULT NULL,
  `longitud` varchar(255) DEFAULT NULL,
  `mater_entre` varchar(200) DEFAULT NULL,
  `mod_fh` datetime(6) NOT NULL,
  `offlinex` varchar(2) NOT NULL,
  `evento_id` bigint(20) NOT NULL,
  `matricula_id` bigint(20) NOT NULL,
  `latituda` varchar(255) DEFAULT NULL,
  `longituda` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `upeu_materiales`
--

INSERT INTO `upeu_materiales` (`id`, `fecha`, `hora_reg`, `latitud`, `longitud`, `mater_entre`, `mod_fh`, `offlinex`, `evento_id`, `matricula_id`, `latituda`, `longituda`) VALUES
(1, '2023-10-01', '01:01:00.000000', '545454', '54545', 'Cuaderno', '2023-10-01 00:00:00.000000', 'SI', 2, 1, '5454', '54545');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `upeu_matricula`
--

CREATE TABLE `upeu_matricula` (
  `id` bigint(20) NOT NULL,
  `estado` varchar(8) NOT NULL,
  `evento_id` bigint(20) DEFAULT NULL,
  `periodo_id` bigint(20) NOT NULL,
  `persona_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `upeu_matricula`
--

INSERT INTO `upeu_matricula` (`id`, `estado`, `evento_id`, `periodo_id`, `persona_id`) VALUES
(1, 'Activo', 1, 31, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `upeu_periodo`
--

CREATE TABLE `upeu_periodo` (
  `id` bigint(20) NOT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `upeu_periodo`
--

INSERT INTO `upeu_periodo` (`id`, `estado`, `nombre`) VALUES
(31, 'Activo', '2023-2'),
(34, 'Activo', '2021-2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `upeu_persona`
--

CREATE TABLE `upeu_persona` (
  `id` bigint(20) NOT NULL,
  `apellido_mat` varchar(40) NOT NULL,
  `apellido_pat` varchar(40) NOT NULL,
  `celular` varchar(12) NOT NULL,
  `clave` varchar(255) NOT NULL,
  `codigo` varchar(10) NOT NULL,
  `correo` varchar(40) NOT NULL,
  `estado` varchar(8) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `tipo` varchar(12) NOT NULL,
  `escuela_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `upeu_persona`
--

INSERT INTO `upeu_persona` (`id`, `apellido_mat`, `apellido_pat`, `celular`, `clave`, `codigo`, `correo`, `estado`, `nombre`, `tipo`, `escuela_id`) VALUES
(1, 'Mamani', 'Pari', '951782520', '123456', '43631917', 'dd@gmail.com', 'Activo', 'Dario', 'DTN', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `upeu_subactasis`
--

CREATE TABLE `upeu_subactasis` (
  `id` bigint(20) NOT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecha` date NOT NULL,
  `horasi` time(6) NOT NULL,
  `min_toler` time(6) NOT NULL,
  `offlinex` varchar(2) NOT NULL,
  `evento_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asis_actividad`
--
ALTER TABLE `asis_actividad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `asis_asistenciax`
--
ALTER TABLE `asis_asistenciax`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqxghrqv9yxk45gev1kbynala6` (`actividad_id`);

--
-- Indices de la tabla `asis_evento`
--
ALTER TABLE `asis_evento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7kcavb0625k9krhvomdls9cfd` (`actividad_id`),
  ADD KEY `FKlbljxljbqmo731yhftiidrqc2` (`periodo_id`);

--
-- Indices de la tabla `asis_inscritos`
--
ALTER TABLE `asis_inscritos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKp02hf020bwt4mjxmj4wpeyhov` (`actividad_id`);

--
-- Indices de la tabla `asis_materialesx`
--
ALTER TABLE `asis_materialesx`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKic3mokx8oljp3bptiihgxkjkb` (`actividad_id`);

--
-- Indices de la tabla `asis_produccion`
--
ALTER TABLE `asis_produccion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `asis_subactasisx`
--
ALTER TABLE `asis_subactasisx`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKt3ntxue4q2sx5wxrlnrc6e8d0` (`actividad_id`);

--
-- Indices de la tabla `global_usuario_rol`
--
ALTER TABLE `global_usuario_rol`
  ADD PRIMARY KEY (`usuario_id`,`rol_id`),
  ADD KEY `FKp8ulk53js4l5c0nxbudxd34tl` (`rol_id`);

--
-- Indices de la tabla `gobal_rol`
--
ALTER TABLE `gobal_rol`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `gobal_usuario`
--
ALTER TABLE `gobal_usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `upeu_asistencia`
--
ALTER TABLE `upeu_asistencia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcmk7kpgdrvi1rexe5xnx7w3sy` (`matricula_id`),
  ADD KEY `FKrh5q40pkf1lxr2p72mwieocak` (`evento_id`);

--
-- Indices de la tabla `upeu_escuela`
--
ALTER TABLE `upeu_escuela`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKi6bq6spxryc8ri8tagrhr6f8n` (`facultad_id`);

--
-- Indices de la tabla `upeu_evento`
--
ALTER TABLE `upeu_evento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhkjivyoafa4oebwjpp1ct7rwb` (`periodo_id`);

--
-- Indices de la tabla `upeu_facultad`
--
ALTER TABLE `upeu_facultad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `upeu_materiales`
--
ALTER TABLE `upeu_materiales`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4y2ojl9qcan7vc2otfuk5wc1s` (`evento_id`),
  ADD KEY `FK6ihpgejosi0revo8cxo0c42yb` (`matricula_id`);

--
-- Indices de la tabla `upeu_matricula`
--
ALTER TABLE `upeu_matricula`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbl6tkqrinfnkseimi8o4s3mvy` (`periodo_id`),
  ADD KEY `FKrka3gnhkh2ndye2c4lv7ioxl8` (`persona_id`);

--
-- Indices de la tabla `upeu_periodo`
--
ALTER TABLE `upeu_periodo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `upeu_persona`
--
ALTER TABLE `upeu_persona`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkhqqsdy9tdqhuaqlkjynaidcn` (`escuela_id`);

--
-- Indices de la tabla `upeu_subactasis`
--
ALTER TABLE `upeu_subactasis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK349lx417micrjodnd865m1lhb` (`evento_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asis_actividad`
--
ALTER TABLE `asis_actividad`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de la tabla `asis_asistenciax`
--
ALTER TABLE `asis_asistenciax`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `asis_evento`
--
ALTER TABLE `asis_evento`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `asis_inscritos`
--
ALTER TABLE `asis_inscritos`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `asis_materialesx`
--
ALTER TABLE `asis_materialesx`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `asis_produccion`
--
ALTER TABLE `asis_produccion`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `asis_subactasisx`
--
ALTER TABLE `asis_subactasisx`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `gobal_rol`
--
ALTER TABLE `gobal_rol`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `gobal_usuario`
--
ALTER TABLE `gobal_usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `images`
--
ALTER TABLE `images`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `upeu_asistencia`
--
ALTER TABLE `upeu_asistencia`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `upeu_escuela`
--
ALTER TABLE `upeu_escuela`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `upeu_evento`
--
ALTER TABLE `upeu_evento`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `upeu_facultad`
--
ALTER TABLE `upeu_facultad`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `upeu_materiales`
--
ALTER TABLE `upeu_materiales`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `upeu_matricula`
--
ALTER TABLE `upeu_matricula`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `upeu_periodo`
--
ALTER TABLE `upeu_periodo`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=274;

--
-- AUTO_INCREMENT de la tabla `upeu_persona`
--
ALTER TABLE `upeu_persona`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `upeu_subactasis`
--
ALTER TABLE `upeu_subactasis`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asis_asistenciax`
--
ALTER TABLE `asis_asistenciax`
  ADD CONSTRAINT `FKqxghrqv9yxk45gev1kbynala6` FOREIGN KEY (`actividad_id`) REFERENCES `asis_actividad` (`id`);

--
-- Filtros para la tabla `asis_evento`
--
ALTER TABLE `asis_evento`
  ADD CONSTRAINT `FK7kcavb0625k9krhvomdls9cfd` FOREIGN KEY (`actividad_id`) REFERENCES `asis_actividad` (`id`),
  ADD CONSTRAINT `FKlbljxljbqmo731yhftiidrqc2` FOREIGN KEY (`periodo_id`) REFERENCES `upeu_periodo` (`id`);

--
-- Filtros para la tabla `asis_inscritos`
--
ALTER TABLE `asis_inscritos`
  ADD CONSTRAINT `FKp02hf020bwt4mjxmj4wpeyhov` FOREIGN KEY (`actividad_id`) REFERENCES `asis_actividad` (`id`);

--
-- Filtros para la tabla `asis_materialesx`
--
ALTER TABLE `asis_materialesx`
  ADD CONSTRAINT `FKic3mokx8oljp3bptiihgxkjkb` FOREIGN KEY (`actividad_id`) REFERENCES `asis_actividad` (`id`);

--
-- Filtros para la tabla `asis_subactasisx`
--
ALTER TABLE `asis_subactasisx`
  ADD CONSTRAINT `FKt3ntxue4q2sx5wxrlnrc6e8d0` FOREIGN KEY (`actividad_id`) REFERENCES `asis_actividad` (`id`);

--
-- Filtros para la tabla `global_usuario_rol`
--
ALTER TABLE `global_usuario_rol`
  ADD CONSTRAINT `FK7c58vygd75tq899d94hxr5ubw` FOREIGN KEY (`usuario_id`) REFERENCES `gobal_usuario` (`id`),
  ADD CONSTRAINT `FKp8ulk53js4l5c0nxbudxd34tl` FOREIGN KEY (`rol_id`) REFERENCES `gobal_rol` (`id`);

--
-- Filtros para la tabla `upeu_asistencia`
--
ALTER TABLE `upeu_asistencia`
  ADD CONSTRAINT `FKcmk7kpgdrvi1rexe5xnx7w3sy` FOREIGN KEY (`matricula_id`) REFERENCES `upeu_matricula` (`id`),
  ADD CONSTRAINT `FKpmfydfcoljuo3babherh3mjsh` FOREIGN KEY (`evento_id`) REFERENCES `upeu_evento` (`id`),
  ADD CONSTRAINT `FKrh5q40pkf1lxr2p72mwieocak` FOREIGN KEY (`evento_id`) REFERENCES `asis_evento` (`id`);

--
-- Filtros para la tabla `upeu_escuela`
--
ALTER TABLE `upeu_escuela`
  ADD CONSTRAINT `FKi6bq6spxryc8ri8tagrhr6f8n` FOREIGN KEY (`facultad_id`) REFERENCES `upeu_facultad` (`id`);

--
-- Filtros para la tabla `upeu_evento`
--
ALTER TABLE `upeu_evento`
  ADD CONSTRAINT `FKhkjivyoafa4oebwjpp1ct7rwb` FOREIGN KEY (`periodo_id`) REFERENCES `upeu_periodo` (`id`);

--
-- Filtros para la tabla `upeu_materiales`
--
ALTER TABLE `upeu_materiales`
  ADD CONSTRAINT `FK4y2ojl9qcan7vc2otfuk5wc1s` FOREIGN KEY (`evento_id`) REFERENCES `upeu_evento` (`id`),
  ADD CONSTRAINT `FK6ihpgejosi0revo8cxo0c42yb` FOREIGN KEY (`matricula_id`) REFERENCES `upeu_matricula` (`id`);

--
-- Filtros para la tabla `upeu_matricula`
--
ALTER TABLE `upeu_matricula`
  ADD CONSTRAINT `FKbl6tkqrinfnkseimi8o4s3mvy` FOREIGN KEY (`periodo_id`) REFERENCES `upeu_periodo` (`id`),
  ADD CONSTRAINT `FKrka3gnhkh2ndye2c4lv7ioxl8` FOREIGN KEY (`persona_id`) REFERENCES `upeu_persona` (`id`);

--
-- Filtros para la tabla `upeu_persona`
--
ALTER TABLE `upeu_persona`
  ADD CONSTRAINT `FKkhqqsdy9tdqhuaqlkjynaidcn` FOREIGN KEY (`escuela_id`) REFERENCES `upeu_escuela` (`id`);

--
-- Filtros para la tabla `upeu_subactasis`
--
ALTER TABLE `upeu_subactasis`
  ADD CONSTRAINT `FK349lx417micrjodnd865m1lhb` FOREIGN KEY (`evento_id`) REFERENCES `asis_evento` (`id`),
  ADD CONSTRAINT `FKr8q74flwiabic0b7v64sxwedr` FOREIGN KEY (`evento_id`) REFERENCES `upeu_evento` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
