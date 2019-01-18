ALTER TABLE posts ADD COLUMN created TIMESTAMP;
ALTER TABLE posts ADD COLUMN modified TIMESTAMP;

ALTER TABLE posts ALTER COLUMN created SET DEFAULT CURRENT_TIMESTAMP(0);

CREATE OR REPLACE FUNCTION update_modified_column()
RETURNS TRIGGER AS $func_body$
BEGIN
    NEW.modified = CURRENT_TIMESTAMP(0);
    RETURN NEW;
END;
$func_body$ language 'plpgsql';

CREATE TRIGGER update_posts_modified BEFORE UPDATE ON posts FOR EACH ROW EXECUTE PROCEDURE update_modified_column();
