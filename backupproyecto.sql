--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'SQL_ASCII';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: secuencia_id_cotizacion; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE secuencia_id_cotizacion
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE secuencia_id_cotizacion OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: cotizacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE cotizacion (
    id_cotizacion integer DEFAULT nextval('secuencia_id_cotizacion'::regclass) NOT NULL,
    id_vehiculo integer,
    id_usuario integer,
    id_sede integer,
    fecha date
);


ALTER TABLE cotizacion OWNER TO postgres;

--
-- Name: orden_de_trabajo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE orden_de_trabajo (
    id_orden integer NOT NULL,
    id_usuario integer,
    id_repuesto integer,
    id_vehiculo integer,
    id_sede integer,
    cantidad_repuesto integer,
    descripcion character varying(500)
);


ALTER TABLE orden_de_trabajo OWNER TO postgres;

--
-- Name: recuperacionencriptacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE recuperacionencriptacion (
    cuenta_desencriptada character varying(120),
    contrasena_desencriptada character varying(120),
    pin character varying(120),
    cedula integer
);


ALTER TABLE recuperacionencriptacion OWNER TO postgres;

--
-- Name: secuencia_id_repuesto; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE secuencia_id_repuesto
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE secuencia_id_repuesto OWNER TO postgres;

--
-- Name: repuestos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE repuestos (
    id_repuesto integer DEFAULT nextval('secuencia_id_repuesto'::regclass) NOT NULL,
    id_sede integer,
    nombre character varying(100),
    cantidad integer,
    precio_unidad integer,
    iva integer,
    descripcion character varying(500)
);


ALTER TABLE repuestos OWNER TO postgres;

--
-- Name: repuestos_vehiculos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE repuestos_vehiculos (
    id_repuesto integer NOT NULL,
    id_vehiculo integer NOT NULL
);


ALTER TABLE repuestos_vehiculos OWNER TO postgres;

--
-- Name: secuencia_id_orden_de_trabajo; Type: SEQUENCE; Schema: public; Owner: erik
--

CREATE SEQUENCE secuencia_id_orden_de_trabajo
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE secuencia_id_orden_de_trabajo OWNER TO erik;

--
-- Name: secuencia_id_vehiculo; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE secuencia_id_vehiculo
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE secuencia_id_vehiculo OWNER TO postgres;

--
-- Name: secuencia_id_venta; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE secuencia_id_venta
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE secuencia_id_venta OWNER TO postgres;

--
-- Name: sedes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE sedes (
    id_sede integer NOT NULL,
    nombre character varying(100),
    ciudad character varying(50),
    direccion character varying(100),
    telefono character varying(20),
    fax character varying(20)
);


ALTER TABLE sedes OWNER TO postgres;

--
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usuarios (
    cedula integer NOT NULL,
    id_sede integer,
    nombre character varying(100),
    fecha_nacimiento date,
    direccion character varying(100),
    genero character(1),
    e_mail character varying(100),
    cargo integer,
    salario integer,
    telefono character varying(20),
    estado character varying(20),
    cuenta character varying(120),
    contrasena character varying(120)
);


ALTER TABLE usuarios OWNER TO postgres;

--
-- Name: vehiculos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE vehiculos (
    id_vehiculo integer DEFAULT nextval('secuencia_id_vehiculo'::regclass) NOT NULL,
    id_sede integer,
    color character varying(50),
    marca character varying(50),
    referencia character varying(50),
    tipo character varying(20),
    traccion character varying(20),
    modelo character varying(20),
    precio integer,
    iva integer,
    estado character varying(20)
);


ALTER TABLE vehiculos OWNER TO postgres;

--
-- Name: venta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE venta (
    id_venta integer DEFAULT nextval('secuencia_id_venta'::regclass) NOT NULL,
    id_vehiculo integer,
    id_usuario integer,
    id_sede integer,
    formadepago character varying(30),
    fecha date,
    cedula_cliente character varying(50),
    nombre_cliente character varying(100),
    telefono_cliente character varying(10)
);


ALTER TABLE venta OWNER TO postgres;

--
-- Data for Name: cotizacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cotizacion (id_cotizacion, id_vehiculo, id_usuario, id_sede, fecha) FROM stdin;
1	2	1109948394	6	2016-12-14
\.


--
-- Data for Name: orden_de_trabajo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY orden_de_trabajo (id_orden, id_usuario, id_repuesto, id_vehiculo, id_sede, cantidad_repuesto, descripcion) FROM stdin;
12	1109498849	4	1	3	4	Urgentemente
14	1109498849	4	5	3	2	urgente!
13	1109498849	3	7	3	2	urgente! 
\.


--
-- Data for Name: recuperacionencriptacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY recuperacionencriptacion (cuenta_desencriptada, contrasena_desencriptada, pin, cedula) FROM stdin;
Alevale	Alevale	37712056156	1120309485
Juavar	Juavar	84901842479	1120309485
Pedper	Pedper	364225255579	1120309485
\.


--
-- Data for Name: repuestos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY repuestos (id_repuesto, id_sede, nombre, cantidad, precio_unidad, iva, descripcion) FROM stdin;
2	1	Cogin	30	300000	400	juego de cojines para auto
3	1	Retrovisor	15	40000	300	juego de retrovisores
4	1	Radio	10	40000	400	radio para auto
6	1	Chazis	10	400000	200	chazis para auto
8	1	luces traseras	20	20000	300	luces traseras para autos Chevrolet
9	1	luces direccionales	20	15000	250	luces direccionales para cualquier marca
10	1	rin-bmw	10	50000	500	rines para autos BMW
11	1	vidrio panoramico delantero	10	100000	500	vidrios panoramico para autos Chevrolet
12	1	volante	30	30000	300	volante para diferentes marcas de autos
13	1	palanca de cambios	15	20000	250	palanca de cambios para diferentes marcas de autos
14	1	carburador	10	50000	300	carburador para autos de marca Kia
15	1	Retrovisor trival	15	50000	250	retrovisor con exclusivo diseño
16	1	car audio	5	200000	300	sistema de car audio personalizable
17	1	set de tormillos	20	40000	200	juego de tornillos genericos
18	1	calcomania	50	10000	100	calcomania con el logo de autos ABC
19	1	rin-pagani	5	1000000	10000	rin esclusivo para autos pagani
20	1	neumatico	20	30000	250	neumatico generico
1	1	Rin	4	80000	200	rin para llanta de auto
5	1	Sonido	2	400000	200	juego de parlantes para auto
7	1	luces delanteras	2	20000	300	luces delanteras para autos Chevrolet
\.


--
-- Data for Name: repuestos_vehiculos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY repuestos_vehiculos (id_repuesto, id_vehiculo) FROM stdin;
\.


--
-- Name: secuencia_id_cotizacion; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('secuencia_id_cotizacion', 1, true);


--
-- Name: secuencia_id_orden_de_trabajo; Type: SEQUENCE SET; Schema: public; Owner: erik
--

SELECT pg_catalog.setval('secuencia_id_orden_de_trabajo', 1, false);


--
-- Name: secuencia_id_repuesto; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('secuencia_id_repuesto', 20, true);


--
-- Name: secuencia_id_vehiculo; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('secuencia_id_vehiculo', 10, true);


--
-- Name: secuencia_id_venta; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('secuencia_id_venta', 2, true);


--
-- Data for Name: sedes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sedes (id_sede, nombre, ciudad, direccion, telefono, fax) FROM stdin;
1	yanaconas	cali	calle 3 # 45a-12	3323456	343456
2	automotores	palmira	carrera 4 # 23-97	4455234	345203
3	AutoPacifico	Buenaventura	Av 4 # 9-12	5544367	345412
4	AutoSuperior	cali	calle 5 #46a-23	3348769	239856
5	CasaRestrepo	bogota	Av 5 # 34-34	5544336	598934
6	AutoMar	cartagena	calle 20 # 34-32	2230958	344321
7	Laureles	medellin	carrera 56 # 32-34	3344509	340958
8	ContinAutos	cali	calle 3 # 34-45	3344056	320956
9	GeneralMotors	bogota	carrera 3 # 34-56	2200989	3400584
\.


--
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuarios (cedula, id_sede, nombre, fecha_nacimiento, direccion, genero, e_mail, cargo, salario, telefono, estado, cuenta, contrasena) FROM stdin;
1134495960	1	Andres hurtado	1982-10-23	calle 4 # 34-45	M	hurtado.andres_ho@yahoo.co	3	800000	3344554	activo	FALTA-CONTRASEÑA	FALTA-CONTRASEÑA
1122394859	2	Angela Henao	1994-09-21	carrera 5 # 3-32	F	Henao.An1998@Mye-mail.com	3	750000	2233454	activo	FALTA-CONTRASEÑA	FALTA-CONTRASEÑA
1109498849	3	Pedro Perez	1992-03-15	calle 4 # 32-67	M	pepedrorez@mysql.com	2	1000000	4455968	activo	6d]<btWRJ/^$<UJkN(	N}WMb|#TanmdM$j;0s
230049958	4	Patricia Soto	1976-01-09	Avenida 4 # 34-45	F	paty-soto@gmail.com	3	850000	3399485	activo	FALTA-CONTRASEÑA	FALTA-CONTRASEÑA
1120309485	5	Alejandro Valencia	1991-05-07	calle 5 # 32-34	M	alevari@hotmail.com	1	2000000	3344959	activo	&tPMyTYF]c`kBzvfa3Lk=	tYv]+KWqw`T31ZAdlb&*G
1109948394	6	Juan varela 	1993-12-19	carrera 4 # 34-45	M	Varela.juan-123@gmail.com	3	800000	4455948	activo	{]>+[RT@XLeJ4U2kCN	TD-ZlUnS]5V}F:*4cl
34958478	7	Jairo Diaz rincon	1984-07-11	calle 45 # 3-23	M	dia-jairo@hotmail.com	3	800000	3344059	activo	FALTA-CONTRASEÑA	FALTA-CONTRASEÑA
\.


--
-- Data for Name: vehiculos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY vehiculos (id_vehiculo, id_sede, color, marca, referencia, tipo, traccion, modelo, precio, iva, estado) FROM stdin;
1	1	verde	Mazda	3	sedan	trasera	2013	54989999	20000	DISPONIBLE
2	1	negro	Chevrolet	spak	coupe	doble	2016	89579999	30000	DISPONIBLE
3	1	rojo	Honda	huang	sedan	delantera	2014	34560000	20000	DISPONIBLE
4	1	azul	Audi	scorpion	sedan	trasera	2013	54697000	30000	DISPONIBLE
6	1	verde	pagani	zonda	coupe	trasera	2016	2050060000	1000000	DISPONIBLE
7	1	negro	Chevrolet	camaro	coupe	trasera	2015	120495598	10000	DISPONIBLE
9	1	blando	Kia	Cerato	coupe	trasera	2015	85698958	50000	DISPONIBLE
10	1	rojo	Chevrolet	Spark-GT	sedan	delantera	2015	46596958	20000	DISPONIBLE
5	1	blanco	Kia	soul	sedan	doble	2015	67986000	40000	VENDIDO
8	1	amarillo	Ford	Mustang	coupe	trasera	2014	100490509	200000	VENDIDO
\.


--
-- Data for Name: venta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY venta (id_venta, id_vehiculo, id_usuario, id_sede, formadepago, fecha, cedula_cliente, nombre_cliente, telefono_cliente) FROM stdin;
1	5	1109948394	6	EFECTIVO	2016-12-14	110710359	Alejandro Valencia	326165
2	8	1109948394	6	EFECTIVO	2016-12-14	1123495843	Alejandro	2321344
\.


--
-- Name: cotizacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cotizacion
    ADD CONSTRAINT cotizacion_pkey PRIMARY KEY (id_cotizacion);


--
-- Name: orden_de_trabajo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orden_de_trabajo
    ADD CONSTRAINT orden_de_trabajo_pkey PRIMARY KEY (id_orden);


--
-- Name: repuestos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY repuestos
    ADD CONSTRAINT repuestos_pkey PRIMARY KEY (id_repuesto);


--
-- Name: repuestos_vehiculos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY repuestos_vehiculos
    ADD CONSTRAINT repuestos_vehiculos_pkey PRIMARY KEY (id_vehiculo, id_repuesto);


--
-- Name: sedes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sedes
    ADD CONSTRAINT sedes_pkey PRIMARY KEY (id_sede);


--
-- Name: usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (cedula);


--
-- Name: vehiculos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY vehiculos
    ADD CONSTRAINT vehiculos_pkey PRIMARY KEY (id_vehiculo);


--
-- Name: venta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY venta
    ADD CONSTRAINT venta_pkey PRIMARY KEY (id_venta);


--
-- Name: cotizacion_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cotizacion
    ADD CONSTRAINT cotizacion_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES usuarios(cedula);


--
-- Name: cotizacion_id_vehiculo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cotizacion
    ADD CONSTRAINT cotizacion_id_vehiculo_fkey FOREIGN KEY (id_vehiculo) REFERENCES vehiculos(id_vehiculo);


--
-- Name: orden_de_trabajo_id_repuesto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orden_de_trabajo
    ADD CONSTRAINT orden_de_trabajo_id_repuesto_fkey FOREIGN KEY (id_repuesto) REFERENCES repuestos(id_repuesto);


--
-- Name: orden_de_trabajo_id_sede_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orden_de_trabajo
    ADD CONSTRAINT orden_de_trabajo_id_sede_fkey FOREIGN KEY (id_sede) REFERENCES sedes(id_sede);


--
-- Name: orden_de_trabajo_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orden_de_trabajo
    ADD CONSTRAINT orden_de_trabajo_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES usuarios(cedula);


--
-- Name: orden_de_trabajo_id_vehiculo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orden_de_trabajo
    ADD CONSTRAINT orden_de_trabajo_id_vehiculo_fkey FOREIGN KEY (id_vehiculo) REFERENCES vehiculos(id_vehiculo);


--
-- Name: repuestos_id_sede_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY repuestos
    ADD CONSTRAINT repuestos_id_sede_fkey FOREIGN KEY (id_sede) REFERENCES sedes(id_sede);


--
-- Name: repuestos_vehiculos_id_repuesto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY repuestos_vehiculos
    ADD CONSTRAINT repuestos_vehiculos_id_repuesto_fkey FOREIGN KEY (id_repuesto) REFERENCES repuestos(id_repuesto);


--
-- Name: repuestos_vehiculos_id_vehiculo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY repuestos_vehiculos
    ADD CONSTRAINT repuestos_vehiculos_id_vehiculo_fkey FOREIGN KEY (id_vehiculo) REFERENCES vehiculos(id_vehiculo);


--
-- Name: usuarios_id_sede_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT usuarios_id_sede_fkey FOREIGN KEY (id_sede) REFERENCES sedes(id_sede);


--
-- Name: vehiculos_id_sede_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY vehiculos
    ADD CONSTRAINT vehiculos_id_sede_fkey FOREIGN KEY (id_sede) REFERENCES sedes(id_sede);


--
-- Name: venta_id_sede_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY venta
    ADD CONSTRAINT venta_id_sede_fkey FOREIGN KEY (id_sede) REFERENCES sedes(id_sede);


--
-- Name: venta_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY venta
    ADD CONSTRAINT venta_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES usuarios(cedula);


--
-- Name: venta_id_vehiculo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY venta
    ADD CONSTRAINT venta_id_vehiculo_fkey FOREIGN KEY (id_vehiculo) REFERENCES vehiculos(id_vehiculo);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

