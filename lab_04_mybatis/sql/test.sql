CREATE TABLE `demo`
(
    `id`   int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name` varchar(10) DEFAULT NULL COMMENT '姓名',
    `age`  int         DEFAULT NULL COMMENT '年龄',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='mybatis - demo表'

CREATE TABLE `emp`
(
    `EMPNO`    int NOT NULL,
    `ENAME`    varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
    `JOB`      varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL,
    `MGR`      int                                                          DEFAULT NULL,
    `HIREDATE` date                                                         DEFAULT NULL,
    `SAL`      double(7, 2
) DEFAULT NULL,
  `COMM` double(7,2) DEFAULT NULL,
  `DEPTNO` int DEFAULT NULL,
  PRIMARY KEY (`EMPNO`) USING BTREE,
  KEY `FK_DEPTNO` (`DEPTNO`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;