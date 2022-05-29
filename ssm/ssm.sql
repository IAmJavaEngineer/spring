/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : ssm

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 30/05/2022 00:28:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `money` double(7, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 'zhangsan', 5000.00);
INSERT INTO `account` VALUES (2, 'lisi', 5000.00);
INSERT INTO `account` VALUES (3, NULL, 0.00);
INSERT INTO `account` VALUES (4, NULL, 0.00);
INSERT INTO `account` VALUES (5, 'zhangsan', 5000.00);
INSERT INTO `account` VALUES (6, 'jery', 5000.00);

-- ----------------------------
-- Table structure for tbl_dept
-- ----------------------------
DROP TABLE IF EXISTS `tbl_dept`;
CREATE TABLE `tbl_dept`  (
  `dept_id` int NOT NULL,
  `dept_name` varchar(765) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dept_id`) USING BTREE,
  INDEX `dept_id`(`dept_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_dept
-- ----------------------------
INSERT INTO `tbl_dept` VALUES (1, '法务部');
INSERT INTO `tbl_dept` VALUES (2, '信息服务部');
INSERT INTO `tbl_dept` VALUES (3, '开发部');
INSERT INTO `tbl_dept` VALUES (4, '测试部');
INSERT INTO `tbl_dept` VALUES (5, '生产部');
INSERT INTO `tbl_dept` VALUES (6, '技术部');
INSERT INTO `tbl_dept` VALUES (7, '人事部');
INSERT INTO `tbl_dept` VALUES (8, '财务部');
INSERT INTO `tbl_dept` VALUES (9, '教务部');
INSERT INTO `tbl_dept` VALUES (10, '宣传部');

-- ----------------------------
-- Table structure for tbl_stu
-- ----------------------------
DROP TABLE IF EXISTS `tbl_stu`;
CREATE TABLE `tbl_stu`  (
  `stu_id` int NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `d_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`stu_id`) USING BTREE,
  INDEX `stu_dept`(`d_id` ASC) USING BTREE,
  CONSTRAINT `stu_dept` FOREIGN KEY (`d_id`) REFERENCES `tbl_dept` (`dept_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_stu
-- ----------------------------
INSERT INTO `tbl_stu` VALUES (1, '卢秀英', 'F', 'xiuyinglu@qq.com', 8);
INSERT INTO `tbl_stu` VALUES (2, '常睿', 'M', 'chang90@qq.com', 10);
INSERT INTO `tbl_stu` VALUES (3, '潘睿', 'M', 'panrui@qq.com', 4);
INSERT INTO `tbl_stu` VALUES (4, '于云熙', 'M', 'yuy71@qq.com', 3);
INSERT INTO `tbl_stu` VALUES (5, '郑致远', 'M', 'zheng5@qq.com', 9);
INSERT INTO `tbl_stu` VALUES (6, '邹云熙', 'M', 'yunxiz5@qq.com', 7);
INSERT INTO `tbl_stu` VALUES (7, '孟岚', 'F', 'lm1218@qq.com', 1);
INSERT INTO `tbl_stu` VALUES (8, '谭秀英', 'F', 'tanxiuyi2009@qq.com', 8);
INSERT INTO `tbl_stu` VALUES (9, '孙安琪', 'F', 'sun51@qq.com', 4);
INSERT INTO `tbl_stu` VALUES (10, '韦子异', 'M', 'ziyiwe@qq.com', 3);
INSERT INTO `tbl_stu` VALUES (11, '钟安琪', 'F', 'azhong@qq.com', 9);
INSERT INTO `tbl_stu` VALUES (12, '梁嘉伦', 'M', 'liang89@qq.com', 4);
INSERT INTO `tbl_stu` VALUES (13, '杜震南', 'M', 'zhend524@qq.com', 7);
INSERT INTO `tbl_stu` VALUES (14, '史震南', 'M', 'zhennan3@qq.com', 6);
INSERT INTO `tbl_stu` VALUES (15, '侯云熙', 'M', 'yunxiho@qq.com', 2);
INSERT INTO `tbl_stu` VALUES (16, '张杰宏', 'M', 'jiehongzha419@qq.com', 1);
INSERT INTO `tbl_stu` VALUES (17, '余詩涵', 'F', 'yushihan1019@qq.com', 4);
INSERT INTO `tbl_stu` VALUES (18, '唐子韬', 'M', 'zitao818@qq.com', 8);
INSERT INTO `tbl_stu` VALUES (19, '曹璐', 'F', 'cao1115@qq.com', 1);
INSERT INTO `tbl_stu` VALUES (20, '邵岚', 'F', 'shaolan@qq.com', 7);
INSERT INTO `tbl_stu` VALUES (21, '范子韬', 'M', 'zitaof@qq.com', 10);
INSERT INTO `tbl_stu` VALUES (22, '曹杰宏', 'M', 'cajiehong@qq.com', 8);
INSERT INTO `tbl_stu` VALUES (23, '沈杰宏', 'M', 'sj1117@qq.com', 4);
INSERT INTO `tbl_stu` VALUES (24, '钟晓明', 'M', 'xiaoming715@qq.com', 6);
INSERT INTO `tbl_stu` VALUES (25, '彭子异', 'M', 'zpe@qq.com', 2);
INSERT INTO `tbl_stu` VALUES (26, '严睿', 'M', 'ruiyan@qq.com', 4);
INSERT INTO `tbl_stu` VALUES (27, '方宇宁', 'M', 'fangyuning220@qq.com', 9);
INSERT INTO `tbl_stu` VALUES (28, '余晓明', 'M', 'xyu6@qq.com', 4);
INSERT INTO `tbl_stu` VALUES (29, '陆睿', 'M', 'luru@qq.com', 6);
INSERT INTO `tbl_stu` VALUES (30, '苏杰宏', 'M', 'su228@qq.com', 10);
INSERT INTO `tbl_stu` VALUES (31, '邹詩涵', 'F', 'szou611@qq.com', 3);
INSERT INTO `tbl_stu` VALUES (32, '郭璐', 'F', 'guolu9@qq.com', 2);
INSERT INTO `tbl_stu` VALUES (33, '熊詩涵', 'F', 'shx717@qq.com', 7);
INSERT INTO `tbl_stu` VALUES (34, '于睿', 'M', 'ruiyu@qq.com', 2);
INSERT INTO `tbl_stu` VALUES (35, '于子韬', 'M', 'zitaoyu@qq.com', 2);
INSERT INTO `tbl_stu` VALUES (36, '蔡秀英', 'F', 'xiucai@qq.com', 5);
INSERT INTO `tbl_stu` VALUES (37, '孟嘉伦', 'M', 'mejialun@qq.com', 10);
INSERT INTO `tbl_stu` VALUES (38, '黄秀英', 'F', 'huangxiuying@qq.com', 3);
INSERT INTO `tbl_stu` VALUES (39, '马嘉伦', 'M', 'majial@qq.com', 6);
INSERT INTO `tbl_stu` VALUES (40, '汪璐', 'F', 'wlu@qq.com', 2);
INSERT INTO `tbl_stu` VALUES (41, '雷晓明', 'M', 'xiaoming1957@qq.com', 7);
INSERT INTO `tbl_stu` VALUES (42, '田震南', 'M', 'zhetian10@qq.com', 10);
INSERT INTO `tbl_stu` VALUES (43, '贺致远', 'M', 'zhiyuhe@qq.com', 1);
INSERT INTO `tbl_stu` VALUES (44, '徐宇宁', 'M', 'yuningxu@qq.com', 10);
INSERT INTO `tbl_stu` VALUES (45, '田璐', 'F', 'lutian@qq.com', 9);
INSERT INTO `tbl_stu` VALUES (46, '马子韬', 'M', 'zitaoma@qq.com', 7);
INSERT INTO `tbl_stu` VALUES (47, '史安琪', 'F', 'shi74@qq.com', 8);
INSERT INTO `tbl_stu` VALUES (48, '徐安琪', 'F', 'xuanqi@qq.com', 10);
INSERT INTO `tbl_stu` VALUES (49, '袁云熙', 'M', 'yuyunx@qq.com', 6);
INSERT INTO `tbl_stu` VALUES (50, '石致远', 'M', 'zhiyuanshi@qq.com', 2);
INSERT INTO `tbl_stu` VALUES (51, '龙安琪', 'F', 'lanq2@qq.com', 7);
INSERT INTO `tbl_stu` VALUES (52, '王岚', 'F', 'lan7@qq.com', 4);
INSERT INTO `tbl_stu` VALUES (53, '石致远', 'M', 'shz@qq.com', 8);
INSERT INTO `tbl_stu` VALUES (54, '吴璐', 'F', 'lwu1971@qq.com', 9);
INSERT INTO `tbl_stu` VALUES (55, '王宇宁', 'M', 'wyunin15@qq.com', 1);
INSERT INTO `tbl_stu` VALUES (56, '龙杰宏', 'M', 'longjiehong7@qq.com', 5);
INSERT INTO `tbl_stu` VALUES (57, '姚嘉伦', 'M', 'yaoj@qq.com', 4);
INSERT INTO `tbl_stu` VALUES (58, '贾震南', 'M', 'zhjia5@qq.com', 1);
INSERT INTO `tbl_stu` VALUES (59, '田詩涵', 'F', 'shihan1129@qq.com', 10);
INSERT INTO `tbl_stu` VALUES (60, '汪震南', 'M', 'zhwang7@qq.com', 3);
INSERT INTO `tbl_stu` VALUES (61, '何嘉伦', 'M', 'jialunhe@qq.com', 9);
INSERT INTO `tbl_stu` VALUES (62, '董嘉伦', 'M', 'jialudong@qq.com', 5);
INSERT INTO `tbl_stu` VALUES (63, '夏云熙', 'M', 'xiyunxi2016@qq.com', 4);
INSERT INTO `tbl_stu` VALUES (64, '罗岚', 'F', 'luo84@qq.com', 4);
INSERT INTO `tbl_stu` VALUES (65, '蔡安琪', 'F', 'caia@qq.com', 6);
INSERT INTO `tbl_stu` VALUES (66, '杨云熙', 'M', 'yunxiyang@qq.com', 8);
INSERT INTO `tbl_stu` VALUES (67, '周致远', 'M', 'zhiyuanzho1015@qq.com', 6);
INSERT INTO `tbl_stu` VALUES (68, '程晓明', 'M', 'xiaomingch@qq.com', 1);
INSERT INTO `tbl_stu` VALUES (69, '武致远', 'M', 'zhiyuanw9@qq.com', 1);
INSERT INTO `tbl_stu` VALUES (70, '陆致远', 'M', 'zlu8@qq.com', 10);
INSERT INTO `tbl_stu` VALUES (71, '孟秀英', 'F', 'mengxiuying3@qq.com', 6);
INSERT INTO `tbl_stu` VALUES (72, '吕安琪', 'F', 'lu7@qq.com', 6);
INSERT INTO `tbl_stu` VALUES (73, '莫致远', 'M', 'zhiyuan501@qq.com', 2);
INSERT INTO `tbl_stu` VALUES (74, '潘秀英', 'F', 'xp93@qq.com', 8);
INSERT INTO `tbl_stu` VALUES (75, '萧睿', 'M', 'ruix40@qq.com', 7);
INSERT INTO `tbl_stu` VALUES (76, '罗安琪', 'F', 'lan315@qq.com', 8);
INSERT INTO `tbl_stu` VALUES (77, '潘云熙', 'M', 'yunxip1@qq.com', 7);
INSERT INTO `tbl_stu` VALUES (78, '夏震南', 'M', 'zhennanxia@qq.com', 6);
INSERT INTO `tbl_stu` VALUES (79, '严秀英', 'F', 'yan65@qq.com', 3);
INSERT INTO `tbl_stu` VALUES (80, '钱致远', 'M', 'qianzhiy02@qq.com', 4);
INSERT INTO `tbl_stu` VALUES (81, '范云熙', 'M', 'fanyunx3@qq.com', 5);
INSERT INTO `tbl_stu` VALUES (82, '李云熙', 'M', 'li5@qq.com', 1);
INSERT INTO `tbl_stu` VALUES (83, '毛嘉伦', 'M', 'mao9@qq.com', 1);
INSERT INTO `tbl_stu` VALUES (84, '宋宇宁', 'M', 'yusong01@qq.com', 5);
INSERT INTO `tbl_stu` VALUES (85, '宋致远', 'M', 'zhiyuans@qq.com', 6);
INSERT INTO `tbl_stu` VALUES (86, '许岚', 'F', 'xulan18@qq.com', 2);
INSERT INTO `tbl_stu` VALUES (87, '杨秀英', 'F', 'xiuyingyang@qq.com', 10);
INSERT INTO `tbl_stu` VALUES (88, '朱致远', 'M', 'zhiz11@qq.com', 2);
INSERT INTO `tbl_stu` VALUES (89, '于詩涵', 'F', 'yus1122@qq.com', 6);
INSERT INTO `tbl_stu` VALUES (90, '邓安琪', 'F', 'anqideng@qq.com', 2);
INSERT INTO `tbl_stu` VALUES (91, '冯安琪', 'F', 'fengan@qq.com', 9);
INSERT INTO `tbl_stu` VALUES (92, '吴安琪', 'F', 'wa83@qq.com', 2);
INSERT INTO `tbl_stu` VALUES (93, '傅璐', 'F', 'fulu1974@qq.com', 2);
INSERT INTO `tbl_stu` VALUES (94, '宋子异', 'M', 'ziyisong9@qq.com', 7);
INSERT INTO `tbl_stu` VALUES (95, '汤晓明', 'M', 'txiaoming@qq.com', 5);
INSERT INTO `tbl_stu` VALUES (96, '吴岚', 'F', 'wulan@qq.com', 1);
INSERT INTO `tbl_stu` VALUES (97, '钱睿', 'M', 'qian1957@qq.com', 7);
INSERT INTO `tbl_stu` VALUES (98, '韩詩涵', 'F', 'hshiha820@qq.com', 8);
INSERT INTO `tbl_stu` VALUES (99, '潘嘉伦', 'M', 'panjialun@qq.com', 10);
INSERT INTO `tbl_stu` VALUES (100, '田睿', 'M', 'tir@qq.com', 5);

SET FOREIGN_KEY_CHECKS = 1;
