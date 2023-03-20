/*
 Navicat Premium Data Transfer

 Source Server         : FelixDB
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : mybatistest

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 20/03/2023 16:18:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(5) NOT NULL,
  `ordertime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `total` double(10, 2) NULL DEFAULT NULL,
  `uid` int(5) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fky_uid`(`uid`) USING BTREE,
  CONSTRAINT `fky_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, '2020-05-01', 3000.00, 1);
INSERT INTO `orders` VALUES (2, '2021-05-01', 4000.00, 1);
INSERT INTO `orders` VALUES (3, '2021-05-01', 4300.00, 2);
INSERT INTO `orders` VALUES (4, '2021-05-02', 3300.00, 2);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role_addr` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role_level` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role_category` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '五条悟-update', '东京', '特级', '咒术师');
INSERT INTO `role` VALUES ('2', '虎杖悠仁', '东京', '一年生', '咒术师');
INSERT INTO `role` VALUES ('3', '伏黑惠', '东京', '一年生', '咒术师');
INSERT INTO `role` VALUES ('4', '钉崎野蔷薇', '东京', '一年生', '咒术师');
INSERT INTO `role` VALUES ('6', '东堂葵', '京都', '三年生', '咒术师');
INSERT INTO `role` VALUES ('7', '漏壶', '东京', '特级', '咒灵');

-- ----------------------------
-- Table structure for role2
-- ----------------------------
DROP TABLE IF EXISTS `role2`;
CREATE TABLE `role2`  (
  `id` int(5) NOT NULL,
  `rolename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role2
-- ----------------------------
INSERT INTO `role2` VALUES (1, '后端攻城狮');
INSERT INTO `role2` VALUES (2, '前端攻城狮');
INSERT INTO `role2` VALUES (3, '大数据开发');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(5) NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `birthday` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'tom', '123', '2001-01-01');
INSERT INTO `user` VALUES (2, 'jerry', '456', '2001-01-02');
INSERT INTO `user` VALUES (3, 'zhangsan', '789', '2001-01-03');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int(5) NOT NULL,
  `role_id` int(5) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE,
  INDEX `fkyrid`(`role_id`) USING BTREE,
  CONSTRAINT `fkyrid` FOREIGN KEY (`role_id`) REFERENCES `role2` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fkyuid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (3, 1);
INSERT INTO `user_role` VALUES (2, 2);
INSERT INTO `user_role` VALUES (1, 3);

SET FOREIGN_KEY_CHECKS = 1;
