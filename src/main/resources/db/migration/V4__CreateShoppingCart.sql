CREATE TABLE shopping_cart
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id    BIGINT,
    goods_id   BIGINT,
    number     INT,
    status     VARCHAR(16),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

INSERT INTO shopping_cart(user_id, goods_id, number, status)
VALUES (1, 1, 100, 'ok');
INSERT INTO shopping_cart(user_id, goods_id, number, status)
VALUES (1, 4, 200, 'ok');
INSERT INTO shopping_cart(user_id, goods_id, number, status)
VALUES (1, 5, 300, 'ok');