/*
Navicat MySQL Data Transfer

Source Server         : llz
Source Server Version : 50045
Source Host           : localhost:3306
Source Database       : atch

Target Server Type    : MYSQL
Target Server Version : 50045
File Encoding         : 65001

Date: 2016-04-12 11:46:32
*/

use atech;

drop table if exists test_object;

/*==============================================================*/
/* Table: test_object                                           */
/*==============================================================*/
create table test_object
(
   id                   int(11) not null auto_increment,
   status               varchar(20) not null,
   actual_fee           bigint(20),
   buyer_id             varchar(128),
   buy_time             datetime,
   platform_type        varchar(10) not null,
   create_time          datetime,
   update_time          datetime,
   operator_id          int(11),
   order_no             varchar(20) not null,
   primary key (id)
);

drop table if exists test_object_item;

/*==============================================================*/
/* Table: test_object_item                                      */
/*==============================================================*/
create table test_object_item
(
   id                   int(11) not null auto_increment,
   product_sku          varchar(32) not null,
   product_id           int(11) not null,
   test_object_id       int(11) not null,
   status               varchar(20),
   price                bigint(20),
   primary key (id)
);
SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL auto_increment COMMENT '管理员编号',
  `name` varchar(25) default NULL COMMENT '用户名',
  `email` varchar(45) default NULL,
  `password` varchar(45) default NULL,
  `phone` varchar(11) default NULL,
  `create_time` datetime default NULL,
  `last_login_time` datetime default NULL COMMENT '最后登录时间',
  `last_ip` varchar(11) default NULL COMMENT '最后登录ip',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL default '0',
  `type` tinyint(20) default NULL COMMENT '用户类型PUBLIC:普通用户EXPERT:专家用户',
  `address` varchar(80) default NULL,
  `real_name` varchar(25) default NULL COMMENT '真实姓名',
  `password` varchar(45) default NULL,
  `email` varchar(45) default NULL,
  `phone` varchar(11) default NULL,
  `name` varchar(25) default NULL,
  `avatar` varchar(45) default NULL COMMENT '头像',
  `industry` varchar(255) default NULL COMMENT '用户经营的产业',
  `scale` varchar(255) default NULL COMMENT '产业规模',
  `last_login_time` datetime default NULL COMMENT '最后登录时间',
  `register_time` datetime default NULL COMMENT '注册时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `advertisement`
-- ----------------------------
DROP TABLE IF EXISTS `advertisement`;
CREATE TABLE `advertisement` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(45) default NULL COMMENT '广告名称',
  `description` varchar(225) default NULL COMMENT '描述',
  `url` varchar(90) default NULL COMMENT '链接',
  `image` varchar(45) default NULL COMMENT '图片链接',
  `create_time` datetime default NULL,
  `update_time` datetime default NULL,
  `click` int(7) default NULL COMMENT '点击次数',
  `position` varchar(40) default NULL COMMENT '广告类型（FLOAT:幻灯片、TOP:顶部、AMONG:模\r\r\n\r\r\n块中间）',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of advertisement
-- ----------------------------

-- ----------------------------
-- Table structure for `album`
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `id` int(11) NOT NULL auto_increment COMMENT '专家相册表',
  `name` varchar(45) default NULL COMMENT '照片名',
  `path` varchar(45) default NULL COMMENT '照片路径',
  `user_id` int(11) default NULL COMMENT '用户（专家）id',
  `create_time` datetime default NULL,
  `description` varchar(255) default NULL COMMENT '描述',
  PRIMARY KEY  (`id`),
  KEY `abuser` (`user_id`),
  CONSTRAINT `abuser` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of album
-- ----------------------------

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(45) default NULL,
  `content` text COMMENT '内容',
  `key` varchar(45) default NULL COMMENT '关键字',
  `categoery_id` int(11) default NULL COMMENT '文章类型id',
  `admin_id` int(11) default NULL COMMENT '管理员id\r\n',
  `create_time` datetime default NULL COMMENT '发布时间',
  `update_time` datetime default NULL COMMENT '最近一次修改时间',
  `sort` tinyint(3) default NULL COMMENT '排序',
  `user_id` int(11) default NULL COMMENT '专家id',
  `click` int(11) default NULL COMMENT '点击次数',
  `image` varchar(45) default NULL COMMENT '图片路径',
  `type` varchar(40) default NULL COMMENT '文章类型-WEB:网站ARTICLE：文\r\r\n章ACCOMPLISH\r\r\n：成果',
  `state` varchar(40) default NULL COMMENT '提交状态NOT_AUDITED：未审核WAIT_AUDITED：待\r\r\n审\r\r\n核AUDITED：审核成功FAILED_AUDITED：未通过',
  PRIMARY KEY  (`id`),
  KEY `acateid` (`categoery_id`),
  KEY `aadmin` (`admin_id`),
  KEY `auser` (`user_id`),
  CONSTRAINT `aadmin` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`) ON DELETE NO ACTION,
  CONSTRAINT `acatagory` FOREIGN KEY (`categoery_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION,
  CONSTRAINT `auser` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL auto_increment,
  `pid` int(11) default NULL COMMENT '父编号\r\n0：一级分类，pid与id相\r\r\n关\r\r\n联',
  `name` varchar(25) default NULL,
  `type` varchar(40) default NULL COMMENT '分类类型ARTICLE:文章EXPERT:专家QUESTION\r\r\n:\r\r\n问题',
  `image` varchar(45) default NULL,
  `create_time` datetime default NULL,
  `update_time` datetime default NULL,
  `sort` tinyint(3) default NULL COMMENT '排序\r\n0-255',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for `answer`
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL auto_increment,
  `question_id` int(11) default NULL,
  `content` text,
  `create_time` datetime default NULL,
  `expert_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `aquestion` (`question_id`),
  KEY `aexpert` (`expert_id`),
  CONSTRAINT `aexpert` FOREIGN KEY (`expert_id`) REFERENCES `expert` (`id`) ON DELETE NO ACTION,
  CONSTRAINT `aquestion` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL auto_increment,
  `article_id` int(11) default NULL COMMENT '对应的文章',
  `user_id` int(11) default NULL COMMENT '对应用户编号\r\nuser_avatar  \r\r\n \r\r\n user_name',
  `content` varchar(255) default NULL,
  `create_time` datetime default NULL COMMENT '越早发布越靠下',
  PRIMARY KEY  (`id`),
  KEY `carticle` (`article_id`),
  KEY `cuser` (`user_id`),
  CONSTRAINT `carticle` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cuser` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `expert`
-- ----------------------------
DROP TABLE IF EXISTS `expert`;
CREATE TABLE `expert` (
  `id` int(11) NOT NULL auto_increment,
  `user_id` int(11) NOT NULL,
  `category_id` int(11) default NULL COMMENT '专家类别id',
  `professional` varchar(25) default NULL COMMENT '专家职称',
  `duty` varchar(25) default NULL COMMENT '职务',
  `instruction` text COMMENT '简介',
  `service` varchar(45) default NULL COMMENT '服务项目',
  `company` varchar(45) default NULL COMMENT '所在单位',
  PRIMARY KEY  (`id`),
  KEY `ecategory` (`category_id`),
  KEY `euser` (`user_id`),
  CONSTRAINT `euser` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION,
  CONSTRAINT `ecategory` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expert
-- ----------------------------

-- ----------------------------
-- Table structure for `favorite`
-- ----------------------------
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite` (
  `id` int(11) NOT NULL auto_increment,
  `fav_id` int(11) default NULL COMMENT '被收藏的id',
  `create_time` datetime default NULL COMMENT '收藏时间',
  `type` varchar(20) default NULL COMMENT '收藏类型（QUESTION:问题、TRADE:交易）',
  `user_id` int(11) default NULL COMMENT '用户id',
  PRIMARY KEY  (`id`),
  KEY `fuser` USING BTREE (`user_id`),
  CONSTRAINT `fuser` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of favorite
-- ----------------------------

-- ----------------------------
-- Table structure for `link`
-- ----------------------------
DROP TABLE IF EXISTS `link`;
CREATE TABLE `link` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(25) default NULL COMMENT '友情链接',
  `url` varchar(45) default NULL,
  `update_time` datetime default NULL,
  `create_time` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of link
-- ----------------------------

-- ----------------------------
-- Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) NOT NULL auto_increment,
  `category_id` int(40) NOT NULL,
  `title` varchar(45) NOT NULL COMMENT '主题',
  `state` varchar(40) NOT NULL COMMENT '状态NOT_AUDITED:未审核AUDITED:已审核REPLY:已经回复',
  `content` text COMMENT '具体内容',
  `create_time` datetime default NULL COMMENT '咨询时间',
  `click` int(7) default NULL COMMENT '点击数',
  `like` int(7) default NULL COMMENT '点赞数（收藏）',
  `top` int(7) default NULL COMMENT '催一下数量(只记录数量，不记录具体\r\r\n用\r\r\n户)',
  `expert_id` int(11) default NULL COMMENT '制定专家回答',
  `user_id` int(11) default NULL COMMENT '提问者(name)',
  PRIMARY KEY  (`id`),
  KEY `qcategory` (`category_id`),
  KEY `qexpert` (`expert_id`),
  KEY `quser` (`user_id`),
  CONSTRAINT `qcategory` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION,
  CONSTRAINT `qexpert` FOREIGN KEY (`expert_id`) REFERENCES `expert` (`id`) ON DELETE NO ACTION,
  CONSTRAINT `quser` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------

-- ----------------------------
-- Table structure for `trade`
-- ----------------------------
DROP TABLE IF EXISTS `trade`;
CREATE TABLE `trade` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(45) default NULL COMMENT '交易标题',
  `description` varchar(255) default NULL COMMENT '交易描述',
  `user_id` int(11) default NULL COMMENT '用户id',
  `click` int(11) default NULL,
  `like` int(11) default NULL,
  `create_time` datetime default NULL COMMENT '发布时间',
  `update_time` datetime default NULL,
  `end_time` datetime default NULL COMMENT '结束时间',
  `state` varchar(40) default NULL COMMENT '状态（WAIT_AUDITED:待审核AUDITED:已通过FAILED:\r\r\n未\r\r\n通过）',
  `category_id` int(11) default NULL COMMENT '分类id',
  `type` varchar(20) default NULL COMMENT '交易类型（SUPPLY:供应DEMANF:需求）',
  PRIMARY KEY  (`id`),
  KEY `tuser` (`user_id`),
  KEY `tcategory` (`category_id`),
  CONSTRAINT `tcategory` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION,
  CONSTRAINT `tuser` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trade
-- ----------------------------

-- ----------------------------
-- Table structure for `trend`
-- ----------------------------
DROP TABLE IF EXISTS `trend`;
CREATE TABLE `trend` (
  `id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `content` varchar(255) default NULL COMMENT '动态内容',
  `image` varchar(45) default NULL COMMENT '配图id(多个用“，”号隔\r\r\n开)',
  `create_time` datetime default NULL,
  PRIMARY KEY  (`id`),
  KEY `truser` (`user_id`),
  CONSTRAINT `truser` FOREIGN KEY (`user_id`) REFERENCES `trend` (`id`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trend
-- ----------------------------

-- ----------------------------
-- Table structure for `video`
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(45) default NULL,
  `description` varchar(255) default NULL,
  `path` varchar(80) default NULL COMMENT '文件路径',
  `create_time` datetime default NULL COMMENT '发布时间',
  `update_time` datetime default NULL,
  `admin_id` int(11) default NULL COMMENT '管理员id',
  `category_id` int(11) default NULL COMMENT '分类id',
  `click` int(11) default NULL COMMENT '点击次数',
  PRIMARY KEY  (`id`),
  KEY `vadmin` (`admin_id`),
  KEY `vcategory` (`category_id`),
  CONSTRAINT `vadmin` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`) ON DELETE NO ACTION,
  CONSTRAINT `vcategory` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video
-- ----------------------------
