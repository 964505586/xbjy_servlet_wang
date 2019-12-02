/*
 Navicat Premium Data Transfer

 Source Server         : mater
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : xbjy_servlet_201910

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 02/12/2019 10:49:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_id` int(11) NULL DEFAULT NULL COMMENT '部门id',
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `age` int(3) NULL DEFAULT NULL,
  `sex` int(2) NULL DEFAULT NULL COMMENT '性别：1男，0女',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `birth_date` date NULL DEFAULT NULL COMMENT '出生日期',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `create_by` int(11) NULL DEFAULT NULL,
  `del_flag` int(1) NULL DEFAULT 0 COMMENT '是否删除1是，0否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 1, 'admin', '1275ee31148c5450ff6f5561396cb593cb1c2c1a', '马云123', 55, 1, 'xxx@qq.com', '2019-10-24', '2019-10-11 22:26:56', 1, NULL);
INSERT INTO `sys_user` VALUES (2, 1, 'admin2', '1275ee31148c5450ff6f5561396cb593cb1c2c1a', '马云1', 231, 0, NULL, '2019-10-20', '2019-10-11 23:27:40', 1, NULL);
INSERT INTO `sys_user` VALUES (3, 2, 'admin3', '123', '马云2', 23, 0, NULL, '2019-10-16', '2019-10-12 11:54:22', 1, NULL);
INSERT INTO `sys_user` VALUES (4, 3, 'admin4', '1', '马云4', 1, 0, NULL, '2019-10-19', '2019-10-12 11:57:55', 1, NULL);
INSERT INTO `sys_user` VALUES (5, 4, 'admin5', '1', '1', 1, 0, NULL, '2019-10-19', '2019-10-12 12:00:44', 1, NULL);
INSERT INTO `sys_user` VALUES (6, 2, 'admin6', '1', '1', 1, 1, NULL, '2019-10-18', '2019-10-12 12:03:38', 1, NULL);
INSERT INTO `sys_user` VALUES (7, 5, 'admin7', '123', '董明珠', 60, 0, NULL, '2019-10-15', '2019-10-14 15:07:53', 1, NULL);
INSERT INTO `sys_user` VALUES (10, 2, 'hello', '8054c59b9a60d356a3e634ea20c976096691b05f', '马', 23, 0, '122@qq.com', '2019-10-11', '2019-10-21 15:29:40', 1, 0);

SET FOREIGN_KEY_CHECKS = 1;
