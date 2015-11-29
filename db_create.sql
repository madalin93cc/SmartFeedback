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
CREATE DATABASE IF NOT EXISTS `smartfeedback` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `smartfeedback`;


-- Dumping structure for table smartfeedback.activitate
CREATE TABLE IF NOT EXISTS `activitate` (
  `id` int(11) NOT NULL,
  `an` int(11) NOT NULL,
  `nume` varchar(255) NOT NULL,
  `code` varchar(50) NOT NULL,
  `id_tip_activitate` int(11) NOT NULL,
  `id_serie` int(11) NOT NULL,
  `id_grupa` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_activitate_tip_activitate` (`id_tip_activitate`),
  KEY `FK_activitate_serie` (`id_serie`),
  KEY `FK_activitate_grupa` (`id_grupa`),
  CONSTRAINT `FK_activitate_grupa` FOREIGN KEY (`id_grupa`) REFERENCES `grupa` (`id`),
  CONSTRAINT `FK_activitate_serie` FOREIGN KEY (`id_serie`) REFERENCES `serie` (`id`),
  CONSTRAINT `FK_activitate_tip_activitate` FOREIGN KEY (`id_tip_activitate`) REFERENCES `tip_activitate` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabele pentru activitate';

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.feedback
CREATE TABLE IF NOT EXISTS `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(255) NOT NULL,
  `id_activitate` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_feedback_activitate` (`id_activitate`),
  CONSTRAINT `FK_feedback_activitate` FOREIGN KEY (`id_activitate`) REFERENCES `activitate` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.grupa
CREATE TABLE IF NOT EXISTS `grupa` (
  `id` int(11) NOT NULL,
  `nume` varchar(50) DEFAULT NULL,
  `an` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.profesor
CREATE TABLE IF NOT EXISTS `profesor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabele pentru profesori';

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.profesor_activitate
CREATE TABLE IF NOT EXISTS `profesor_activitate` (
  `id_activitate` int(11) NOT NULL,
  `id_profesor` int(11) NOT NULL,
  PRIMARY KEY (`id_profesor`,`id_activitate`),
  KEY `FK_profesor_activitate_activitate` (`id_activitate`),
  CONSTRAINT `FK_profesor_activitate_activitate` FOREIGN KEY (`id_activitate`) REFERENCES `activitate` (`id`),
  CONSTRAINT `FK_profesor_activitate_profesor` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='profesor_activitate';

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.sectie
CREATE TABLE IF NOT EXISTS `sectie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(50) NOT NULL,
  `code` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.serie
CREATE TABLE IF NOT EXISTS `serie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.student
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
CREATE TABLE IF NOT EXISTS `student_activitate` (
  `id_student` int(11) NOT NULL,
  `id_activitate` int(11) NOT NULL,
  PRIMARY KEY (`id_student`,`id_activitate`),
  KEY `FK__activitate` (`id_activitate`),
  CONSTRAINT `FK__activitate` FOREIGN KEY (`id_activitate`) REFERENCES `activitate` (`id`),
  CONSTRAINT `FK__student` FOREIGN KEY (`id_student`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.tip_activitate
CREATE TABLE IF NOT EXISTS `tip_activitate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(255) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table smartfeedback.utilizator
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
  KEY `FK_utilizator_student` (`id_student`),
  KEY `FK_utilizator_profesor` (`id_profesor`),
  CONSTRAINT `FK_utilizator_profesor` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id`),
  CONSTRAINT `FK_utilizator_student` FOREIGN KEY (`id_student`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabela generica pentru orice utilizator';

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
