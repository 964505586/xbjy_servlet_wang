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

 Date: 02/12/2019 13:25:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` int(255) NULL DEFAULT NULL COMMENT '创建人',
  `del_flag` int(2) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, '研发部', '2019-10-22 09:41:25', 1, NULL);
INSERT INTO `sys_dept` VALUES (2, '推广部', '2019-10-24 09:41:28', 1, NULL);
INSERT INTO `sys_dept` VALUES (3, '行政部', '2019-10-04 09:41:33', 1, NULL);
INSERT INTO `sys_dept` VALUES (4, '财务部', '2019-10-17 09:41:38', 1, NULL);
INSERT INTO `sys_dept` VALUES (5, '总裁办公室', '2019-10-17 09:41:42', 1, NULL);
INSERT INTO `sys_dept` VALUES (6, '秘书部', '2019-10-09 09:41:46', 1, NULL);
INSERT INTO `sys_dept` VALUES (7, '外交部', '2019-10-22 09:58:11', 2, NULL);

SET FOREIGN_KEY_CHECKS = 1;
