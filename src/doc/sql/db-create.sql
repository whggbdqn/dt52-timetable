/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.5.20-log : Database - dt52_team1_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dt52_team1_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dt52_team1_db`;

/*Table structure for table `classes` */

DROP TABLE IF EXISTS `classes`;

CREATE TABLE `classes` (
  `class_pk` int(20) NOT NULL AUTO_INCREMENT COMMENT '班级主键',
  `stu_num` int(20) DEFAULT NULL COMMENT '班级人数',
  `class_name` varchar(20) DEFAULT NULL COMMENT '班级名称',
  `major` varchar(20) DEFAULT NULL COMMENT '专业',
  `course_id` int(20) DEFAULT NULL COMMENT '课程id',
  `teacher_id` int(20) DEFAULT NULL COMMENT '班主任id',
  `instructor_id` int(20) DEFAULT NULL COMMENT '授课老师',
  `dr` int(10) DEFAULT '0',
  PRIMARY KEY (`class_pk`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `classes` */

insert  into `classes`(`class_pk`,`stu_num`,`class_name`,`major`,`course_id`,`teacher_id`,`instructor_id`,`dr`) values 
(1,30,'DT50','java',11,5,4,0),
(2,25,'DT52','java',11,1,2,0),
(3,35,'DT53','java',11,3,4,0),
(4,30,'DT51','ui',11,5,10,0),
(5,30,'DT54','java',11,12,2,0),
(6,40,'DT55','java',11,9,2,0),
(7,40,'DT56','java',11,3,7,0),
(8,40,'DT57','java',11,1,4,0),
(9,30,'DT58','java',11,11,10,0),
(10,30,'DT59','java',11,5,7,0),
(12,30,'DT60','java',11,12,6,0);

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `course_pk` int(20) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(20) DEFAULT NULL,
  `course_content` varchar(20) DEFAULT NULL,
  `dr` int(10) DEFAULT '0',
  PRIMARY KEY (`course_pk`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`course_pk`,`course_name`,`course_content`,`dr`) values 
(11,'java','Java1',0),
(12,'java','Java2',0),
(13,'java','Java3',0),
(14,'java','Java4',0),
(15,'java','Java5',0),
(16,'java','Java6',0),
(17,'java','Java7',0),
(18,'java','Java8',0),
(19,'java','Java9',0),
(20,'java','Java10',0),
(21,'java','Java高级1',0),
(22,'java','Java高级2',0),
(23,'java','Java高级3',0),
(24,'java','Java高级4',0),
(25,'java','Java高级5',0),
(26,'java','Java高级6',0),
(27,'java','Java高级7',0),
(28,'java','Java高级8',0),
(29,'java','Java高级9',0),
(30,'java','Java高级10',0),
(31,'java','Java高级11',0),
(32,'java','Web前端1',0),
(33,'java','Web前端2',0),
(34,'java','Web前端3',0),
(35,'java','Web前端4',0),
(36,'java','Web前端5',0),
(37,'java','Web前端6',0),
(38,'java','Web前端7',0),
(39,'java','Web前端8',0),
(40,'java','Web前端9',0),
(41,'java','Web前端10',0),
(42,'java','Web前端11',0),
(43,'java','Web前端12',0),
(44,'java','Web前端13',0),
(45,'java','Web前端14',0),
(46,'java','Web前端15',0),
(47,'java','MySQL1',0),
(48,'java','MySQL2',0),
(49,'java','MySQL3',0),
(50,'java','MySQL4',0),
(51,'java','MySQL4',0),
(52,'java','MySQL5',0),
(53,'java','MySQL6',0),
(54,'java','MySQL7',0),
(55,'java','MySQL8',0),
(56,'java','MySQL9',0),
(57,'java','MySQL10',0),
(58,'java','MySQL11',0),
(59,'java','MySQL12',0),
(60,'java','Jsp1',0),
(61,'java','Jsp2',0),
(62,'java','Jsp3',0),
(63,'java','Jsp4',0),
(64,'java','Jsp5',0),
(65,'java','Jsp6',0),
(66,'java','Jsp7',0),
(67,'java','Jsp8',0),
(68,'java','Jsp9',0),
(69,'java','Jsp10',0),
(70,'java','Jsp11',0),
(71,'java','Oracle1',0),
(72,'java','Oracle2',0),
(73,'java','Oracle3',0),
(74,'java','Oracle4',0),
(75,'java','MyBatis1',0),
(76,'java','MyBatis2',0),
(77,'java','MyBatis3',0),
(78,'java','MyBatis4',0),
(79,'java','MyBatis5',0),
(80,'java','Spring1',0),
(81,'java','Spring2',0),
(82,'java','MVC1',0),
(83,'java','MVC2',0),
(84,'java','MVC3',0),
(85,'java','MVC4',0),
(86,'java','MVC5',0),
(87,'java','MVC6',0),
(88,'java','SSM1',0),
(89,'java','SSM2',0),
(90,'java','JavaEE1',0),
(91,'java','JavaEE2',0),
(92,'java','JavaEE3',0),
(93,'java','JavaEE4',0),
(94,'java','JavaEE5',0),
(95,'java','JavaEE6',0),
(96,'java','JavaEE7',0),
(97,'自习','自习',0);

/*Table structure for table `room` */

DROP TABLE IF EXISTS `room`;

CREATE TABLE `room` (
  `room_id` int(20) NOT NULL AUTO_INCREMENT,
  `room_name` varchar(20) DEFAULT NULL,
  `room_size` int(11) DEFAULT NULL,
  `dr` int(20) DEFAULT '0',
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `room` */

insert  into `room`(`room_id`,`room_name`,`room_size`,`dr`) values 
(1,'一机房',40,0),
(2,'二机房',30,0),
(3,'三机房',30,0),
(4,'四机房',30,0),
(5,'五机房',30,0),
(6,'六机房',50,0),
(7,'七机房',45,0),
(8,'八机房',30,0);

/*Table structure for table `schedule` */

DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
  `schedule_pk` int(20) NOT NULL AUTO_INCREMENT COMMENT '课表主键',
  `sch_date` date DEFAULT NULL COMMENT '日期',
  `sch_time` varchar(20) DEFAULT NULL COMMENT '上午、下午、晚上',
  `classes_id` int(11) NOT NULL COMMENT '班级id',
  `room_id` int(11) NOT NULL COMMENT '教室id',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教室id(弃用)',
  `course_id` int(20) DEFAULT NULL COMMENT '课程id',
  `week` varchar(20) DEFAULT NULL COMMENT '周数',
  `dr` int(10) DEFAULT '0',
  PRIMARY KEY (`schedule_pk`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `schedule` */

insert  into `schedule`(`schedule_pk`,`sch_date`,`sch_time`,`classes_id`,`room_id`,`teacher_id`,`course_id`,`week`,`dr`) values 
(1,'2018-02-27','上午',12,1,6,97,NULL,0),
(2,'2018-01-22','下午',12,1,12,12,NULL,0),
(3,'2018-01-22','晚上',0,0,NULL,NULL,NULL,0),
(4,'2018-01-22','上午',10,2,5,32,NULL,0),
(5,'2018-01-22','下午',10,2,7,97,NULL,0),
(6,'2018-01-22','晚上',0,0,NULL,NULL,NULL,0),
(8,'2018-01-22','上午',0,3,NULL,NULL,NULL,0),
(9,'2018-01-22','下午',0,3,NULL,NULL,NULL,0),
(10,'2018-01-22','晚上',0,0,NULL,NULL,NULL,0),
(11,'2018-01-22','上午',0,4,NULL,NULL,NULL,0),
(12,'2018-01-22','下午',0,4,NULL,NULL,NULL,0),
(13,'2018-01-22','晚上',0,0,NULL,NULL,NULL,0),
(14,'2018-01-22','上午',0,5,NULL,NULL,NULL,0),
(15,'2018-01-22','下午',0,5,NULL,NULL,NULL,0),
(16,'2018-01-22','晚上',0,0,NULL,NULL,NULL,0),
(17,'2018-01-22','上午',0,6,NULL,NULL,NULL,0),
(18,'2018-01-22','下午',0,6,NULL,NULL,NULL,0),
(19,'2018-01-22','晚上',0,0,NULL,NULL,NULL,0),
(20,'2018-01-22','上午',0,7,NULL,NULL,NULL,0),
(21,'2018-01-22','下午',0,7,NULL,NULL,NULL,0),
(22,'2018-01-22','晚上',0,0,NULL,NULL,NULL,0),
(23,'2018-01-22','上午',0,8,NULL,NULL,NULL,0),
(24,'2018-01-22','下午',0,8,NULL,NULL,NULL,0),
(25,'2018-01-22','晚上',0,0,NULL,NULL,NULL,0),
(26,'2018-02-01','上午',8,5,NULL,NULL,NULL,0),
(27,'2018-02-01','下午',8,5,NULL,NULL,NULL,0),
(28,'2018-02-01','晚上',0,0,NULL,NULL,NULL,0);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `teacher_id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `schedule_name` varchar(20) DEFAULT NULL,
  `dr` int(10) DEFAULT '0',
  `emplId` varchar(20) DEFAULT NULL COMMENT '钉钉中用户的id',
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`teacher_id`,`name`,`gender`,`schedule_name`,`dr`,`emplId`) values 
(1,'罗纯','女','cot',0,NULL),
(2,'吴智超','男','java',0,NULL),
(3,'文雯','女','cot',0,NULL),
(4,'王建兵','男','java',0,NULL),
(5,'朱大玲','女','cot',0,NULL),
(6,'丁鹏','男','java',0,NULL),
(7,'徐士甲','男','java',0,NULL),
(8,'郑韦韦','女','cot',0,NULL),
(9,'阮柳','男','cot',0,NULL),
(10,'孙子荃','男','ui',0,NULL),
(11,'汪文妮','女','cot',0,NULL),
(12,'陈冠男','女','cot',0,NULL),
(14,'郑文尧','男','java',0,'manager6387');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
