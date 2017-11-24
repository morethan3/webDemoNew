/*
Navicat MySQL Data Transfer

Source Server         : adss
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2017-11-24 10:03:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(250) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('my-trusted-client', null, 'secret', 'read, write, trust', 'password, authorization_code, refresh_token, implicit', null, 'ROLE_CLIENT, ROLE_TRUSTED_CLIENT', '120', '600', null, null);

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
