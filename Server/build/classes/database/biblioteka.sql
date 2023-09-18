/*
SQLyog Community v13.1.9 (64 bit)
MySQL - 8.0.31 : Database - biblioteka
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`biblioteka` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `biblioteka`;

/*Table structure for table `administrator` */

DROP TABLE IF EXISTS `administrator`;

CREATE TABLE `administrator` (
  `adminId` bigint unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `prezime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `sifra` varchar(30) COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

/*Data for the table `administrator` */

insert  into `administrator`(`adminId`,`ime`,`prezime`,`sifra`) values 
(0,' ',' ',''),
(1,'milica','mitrovic','milica123'),
(2,'zoran','lukic','zoran123'),
(3,'ana','nastic','ana123'),
(4,'pavle','antic','pavle123'),
(5,'a','a','a');

/*Table structure for table `autor` */

DROP TABLE IF EXISTS `autor`;

CREATE TABLE `autor` (
  `autorId` bigint unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(30) COLLATE utf8mb3_unicode_ci NOT NULL,
  `prezime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`autorId`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

/*Data for the table `autor` */

insert  into `autor`(`autorId`,`ime`,`prezime`) values 
(0,' ',' '),
(1,'ivo','andric'),
(2,'mesa','selimovic'),
(3,'laza','lazarevic'),
(4,'milos','crnjanski'),
(5,'mihajlo','pupin'),
(6,'borisav','stankovic'),
(7,'danilo','kis'),
(8,'dragoslav','mihajlovic'),
(9,'dobrica','cosic'),
(10,'milorad','pavic'),
(11,'isidora','sekulic'),
(12,'borislav','pekic'),
(13,'momo','kapor'),
(14,'grozdana','olujic'),
(15,'lav','tolstoj'),
(16,'harper','li'),
(17,'f. skot','ficdzerald'),
(18,'gabriel garsia','markez'),
(19,'sarlot','bronte'),
(20,'dzejn','ostin'),
(21,'oskar','vajld'),
(22,'vilijam','sekspir'),
(23,'dzordz R.','martin'),
(24,'j.r.r.','tolkin'),
(25,'stiven','king'),
(26,'herman','melvil'),
(28,'vladmir','nabokov'),
(29,'fjodor','dostojevski'),
(30,'mark','tvejn'),
(31,'luis','kerol'),
(32,'virdzinija','vulf'),
(33,'dzordz','orvel'),
(34,'carls','dikens'),
(35,'albert','kami'),
(36,'madlin','miler'),
(37,'natali','hejns');

/*Table structure for table `clan` */

DROP TABLE IF EXISTS `clan`;

CREATE TABLE `clan` (
  `clanId` bigint unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `prezime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `brLicneKarte` bigint unsigned NOT NULL,
  PRIMARY KEY (`clanId`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

/*Data for the table `clan` */

insert  into `clan`(`clanId`,`ime`,`prezime`,`brLicneKarte`) values 
(0,' ',' ',0),
(7,'ana','kostic',333333333),
(19,'tamara','maksimovic',222222222),
(20,'nikolina','konatarevic',444444444),
(21,'tijana','lazic',555555556),
(22,'lena','loncarevic',666666666),
(24,'balsa','kretic',777777777),
(25,'magdalena','maksimovic',888888888);

/*Table structure for table `knjiga` */

DROP TABLE IF EXISTS `knjiga`;

CREATE TABLE `knjiga` (
  `knjigaId` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nazivKnjige` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `autorId` bigint unsigned NOT NULL,
  `dostupnost` tinyint(1) NOT NULL,
  PRIMARY KEY (`knjigaId`),
  KEY `autor_fk` (`autorId`),
  CONSTRAINT `autor_fk` FOREIGN KEY (`autorId`) REFERENCES `autor` (`autorId`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

/*Data for the table `knjiga` */

insert  into `knjiga`(`knjigaId`,`nazivKnjige`,`autorId`,`dostupnost`) values 
(0,' ',0,0),
(1,'na drini cuprija',1,1),
(2,'tvrdjava',2,1),
(3,'prvi put s ocem na jutrenje',3,1),
(4,'seobe',4,0),
(5,'sa pasnjaka do naucenjaka',5,1),
(6,'necista krv',6,1),
(7,'rani jadi',7,1),
(8,'petrijin venac',8,1),
(9,'koreni',9,1),
(10,'hazarski recnik',10,1),
(11,'pisma iz norveske',11,1),
(12,'besnilo',12,1),
(13,'una',13,1),
(14,'zlatokosa',14,0),
(15,'ana karenjina',15,1),
(16,'ubiti pticu rugalicu',16,1),
(17,'veliki gedzbi',17,1),
(18,'sto godina samoce',18,1),
(19,'dzejn ejr',19,1),
(20,'ponos i predrasude',20,1),
(21,'slika dorijana greja',21,1),
(22,'hamlet',22,1),
(23,'igra prestola',23,1),
(24,'gospodar prstenova',24,1),
(25,'keri',25,1),
(26,'mobi dik',26,1),
(28,'lolita',28,1),
(29,'zlocin i kazna',29,1),
(30,'dozivljaji toma sojera',30,1),
(31,'alisa u zemlji cuda',31,1),
(32,'gospoda dalovej',32,1),
(33,'zivotinjska farma',33,1),
(34,'oliver tvist',34,1),
(35,'stranac',35,1),
(36,'ahilova pesma',36,1),
(37,'hiljadu brodova',37,1);

/*Table structure for table `nalog` */

DROP TABLE IF EXISTS `nalog`;

CREATE TABLE `nalog` (
  `nalogID` bigint unsigned NOT NULL AUTO_INCREMENT,
  `datumIzdavanja` date NOT NULL,
  `vaziDo` date NOT NULL,
  `adminId` bigint unsigned NOT NULL,
  `clanId` bigint unsigned NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`nalogID`),
  KEY `admin_fk` (`adminId`),
  KEY `clan1_fk` (`clanId`),
  CONSTRAINT `admin_fk` FOREIGN KEY (`adminId`) REFERENCES `administrator` (`adminId`),
  CONSTRAINT `clan1_fk` FOREIGN KEY (`clanId`) REFERENCES `clan` (`clanId`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

/*Data for the table `nalog` */

insert  into `nalog`(`nalogID`,`datumIzdavanja`,`vaziDo`,`adminId`,`clanId`,`status`) values 
(104,'2023-06-29','2023-07-29',2,7,0),
(106,'2023-06-01','2023-07-01',4,20,0),
(107,'2023-06-09','2023-08-09',1,21,0),
(135,'2023-07-06','2023-08-06',3,19,0);

/*Table structure for table `stavkanaloga` */

DROP TABLE IF EXISTS `stavkanaloga`;

CREATE TABLE `stavkanaloga` (
  `stavkaId` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nalogId` bigint unsigned NOT NULL,
  `knjigaID` bigint unsigned NOT NULL,
  `vracena` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`nalogId`,`stavkaId`),
  KEY `stavkaId` (`stavkaId`),
  KEY `knjiga_fk` (`knjigaID`),
  CONSTRAINT `knjiga_fk` FOREIGN KEY (`knjigaID`) REFERENCES `knjiga` (`knjigaId`),
  CONSTRAINT `nalog_fk` FOREIGN KEY (`nalogId`) REFERENCES `nalog` (`nalogID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

/*Data for the table `stavkanaloga` */

insert  into `stavkanaloga`(`stavkaId`,`nalogId`,`knjigaID`,`vracena`) values 
(82,104,1,1),
(83,104,3,1),
(84,104,25,1),
(85,104,36,1),
(86,104,133,0),
(87,104,20,1),
(88,104,3,1),
(89,106,2,0),
(90,107,7,0),
(91,107,30,0),
(92,107,37,1),
(98,135,8,1),
(99,135,1,1),
(100,135,28,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
