/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : deep_practice

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 02/07/2023 23:00:48
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`
(
    `DEPTNO` int NOT NULL,
    `DNAME`  varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `LOC`    varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    PRIMARY KEY (`DEPTNO`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`
(
    `EMPNO`    int NOT NULL,
    `ENAME`    varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `JOB`      varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `MGR`      int NULL DEFAULT NULL,
    `HIREDATE` date NULL DEFAULT NULL,
    `SAL`      double(7, 2
) NULL DEFAULT NULL,
  `COMM` double(7, 2) NULL DEFAULT NULL,
  `DEPTNO` int NULL DEFAULT NULL,
  PRIMARY KEY (`EMPNO`) USING BTREE,
  INDEX `FK_DEPTNO`(`DEPTNO`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`
(
    `pid`   int                                                          NOT NULL AUTO_INCREMENT,
    `pname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `money` int NULL DEFAULT NULL,
    PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for project_record
-- ----------------------------
DROP TABLE IF EXISTS `project_record`;
CREATE TABLE `project_record`
(
    `empno` int NOT NULL,
    `pid`   int NOT NULL,
    PRIMARY KEY (`empno`, `pid`) USING BTREE,
    INDEX   `fk_project_pro`(`pid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Procedure structure for getEmpAndDept
-- ----------------------------
DROP PROCEDURE IF EXISTS `getEmpAndDept`;
delimiter;;
CREATE PROCEDURE `getEmpAndDept`(IN deptno int (11))
BEGIN
select *
from emp e
         left join dept d on (e.deptno = d.deptno)
where e.deptno = deptno;
END
;;
delimiter ;

SET
FOREIGN_KEY_CHECKS = 1;
