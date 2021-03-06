CREATE TABLE goods
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    shop_id     BIGINT,
    name        VARCHAR(100),
    description VARCHAR(1024),
    details     TEXT,
    img_url     VARCHAR(1024),
    price       BIGINT,      -- 单位 分
    stock       INT       NOT NULL DEFAULT 0,
    status      VARCHAR(16), -- 'ok' 正常 'deleted' 已经删除
    created_at  TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMP NOT NULL DEFAULT NOW()
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

INSERT INTO goods(id, shop_id, name, description, details, img_url, price, stock, status)
VALUES (1, 1, 'goods1', 'desc1', 'details1', 'url1', 100, 5, 'ok');
INSERT INTO goods(id, shop_id, name, description, details, img_url, price, stock, status)
VALUES (2, 1, 'goods2', 'desc2', 'details2', 'url2', 100, 5, 'ok');
INSERT INTO goods(id, shop_id, name, description, details, img_url, price, stock, status)
VALUES (3, 2, 'goods3', 'desc2', 'details3', 'url3', 100, 5, 'ok');
INSERT INTO goods(id, shop_id, name, description, details, img_url, price, stock, status)
VALUES (4, 2, 'goods4', 'desc2', 'details4', 'url4', 100, 5, 'ok');
INSERT INTO goods(id, shop_id, name, description, details, img_url, price, stock, status)
VALUES (5, 2, 'goods5', 'desc2', 'details5', 'url5', 200, 5, 'ok');