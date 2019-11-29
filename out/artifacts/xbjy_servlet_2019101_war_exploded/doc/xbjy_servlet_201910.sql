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

 Date: 29/11/2019 15:00:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `p_id` int(11) NULL DEFAULT NULL,
  `type` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '1一级，2二级',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `menu_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url',
  `order_by` int(2) NULL DEFAULT NULL COMMENT '排序',
  `creat_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) NULL DEFAULT NULL COMMENT '创建人',
  `del_flag` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否删除1是，0否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, -1, '1', '系统管理', NULL, 1, '2019-11-29 11:49:00', 1, '0');
INSERT INTO `sys_menu` VALUES (2, -1, '1', '订单管理', NULL, 2, '2019-11-29 11:49:25', 1, '0');
INSERT INTO `sys_menu` VALUES (3, 1, '2', '部门管理', NULL, 1, '2019-11-29 11:49:57', 1, '0');
INSERT INTO `sys_menu` VALUES (4, 1, '2', '用户管理', NULL, 2, '2019-11-29 11:50:23', 1, '0');

SET FOREIGN_KEY_CHECKS = 1;
