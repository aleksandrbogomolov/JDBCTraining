DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id          INT                          AUTO_INCREMENT PRIMARY KEY,
  name        VARCHAR(50) NOT NULL,
  email       VARCHAR(50) NOT NULL,
  create_date TIMESTAMP   NOT NULL         DEFAULT now()
)
  AUTO_INCREMENT = 100000;

CREATE TABLE user_role (
  user_id INT,
  role    VARCHAR(20) NOT NULL,
  CONSTRAINT user_role_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
