-- ============================================================
-- Comiquería
-- Migración inicial de base de datos
-- Flyway: V1__estructura_inicial.sql
-- Generado a partir del esquema actual de comiqueria_db
-- ============================================================

CREATE TABLE `paises` (
  `pais_id` bigint NOT NULL AUTO_INCREMENT,
  `pais_esta_vigente` bit(1) DEFAULT NULL,
  `pais_fecha_alta` datetime(6) DEFAULT NULL,
  `pais_fecha_baja` datetime(6) DEFAULT NULL,
  `pais_nombre` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`pais_id`),
  UNIQUE KEY `UKs0f6w1fkkxt992ego249e33s5` (`pais_nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `provincias` (
  `prov_id` bigint NOT NULL AUTO_INCREMENT,
  `prov_esta_vigente` bit(1) DEFAULT NULL,
  `prov_fecha_alta` datetime(6) DEFAULT NULL,
  `prov_fecha_baja` datetime(6) DEFAULT NULL,
  `prov_nombre` varchar(30) DEFAULT NULL,
  `prov_pais_id` bigint DEFAULT NULL,
  PRIMARY KEY (`prov_id`),
  UNIQUE KEY `UKnstky815hxt8rxvgioti5lnr5` (`prov_nombre`),
  KEY `FKaukrn5jko35c2t5mfqcedcqs5` (`prov_pais_id`),
  CONSTRAINT `FKaukrn5jko35c2t5mfqcedcqs5` FOREIGN KEY (`prov_pais_id`) REFERENCES `paises` (`pais_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `departamentos` (
  `dep_id` bigint NOT NULL AUTO_INCREMENT,
  `dep_esta_vigente` bit(1) DEFAULT NULL,
  `dep_fecha_alta` datetime(6) DEFAULT NULL,
  `dep_fecha_baja` datetime(6) DEFAULT NULL,
  `dep_nombre` varchar(50) DEFAULT NULL,
  `dep_prov_id` bigint NOT NULL,
  PRIMARY KEY (`dep_id`),
  KEY `FKeq4pn7n95fyhd5y1ydcvtnbl5` (`dep_prov_id`),
  CONSTRAINT `FKeq4pn7n95fyhd5y1ydcvtnbl5` FOREIGN KEY (`dep_prov_id`) REFERENCES `provincias` (`prov_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `localidades` (
  `loc_id` bigint NOT NULL AUTO_INCREMENT,
  `loc_esta_vigente` bit(1) DEFAULT NULL,
  `loc_fecha_alta` datetime(6) DEFAULT NULL,
  `loc_fecha_baja` datetime(6) DEFAULT NULL,
  `loc_nombre` varchar(30) DEFAULT NULL,
  `loc_dep_id` bigint NOT NULL,
  PRIMARY KEY (`loc_id`),
  KEY `FKlo5gydd4s7438fdk0uxqca8ah` (`loc_dep_id`),
  CONSTRAINT `FKlo5gydd4s7438fdk0uxqca8ah` FOREIGN KEY (`loc_dep_id`) REFERENCES `departamentos` (`dep_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `usuarios` (
  `usr_id` bigint NOT NULL AUTO_INCREMENT,
  `usr_email` varchar(100) DEFAULT NULL,
  `usr_esta_activo` bit(1) DEFAULT NULL,
  `usr_fecha_alta` datetime(6) DEFAULT NULL,
  `usr_fecha_baja` datetime(6) DEFAULT NULL,
  `usr_password_hash` varchar(255) DEFAULT NULL,
  `usr_rptoken` varchar(255) DEFAULT NULL,
  `usr_rtokened` datetime(6) DEFAULT NULL,
  `usr_rol` enum('ADMIN','CLIENTE','EMPLEADO') DEFAULT NULL,
  `usr_ultimo_login` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`usr_id`),
  UNIQUE KEY `UKj31m7vu513v5qtgdcklqvopwk` (`usr_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `clientes` (
  `cte_id` bigint NOT NULL AUTO_INCREMENT,
  `cte_apellido` varchar(30) DEFAULT NULL,
  `cte_esta_vigente` bit(1) DEFAULT NULL,
  `cte_fecha_alta` datetime(6) DEFAULT NULL,
  `cte_fecha_baja` datetime(6) DEFAULT NULL,
  `cte_fecha_nac` date DEFAULT NULL,
  `cte_nombre` varchar(30) DEFAULT NULL,
  `cte_documento` varchar(255) DEFAULT NULL,
  `cte_sexo` enum('FEMENINO','MASCULINO','OTRO','PREFIERO_NO_DECIRLO') DEFAULT NULL,
  `cte_telefono` varchar(20) DEFAULT NULL,
  `cte_tipo_doc` enum('CEDULA_IDENTIDAD','CUIT_CUIL','DNI','LIBRETA_CIVICA','LIBRETA_ENROLAMIENTO','OTRO','PASAPORTE') DEFAULT NULL,
  `usr_id` bigint NOT NULL,
  PRIMARY KEY (`cte_id`),
  UNIQUE KEY `UK1j31k5bbi5g5qc9pod0xuao1g` (`usr_id`),
  UNIQUE KEY `UKpk9cnvmy8r3577uisqc8mfciw` (`cte_documento`),
  CONSTRAINT `FKmfr0lysgdreekyu9sd9g4b8ty` FOREIGN KEY (`usr_id`) REFERENCES `usuarios` (`usr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `domicilios` (
  `dom_id` bigint NOT NULL AUTO_INCREMENT,
  `dom_altura` varchar(10) DEFAULT NULL,
  `dom_calle` text,
  `dom_cp` varchar(8) DEFAULT NULL,
  `dom_depto` varchar(10) DEFAULT NULL,
  `dom_esta_vigente` bit(1) DEFAULT NULL,
  `dom_fecha_alta` date DEFAULT NULL,
  `dom_fecha_baja` date DEFAULT NULL,
  `dom_cte_id` bigint NOT NULL,
  `dom_loc_id` bigint NOT NULL,
  PRIMARY KEY (`dom_id`),
  KEY `FK1kqopccnonm4ptuwroqlf3tc5` (`dom_cte_id`),
  KEY `FKe6s5vgipq9tyma7c8wxsni0v9` (`dom_loc_id`),
  CONSTRAINT `FK1kqopccnonm4ptuwroqlf3tc5` FOREIGN KEY (`dom_cte_id`) REFERENCES `clientes` (`cte_id`),
  CONSTRAINT `FKe6s5vgipq9tyma7c8wxsni0v9` FOREIGN KEY (`dom_loc_id`) REFERENCES `localidades` (`loc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `categorias` (
  `cat_id` bigint NOT NULL AUTO_INCREMENT,
  `cat_esta_vigente` bit(1) DEFAULT NULL,
  `cat_fecha_alta` datetime(6) DEFAULT NULL,
  `cat_fecha_baja` datetime(6) DEFAULT NULL,
  `cat_nombre` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cat_id`),
  UNIQUE KEY `UKksu9haqqn1308gq0n5ot5ubmx` (`cat_nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `subcategorias` (
  `subcat_id` bigint NOT NULL AUTO_INCREMENT,
  `subcat_esta_vigente` bit(1) DEFAULT NULL,
  `subcat_fecha_alta` datetime(6) DEFAULT NULL,
  `subcat_fecha_baja` datetime(6) DEFAULT NULL,
  `subcat_nombre` varchar(30) DEFAULT NULL,
  `subcat_cat_id` bigint DEFAULT NULL,
  PRIMARY KEY (`subcat_id`),
  UNIQUE KEY `UKlsvij0wlrpdcyalj59r90rdy8` (`subcat_nombre`),
  KEY `FKogt5vil0uvdi77ehea9wtbyas` (`subcat_cat_id`),
  CONSTRAINT `FKogt5vil0uvdi77ehea9wtbyas` FOREIGN KEY (`subcat_cat_id`) REFERENCES `categorias` (`cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `editoriales` (
  `edit_id` bigint NOT NULL AUTO_INCREMENT,
  `edit_esta_vigente` bit(1) DEFAULT NULL,
  `edit_fecha_alta` datetime(6) DEFAULT NULL,
  `edit_fecha_baja` datetime(6) DEFAULT NULL,
  `edit_nombre` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`edit_id`),
  UNIQUE KEY `UKojdh2w1p23e75ygds7629gi14` (`edit_nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `autores` (
  `aut_id` bigint NOT NULL AUTO_INCREMENT,
  `aut_apellido` varchar(30) DEFAULT NULL,
  `aut_esta_vigente` bit(1) DEFAULT NULL,
  `aut_fecha_alta` date DEFAULT NULL,
  `aut_fecha_baja` date DEFAULT NULL,
  `aut_nombre` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`aut_id`),
  UNIQUE KEY `UK4fwa0vd6uwjygbvhixrnu7nso` (`aut_nombre`,`aut_apellido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `productos` (
  `prod_id` bigint NOT NULL AUTO_INCREMENT,
  `prod_descripcion` text,
  `prod_dimensiones` varchar(30) DEFAULT NULL,
  `prod_es_mas_vendido` bit(1) DEFAULT NULL,
  `prod_es_novedad` bit(1) DEFAULT NULL,
  `prod_es_oferta` bit(1) DEFAULT NULL,
  `prod_index` bit(1) DEFAULT NULL,
  `prod_esta_vigente` bit(1) DEFAULT NULL,
  `prod_fecha_alta` datetime(6) DEFAULT NULL,
  `prod_fecha_baja` datetime(6) DEFAULT NULL,
  `prod_isbn` varchar(30) DEFAULT NULL,
  `prod_paginas` int DEFAULT NULL,
  `prod_peso` int DEFAULT NULL,
  `prod_precio` decimal(38,2) DEFAULT NULL,
  `prod_tapa` text,
  `prod_titulo` text,
  `prod_edit_id` bigint DEFAULT NULL,
  `prod_subcat_id` bigint DEFAULT NULL,
  PRIMARY KEY (`prod_id`),
  UNIQUE KEY `UK8141ydev3qy7crf4o9y10e2eu` (`prod_isbn`),
  KEY `FKp6ffr0apjwsoejnp7ewe78swb` (`prod_edit_id`),
  KEY `FKegs5fke4u0rutb3v8lru33ym6` (`prod_subcat_id`),
  CONSTRAINT `FKegs5fke4u0rutb3v8lru33ym6` FOREIGN KEY (`prod_subcat_id`) REFERENCES `subcategorias` (`subcat_id`),
  CONSTRAINT `FKp6ffr0apjwsoejnp7ewe78swb` FOREIGN KEY (`prod_edit_id`) REFERENCES `editoriales` (`edit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `productos-autores` (
  `aut_id` bigint NOT NULL,
  `prod_id` bigint NOT NULL,
  PRIMARY KEY (`aut_id`,`prod_id`),
  KEY `FKo1wp5rna4b8qe8arxo0yt3tdt` (`prod_id`),
  CONSTRAINT `FKo1wp5rna4b8qe8arxo0yt3tdt` FOREIGN KEY (`prod_id`) REFERENCES `productos` (`prod_id`),
  CONSTRAINT `FKt81nkwxykk663g5o32p0xqqsh` FOREIGN KEY (`aut_id`) REFERENCES `autores` (`aut_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cte_producto_favorito` (
  `cte_id` bigint NOT NULL,
  `prod_id` bigint NOT NULL,
  PRIMARY KEY (`cte_id`,`prod_id`),
  KEY `FKike2c83ntsr00q3h7yyouafvr` (`prod_id`),
  CONSTRAINT `FKg1tu3fh3qwiifi9e3bminsjex` FOREIGN KEY (`cte_id`) REFERENCES `clientes` (`cte_id`),
  CONSTRAINT `FKike2c83ntsr00q3h7yyouafvr` FOREIGN KEY (`prod_id`) REFERENCES `productos` (`prod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `ventas` (
  `vta_id` bigint NOT NULL AUTO_INCREMENT,
  `vta_estado` enum('CANCELADA','COMPLETADA','DEVUELTA','ENTREGADA','EN_ENVIO','PENDIENTE') NOT NULL,
  `vta_fecha_vta` datetime(6) NOT NULL,
  `vta_total` decimal(10,2) NOT NULL,
  `vta_cte_id` bigint NOT NULL,
  PRIMARY KEY (`vta_id`),
  KEY `FK520aka1y5o18h8xllg8l3nxi7` (`vta_cte_id`),
  CONSTRAINT `FK520aka1y5o18h8xllg8l3nxi7` FOREIGN KEY (`vta_cte_id`) REFERENCES `clientes` (`cte_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `lineas_ventas` (
  `linea_id` bigint NOT NULL AUTO_INCREMENT,
  `linea_cantidad` int DEFAULT NULL,
  `linea_precio` decimal(10,2) NOT NULL,
  `linea_prod_id` bigint DEFAULT NULL,
  `linea_vta_id` bigint NOT NULL,
  PRIMARY KEY (`linea_id`),
  KEY `FKece6fngnu5jca71sro0rotldi` (`linea_prod_id`),
  KEY `FKa2l98ff8vk0skvit57af46bpm` (`linea_vta_id`),
  CONSTRAINT `FKa2l98ff8vk0skvit57af46bpm` FOREIGN KEY (`linea_vta_id`) REFERENCES `ventas` (`vta_id`),
  CONSTRAINT `FKece6fngnu5jca71sro0rotldi` FOREIGN KEY (`linea_prod_id`) REFERENCES `productos` (`prod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `carruseles` (
  `car_id` bigint NOT NULL AUTO_INCREMENT,
  `car_esta_activo` bit(1) DEFAULT NULL,
  `car_imagen` text,
  `car_orden` int DEFAULT NULL,
  `car_subtitulo` varchar(50) DEFAULT NULL,
  `car_texto` varchar(100) DEFAULT NULL,
  `car_destino` text,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
