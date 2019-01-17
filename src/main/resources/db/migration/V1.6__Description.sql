DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users(
user_id serial PRIMARY KEY,
username VARCHAR(50) UNIQUE NOT NULL,
password VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL,
name VARCHAR(50) NOT NULL,
enabled SMALLINT NOT NULL
);

DROP TABLE IF EXISTS authorities;
CREATE TABLE authorities(
auth_user_id INTEGER NOT NULL,
authority VARCHAR(50) NOT NULL,
username VARCHAR(50) NOT NULL,
PRIMARY KEY (auth_user_id),
FOREIGN KEY (auth_user_id) REFERENCES users (user_id),
FOREIGN KEY (username) REFERENCES users (username)
);

INSERT INTO users (username, "password", email, name, enabled)
VALUES ('test_acc', '{noop}testing123', 'test_acc@example.com', 'test', 1);
INSERT INTO authorities (auth_user_id, authority, username)
VALUES (1, 'USER', 'test_acc');

INSERT INTO users (username, "password", email, name, enabled)
VALUES ('test_acc_1', '{noop}testing123', 'test_acc_2@example.com', 'test', 1);
INSERT INTO authorities (auth_user_id, authority, username)
VALUES (2, 'USER', 'test_acc_1');