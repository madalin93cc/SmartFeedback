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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='Tabele pentru activitate';

-- Dumping data for table smartfeedback.activitate: ~0 rows (approximately)
/*!40000 ALTER TABLE `activitate` DISABLE KEYS */;
REPLACE INTO `activitate` (`id`, `an`, `nume`, `code`, `id_tip_activitate`, `id_serie`, `id_grupa`) VALUES
	(1, 1, 'Utilizarea sistemelor de operare CA', 'USO', 1, 3, NULL);
/*!40000 ALTER TABLE `activitate` ENABLE KEYS */;


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
  UNIQUE KEY `UK_fc6nk9khge33nptr1014fmdto` (`id_utilizator`),
  UNIQUE KEY `UK_nr1h2hvcgos81lleqnpmg0wpw` (`id_parinte`),
  KEY `FK_comentariu_comentariu` (`id_parinte`),
  KEY `FK_comentariu_utilizator` (`id_utilizator`),
  CONSTRAINT `FK_comentariu_comentariu` FOREIGN KEY (`id_parinte`) REFERENCES `comentariu` (`id`),
  CONSTRAINT `FK_comentariu_utilizator` FOREIGN KEY (`id_utilizator`) REFERENCES `utilizator` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table smartfeedback.comentariu: ~0 rows (approximately)
/*!40000 ALTER TABLE `comentariu` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentariu` ENABLE KEYS */;


-- Dumping structure for table smartfeedback.feedback
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE IF NOT EXISTS `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(255) NOT NULL,
  `id_activitate` int(11) NOT NULL,
  `status` int(11) NOT NULL COMMENT '1-activ; 2-inactiv',
  `from_date` datetime DEFAULT NULL,
  `to_date` datetime DEFAULT NULL,
  `saptamana` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_feedback_activitate` (`id_activitate`),
  CONSTRAINT `FK_feedback_activitate` FOREIGN KEY (`id_activitate`) REFERENCES `activitate` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table smartfeedback.feedback: ~0 rows (approximately)
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
REPLACE INTO `feedback` (`id`, `nume`, `id_activitate`, `status`, `from_date`, `to_date`, `saptamana`) VALUES
	(1, 'USO CC Saptamana 1', 1, 1, '2015-12-02 15:46:56', '2015-12-07 15:47:03', 1),
	(2, 'USO CC Saptamana 2', 1, 1, '2015-12-02 15:46:56', '2015-12-07 15:47:03', 2),
	(3, 'USO CC Saptamana 3', 1, 1, '2015-11-23 15:46:56', '2015-11-30 15:47:03', 3),
	(4, 'USO CC Saptamana 4', 1, 1, '2015-12-05 15:46:56', '2015-12-13 15:48:03', 4),
	(5, 'USO CC Saptamana 5', 1, 2, '2015-12-02 15:46:56', '2015-12-07 15:47:03', 5);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;


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

-- Dumping data for table smartfeedback.feedback_intrebari: ~0 rows (approximately)
/*!40000 ALTER TABLE `feedback_intrebari` DISABLE KEYS */;
REPLACE INTO `feedback_intrebari` (`id_feedback`, `id_intrebare`) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 4),
	(1, 5),
	(2, 1),
	(2, 2),
	(2, 3),
	(2, 4),
	(2, 5),
	(3, 1),
	(3, 2),
	(3, 3),
	(3, 4),
	(3, 5),
	(4, 1),
	(4, 2),
	(4, 3),
	(4, 4),
	(4, 5),
	(5, 1),
	(5, 2),
	(5, 3),
	(5, 4),
	(5, 5);
/*!40000 ALTER TABLE `feedback_intrebari` ENABLE KEYS */;


-- Dumping structure for table smartfeedback.grupa
DROP TABLE IF EXISTS `grupa`;
CREATE TABLE IF NOT EXISTS `grupa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(50) DEFAULT NULL,
  `an` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table smartfeedback.grupa: ~3 rows (approximately)
/*!40000 ALTER TABLE `grupa` DISABLE KEYS */;
REPLACE INTO `grupa` (`id`, `nume`, `an`) VALUES
	(1, '334CC', 2015),
	(2, '333CC', 2015),
	(3, '332CC', 2015);
/*!40000 ALTER TABLE `grupa` ENABLE KEYS */;


-- Dumping structure for table smartfeedback.intrebari
DROP TABLE IF EXISTS `intrebari`;
CREATE TABLE IF NOT EXISTS `intrebari` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `intrebare` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table smartfeedback.intrebari: ~5 rows (approximately)
/*!40000 ALTER TABLE `intrebari` DISABLE KEYS */;
REPLACE INTO `intrebari` (`id`, `intrebare`) VALUES
	(1, 'Nota generala'),
	(2, 'Interactiunea cu studentii'),
	(3, 'Gradul de intelegere'),
	(4, 'Organizare'),
	(5, 'Expunerea activitatii');
/*!40000 ALTER TABLE `intrebari` ENABLE KEYS */;


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
  UNIQUE KEY `UK_llbml13w99sw6q6px82pplwf7` (`id_user_recv`),
  UNIQUE KEY `UK_fujknd2caa9koqxps0kw2i6s5` (`id_user_send`),
  UNIQUE KEY `UK_ssck7974sr5weq45vqh3fcxax` (`id_parinte`),
  KEY `FK_mesaj_utilizator` (`id_user_send`),
  KEY `FK_mesaj_utilizator_2` (`id_user_recv`),
  KEY `FK_mesaj_mesaj` (`id_parinte`),
  CONSTRAINT `FK_mesaj_mesaj` FOREIGN KEY (`id_parinte`) REFERENCES `mesaj` (`id`),
  CONSTRAINT `FK_mesaj_utilizator` FOREIGN KEY (`id_user_send`) REFERENCES `utilizator` (`id`),
  CONSTRAINT `FK_mesaj_utilizator_2` FOREIGN KEY (`id_user_recv`) REFERENCES `utilizator` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table smartfeedback.mesaj: ~0 rows (approximately)
/*!40000 ALTER TABLE `mesaj` DISABLE KEYS */;
/*!40000 ALTER TABLE `mesaj` ENABLE KEYS */;


-- Dumping structure for table smartfeedback.profesor
DROP TABLE IF EXISTS `profesor`;
CREATE TABLE IF NOT EXISTS `profesor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='Tabele pentru profesori';

-- Dumping data for table smartfeedback.profesor: ~0 rows (approximately)
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
REPLACE INTO `profesor` (`id`) VALUES
	(1);
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;


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

-- Dumping data for table smartfeedback.profesor_activitate: ~0 rows (approximately)
/*!40000 ALTER TABLE `profesor_activitate` DISABLE KEYS */;
REPLACE INTO `profesor_activitate` (`id_activitate`, `id_profesor`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `profesor_activitate` ENABLE KEYS */;


-- Dumping structure for table smartfeedback.raspuns_intrebare
DROP TABLE IF EXISTS `raspuns_intrebare`;
CREATE TABLE IF NOT EXISTS `raspuns_intrebare` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_feedback` int(11) NOT NULL,
  `id_utilizator` int(11) NOT NULL,
  `id_intrebare` int(11) DEFAULT NULL,
  `raspuns` text,
  `tip_raspuns` int(11) NOT NULL COMMENT '1 - observatie; 2 - intrebare',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9orj7o6cdwdlf8358r60qtvg1` (`id_feedback`),
  UNIQUE KEY `UK_mkklwfyeasna4luj1w6s1jh6f` (`id_utilizator`),
  UNIQUE KEY `UK_3fek4sob1owyamh7nt26fevre` (`id_intrebare`),
  KEY `FK__feedback_raspuns` (`id_feedback`),
  CONSTRAINT `FK_feedback_raspuns` FOREIGN KEY (`id_feedback`) REFERENCES `feedback` (`id`),
  CONSTRAINT `FK_raspuns_intrebare_intrebari` FOREIGN KEY (`id_intrebare`) REFERENCES `intrebari` (`id`),
  CONSTRAINT `FK_raspuns_intrebare_utilizator` FOREIGN KEY (`id_utilizator`) REFERENCES `utilizator` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table smartfeedback.raspuns_intrebare: ~0 rows (approximately)
/*!40000 ALTER TABLE `raspuns_intrebare` DISABLE KEYS */;
/*!40000 ALTER TABLE `raspuns_intrebare` ENABLE KEYS */;


-- Dumping structure for table smartfeedback.sectie
DROP TABLE IF EXISTS `sectie`;
CREATE TABLE IF NOT EXISTS `sectie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(50) NOT NULL,
  `code` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table smartfeedback.sectie: ~2 rows (approximately)
/*!40000 ALTER TABLE `sectie` DISABLE KEYS */;
REPLACE INTO `sectie` (`id`, `nume`, `code`) VALUES
	(1, 'Calculatoare si Tehnologia Informatiei', 'CTI'),
	(2, 'Ingineria sistemelor', 'IS');
/*!40000 ALTER TABLE `sectie` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- Dumping data for table smartfeedback.serie: ~11 rows (approximately)
/*!40000 ALTER TABLE `serie` DISABLE KEYS */;
REPLACE INTO `serie` (`id`, `nume`, `code`, `id_sectie`) VALUES
	(1, 'CA', 'CA', 1),
	(2, 'CB', 'CB', 1),
	(3, 'CC', 'CC', 1),
	(4, 'Arhitectura Sistemelor de Calcul', 'C1', 1),
	(5, 'Sisteme embedded', 'C2', 1),
	(6, 'Compilatoare', 'C3', 1),
	(7, 'Inteligenta artificiala', 'C4', 1),
	(8, 'Programare web', 'C5', 1),
	(9, 'AA', 'AA', 2),
	(10, 'AB', 'AB', 2),
	(11, 'AC', 'AC', 2);
/*!40000 ALTER TABLE `serie` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='Tabele pentru studenti';

-- Dumping data for table smartfeedback.student: ~0 rows (approximately)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
REPLACE INTO `student` (`id`, `an_studiu`, `id_serie`, `id_grupa`) VALUES
	(1, 2015, 3, 1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;


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

-- Dumping data for table smartfeedback.student_activitate: ~0 rows (approximately)
/*!40000 ALTER TABLE `student_activitate` DISABLE KEYS */;
REPLACE INTO `student_activitate` (`id_student`, `id_activitate`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `student_activitate` ENABLE KEYS */;


-- Dumping structure for table smartfeedback.tip_activitate
DROP TABLE IF EXISTS `tip_activitate`;
CREATE TABLE IF NOT EXISTS `tip_activitate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(255) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table smartfeedback.tip_activitate: ~3 rows (approximately)
/*!40000 ALTER TABLE `tip_activitate` DISABLE KEYS */;
REPLACE INTO `tip_activitate` (`id`, `nume`) VALUES
	(1, 'curs'),
	(2, 'seminar'),
	(3, 'laborator');
/*!40000 ALTER TABLE `tip_activitate` ENABLE KEYS */;


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
  UNIQUE KEY `UK_nnj7958wgayx950e6rg7v4yup` (`id_profesor`),
  UNIQUE KEY `UK_5nly9nfi7i00292dmn460m19c` (`id_student`),
  KEY `FK_utilizator_student` (`id_student`),
  KEY `FK_utilizator_profesor` (`id_profesor`),
  CONSTRAINT `FK_utilizator_profesor` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id`),
  CONSTRAINT `FK_utilizator_student` FOREIGN KEY (`id_student`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='Tabela generica pentru orice utilizator';

-- Dumping data for table smartfeedback.utilizator: ~2 rows (approximately)
/*!40000 ALTER TABLE `utilizator` DISABLE KEYS */;
REPLACE INTO `utilizator` (`id`, `nume`, `prenume`, `username`, `password`, `email`, `tip`, `id_student`, `id_profesor`) VALUES
	(1, 'Deaconescu', 'Razvan', 'prof', 'test', 'razvan.deaconescu@cs.pub.ro', 1, NULL, 1),
	(2, 'Colezea', 'Madalin', 'george', 'test', 'madalin.colezea@cs.pub.ro', 2, 1, NULL);
/*!40000 ALTER TABLE `utilizator` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
