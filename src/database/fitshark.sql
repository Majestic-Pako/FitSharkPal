-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
USE fitshark;
-- -----------------------------------------------------
-- Table `Cuenta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Cuenta` ;

CREATE TABLE IF NOT EXISTS `Cuenta` (
  `idCuenta` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(65) NULL,
  `contrasena` VARCHAR(45) NULL,
  `rol` ENUM('cliente', 'entrenador') NULL,
  PRIMARY KEY (`idCuenta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Cliente` ;

CREATE TABLE IF NOT EXISTS `Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `edad` INT NULL,
  `genero` ENUM('Hombre', 'Mujer', 'Otro') NULL,
  `nivel` ENUM('Principiante', 'Intermedio', 'Avanzado') NULL,
  `Cuenta_idCuenta` INT NOT NULL,
  PRIMARY KEY (`idCliente`, `Cuenta_idCuenta`),
  CONSTRAINT `fk_Cliente_Cuenta1`
    FOREIGN KEY (`Cuenta_idCuenta`)
    REFERENCES `Cuenta` (`idCuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Cliente_Cuenta1_idx` ON `Cliente` (`Cuenta_idCuenta` ASC);


-- -----------------------------------------------------
-- Table `Entrenador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Entrenador` ;

CREATE TABLE IF NOT EXISTS `Entrenador` (
  `idEntrenador` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `edad` INT NULL,
  `genero` ENUM('Hombre', 'Mujer', 'Otro') NULL,
  `Cuenta_idCuenta` INT NOT NULL,
  PRIMARY KEY (`idEntrenador`, `Cuenta_idCuenta`),
  CONSTRAINT `fk_Entrenador_Cuenta1`
    FOREIGN KEY (`Cuenta_idCuenta`)
    REFERENCES `Cuenta` (`idCuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Entrenador_Cuenta1_idx` ON `Entrenador` (`Cuenta_idCuenta` ASC);


-- -----------------------------------------------------
-- Table `Entrenamientos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Entrenamientos` ;

CREATE TABLE IF NOT EXISTS `Entrenamientos` (
  `idEntrenamientos` INT NOT NULL AUTO_INCREMENT,
  `peso` DECIMAL(5,2) NULL,
  `altura` DECIMAL(4,2) NULL,
  `plan` VARCHAR(45) NULL,
  `Cuenta_idCuenta` INT NOT NULL,
  PRIMARY KEY (`idEntrenamientos`, `Cuenta_idCuenta`),
  CONSTRAINT `fk_Entrenamientos_Cuenta1`
    FOREIGN KEY (`Cuenta_idCuenta`)
    REFERENCES `Cuenta` (`idCuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Entrenamientos_Cuenta1_idx` ON `Entrenamientos` (`Cuenta_idCuenta` ASC);


-- -----------------------------------------------------
-- Table `Ejercicios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Ejercicios` ;

CREATE TABLE IF NOT EXISTS `Ejercicios` (
  `idEjercicios` INT NOT NULL AUTO_INCREMENT,
  `repeticiones` INT NULL,
  `series` INT NULL,
  `cantidad_peso` DECIMAL(5,2) NULL,
  `pausas_de_series` INT NULL,
  PRIMARY KEY (`idEjercicios`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Fuerza`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Fuerza` ;

CREATE TABLE IF NOT EXISTS `Fuerza` (
  `idFuerza` INT NOT NULL AUTO_INCREMENT,
  `tipo_fuerza` VARCHAR(45) NULL,
  `maquinaria` TINYINT NULL,
  PRIMARY KEY (`idFuerza`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Resistencia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Resistencia` ;

CREATE TABLE IF NOT EXISTS `Resistencia` (
  `idResistencia` INT NOT NULL AUTO_INCREMENT,
  `tiempo_total` DECIMAL NULL,
  `tipo_actividad` VARCHAR(45) NULL,
  PRIMARY KEY (`idResistencia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Volumen`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Volumen` ;

CREATE TABLE IF NOT EXISTS `Volumen` (
  `idVolumen` INT NOT NULL AUTO_INCREMENT,
  `grupo_muscular` VARCHAR(45) NULL,
  `supersets` TINYINT NULL,
  PRIMARY KEY (`idVolumen`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Resistencia_has_Ejercicios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Resistencia_has_Ejercicios` ;

CREATE TABLE IF NOT EXISTS `Resistencia_has_Ejercicios` (
  `Resistencia_idResistencia` INT NOT NULL,
  `Ejercicios_idEjercicios` INT NOT NULL,
  PRIMARY KEY (`Resistencia_idResistencia`, `Ejercicios_idEjercicios`),
  CONSTRAINT `fk_Resistencia_has_Ejercicios_Resistencia1`
    FOREIGN KEY (`Resistencia_idResistencia`)
    REFERENCES `Resistencia` (`idResistencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Resistencia_has_Ejercicios_Ejercicios1`
    FOREIGN KEY (`Ejercicios_idEjercicios`)
    REFERENCES `Ejercicios` (`idEjercicios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Resistencia_has_Ejercicios_Ejercicios1_idx` ON `Resistencia_has_Ejercicios` (`Ejercicios_idEjercicios` ASC) ;

CREATE INDEX `fk_Resistencia_has_Ejercicios_Resistencia1_idx` ON `Resistencia_has_Ejercicios` (`Resistencia_idResistencia` ASC) ;


-- -----------------------------------------------------
-- Table `Volumen_has_Ejercicios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Volumen_has_Ejercicios` ;

CREATE TABLE IF NOT EXISTS `Volumen_has_Ejercicios` (
  `Volumen_idVolumen` INT NOT NULL,
  `Ejercicios_idEjercicios` INT NOT NULL,
  PRIMARY KEY (`Volumen_idVolumen`, `Ejercicios_idEjercicios`),
  CONSTRAINT `fk_Volumen_has_Ejercicios_Volumen1`
    FOREIGN KEY (`Volumen_idVolumen`)
    REFERENCES `Volumen` (`idVolumen`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Volumen_has_Ejercicios_Ejercicios1`
    FOREIGN KEY (`Ejercicios_idEjercicios`)
    REFERENCES `Ejercicios` (`idEjercicios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Volumen_has_Ejercicios_Ejercicios1_idx` ON `Volumen_has_Ejercicios` (`Ejercicios_idEjercicios` ASC) ;

CREATE INDEX `fk_Volumen_has_Ejercicios_Volumen1_idx` ON `Volumen_has_Ejercicios` (`Volumen_idVolumen` ASC) ;


-- -----------------------------------------------------
-- Table `Fuerza_has_Ejercicios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Fuerza_has_Ejercicios` ;

CREATE TABLE IF NOT EXISTS `Fuerza_has_Ejercicios` (
  `Fuerza_idFuerza` INT NOT NULL,
  `Ejercicios_idEjercicios` INT NOT NULL,
  PRIMARY KEY (`Fuerza_idFuerza`, `Ejercicios_idEjercicios`),
  CONSTRAINT `fk_Fuerza_has_Ejercicios_Fuerza1`
    FOREIGN KEY (`Fuerza_idFuerza`)
    REFERENCES `Fuerza` (`idFuerza`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fuerza_has_Ejercicios_Ejercicios1`
    FOREIGN KEY (`Ejercicios_idEjercicios`)
    REFERENCES `Ejercicios` (`idEjercicios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Fuerza_has_Ejercicios_Ejercicios1_idx` ON `Fuerza_has_Ejercicios` (`Ejercicios_idEjercicios` ASC) ;

CREATE INDEX `fk_Fuerza_has_Ejercicios_Fuerza1_idx` ON `Fuerza_has_Ejercicios` (`Fuerza_idFuerza` ASC) ;


-- -----------------------------------------------------
-- Table `Entrenamientos_has_Ejercicios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Entrenamientos_has_Ejercicios` ;

CREATE TABLE IF NOT EXISTS `Entrenamientos_has_Ejercicios` (
  `Entrenamientos_idEntrenamientos` INT NOT NULL,
  `Entrenamientos_Cuenta_idCuenta` INT NOT NULL,
  `Ejercicios_idEjercicios` INT NOT NULL,
  PRIMARY KEY (`Entrenamientos_idEntrenamientos`, `Entrenamientos_Cuenta_idCuenta`, `Ejercicios_idEjercicios`),
  CONSTRAINT `fk_Entrenamientos_has_Ejercicios_Entrenamientos1`
    FOREIGN KEY (`Entrenamientos_idEntrenamientos` , `Entrenamientos_Cuenta_idCuenta`)
    REFERENCES `Entrenamientos` (`idEntrenamientos` , `Cuenta_idCuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Entrenamientos_has_Ejercicios_Ejercicios1`
    FOREIGN KEY (`Ejercicios_idEjercicios`)
    REFERENCES `Ejercicios` (`idEjercicios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Entrenamientos_has_Ejercicios_Ejercicios1_idx` ON `Entrenamientos_has_Ejercicios` (`Ejercicios_idEjercicios` ASC) ;

CREATE INDEX `fk_Entrenamientos_has_Ejercicios_Entrenamientos1_idx` ON `Entrenamientos_has_Ejercicios` (`Entrenamientos_idEntrenamientos` ASC, `Entrenamientos_Cuenta_idCuenta` ASC) ;


-- -----------------------------------------------------
-- Table `Cliente_has_Ejercicios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Cliente_has_Ejercicios` ;

CREATE TABLE IF NOT EXISTS `Cliente_has_Ejercicios` (
  `Cliente_idCliente` INT NOT NULL,
  `Cliente_Cuenta_idCuenta` INT NOT NULL,
  `Ejercicios_idEjercicios` INT NOT NULL,
  PRIMARY KEY (`Cliente_idCliente`, `Cliente_Cuenta_idCuenta`, `Ejercicios_idEjercicios`),
  CONSTRAINT `fk_Cliente_has_Ejercicios_Cliente1`
    FOREIGN KEY (`Cliente_idCliente` , `Cliente_Cuenta_idCuenta`)
    REFERENCES `Cliente` (`idCliente` , `Cuenta_idCuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cliente_has_Ejercicios_Ejercicios1`
    FOREIGN KEY (`Ejercicios_idEjercicios`)
    REFERENCES `Ejercicios` (`idEjercicios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Cliente_has_Ejercicios_Ejercicios1_idx` ON `Cliente_has_Ejercicios` (`Ejercicios_idEjercicios` ASC) ;

CREATE INDEX `fk_Cliente_has_Ejercicios_Cliente1_idx` ON `Cliente_has_Ejercicios` (`Cliente_idCliente` ASC, `Cliente_Cuenta_idCuenta` ASC) ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
