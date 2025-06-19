-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

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
  INDEX `fk_Cliente_Cuenta1_idx` (`Cuenta_idCuenta` ASC) VISIBLE,
  CONSTRAINT `fk_Cliente_Cuenta1`
    FOREIGN KEY (`Cuenta_idCuenta`)
    REFERENCES `Cuenta` (`idCuenta`)
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
  INDEX `fk_Entrenador_Cuenta1_idx` (`Cuenta_idCuenta` ASC) VISIBLE,
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
-- Table `ConfiguracionEjercicios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ConfiguracionEjercicios` ;

CREATE TABLE IF NOT EXISTS `ConfiguracionEjercicios` (
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
  INDEX `fk_Ejercicios_Espalda1_idx` (`Espalda_idEspalda` ASC) VISIBLE,
  INDEX `fk_Ejercicios_Brazos1_idx` (`Brazos_idBrazos` ASC) VISIBLE,
  INDEX `fk_Ejercicios_Pecho1_idx` (`Pecho_idPecho` ASC) VISIBLE,
  INDEX `fk_Ejercicios_Cardio1_idx` (`Cardio_idCardio` ASC) VISIBLE,
  INDEX `fk_Ejercicios_ZonaMedia1_idx` (`ZonaMedia_idZonaMedia` ASC) VISIBLE,
  INDEX `fk_Ejercicios_Piernas1_idx` (`Piernas_idPiernas` ASC) VISIBLE,
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
-- Table `Gamificacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Gamificacion` ;

CREATE TABLE IF NOT EXISTS `Gamificacion` (
  `idGamificacion` INT NOT NULL AUTO_INCREMENT,
  `puntaje` INT NOT NULL,
  `carta` ENUM('Bronce', 'Plata', 'Oro') NOT NULL,
  `ConfiguracionEjercicios_idEjercicios` INT NOT NULL,
  `ConfiguracionEjercicios_Espalda_idEspalda` INT NOT NULL,
  `ConfiguracionEjercicios_Brazos_idBrazos` INT NOT NULL,
  `ConfiguracionEjercicios_Pecho_idPecho` INT NOT NULL,
  `ConfiguracionEjercicios_Cardio_idCardio` INT NOT NULL,
  `ConfiguracionEjercicios_ZonaMedia_idZonaMedia` INT NOT NULL,
  `ConfiguracionEjercicios_Piernas_idPiernas` INT NOT NULL,
  PRIMARY KEY (`idGamificacion`, `ConfiguracionEjercicios_idEjercicios`, `ConfiguracionEjercicios_Espalda_idEspalda`, `ConfiguracionEjercicios_Brazos_idBrazos`, `ConfiguracionEjercicios_Pecho_idPecho`, `ConfiguracionEjercicios_Cardio_idCardio`, `ConfiguracionEjercicios_ZonaMedia_idZonaMedia`, `ConfiguracionEjercicios_Piernas_idPiernas`),
  INDEX `fk_Gamificacion_ConfiguracionEjercicios1_idx` (`ConfiguracionEjercicios_idEjercicios` ASC, `ConfiguracionEjercicios_Espalda_idEspalda` ASC, `ConfiguracionEjercicios_Brazos_idBrazos` ASC, `ConfiguracionEjercicios_Pecho_idPecho` ASC, `ConfiguracionEjercicios_Cardio_idCardio` ASC, `ConfiguracionEjercicios_ZonaMedia_idZonaMedia` ASC, `ConfiguracionEjercicios_Piernas_idPiernas` ASC) VISIBLE,
  CONSTRAINT `fk_Gamificacion_ConfiguracionEjercicios1`
    FOREIGN KEY (`ConfiguracionEjercicios_idEjercicios` , `ConfiguracionEjercicios_Espalda_idEspalda` , `ConfiguracionEjercicios_Brazos_idBrazos` , `ConfiguracionEjercicios_Pecho_idPecho` , `ConfiguracionEjercicios_Cardio_idCardio` , `ConfiguracionEjercicios_ZonaMedia_idZonaMedia` , `ConfiguracionEjercicios_Piernas_idPiernas`)
    REFERENCES `ConfiguracionEjercicios` (`idEjercicios` , `Espalda_idEspalda` , `Brazos_idBrazos` , `Pecho_idPecho` , `Cardio_idCardio` , `ZonaMedia_idZonaMedia` , `Piernas_idPiernas`)
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
  `Gamificacion_idGamificacion` INT NOT NULL,
  `Gamificacion_ConfiguracionEjercicios_idEjercicios` INT NOT NULL,
  `Gamificacion_ConfiguracionEjercicios_Espalda_idEspalda` INT NOT NULL,
  `Gamificacion_ConfiguracionEjercicios_Brazos_idBrazos` INT NOT NULL,
  `Gamificacion_ConfiguracionEjercicios_Pecho_idPecho` INT NOT NULL,
  `Gamificacion_ConfiguracionEjercicios_Cardio_idCardio` INT NOT NULL,
  `Gamificacion_ConfiguracionEjercicios_ZonaMedia_idZonaMedia` INT NOT NULL,
  `Gamificacion_ConfiguracionEjercicios_Piernas_idPiernas` INT NOT NULL,
  PRIMARY KEY (`idRutina`, `Cuenta_idCuenta`, `Gamificacion_idGamificacion`, `Gamificacion_ConfiguracionEjercicios_idEjercicios`, `Gamificacion_ConfiguracionEjercicios_Espalda_idEspalda`, `Gamificacion_ConfiguracionEjercicios_Brazos_idBrazos`, `Gamificacion_ConfiguracionEjercicios_Pecho_idPecho`, `Gamificacion_ConfiguracionEjercicios_Cardio_idCardio`, `Gamificacion_ConfiguracionEjercicios_ZonaMedia_idZonaMedia`, `Gamificacion_ConfiguracionEjercicios_Piernas_idPiernas`),
  INDEX `fk_Entrenamientos_Cuenta1_idx` (`Cuenta_idCuenta` ASC) VISIBLE,
  INDEX `fk_Rutina_Gamificacion1_idx` (`Gamificacion_idGamificacion` ASC, `Gamificacion_ConfiguracionEjercicios_idEjercicios` ASC, `Gamificacion_ConfiguracionEjercicios_Espalda_idEspalda` ASC, `Gamificacion_ConfiguracionEjercicios_Brazos_idBrazos` ASC, `Gamificacion_ConfiguracionEjercicios_Pecho_idPecho` ASC, `Gamificacion_ConfiguracionEjercicios_Cardio_idCardio` ASC, `Gamificacion_ConfiguracionEjercicios_ZonaMedia_idZonaMedia` ASC, `Gamificacion_ConfiguracionEjercicios_Piernas_idPiernas` ASC) VISIBLE,
  CONSTRAINT `fk_Entrenamientos_Cuenta1`
    FOREIGN KEY (`Cuenta_idCuenta`)
    REFERENCES `Cuenta` (`idCuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Rutina_Gamificacion1`
    FOREIGN KEY (`Gamificacion_idGamificacion` , `Gamificacion_ConfiguracionEjercicios_idEjercicios` , `Gamificacion_ConfiguracionEjercicios_Espalda_idEspalda` , `Gamificacion_ConfiguracionEjercicios_Brazos_idBrazos` , `Gamificacion_ConfiguracionEjercicios_Pecho_idPecho` , `Gamificacion_ConfiguracionEjercicios_Cardio_idCardio` , `Gamificacion_ConfiguracionEjercicios_ZonaMedia_idZonaMedia` , `Gamificacion_ConfiguracionEjercicios_Piernas_idPiernas`)
    REFERENCES `Gamificacion` (`idGamificacion` , `ConfiguracionEjercicios_idEjercicios` , `ConfiguracionEjercicios_Espalda_idEspalda` , `ConfiguracionEjercicios_Brazos_idBrazos` , `ConfiguracionEjercicios_Pecho_idPecho` , `ConfiguracionEjercicios_Cardio_idCardio` , `ConfiguracionEjercicios_ZonaMedia_idZonaMedia` , `ConfiguracionEjercicios_Piernas_idPiernas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
