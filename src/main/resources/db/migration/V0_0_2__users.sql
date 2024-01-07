DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id UUID NOT NULL DEFAULT uuid_generate_v4(),
    username VARCHAR(255) NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT "PK___user_id___id" PRIMARY KEY (id)
);

CREATE INDEX "IDX___users___id" ON users (id);

INSERT INTO users (username) VALUES ('tiemen');
INSERT INTO users (username) VALUES ('john');
INSERT INTO users (username) VALUES ('jane');