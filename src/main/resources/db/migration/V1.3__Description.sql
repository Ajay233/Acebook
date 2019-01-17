DROP TABLE IF EXISTS users;

CREATE TABLE users (
  username varchar(35) PRIMARY KEY,
  password varchar(15) NOT NULL,
  name varchar(100) NOT NULL,
  email varchar(200) NOT NULL
);