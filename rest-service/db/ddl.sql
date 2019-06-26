create database test;
use test;
create table t_student(
  id bigint NOT NULL AUTO_INCREMENT,
  version bigint NOT NULL DEFAULT 0 COMMENT '版本',
  creation datetime NOT NULL DEFAULT now() COMMENT '创建时间',
  last_modified datetime NOT NULL DEFAULT now() ON UPDATE now() COMMENT '最后更新时间',
  name varchar(4) NOT NULL DEFAULT '' COMMENT '姓名',
  age int NOT NULL DEFAULT 0 COMMENT '年龄',
  class_id bigint NOT NULL COMMENT '班级',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生表';
drop TABLE t_class;
create table t_class(
  id bigint NOT NULL AUTO_INCREMENT,
  version bigint NOT NULL DEFAULT 0 COMMENT '版本',
  creation datetime NOT NULL DEFAULT now() COMMENT '创建时间',
  last_modified datetime NOT NULL DEFAULT now() ON UPDATE now() COMMENT '最后更新时间',
  name varchar(4) NOT NULL DEFAULT '' COMMENT '班级名称',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生表';

create table t_json_test(
  id bigint NOT NULL AUTO_INCREMENT,
  version bigint NOT NULL DEFAULT 0 COMMENT '版本',
  creation datetime NOT NULL DEFAULT now() COMMENT '创建时间',
  last_modified datetime NOT NULL DEFAULT now() ON UPDATE now() COMMENT '最后更新时间',
  json_content json NOT NULL DEFAULT '' COMMENT 'json数据',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='json字段测试';