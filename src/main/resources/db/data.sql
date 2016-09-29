DELETE FROM users;
DELETE FROM user_role;
ALTER TABLE users AUTO_INCREMENT = 100000;


INSERT INTO users (name, email) VALUES ('User', 'user@yandex.ru');
INSERT INTO users (name, email) VALUES ('Admin', 'admin@yandex.ru');

INSERT INTO user_role (user_id, role) VALUES (100000, 'ROLE_USER');
INSERT INTO user_role (user_id, role) VALUES (100001, 'ROLE_USER');
INSERT INTO user_role (user_id, role) VALUES (100001, 'ROLE_ADMIN');
