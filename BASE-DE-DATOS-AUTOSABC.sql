DROP TABLE IF EXISTS usuarios CASCADE;
DROP TABLE IF EXISTS sedes CASCADE;
DROP TABLE IF EXISTS vehiculos CASCADE;
DROP TABLE IF EXISTS repuestos CASCADE;
DROP TABLE IF EXISTS venta CASCADE;
DROP TABLE IF EXISTS cotizacion CASCADE;
DROP TABLE IF EXISTS orden_de_trabajo CASCADE;
DROP TABLE IF EXISTS repuestos_vehiculos CASCADE;
DROP TABLE IF EXISTS recuperacionEncriptacion CASCADE;


CREATE TABLE sedes (

	id_sede INT PRIMARY KEY,
	nombre VARCHAR(100),
	ciudad VARCHAR(50),
	direccion VARCHAR (100),
	telefono VARCHAR(20),
	fax VARCHAR (20)
	
);

CREATE TABLE usuarios (

	cedula INT PRIMARY KEY,
	id_sede INT,
	nombre VARCHAR(100),
	fecha_nacimiento DATE,
	direcion VARCHAR(100),
	genero CHAR(1),
	e_mail VARCHAR(100),
	cargo INT,
	salario INT,
	telefono VARCHAR(20),
	estado VARCHAR(20),
	cuenta VARCHAR(120),
	contrasena VARCHAR(120),
	FOREIGN KEY (id_sede) REFERENCES sedes(id_sede)
);

CREATE TABLE vehiculos (

	id_vehiculo INT PRIMARY KEY,
	id_sede INT,
	color VARCHAR(50),
	marca VARCHAR(50),
	referencia VARCHAR(50),
	tipo VARCHAR(20),
	traccion VARCHAR(20),
	modelo VARCHAR(20),
	precio INT,
	iva INT,
	FOREIGN KEY (id_sede) REFERENCES sedes(id_sede)
);


CREATE TABLE repuestos (

	id_repuesto INT PRIMARY KEY,
	id_sede INT,
	nombre VARCHAR(100),
	cantidad INT,
	precio_unidad INT,
	iva INT,
	descripcion VARCHAR(500),
	FOREIGN KEY (id_sede) REFERENCES sedes(id_sede)	
	
);


CREATE TABLE orden_de_trabajo (

	id_orden INT,
	id_usuario INT,
	id_repuesto INT,
	id_vehiculo INT,
	id_sede INT,
	descripcion INT,
	PRIMARY KEY (id_orden,id_usuario, id_repuesto,id_vehiculo,id_sede),
	FOREIGN KEY (id_vehiculo) REFERENCES vehiculos(id_vehiculo),
	FOREIGN KEY (id_repuesto) REFERENCES repuestos(id_repuesto),
	FOREIGN KEY (id_sede) REFERENCES sedes(id_sede),
	FOREIGN KEY (id_usuario) REFERENCES usuarios(cedula)
	
);

CREATE TABLE venta (

	id_venta INT,
	id_vehiculo INT,
	id_usuario INT,
	id_sede INT,
	precio INT,
	iva INT,
	fecha DATE,
	cedula_cliente VARCHAR(50),
	placa_vehiculo VARCHAR(40),
	PRIMARY KEY (id_venta,id_vehiculo, id_usuario,id_sede),
	FOREIGN KEY (id_vehiculo) REFERENCES vehiculos(id_vehiculo),
	FOREIGN KEY (id_usuario) REFERENCES usuarios(cedula),
	FOREIGN KEY (id_sede) REFERENCES sedes(id_sede)

);

CREATE TABLE cotizacion (

	id_cotizacion INT,
	id_vehiculo INT,
	id_usuario INT,
	id_sede INT,
	precio INT,
	iva INT,
	fecha DATE,
	PRIMARY KEY (id_cotizacion,id_vehiculo, id_usuario),
	FOREIGN KEY (id_vehiculo) REFERENCES vehiculos(id_vehiculo),
	FOREIGN KEY (id_usuario) REFERENCES usuarios(cedula)
	
);

CREATE TABLE repuestos_vehiculos (

	id_repuesto INT,
	id_vehiculo INT,
	PRIMARY KEY (id_vehiculo, id_repuesto),
	FOREIGN KEY (id_vehiculo) REFERENCES vehiculos(id_vehiculo),
	FOREIGN KEY (id_repuesto) REFERENCES repuestos(id_repuesto)

);

CREATE TABLE recuperacionEncriptacion (
	cuenta VARCHAR(120),
	contrasena VARCHAR(120),
	pin VARCHAR(120),
	cedula INT
);

INSERT INTO recuperacionEncriptacion VALUES ('Alevale', 'Alevale',552107685672,1120309485);

INSERT INTO sedes  VALUES (01, 'yanaconas',     'cali',         'calle 3 # 45a-12',   '3323456', '343456');
INSERT INTO sedes  VALUES (02, 'automotores',   'palmira',      'carrera 4 # 23-97',  '4455234', '345203');
INSERT INTO sedes  VALUES (03, 'AutoPacifico',  'Buenaventura', 'Av 4 # 9-12',        '5544367', '345412');
INSERT INTO sedes  VALUES (04, 'AutoSuperior',  'cali',         'calle 5 #46a-23',    '3348769', '239856');
INSERT INTO sedes  VALUES (05, 'CasaRestrepo',  'bogota',       'Av 5 # 34-34',       '5544336', '598934');
INSERT INTO sedes  VALUES (06, 'AutoMar',       'cartagena',    'calle 20 # 34-32',   '2230958', '344321');
INSERT INTO sedes  VALUES (07, 'Laureles',      'medellin',     'carrera 56 # 32-34', '3344509', '340958');
INSERT INTO sedes  VALUES (08, 'ContinAutos',   'cali',         'calle 3 # 34-45',    '3344056', '320956');
INSERT INTO sedes  VALUES (09, 'GeneralMotors', 'bogota',       'carrera 3 # 34-56',  '2200989', '3400584');


INSERT INTO usuarios  VALUES (1134495960, 01, 'Andres hurtado',     '1982-10-23', 'calle 4 # 34-45',   'M', 'hurtado.andres_ho@yahoo.co', 3, 800000,  '3344554', 'activo', 'Andrehurr', 'Andrehurr');
INSERT INTO usuarios  VALUES (1122394859, 02, 'Angela Henao',       '1994-09-21', 'carrera 5 # 3-32',  'F', 'Henao.An1998@Mye-mail.com' , 3, 750000,  '2233454', 'activo', 'Anghen',   'Anghen');
INSERT INTO usuarios  VALUES (1109498849, 03, 'Pedro Perez',        '1992-03-15', 'calle 4 # 32-67',   'M', 'pepedrorez@mysql.com'      , 2, 1000000, '4455968', 'activo', 'Pedper',   'Pedper');
INSERT INTO usuarios  VALUES (230049958,  04, 'Patricia Soto',      '1976-01-09', 'Avenida 4 # 34-45', 'F', 'paty-soto@gmail.com'       , 3, 850000,  '3399485', 'activo', 'Patsot',   'Patsot');
INSERT INTO usuarios  VALUES (1120309485, 05, 'Alejandro Valencia', '1991-05-07', 'calle 5 # 32-34',   'M', 'alevari@hotmail.com'       , 1, 2000000, '3344959', 'activo', 'U5/+1GK+4{[6_E~R8vyo«',  'Zu}0P(jBw"GBpCWqU*3c<');
INSERT INTO usuarios  VALUES (1109948394, 06, 'Juan varela ',       '1993-12-19', 'carrera 4 # 34-45', 'M', 'Varela.juan-123@gmail.com' , 3, 800000,  '4455948', 'activo', 'Juavar',   'Juavar');
INSERT INTO usuarios  VALUES (34958478,   07, 'Jairo Diaz',         '1984-07-11', 'calle 45 # 3-23',   'M', 'dia-jairo@hotmail.com'     , 3, 800000,  '3344059', 'activo', 'Jaidia',   'Jaidia');


--INSERT INTO vehiculos VALUES (id, id-sede,  color, marca, referencia, tipo, traccion, modelo, precio, iva);
INSERT INTO vehiculos VALUES (01, 01, 'verde',    'Mazda',     '3',        'sedan', 'trasera',   '2013', 54989999, 20000);
INSERT INTO vehiculos VALUES (02, 01, 'negro',    'Chevrolet', 'spak',     'coupe', 'doble',     '2016', 89579999, 30000);
INSERT INTO vehiculos VALUES (03, 01, 'rojo',     'Honda',     'huang',    'sedan', 'delantera', '2014', 34560000, 20000);
INSERT INTO vehiculos VALUES (04, 01, 'azul',     'Audi',      'scorpion', 'sedan', 'trasera',   '2013', 54697000, 30000);
INSERT INTO vehiculos VALUES (05, 01, 'blanco',   'Kia',       'soul',     'sedan', 'doble',     '2015', 67986000, 40000);
INSERT INTO vehiculos VALUES (06, 01, 'verde',    'pagani',    'zonda',    'coupe', 'trasera',   '2016', 2050060000, 1000000);
INSERT INTO vehiculos VALUES (07, 01, 'negro',    'Chevrolet', 'camaro',   'coupe', 'trasera',   '2015', 120495598, 10000);
INSERT INTO	vehiculos VALUES (08, 01, 'amarillo', 'Ford',      'Mustang',  'coupe', 'trasera',   '2014', 100490509, 200000);
INSERT INTO vehiculos VALUES (09, 01, 'blando',   'Kia',       'Cerato',   'coupe', 'trasera',   '2015', 85698958, 50000);
INSERT INTO vehiculos VALUES (10, 01, 'rojo',     'Chevrolet', 'Spark-GT', 'sedan', 'delantera', '2015', 46596958, 20000);

--INSERT INTO repuestos VALUES (id-respuesto, id-sede, nombre, cantidad, percion-un, iva, descripcion);
INSERT INTO repuestos VALUES (01, 01, 'Rin',                         20, 80000,   200,   'rin para llanta de auto');
INSERT INTO repuestos VALUES (02, 01, 'Cogin',                       30, 300000,  400,   'juego de cojines para auto');
INSERT INTO repuestos VALUES (03, 01, 'Retrovisor',                  15, 40000,   300,   'juego de retrovisores');
INSERT INTO repuestos VALUES (04, 01, 'Radio',                       10, 40000,   400,   'radio para auto');
INSERT INTO repuestos VALUES (05, 01, 'Sonido',                      05, 400000,  200,   'juego de parlantes para auto');
INSERT INTO repuestos VALUES (06, 01, 'Chazis',                      10, 400000,  200,   'chazis para auto');
INSERT INTO repuestos VALUES (07, 01, 'luces delanteras',            20, 20000,   300,   'luces delanteras para autos Chevrolet');
INSERT INTO repuestos VALUES (08, 01, 'luces traseras',              20, 20000,   300,   'luces traseras para autos Chevrolet');
INSERT INTO repuestos VALUES (09, 01, 'luces direccionales',         20, 15000,   250,   'luces direccionales para cualquier marca');
INSERT INTO repuestos VALUES (10, 01, 'rin-bmw',                     10, 50000,   500,   'rines para autos BMW');
INSERT INTO repuestos VALUES (11, 01, 'vidrio panoramico delantero', 10, 100000,  500,   'vidrios panoramico para autos Chevrolet');
INSERT INTO repuestos VALUES (12, 01, 'volante',                     30, 30000,   300,   'volante para diferentes marcas de autos');
INSERT INTO repuestos VALUES (13, 01, 'palanca de cambios',          15, 20000,   250,   'palanca de cambios para diferentes marcas de autos');
INSERT INTO repuestos VALUES (14, 01, 'carburador',                  10, 50000,   300,   'carburador para autos de marca Kia');
INSERT INTO repuestos VALUES (15, 01, 'Retrovisor trival',           15, 50000,   250,   'retrovisor con exclusivo diseño');
INSERT INTO repuestos VALUES (16, 01, 'car audio',                    5, 200000,  300,   'sistema de car audio personalizable');
INSERT INTO repuestos VALUES (17, 01, 'set de tormillos',            20, 40000,   200,   'juego de tornillos genericos');
INSERT INTO repuestos VALUES (18, 01, 'calcomania',                  50, 10000,   100,   'calcomania con el logo de autos ABC');
INSERT INTO repuestos VALUES (19, 01, 'rin-pagani',                   5, 1000000, 10000, 'rin esclusivo para autos pagani');
INSERT INTO repuestos VALUES (20, 01, 'neumatico',                   20, 30000,   250,   'neumatico generico');