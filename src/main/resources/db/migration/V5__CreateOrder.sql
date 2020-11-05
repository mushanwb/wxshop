CREATE TABLE `order_table`
(
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id         BIGINT,
    total_price     BIGINT,      -- 价格，单位分
    address         VARCHAR(1024),
    express_company VARCHAR(16),
    express_id      VARCHAR(128),
    status          VARCHAR(16), -- PENDING 待付款 PAID 已付款 DELIVERED 物流中 RECEIVED 已收货
    created_at      TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at      TIMESTAMP NOT NULL DEFAULT NOW()
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `order_goods`
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    goods_id BIGINT,
    order_id BIGINT,
    number   BIGINT -- 单位 分
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

INSERT INTO `order_table` (id, user_id, total_price, address, express_company, express_id, status)
VALUES (1, 1, 1400, '火星', '顺丰', '运单1234567', 'delivered');

INSERT INTO `order_goods`(goods_id, order_id, number)
VALUES (1, 1, 5),
       (2, 1, 9);