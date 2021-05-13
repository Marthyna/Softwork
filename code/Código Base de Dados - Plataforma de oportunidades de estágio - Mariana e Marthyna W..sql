-- MySQL Script generated by MySQL Workbench
-- Fri Jun 29 10:18:56 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cidade` (
  `cod_cidade` INT(4) NOT NULL,
  `estado` CHAR(2) NOT NULL,
  `nome_cidade` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cod_cidade`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Endereço`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Endereço` (
  `cod_endereco` INT(9) NOT NULL,
  `Rua` VARCHAR(45) NOT NULL,
  `Numero` SMALLINT(5) NOT NULL,
  `Bairro` VARCHAR(45) NOT NULL,
  `Complemento` VARCHAR(45) NOT NULL,
  `CEP` INT(8) NOT NULL,
  `Cidade_cod_cidade` INT(4) NOT NULL,
  PRIMARY KEY (`cod_endereco`),
  INDEX `fk_Endereço_Cidade_idx` (`Cidade_cod_cidade` ASC),
  CONSTRAINT `fk_Endereço_Cidade`
    FOREIGN KEY (`Cidade_cod_cidade`)
    REFERENCES `Cidade` (`cod_cidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pessoa` (
  `cod_pessoa` INT(9) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `telefone` BIGINT(11) NOT NULL,
  `ddd` TINYINT(3) NOT NULL,
  `Endereço_cod_endereco` INT(9) NOT NULL,
  PRIMARY KEY (`cod_pessoa`),
  INDEX `fk_Pessoa_Endereço1_idx` (`Endereço_cod_endereco` ASC),
  CONSTRAINT `fk_Pessoa_Endereço1`
    FOREIGN KEY (`Endereço_cod_endereco`)
    REFERENCES `Endereço` (`cod_endereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `PessoaFisica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PessoaFisica` (
  `cod_pf` INT(9) NOT NULL,
  `nomeCompleto` VARCHAR(45) NOT NULL,
  `RG` INT(10) NOT NULL,
  `CPF` BIGINT(11) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  `sexo` TINYINT(1) NOT NULL,
  `sexoLiteral` VARCHAR(12) NOT NULL,
  `idade` TINYINT(2) NOT NULL,
  `Pessoa_cod_pessoa` INT(9) NOT NULL,
  PRIMARY KEY (`cod_pf`),
  INDEX `fk_PessoaFisica_Pessoa1_idx` (`Pessoa_cod_pessoa` ASC),
  CONSTRAINT `fk_PessoaFisica_Pessoa1`
    FOREIGN KEY (`Pessoa_cod_pessoa`)
    REFERENCES `Pessoa` (`cod_pessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Empresa` (
  `cod_empresa` INT(9) NOT NULL,
  `CNPJ` BIGINT(14) NOT NULL,
  `Razão Social` VARCHAR(45) NOT NULL,
  `Nome Fantasia` VARCHAR(45) NOT NULL,
  `Pessoa_cod_pessoa` INT(9) NOT NULL,
  PRIMARY KEY (`cod_empresa`),
  INDEX `fk_Empresa_Pessoa1_idx` (`Pessoa_cod_pessoa` ASC),
  CONSTRAINT `fk_Empresa_Pessoa1`
    FOREIGN KEY (`Pessoa_cod_pessoa`)
    REFERENCES `Pessoa` (`cod_pessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Curriculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Curriculo` (
  `cod_curriculo` INT(9) NOT NULL,
  `descricao` VARCHAR(200) NOT NULL,
  `observacoes` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`cod_curriculo`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Curso` (
  `cod_curso` INT(9) NOT NULL,
  `nome` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`cod_curso`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Aluno` (
  `cod_aluno` INT(9) NOT NULL,
  `matricula` BIGINT(12) NOT NULL,
  `empregado` TINYINT NOT NULL,
  `ano` TINYINT(1) NOT NULL,
  `turno` TINYINT(1) NOT NULL,
  `turnoLiteral` VARCHAR(12) NOT NULL,
  `Curriculo_cod_curriculo` INT(9) NOT NULL,
  `Curso_cod_curso` INT(9) NOT NULL,
  `PessoaFisica_cod_pf` INT(9) NOT NULL,
  PRIMARY KEY (`cod_aluno`),
  INDEX `fk_Aluno_Curriculo1_idx` (`Curriculo_cod_curriculo` ASC),
  INDEX `fk_Aluno_Curso1_idx` (`Curso_cod_curso` ASC),
  INDEX `fk_Aluno_PessoaFisica1_idx` (`PessoaFisica_cod_pf` ASC),
  CONSTRAINT `fk_Aluno_Curriculo1`
    FOREIGN KEY (`Curriculo_cod_curriculo`)
    REFERENCES `Curriculo` (`cod_curriculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aluno_Curso1`
    FOREIGN KEY (`Curso_cod_curso`)
    REFERENCES `Curso` (`cod_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aluno_PessoaFisica1`
    FOREIGN KEY (`PessoaFisica_cod_pf`)
    REFERENCES `PessoaFisica` (`cod_pf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Orientador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Orientador` (
  `cod_orientador` INT(9) NOT NULL,
  `matriculaProf` BIGINT(12) NOT NULL,
  `PessoaFisica_cod_pf` INT(9) NOT NULL,
  PRIMARY KEY (`cod_orientador`),
  INDEX `fk_Orientador_PessoaFisica1_idx` (`PessoaFisica_cod_pf` ASC),
  CONSTRAINT `fk_Orientador_PessoaFisica1`
    FOREIGN KEY (`PessoaFisica_cod_pf`)
    REFERENCES `PessoaFisica` (`cod_pf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Setor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Setor` (
  `cod_setor` INT(9) NOT NULL,
  `descricao` VARCHAR(150) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `Empresa_cod_empresa` INT(9) NOT NULL,
  PRIMARY KEY (`cod_setor`),
  INDEX `fk_Setor_Empresa1_idx` (`Empresa_cod_empresa` ASC),
  CONSTRAINT `fk_Setor_Empresa1`
    FOREIGN KEY (`Empresa_cod_empresa`)
    REFERENCES `Empresa` (`cod_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cargo` (
  `cod_cargo` INT(9) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `risco` VARCHAR(45) NOT NULL,
  `Setor_cod_setor` INT(9) NOT NULL,
  PRIMARY KEY (`cod_cargo`),
  INDEX `fk_Cargo_Setor1_idx` (`Setor_cod_setor` ASC),
  CONSTRAINT `fk_Cargo_Setor1`
    FOREIGN KEY (`Setor_cod_setor`)
    REFERENCES `Setor` (`cod_setor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Vaga`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Vaga` (
  `cod_vaga` INT(9) NOT NULL,
  `descricao` VARCHAR(200) NOT NULL,
  `remunerada` VARCHAR(10) NOT NULL,
  `salario` FLOAT NOT NULL,
  `preenchida` VARCHAR(10) NOT NULL,
  `turno` TINYINT(1) NOT NULL,
  `turnoLiteral` VARCHAR(10) NOT NULL,
  `Cargo_cod_cargo` INT(9) NOT NULL,
  PRIMARY KEY (`cod_vaga`),
  INDEX `fk_Vaga_Cargo1_idx` (`Cargo_cod_cargo` ASC),
  CONSTRAINT `fk_Vaga_Cargo1`
    FOREIGN KEY (`Cargo_cod_cargo`)
    REFERENCES `Cargo` (`cod_cargo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Oferta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Oferta` (
  `cod_oferta` INT(9) NOT NULL,
  `experiencia` VARCHAR(45) NOT NULL,
  `aberta` VARCHAR(10) NOT NULL,
  `Vaga_cod_vaga` INT(9) NOT NULL,
  PRIMARY KEY (`cod_oferta`),
  INDEX `fk_Oferta_Vaga1_idx` (`Vaga_cod_vaga` ASC),
  CONSTRAINT `fk_Oferta_Vaga1`
    FOREIGN KEY (`Vaga_cod_vaga`)
    REFERENCES `Vaga` (`cod_vaga`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Aplicacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Aplicacao` (
  `cod_aplicacao` INT(9) NOT NULL,
  `status` VARCHAR(15) NOT NULL,
  `aceita` VARCHAR(15) NOT NULL,
  `Aluno_cod_aluno` INT(9) NOT NULL,
  `Oferta_cod_oferta` INT(9) NOT NULL,
  PRIMARY KEY (`cod_aplicacao`),
  INDEX `fk_Aplicacao_Aluno1_idx` (`Aluno_cod_aluno` ASC),
  INDEX `fk_Aplicacao_Oferta1_idx` (`Oferta_cod_oferta` ASC),
  CONSTRAINT `fk_Aplicacao_Aluno1`
    FOREIGN KEY (`Aluno_cod_aluno`)
    REFERENCES `Aluno` (`cod_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aplicacao_Oferta1`
    FOREIGN KEY (`Oferta_cod_oferta`)
    REFERENCES `Oferta` (`cod_oferta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `TipoFormacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TipoFormacao` (
  `cod_tipo` INT(9) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cod_tipo`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Formacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Formacao` (
  `cod_formacao` INT(9) NOT NULL,
  `nomeInstituicao` VARCHAR(45) NOT NULL,
  `nomeCurso` VARCHAR(45) NOT NULL,
  `dataInicio` DATE NOT NULL,
  `dataFim` DATE NOT NULL,
  `carga` VARCHAR(45) NOT NULL,
  `situacao` VARCHAR(45) NOT NULL,
  `Curriculo_cod_curriculo` INT(9) NOT NULL,
  `TipoFormacao_cod_tipo` INT(9) NOT NULL,
  PRIMARY KEY (`cod_formacao`),
  INDEX `fk_Formacao_Curriculo1_idx` (`Curriculo_cod_curriculo` ASC),
  INDEX `fk_Formacao_TipoFormacao1_idx` (`TipoFormacao_cod_tipo` ASC),
  CONSTRAINT `fk_Formacao_Curriculo1`
    FOREIGN KEY (`Curriculo_cod_curriculo`)
    REFERENCES `Curriculo` (`cod_curriculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Formacao_TipoFormacao1`
    FOREIGN KEY (`TipoFormacao_cod_tipo`)
    REFERENCES `TipoFormacao` (`cod_tipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Emprego`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Emprego` (
  `cod_emprego` INT NOT NULL,
  `empresa` VARCHAR(45) NOT NULL,
  `cargo` VARCHAR(45) NOT NULL,
  `dataInicio` DATE NOT NULL,
  `dataFim` DATE NOT NULL,
  `atribuicoes` VARCHAR(45) NOT NULL,
  `empregoAtual` VARCHAR(45) NOT NULL,
  `Curriculo_cod_curriculo` INT(9) NOT NULL,
  PRIMARY KEY (`cod_emprego`),
  INDEX `fk_Emprego_Curriculo1_idx` (`Curriculo_cod_curriculo` ASC),
  CONSTRAINT `fk_Emprego_Curriculo1`
    FOREIGN KEY (`Curriculo_cod_curriculo`)
    REFERENCES `Curriculo` (`cod_curriculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Idioma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Idioma` (
  `cod_idioma` INT(9) NOT NULL,
  `nome` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`cod_idioma`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `ResponsavelEm`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ResponsavelEm` (
  `cod_responsavel` INT(9) NOT NULL,
  `PessoaFisica_cod_pf` INT(9) NOT NULL,
  PRIMARY KEY (`cod_responsavel`),
  INDEX `fk_ResponsavelEm_PessoaFisica1_idx` (`PessoaFisica_cod_pf` ASC),
  CONSTRAINT `fk_ResponsavelEm_PessoaFisica1`
    FOREIGN KEY (`PessoaFisica_cod_pf`)
    REFERENCES `PessoaFisica` (`cod_pf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Estagio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Estagio` (
  `cod_estagio` INT(9) NOT NULL,
  `dataInicio` DATE NOT NULL,
  `dataFim` DATE NOT NULL,
  `ResponsavelEm_cod_responsavel` INT(9) NOT NULL,
  `Orientador_cod_orientador` INT(9) NOT NULL,
  `Vaga_cod_vaga` INT(9) NOT NULL,
  `Aluno_cod_aluno` INT(9) NOT NULL,
  PRIMARY KEY (`cod_estagio`),
  INDEX `fk_Estagio_ResponsavelEm1_idx` (`ResponsavelEm_cod_responsavel` ASC),
  INDEX `fk_Estagio_Orientador1_idx` (`Orientador_cod_orientador` ASC),
  INDEX `fk_Estagio_Vaga1_idx` (`Vaga_cod_vaga` ASC),
  INDEX `fk_Estagio_Aluno1_idx` (`Aluno_cod_aluno` ASC),
  CONSTRAINT `fk_Estagio_ResponsavelEm1`
    FOREIGN KEY (`ResponsavelEm_cod_responsavel`)
    REFERENCES `ResponsavelEm` (`cod_responsavel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Estagio_Orientador1`
    FOREIGN KEY (`Orientador_cod_orientador`)
    REFERENCES `Orientador` (`cod_orientador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Estagio_Vaga1`
    FOREIGN KEY (`Vaga_cod_vaga`)
    REFERENCES `Vaga` (`cod_vaga`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Estagio_Aluno1`
    FOREIGN KEY (`Aluno_cod_aluno`)
    REFERENCES `Aluno` (`cod_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Curriculo_has_Idioma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Curriculo_has_Idioma` (
  `Curriculo_cod_curriculo` INT(9) NOT NULL,
  `Idioma_cod_idioma` INT(9) NOT NULL,
  PRIMARY KEY (`Curriculo_cod_curriculo`, `Idioma_cod_idioma`),
  INDEX `fk_Curriculo_has_Idioma_Idioma1_idx` (`Idioma_cod_idioma` ASC),
  INDEX `fk_Curriculo_has_Idioma_Curriculo1_idx` (`Curriculo_cod_curriculo` ASC),
  CONSTRAINT `fk_Curriculo_has_Idioma_Curriculo1`
    FOREIGN KEY (`Curriculo_cod_curriculo`)
    REFERENCES `Curriculo` (`cod_curriculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Curriculo_has_Idioma_Idioma1`
    FOREIGN KEY (`Idioma_cod_idioma`)
    REFERENCES `Idioma` (`cod_idioma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
