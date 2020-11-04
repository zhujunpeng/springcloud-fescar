CREATE TABLE `order`
(
  `id`         bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id`    bigint(11)     DEFAULT NULL COMMENT '用户id',
  `product_id` bigint(11)     DEFAULT NULL COMMENT '产品id',
  `count`      int(11)        DEFAULT NULL COMMENT '数量',
  `money`      decimal(11, 0) DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8;

ALTER TABLE `order`
  ADD COLUMN `status` int(1) DEFAULT NULL COMMENT '订单状态：0：创建中；1：已完结' AFTER `money`;


CREATE TABLE `undo_log`
(
  `id`            bigint(20)   NOT NULL AUTO_INCREMENT,
  `branch_id`     bigint(20)   NOT NULL,
  `xid`           varchar(100) NOT NULL,
  `context`       varchar(128) NOT NULL,
  `rollback_info` longblob     NOT NULL,
  `log_status`    int(11)      NOT NULL,
  `log_created`   datetime     NOT NULL,
  `log_modified`  datetime     NOT NULL,
  `ext`           varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  DEFAULT CHARSET = utf8;