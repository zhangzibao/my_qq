-- MySQL dump 10.16  Distrib 10.1.19-MariaDB, for Win32 (AMD64)
--
-- Host: zhangzibao.xyz    Database: zhangzibao.xyz
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `add_friend`
--

DROP TABLE IF EXISTS `add_friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `add_friend` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `sender_id` int(11) NOT NULL,
  `receiver_id` int(11) NOT NULL,
  `status` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:Ĭ��״̬\n1��ͬ��\n2���ܾ�\n3������',
  `add_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��Ӻ�����Ϣ��';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `add_friend`
--

LOCK TABLES `add_friend` WRITE;
/*!40000 ALTER TABLE `add_friend` DISABLE KEYS */;
/*!40000 ALTER TABLE `add_friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friends`
--

DROP TABLE IF EXISTS `friends`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friends` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `friend_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friends`
--

LOCK TABLES `friends` WRITE;
/*!40000 ALTER TABLE `friends` DISABLE KEYS */;
INSERT INTO `friends` VALUES (1,1,2),(2,1,3),(3,1,4),(5,2,1),(6,3,1),(7,4,1),(8,1,6),(9,2,6),(10,3,6),(11,4,6),(12,2,3);
/*!40000 ALTER TABLE `friends` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `friend_id` int(11) NOT NULL,
  `message_content` text NOT NULL,
  `add_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `isreceive` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (1,3,2,'你好','2019-05-15 11:48:16',1),(2,2,3,'你好','2019-05-15 11:48:16',0),(3,2,3,'性能问题重要吗','2019-05-15 11:48:21',0),(4,3,2,'性能问题重要吗','2019-05-15 11:48:21',1),(5,1,2,'哪个是机器人','2019-05-15 11:48:32',1),(6,2,1,'哪个是机器人','2019-05-15 11:48:32',0),(7,2,3,'哪个是机器人','2019-05-15 11:48:40',0),(8,3,2,'哪个是机器人','2019-05-15 11:48:40',1),(9,3,2,'1','2019-05-15 11:49:19',1),(10,2,3,'1','2019-05-15 11:49:19',0),(11,1,2,'报错','2019-05-15 11:50:23',0),(12,2,1,'报错','2019-05-15 11:50:23',1),(13,1,2,'泪是成长','2019-05-15 12:01:06',1),(14,2,1,'泪是成长','2019-05-15 12:01:06',0),(15,1,2,'必要的露水','2019-05-15 12:01:11',1),(16,2,1,'必要的露水','2019-05-15 12:01:11',0),(17,2,3,'数据流','2019-06-02 14:18:37',0),(18,3,2,'数据流','2019-06-02 14:18:37',1);
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u_avatar` varchar(100) NOT NULL DEFAULT 'http://120.79.44.150/qq_static/images/hj.png',
  `u_birthday` varchar(20) DEFAULT NULL,
  `u_name` varchar(20) NOT NULL,
  `u_gender` varchar(20) DEFAULT NULL,
  `u_email` varchar(30) DEFAULT NULL,
  `u_phone` varchar(11) DEFAULT NULL,
  `u_address` varchar(50) DEFAULT NULL,
  `u_about` text,
  `u_autograph` varchar(150) DEFAULT NULL,
  `u_password` varchar(50) NOT NULL,
  `nick_name` varchar(50) DEFAULT NULL,
  `open_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'http://120.79.44.150/qq_static/images/avatar.jpg','20/4/96','v','female','vanessaboyer@genekom.com','136456780','Nettie, Virginia, 5031','Esse esse pariatur sint irure fugiat anim anim magna irure qui. Sit nostrud veniam laboris ipsum voluptate ipsum dolore esse eiusmod sunt duis commodo ad. Dolor commodo Lorem proident excepteur quis magna proident duis adipisicing ea anim veniam aliquip ullamco. Ipsum fugiat Lorem id duis consequat aliquip proident aliquip in duis adipisicing. Qui ad est qui laborum reprehenderit occaecat nisi ad qui ullamco non.','Ut excepteur consequat duis adipisicing ad elit.','0','test1',NULL),(2,'http://120.79.44.150/qq_static/images/avatar1.jpg','11/3/95','p','female','patetran@genekom.com','178412313','North Carolina, 2584','Ullamco amet velit esse et duis deserunt ex in non eiusmod. Amet anim nisi aliqua minim aute consectetur amet fugiat labore in deserunt duis sunt. Deserunt tempor dolor in adipisicing irure magna in dolor magna exercitation Lorem et Lorem velit. Elit quis et proident ad aliquip qui aute anim eu minim deserunt excepteur. Mollit commodo sunt esse aute do. Quis non nisi id incididunt exercitation sint exercitation.','Dolore ea cupidatat deserunt nostrud officia est','0','test2',NULL),(3,'http://120.79.44.150/qq_static/images/avatar2.jpg','21/6/97','Cardenas Burnett','female','cardenasburnett@genekom.com','135523432','Salix, Delaware, 442','Ea laboris magna ex nisi Lorem anim sint excepteur. Amet nostrud proident dolore ad enim amet ipsum deserunt fugiat duis nisi tempor. Ex id amet duis do nostrud deserunt fugiat. Velit reprehenderit nulla exercitation minim pariatur deserunt do nulla enim Lorem laboris nisi labore incididunt. Laboris proident aliquip in proident cupidatat eiusmod sint nisi sit. Mollit qui pariatur ut exercitation mollit cupidatat. Ad ex cillum voluptate consequat laboris cupidatat.','Ipsum sit cupidatat dolore voluptate.','0','test3',NULL),(4,'http://120.79.44.150/qq_static/images/avatar3.jpg','3/3/99','Imelda Horne','female','imeldahorne@genekom.com','1581234219','Coldiron, Palau, 7757','Irure consectetur do ea ea ex proident laborum ex dolore incididunt mollit fugiat. Lorem minim adipisicing labore cillum velit adipisicing. Laboris laboris proident esse deserunt enim exercitation eu qui pariatur excepteur ad Lorem enim veniam.','Voluptate ad fugiat magna ut cupidatat','0','test4',NULL),(5,'http://120.79.44.150/qq_static/images/hj.png','','5555',NULL,NULL,NULL,NULL,NULL,NULL,'0','test5',NULL),(6,'http://120.79.44.150/qq_static/images/robot.jpg','3/3/99','robot','none','imeldahorne@genekom.com','1581234219','Coldiron, Palau, 7757','Irure consectetur do ea ea ex proident laborum ex dolore incididunt mollit fugiat. Lorem minim adipisicing labore cillum velit adipisicing. Laboris laboris proident esse deserunt enim exercitation eu qui pariatur excepteur ad Lorem enim veniam.','Voluptate ad fugiat magna ut cupidatat','0','robot',NULL),(9,'http://120.79.44.150/qq_static/images/hj.png',NULL,'daiyi',NULL,NULL,NULL,NULL,NULL,NULL,'dai','demo',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-17  7:53:13
