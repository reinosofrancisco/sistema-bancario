-- CREATE TABLE CUENTA CORRIENTE
CREATE TABLE `sistema_bancario`.`CUENTA_CORRIENTE` (
  `numCuenta` INT NOT NULL,
  `saldo` DOUBLE NOT NULL,
  `cbu` VARCHAR(45) NOT NULL,
  `dniCliente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`numCuenta`));