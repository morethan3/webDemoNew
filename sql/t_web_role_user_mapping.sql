/*
Navicat MySQL Data Transfer

Source Server         : adss
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2017-11-24 10:04:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_web_role_user_mapping
-- ----------------------------
DROP TABLE IF EXISTS `t_web_role_user_mapping`;
CREATE TABLE `t_web_role_user_mapping` (
  `id` varchar(32) NOT NULL,
  `userid` varchar(32) NOT NULL,
  `roleid` varchar(32) NOT NULL,
  `ctime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `utime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_web_role_user_mapping
-- ----------------------------
INSERT INTO `t_web_role_user_mapping` VALUES ('1', '1', '1', '2017-11-20 15:11:20', '2017-11-20 15:11:23');
SET FOREIGN_KEY_CHECKS=1;
