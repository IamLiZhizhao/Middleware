CREATE TABLE `t_user` (
  `id` int(20) NOT NULL COMMENT '主键ID',
  `username` varchar(30) DEFAULT NULL COMMENT '用户名',
    `passwd` varchar(128) DEFAULT NULL COMMENT '密码',
  `create_time` DATE DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '是否有效 1：有效  0：锁定',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;


INSERT INTO t_user VALUES ('2', 'test', '7a38c13ec5e9310aed731de58bbc4214', NOW(), '0');
INSERT INTO t_user VALUES ('1', 'mrbird', '42ee25d1e43e9f57119a00d0a39e5250', NOW(), '1');