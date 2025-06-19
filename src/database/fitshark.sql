-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
use fitshark;
-- -----------------------------------------------------
-- Table `Cuenta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Cuenta` ;

CREATE TABLE IF NOT EXISTS `Cuenta` (
  `idCuenta` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(65) NOT NULL,
  `contrasena` VARCHAR(45) NOT NULL,
  `rol` ENUM('cliente', 'entrenador') NULL,
  PRIMARY KEY (`idCuenta`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Cliente` ;

CREATE TABLE IF NOT EXISTS `Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `edad` INT NOT NULL,
  `genero` ENUM('Hombre', 'Mujer', 'Otro') NOT NULL,
  `peso` INT NOT NULL,
  `altura` INT NOT NULL,
  `nivel` ENUM('Principiante', 'Intermedio', 'Avanzado') NOT NULL,
  `Cuenta_idCuenta` INT NOT NULL,
  PRIMARY KEY (`idCliente`, `Cuenta_idCuenta`),
  INDEX `fk_Cliente_Cuenta1_idx` (`Cuenta_idCuenta` ASC),
  CONSTRAINT `fk_Cliente_Cuenta1`
    FOREIGN KEY (`Cuenta_idCuenta`)
    REFERENCES `Cuenta` (`idCuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Gamificacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Gamificacion` ;

CREATE TABLE IF NOT EXISTS `Gamificacion` (
  `idGamificacion` INT NOT NULL AUTO_INCREMENT,
  `puntaje` INT NOT NULL,
  `carta` ENUM('Bronce', 'Plata', 'Oro') NOT NULL,
  `Cuenta_idCuenta` INT NOT NULL,
  PRIMARY KEY (`idGamificacion`),
  INDEX `fk_Gamificacion_Cuenta1_idx` (`Cuenta_idCuenta` ASC),
  CONSTRAINT `fk_Gamificacion_Cuenta1`
    FOREIGN KEY (`Cuenta_idCuenta`)
    REFERENCES `Cuenta` (`Cuenta_idCuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Entrenador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Entrenador` ;

CREATE TABLE IF NOT EXISTS `Entrenador` (
  `idEntrenador` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `Cuenta_idCuenta` INT NOT NULL,
  PRIMARY KEY (`idEntrenador`, `Cuenta_idCuenta`),
  INDEX `fk_Entrenador_Cuenta1_idx` (`Cuenta_idCuenta` ASC) ,
  CONSTRAINT `fk_Entrenador_Cuenta1`
    FOREIGN KEY (`Cuenta_idCuenta`)
    REFERENCES `Cuenta` (`idCuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Espalda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Espalda` ;

CREATE TABLE IF NOT EXISTS `Espalda` (
  `idEspalda` INT NULL AUTO_INCREMENT,
  `ejercicio_espalda` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEspalda`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Brazos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Brazos` ;

CREATE TABLE IF NOT EXISTS `Brazos` (
  `idBrazos` INT NULL AUTO_INCREMENT,
  `ejercicio_brazos` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idBrazos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pecho`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Pecho` ;

CREATE TABLE IF NOT EXISTS `Pecho` (
  `idPecho` INT NULL AUTO_INCREMENT,
  `ejercicio_pecho` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPecho`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cardio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Cardio` ;

CREATE TABLE IF NOT EXISTS `Cardio` (
  `idCardio` INT NULL AUTO_INCREMENT,
  `Actividad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCardio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ZonaMedia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ZonaMedia` ;

CREATE TABLE IF NOT EXISTS `ZonaMedia` (
  `idZonaMedia` INT NULL AUTO_INCREMENT,
  `ejercicio_zona_media` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idZonaMedia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Piernas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Piernas` ;

CREATE TABLE IF NOT EXISTS `Piernas` (
  `idPiernas` INT NULL AUTO_INCREMENT,
  `ejercicio_piernas` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPiernas`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Ejercicios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Ejercicios` ;

CREATE TABLE IF NOT EXISTS `Ejercicios` (
  `idEjercicios` INT NOT NULL AUTO_INCREMENT,
  `repeticiones` INT NOT NULL,
  `series` INT NOT NULL,
  `cantidad_peso` INT NOT NULL,
  `pausa_series` INT NOT NULL,
  `Espalda_idEspalda` INT NOT NULL,
  `Brazos_idBrazos` INT NOT NULL,
  `Pecho_idPecho` INT NOT NULL,
  `Cardio_idCardio` INT NOT NULL,
  `ZonaMedia_idZonaMedia` INT NOT NULL,
  `Piernas_idPiernas` INT NOT NULL,
  PRIMARY KEY (`idEjercicios`, `Espalda_idEspalda`, `Brazos_idBrazos`, `Pecho_idPecho`, `Cardio_idCardio`, `ZonaMedia_idZonaMedia`, `Piernas_idPiernas`),
  INDEX `fk_Ejercicios_Espalda1_idx` (`Espalda_idEspalda` ASC) ,
  INDEX `fk_Ejercicios_Brazos1_idx` (`Brazos_idBrazos` ASC) ,
  INDEX `fk_Ejercicios_Pecho1_idx` (`Pecho_idPecho` ASC) ,
  INDEX `fk_Ejercicios_Cardio1_idx` (`Cardio_idCardio` ASC) ,
  INDEX `fk_Ejercicios_ZonaMedia1_idx` (`ZonaMedia_idZonaMedia` ASC) ,
  INDEX `fk_Ejercicios_Piernas1_idx` (`Piernas_idPiernas` ASC) ,
  CONSTRAINT `fk_Ejercicios_Espalda1`
    FOREIGN KEY (`Espalda_idEspalda`)
    REFERENCES `Espalda` (`idEspalda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ejercicios_Brazos1`
    FOREIGN KEY (`Brazos_idBrazos`)
    REFERENCES `Brazos` (`idBrazos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ejercicios_Pecho1`
    FOREIGN KEY (`Pecho_idPecho`)
    REFERENCES `Pecho` (`idPecho`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ejercicios_Cardio1`
    FOREIGN KEY (`Cardio_idCardio`)
    REFERENCES `Cardio` (`idCardio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ejercicios_ZonaMedia1`
    FOREIGN KEY (`ZonaMedia_idZonaMedia`)
    REFERENCES `ZonaMedia` (`idZonaMedia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ejercicios_Piernas1`
    FOREIGN KEY (`Piernas_idPiernas`)
    REFERENCES `Piernas` (`idPiernas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Rutina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Rutina` ;

CREATE TABLE IF NOT EXISTS `Rutina` (
  `idRutina` INT NOT NULL AUTO_INCREMENT,
  `Cuenta_idCuenta` INT NOT NULL,
  `Ejercicios_idEjercicios` INT NOT NULL,
  `Gamificacion_idGamificacion` INT NOT NULL,
  PRIMARY KEY (`idRutina`, `Cuenta_idCuenta`, `Ejercicios_idEjercicios`, `Gamificacion_idGamificacion`),
  INDEX `fk_Rutina_Cuenta1_idx` (`Cuenta_idCuenta` ASC),
  INDEX `fk_Rutina_Ejercicios1_idx` (`Ejercicios_idEjercicios` ASC),
  INDEX `fk_Rutina_Gamificacion1_idx` (`Gamificacion_idGamificacion` ASC),
  
  CONSTRAINT `fk_Rutina_Cuenta1`
    FOREIGN KEY (`Cuenta_idCuenta`)
    REFERENCES `Cuenta` (`idCuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Rutina_Ejercicios1`
    FOREIGN KEY (`Ejercicios_idEjercicios`)
    REFERENCES `Ejercicios` (`idEjercicios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Rutina_Gamificacion1`
    FOREIGN KEY (`Gamificacion_idGamificacion`)
    REFERENCES `Gamificacion` (`idGamificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
