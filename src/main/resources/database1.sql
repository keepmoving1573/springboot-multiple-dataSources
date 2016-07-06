/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.6.27-log : Database - database1
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE = '' */;

/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS */`database1` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `database1`;

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `id`                  VARCHAR(100) NOT NULL,
  `username`            VARCHAR(255) DEFAULT NULL,
  `net_name`            VARCHAR(255) DEFAULT NULL,
  `job`                 VARCHAR(255) DEFAULT NULL,
  `family_native_place` VARCHAR(255) DEFAULT NULL,
  `mobile`              VARCHAR(100) DEFAULT NULL,
  `email`               VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `user_info` */

INSERT INTO `user_info` (`id`, `username`, `net_name`, `job`, `family_native_place`, `mobile`, `email`)
VALUES ('1', '詹欢欢', 'heikehuan', 'java后端开发', '湖北省孝感市', '15010699876', '873089996@qq.com');

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;
