DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo`
(
    `id`        int    NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name`      varchar(10)     DEFAULT NULL COMMENT '姓名',
    `age`       int             DEFAULT NULL COMMENT '年龄',
    `tenant_id` bigint NOT NULL DEFAULT '0' COMMENT '租户id',
    PRIMARY KEY (`id`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci  COMMENT='mybatis - demo表';