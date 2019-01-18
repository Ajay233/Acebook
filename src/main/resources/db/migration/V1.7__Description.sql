-- Adds two new columns to Posts table along with SQL functions and triggers for auto-updates

ALTER TABLE posts ADD COLUMN created TIMESTAMP;
ALTER TABLE posts ADD COLUMN modified TIMESTAMP;
ALTER TABLE posts ALTER COLUMN created SET DEFAULT CURRENT_TIMESTAMP(0);

-- Time modified column function/trigger
CREATE OR REPLACE FUNCTION update_modified_column()
RETURNS TRIGGER AS $func_body$
BEGIN
    NEW.modified = CURRENT_TIMESTAMP(0);
    RETURN NEW;
END;
$func_body$ language 'plpgsql';

CREATE TRIGGER update_posts_modified BEFORE UPDATE ON posts FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

-- Time created column function/trigger
CREATE OR REPLACE FUNCTION update_created_column()
RETURNS TRIGGER AS $func_body$
BEGIN
  NEW.created = CURRENT_TIMESTAMP(0);
  RETURN NEW;
  END;
$func_body$ language 'plpgsql';

CREATE TRIGGER update_posts_created BEFORE INSERT ON posts FOR EACH ROW EXECUTE PROCEDURE update_created_column();

