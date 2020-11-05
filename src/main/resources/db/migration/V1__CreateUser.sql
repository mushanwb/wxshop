create table user (
    id         bigint primary key auto_increment,
    name       varchar(100),
    tel        varchar(20) unique,
    avatar_url varchar(1024),
    address    VARCHAR(1024),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

INSERT INTO user(id, name, tel, avatar_url, address)
VALUES (1, 'user1', '13800000000', 'http://url', '火星')