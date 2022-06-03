CREATE DATABASE sistema_bancario;
use sistema_bancario;

-- CREATE TABLE CLIENTES
CREATE TABLE `sistema_bancario`.`CLIENTES` (
  `dni` INT NOT NULL,
  `domicilio` VARCHAR(45) NOT NULL,
  `NOMBRE_APELLIDO` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`dni`));

ALTER TABLE `sistema_bancario`.`CLIENTES`
ADD COLUMN `numeroSucursal` VARCHAR(45) NOT NULL AFTER `NOMBRE_APELLIDO`;

-- CREATE TABLE CUENTAS AHORRO
CREATE TABLE `sistema_bancario`.`CUENTA_AHORRO` (
  `numCuenta` INT NOT NULL,
  `saldo` DOUBLE NOT NULL,
  `cbu` VARCHAR(45) NOT NULL,
  `tipoMoneda` VARCHAR(45) NOT NULL,
  `dniCliente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`numCuenta`));

-- CREATE TABLE SUCURSALES
CREATE TABLE `sistema_bancario`.`SUCURSALES` (
  `numeroSucursal` INT NOT NULL,
  `nombreSucursal` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`numeroSucursal`));
