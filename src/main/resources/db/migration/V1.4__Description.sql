DROP TABLE IF EXISTS comments;

CREATE TABLE comments (
  commentid bigserial PRIMARY KEY,
  postid bigint REFERENCES posts(id),
  comment varchar(200) NOT NULL
)
