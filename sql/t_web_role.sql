/*
Navicat MySQL Data Transfer

Source Server         : adss
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2017-11-24 10:04:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_web_role
-- ----------------------------
DROP TABLE IF EXISTS `t_web_role`;
CREATE TABLE `t_web_role` (
  `id` varchar(32) NOT NULL,
  `role` varchar(30) NOT NULL,
  `ctime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `utime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_web_role
-- ----------------------------
INSERT INTO `t_web_role` VALUES ('1', 'ROLE_admin', '2017-11-20 15:09:43', '2017-11-20 15:09:46');
INSERT INTO `t_web_role` VALUES ('2', 'ROLE_user', '2017-11-20 15:11:08', '2017-11-20 15:11:11');
SET FOREIGN_KEY_CHECKS=1;
