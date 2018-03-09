CREATE TABLE `miaosha_user`(
  id LONG (16) NOT NULL PRIMARY KEY COMMENT '手机号码',
  nickname VARCHAR(255) NOT NULL ,
  password VARCHAR(32) DEFAULT NULL ,
  salt VARCHAR(16) DEFAULT NULL ,
  gravatar VARCHAR(255) DEFAULT NULL COMMENT '头像url',
  register_date DATETIME DEFAULT NULL ,
  last_login_date DATETIME DEFAULT NULL ,
  login_count int(16) DEFAULT '0'
)ENGINE = InnoDB DEFAULT CHARSET utf8mb4;