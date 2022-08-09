CREATE TABLE `label` (
                         `id` bigint NOT NULL COMMENT '主键',
                         `name` varchar(20) DEFAULT NULL COMMENT '名称',
                         `sort` int DEFAULT NULL COMMENT '排序字段',
                         `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                         `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='标签';