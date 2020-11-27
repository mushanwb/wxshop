ALTER TABLE shopping_cart
    ADD COLUMN (shop_id BIGINT);

delete
FROM shopping_cart
where user_id = 1;

INSERT INTO shopping_cart(user_id, goods_id, shop_id, number, status)
VALUES (1, 1, 1, 100, 'ok');
INSERT INTO shopping_cart(user_id, goods_id, shop_id, number, status)
VALUES (1, 4, 2, 200, 'ok');
INSERT INTO shopping_cart(user_id, goods_id, shop_id, number, status)
VALUES (1, 5, 2, 300, 'ok');