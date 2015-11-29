-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for smartfeedback
DROP DATABASE IF EXISTS `smartfeedback`;
CREATE DATABASE IF NOT EXISTS `smartfeedback` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `smartfeedback`;


-- Dumping structure for table smartfeedback.activitate
DROP TABLE IF EXISTS `activitate`;
CREATE TABLE IF NOT EXISTS `activitate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `an` int(11) NOT NULL,
  `nume` varchar(255) NOT NULL,
  `code` varchar(50) NOT NULL,
  `id_tip_activitate` int(11) NOT NULL,
  `id_serie` int(11) NOT NULL,
  `id_grupa` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_activitate_tip_activitate` (`id_tip_activitate`),
  KEY `FK_activitate_serie` (`id_serie`),
  KEY `FK_activitate_grupa` (`id_grupa`),
  CONSTRAINT `FK_activitate_grupa` FOREIGN KEY (`id_grupa`) REFERENCES `grupa` (`id`),
  CONSTRAINT `FK_activitate_serie` FOREIGN KEY (`id_serie`) REFERENCES `serie` (`id`),
  CONSTRAINT `FK_activitate_tip_activitate` FOREIGN KEY (`id_tip_activitate`) REFERENCES `tip_activitate` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabele pentru activitate';

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.comentariu
DROP TABLE IF EXISTS `comentariu`;
CREATE TABLE IF NOT EXISTS `comentariu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` text NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id_parinte` int(11) DEFAULT NULL,
  `id_utilizator` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_comentariu_comentariu` (`id_parinte`),
  KEY `FK_comentariu_utilizator` (`id_utilizator`),
  CONSTRAINT `FK_comentariu_comentariu` FOREIGN KEY (`id_parinte`) REFERENCES `comentariu` (`id`),
  CONSTRAINT `FK_comentariu_utilizator` FOREIGN KEY (`id_utilizator`) REFERENCES `utilizator` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.feedback
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE IF NOT EXISTS `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(255) NOT NULL,
  `id_activitate` int(11) NOT NULL,
  `status` int(11) NOT NULL COMMENT '1-activ; 2-inactiv',
  `from_date` datetime DEFAULT NULL,
  `to_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_feedback_activitate` (`id_activitate`),
  CONSTRAINT `FK_feedback_activitate` FOREIGN KEY (`id_activitate`) REFERENCES `activitate` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.feedback_intrebari
DROP TABLE IF EXISTS `feedback_intrebari`;
CREATE TABLE IF NOT EXISTS `feedback_intrebari` (
  `id_feedback` int(11) NOT NULL,
  `id_intrebare` int(11) NOT NULL,
  PRIMARY KEY (`id_feedback`,`id_intrebare`),
  KEY `FK_feedback_intrebari_intrebari` (`id_intrebare`),
  CONSTRAINT `FK__feedback` FOREIGN KEY (`id_feedback`) REFERENCES `feedback` (`id`),
  CONSTRAINT `FK_feedback_intrebari_intrebari` FOREIGN KEY (`id_intrebare`) REFERENCES `intrebari` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.grupa
DROP TABLE IF EXISTS `grupa`;
CREATE TABLE IF NOT EXISTS `grupa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(50) DEFAULT NULL,
  `an` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.intrebari
DROP TABLE IF EXISTS `intrebari`;
CREATE TABLE IF NOT EXISTS `intrebari` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `intrebare` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.mesaj
DROP TABLE IF EXISTS `mesaj`;
CREATE TABLE IF NOT EXISTS `mesaj` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user_send` int(11) NOT NULL,
  `id_user_recv` int(11) NOT NULL,
  `id_parinte` int(11) DEFAULT NULL,
  `seen` int(11) DEFAULT NULL COMMENT 'null-nu; 0-nu; 1-da',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `text` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_mesaj_utilizator` (`id_user_send`),
  KEY `FK_mesaj_utilizator_2` (`id_user_recv`),
  KEY `FK_mesaj_mesaj` (`id_parinte`),
  CONSTRAINT `FK_mesaj_mesaj` FOREIGN KEY (`id_parinte`) REFERENCES `mesaj` (`id`),
  CONSTRAINT `FK_mesaj_utilizator` FOREIGN KEY (`id_user_send`) REFERENCES `utilizator` (`id`),
  CONSTRAINT `FK_mesaj_utilizator_2` FOREIGN KEY (`id_user_recv`) REFERENCES `utilizator` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.profesor
DROP TABLE IF EXISTS `profesor`;
CREATE TABLE IF NOT EXISTS `profesor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabele pentru profesori';

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.profesor_activitate
DROP TABLE IF EXISTS `profesor_activitate`;
CREATE TABLE IF NOT EXISTS `profesor_activitate` (
  `id_activitate` int(11) NOT NULL,
  `id_profesor` int(11) NOT NULL,
  PRIMARY KEY (`id_profesor`,`id_activitate`),
  KEY `FK_profesor_activitate_activitate` (`id_activitate`),
  CONSTRAINT `FK_profesor_activitate_activitate` FOREIGN KEY (`id_activitate`) REFERENCES `activitate` (`id`),
  CONSTRAINT `FK_profesor_activitate_profesor` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='profesor_activitate';

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.raspuns_intrebare
DROP TABLE IF EXISTS `raspuns_intrebare`;
CREATE TABLE IF NOT EXISTS `raspuns_intrebare` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_feedback` int(11) NOT NULL,
  `id_student` int(11) NOT NULL,
  `raspuns` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__feedback_raspuns` (`id_feedback`),
  KEY `FK__student_raspuns` (`id_student`),
  CONSTRAINT `FK__feedback_raspuns` FOREIGN KEY (`id_feedback`) REFERENCES `feedback` (`id`),
  CONSTRAINT `FK__student_raspuns` FOREIGN KEY (`id_student`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.sectie
DROP TABLE IF EXISTS `sectie`;
CREATE TABLE IF NOT EXISTS `sectie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(50) NOT NULL,
  `code` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.serie
DROP TABLE IF EXISTS `serie`;
CREATE TABLE IF NOT EXISTS `serie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(50) NOT NULL,
  `code` varchar(50) NOT NULL,
  `id_sectie` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_serie_sectie` (`id_sectie`),
  CONSTRAINT `FK_serie_sectie` FOREIGN KEY (`id_sectie`) REFERENCES `sectie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.student
DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `an_studiu` int(11) NOT NULL,
  `id_serie` int(11) NOT NULL,
  `id_grupa` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_student_serie` (`id_serie`),
  KEY `FK_student_grupa` (`id_grupa`),
  CONSTRAINT `FK_student_grupa` FOREIGN KEY (`id_grupa`) REFERENCES `grupa` (`id`),
  CONSTRAINT `FK_student_serie` FOREIGN KEY (`id_serie`) REFERENCES `serie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabele pentru studenti';

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.student_activitate
DROP TABLE IF EXISTS `student_activitate`;
CREATE TABLE IF NOT EXISTS `student_activitate` (
  `id_student` int(11) NOT NULL,
  `id_activitate` int(11) NOT NULL,
  PRIMARY KEY (`id_student`,`id_activitate`),
  KEY `FK_student_activitate_activitate` (`id_activitate`),
  CONSTRAINT `FK__student` FOREIGN KEY (`id_student`) REFERENCES `student` (`id`),
  CONSTRAINT `FK_student_activitate_activitate` FOREIGN KEY (`id_activitate`) REFERENCES `activitate` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.tip_activitate
DROP TABLE IF EXISTS `tip_activitate`;
CREATE TABLE IF NOT EXISTS `tip_activitate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(255) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.utilizator
DROP TABLE IF EXISTS `utilizator`;
CREATE TABLE IF NOT EXISTS `utilizator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(50) NOT NULL,
  `prenume` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `tip` int(11) NOT NULL COMMENT '1-prof; 2-stud',
  `id_student` int(11) DEFAULT NULL,
  `id_profesor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `FK_utilizator_student` (`id_student`),
  KEY `FK_utilizator_profesor` (`id_profesor`),
  CONSTRAINT `FK_utilizator_profesor` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id`),
  CONSTRAINT `FK_utilizator_student` FOREIGN KEY (`id_student`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabela generica pentru orice utilizator';

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
