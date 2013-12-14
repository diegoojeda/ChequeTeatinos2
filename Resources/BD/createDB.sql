--Borrado de la BD
DROP TABLE empresa CASCADE CONSTRAINTS;
DROP TABLE oferta CASCADE CONSTRAINTS;
DROP TABLE cliente CASCADE CONSTRAINTS;
DROP TABLE pedido CASCADE CONSTRAINTS;
DROP TABLE pedido_oferta CASCADE CONSTRAINTS;
DROP SEQUENCE seq_empresa;
DROP SEQUENCE seq_oferta;
DROP SEQUENCE seq_cliente;
DROP SEQUENCE seq_pedido;
DROP SEQUENCE seq_pedido_oferta;

--Creación de tablas
CREATE TABLE empresa (
  id NUMBER(5) PRIMARY KEY,
  nombre VARCHAR2(30),
  direccion VARCHAR2(60)
);

CREATE TABLE oferta (
  id NUMBER(5) PRIMARY KEY,
  fecha_validez DATE,
  existencias NUMBER(3),
  nombre_oferta VARCHAR2(30),
  descripcion VARCHAR2(200),
  precio_original NUMBER(5,2),
  precio_con_oferta NUMBER(5,2),
  uri_imagen VARCHAR2(255),
  empresa NUMBER(5) --ADD FOREIGN KEY
);

CREATE TABLE cliente (
  nombre VARCHAR2(30),
  apellidos VARCHAR2(60),
  email VARCHAR2(60) PRIMARY KEY,
  telefono NUMBER(9),
  password VARCHAR2(20),
  es_admin NUMBER(1) CHECK es_admin=0 or es_admin=1
);

CREATE TABLE pedido (
  codigo_pedido NUMBER(5) PRIMARY KEY,
  fecha DATE
);

CREATE TABLE pedido_oferta (
  id NUMBER(5) PRIMARY KEY,
  codigo_pedido NUMBER(5),
  codigo_oferta NUMBER(5)
);

--Añadimos las restricciones de integridad
ALTER TABLE oferta ADD CONSTRAINT fk_empresa FOREIGN KEY (empresa) REFERENCES empresa(id);
ALTER TABLE pedido_oferta ADD CONSTRAINT fk_codigo_pedido FOREIGN KEY (codigo_pedido) REFERENCES pedido(codigo_pedido);
ALTER TABLE pedido_oferta ADD CONSTRAINT fk_codigo_oferta FOREIGN KEY (codigo_oferta) REFERENCES oferta(id);

--Creamos las secuencias
CREATE SEQUENCE seq_empresa
MINVALUE 1
START WITH 1
INCREMENT BY 25
CACHE 10;

CREATE SEQUENCE seq_oferta
MINVALUE 1
START WITH 1
INCREMENT BY 25
CACHE 10;

CREATE SEQUENCE seq_cliente
MINVALUE 1
START WITH 1
INCREMENT BY 25
CACHE 10;

CREATE SEQUENCE seq_pedido
MINVALUE 1
START WITH 1
INCREMENT BY 25
CACHE 10;

CREATE SEQUENCE seq_pedido_oferta
MINVALUE 1
START WITH 1
INCREMENT BY 25
CACHE 10;