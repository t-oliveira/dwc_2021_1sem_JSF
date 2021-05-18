-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema aula_dwc_2021_1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema aula_dwc_2021_1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `aula_dwc_2021_1` DEFAULT CHARACTER SET utf8 ;
USE `aula_dwc_2021_1` ;

-- -----------------------------------------------------
-- Table `aula_dwc_2021_1`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aula_dwc_2021_1`.`endereco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(100) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `cep` VARCHAR(45) NOT NULL,
  `pessoa_cpf` BIGINT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_endereco_pessoa_idx` (`pessoa_cpf` ASC) VISIBLE,
  CONSTRAINT `fk_endereco_pessoa`
    FOREIGN KEY (`pessoa_cpf`)
    REFERENCES `aula_dwc_2021_1`.`pessoa` (`cpf`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aula_dwc_2021_1`.`pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aula_dwc_2021_1`.`pessoa` (
  `cpf` BIGINT(11) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `cel` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `end_padrao` INT NOT NULL,
  PRIMARY KEY (`cpf`),
  INDEX `fk_pessoa_endereco_idx` (`end_padrao` ASC) VISIBLE,
  CONSTRAINT `fk_pessoa_endereco`
    FOREIGN KEY (`end_padrao`)
    REFERENCES `aula_dwc_2021_1`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
