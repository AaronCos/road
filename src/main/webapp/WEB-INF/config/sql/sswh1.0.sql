/*
Navicat MySQL Data Transfer

Source Server         : aaa
Source Server Version : 50624
Source Host           : 127.0.0.1:3306
Source Database       : easybuy

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2019-11-24 16:53:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for frontuser
-- ----------------------------
DROP TABLE IF EXISTS `frontuser`;
CREATE TABLE `frontuser` (
  `iid` int(11) NOT NULL AUTO_INCREMENT,
  `frontuseruuid` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `password_salt` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `identity` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `status` int(255) DEFAULT NULL COMMENT '0:无效 1：有效 ',
  `code` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  `day` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`iid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of frontuser
-- ----------------------------
INSERT INTO `frontuser` VALUES ('1', null, 'aaron', '5d93ceb70e2bf5daa84ec3d0cd2c731a', '46f687de1a65446ab8a58726549a3380', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `frontuser` VALUES ('2', null, 'hello', 'ec73bbdb20db641e246eecf342b4d6bd', 'dab4d1f5e7a94b7c8b927aebef6ee8d4', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `frontuser` VALUES ('3', null, 'goodboy', '00bac47ebdd7482c0afce3b777955f66', 'c929e8a57c594dce9194c1d2a92b9bfe', null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for healthindex
-- ----------------------------
DROP TABLE IF EXISTS `healthindex`;
CREATE TABLE `healthindex` (
  `iid` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` varchar(255) DEFAULT NULL,
  `studentName` varchar(255) DEFAULT NULL,
  `height` double DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `lungIndex` double DEFAULT NULL,
  `lung` double DEFAULT NULL,
  `faceArea` double DEFAULT NULL,
  `left_eye` float(255,0) DEFAULT NULL,
  `right_eye` float DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`iid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of healthindex
-- ----------------------------
INSERT INTO `healthindex` VALUES ('1', 'ss0000', '王成成', '173', '66', '0', '0', '0', '0', '0', '2019-06-18 00:07:17');
INSERT INTO `healthindex` VALUES ('2', 'ss0000', '王成成', '174', '55', '0', '0', '0', '0', '0', '2019-06-04 00:08:26');
INSERT INTO `healthindex` VALUES ('3', 'ss0000', '王成成', '177', '78', '0', '0', '0', '0', '0', '2019-05-18 00:09:30');

-- ----------------------------
-- Table structure for platformpermission
-- ----------------------------
DROP TABLE IF EXISTS `platformpermission`;
CREATE TABLE `platformpermission` (
  `iid` int(11) NOT NULL AUTO_INCREMENT,
  `permissionuuid` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of platformpermission
-- ----------------------------

-- ----------------------------
-- Table structure for platformrole
-- ----------------------------
DROP TABLE IF EXISTS `platformrole`;
CREATE TABLE `platformrole` (
  `iid` int(11) DEFAULT NULL,
  `roleuuid` varchar(255) DEFAULT NULL,
  `rolename` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of platformrole
-- ----------------------------

-- ----------------------------
-- Table structure for platformuser
-- ----------------------------
DROP TABLE IF EXISTS `platformuser`;
CREATE TABLE `platformuser` (
  `iid` int(11) NOT NULL AUTO_INCREMENT,
  `useruuid` varchar(255) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(200) NOT NULL,
  `mobilephone` varchar(11) DEFAULT NULL,
  `idcard` varchar(20) DEFAULT NULL,
  `password_salt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`iid`),
  UNIQUE KEY `t_platformuser_t_mobilephone_uindex` (`mobilephone`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='平台后台用户表';

-- ----------------------------
-- Records of platformuser
-- ----------------------------
INSERT INTO `platformuser` VALUES ('1', null, 'wang', '15583514ce2e71d11b7e3915d5d03cb8', '1373220933', '32092119921', '46f687de1a65446ab8a58726549a3380');
INSERT INTO `platformuser` VALUES ('6', null, 'aaron', '15583514ce2e71d11b7e3915d5d03cb8', null, null, '46f687de1a65446ab8a58726549a3380');
INSERT INTO `platformuser` VALUES ('7', null, 'zqq', '647b2cb0ef70159a907037bc6ed44349', null, null, 'cb56fc226d104a36a0dfda11fde8c7c4');
INSERT INTO `platformuser` VALUES ('8', null, 'wby', '012de46a5be74bc699ff0939f13659c1', null, null, '543947ce31664d6caf2fe661877a31d3');
INSERT INTO `platformuser` VALUES ('9', 'b87154a7f032415f9729629befb0a6ad', 'ewqewq', 'bfa4a16dd3ca6c7e382428a5b5a47263', null, null, '92f26f50cdfc4de7a9f579d8b880aff2');

-- ----------------------------
-- Table structure for platform_roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `platform_roles_permissions`;
CREATE TABLE `platform_roles_permissions` (
  `iid` int(11) NOT NULL AUTO_INCREMENT,
  `roleuuid` varchar(255) DEFAULT NULL,
  `permissionuuid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`iid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of platform_roles_permissions
-- ----------------------------
INSERT INTO `platform_roles_permissions` VALUES ('1', 'admin', 'user:select');

-- ----------------------------
-- Table structure for platform_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `platform_user_roles`;
CREATE TABLE `platform_user_roles` (
  `iid` int(11) NOT NULL AUTO_INCREMENT,
  `useruuid` varchar(255) DEFAULT NULL,
  `roleuuid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`iid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of platform_user_roles
-- ----------------------------
INSERT INTO `platform_user_roles` VALUES ('1', 'Mark', 'admin');

-- ----------------------------
-- Table structure for studentgrade
-- ----------------------------
DROP TABLE IF EXISTS `studentgrade`;
CREATE TABLE `studentgrade` (
  `iid` int(11) NOT NULL AUTO_INCREMENT,
  `main_sequence` varchar(255) NOT NULL,
  `sequence` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `submittime` datetime NOT NULL,
  `main_subject` varchar(50) NOT NULL,
  `scores` float NOT NULL DEFAULT '0',
  `realname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`iid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='学生成绩';

-- ----------------------------
-- Records of studentgrade
-- ----------------------------
INSERT INTO `studentgrade` VALUES ('1', '000001', '000100', 'aaron', '2019-06-30 01:56:53', '语文', '90', null);
INSERT INTO `studentgrade` VALUES ('2', '000001', '000100', 'aaron', '2019-06-30 01:56:53', '数学', '89.4', null);
INSERT INTO `studentgrade` VALUES ('3', '000001', '000100', 'aaron', '2019-06-30 01:56:53', '外语', '73', null);
INSERT INTO `studentgrade` VALUES ('4', '000002', '000101', 'aaron', '2019-06-29 01:56:53', '语文', '55', null);
INSERT INTO `studentgrade` VALUES ('5', '000002', '000101', 'aaron', '2019-06-29 10:02:44', '数学', '90', null);
INSERT INTO `studentgrade` VALUES ('6', '000002', '000101', 'aaron', '2019-06-29 10:02:44', '外语', '90', null);
INSERT INTO `studentgrade` VALUES ('7', '000001', '000102', 'hello', '2019-06-28 10:02:44', '语文', '60', null);
INSERT INTO `studentgrade` VALUES ('8', '000001', '000102', 'hello', '2019-06-28 10:02:44', '数学', '85', null);
INSERT INTO `studentgrade` VALUES ('9', '000001', '000102', 'hello', '2019-06-28 10:02:44', '外语', '95', null);
INSERT INTO `studentgrade` VALUES ('10', '000003', '000103', 'aaron', '2019-06-25 10:02:44', '语文', '100', null);
INSERT INTO `studentgrade` VALUES ('11', '000003', '000103', 'aaron', '2019-06-24 10:02:44', '数学', '87', null);
INSERT INTO `studentgrade` VALUES ('12', '000003', '000103', 'aaron', '2019-06-25 10:02:44', '外语', '30', null);
INSERT INTO `studentgrade` VALUES ('13', '000004', '000104', 'aaron', '2019-04-25 10:02:44', '语文', '45', null);
INSERT INTO `studentgrade` VALUES ('14', '000004', '000104', 'aaron', '2019-04-24 10:02:44', '数学', '69', null);
INSERT INTO `studentgrade` VALUES ('15', '000004', '000104', 'aaron', '2019-04-25 10:02:44', '外语', '72', null);
INSERT INTO `studentgrade` VALUES ('16', '000005', '000105', 'aaron', '2019-03-25 10:02:44', '语文', '99', null);
INSERT INTO `studentgrade` VALUES ('17', '000005', '000105', 'aaron', '2019-03-24 10:02:44', '数学', '100', null);
INSERT INTO `studentgrade` VALUES ('18', '000005', '000105', 'aaron', '2019-03-25 10:02:44', '外语', '10', null);

-- ----------------------------
-- Table structure for subjectgrade
-- ----------------------------
DROP TABLE IF EXISTS `subjectgrade`;
CREATE TABLE `subjectgrade` (
  `iid` int(11) NOT NULL AUTO_INCREMENT,
  `gradeuuid` varchar(255) DEFAULT NULL,
  `frontuseruuid` varchar(255) NOT NULL COMMENT '学生唯一键',
  `name` varchar(255) NOT NULL COMMENT '学生姓名',
  `chinese` varchar(255) DEFAULT NULL COMMENT '语文成绩',
  `math` varchar(255) DEFAULT NULL COMMENT '数学成绩',
  `english` varchar(255) DEFAULT NULL COMMENT '英语成绩',
  `physics` varchar(255) DEFAULT NULL COMMENT '化学成绩',
  `chemistry` varchar(255) DEFAULT NULL,
  `history` varchar(255) DEFAULT NULL,
  `geography` varchar(255) DEFAULT NULL,
  `biology` varchar(255) DEFAULT NULL,
  `polity` varchar(255) DEFAULT NULL,
  `createtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` datetime DEFAULT NULL,
  `orderid` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`iid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='学生各科成绩表';

-- ----------------------------
-- Records of subjectgrade
-- ----------------------------
INSERT INTO `subjectgrade` VALUES ('1', null, '32131', '312', '12', '12', '12', '321', '3', '23', '23', '2', '23', '2019-11-24 16:14:38', null, null);
