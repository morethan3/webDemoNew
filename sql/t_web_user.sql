/*
Navicat MySQL Data Transfer

Source Server         : adss
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2017-11-24 10:04:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_web_user
-- ----------------------------
DROP TABLE IF EXISTS `t_web_user`;
CREATE TABLE `t_web_user` (
  `id` varchar(32) NOT NULL,
  `uname` varchar(60) NOT NULL,
  `pwd` varchar(256) NOT NULL,
  `ctime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `utime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_web_user
-- ----------------------------
INSERT INTO `t_web_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '2017-11-20 15:08:58', '2017-11-20 15:09:02');
SET FOREIGN_KEY_CHECKS=1;
