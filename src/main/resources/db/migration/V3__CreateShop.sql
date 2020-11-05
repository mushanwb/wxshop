CREATE TABLE shop
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    name          VARCHAR(100),
    description   VARCHAR(1024),
    img_url       VARCHAR(1024),
    owner_user_id BIGINT,
    status        VARCHAR(16),
    created_at    TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMP NOT NULL DEFAULT NOW()
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

INSERT INTO shop (id, name, description, img_url, owner_user_id, status)
VALUES (1, 'shop1', 'desc1', 'url1', 1, 'ok');
INSERT INTO shop (id, name, description, img_url, owner_user_id, status)
VALUES (2, 'shop2', 'desc2', 'url2', 1, 'ok');