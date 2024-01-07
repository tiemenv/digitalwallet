DROP TABLE IF EXISTS wallets;

CREATE TYPE currency AS ENUM ('GBP');

CREATE TABLE wallets (
    id UUID NOT NULL DEFAULT uuid_generate_v4(),
    user_id UUID NOT NULL,
    balance DOUBLE PRECISION NOT NULL DEFAULT 0,
    currency currency NOT NULL DEFAULT 'GBP',
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT "PK___wallet_id___id" PRIMARY KEY (id),
    CONSTRAINT "FK___wallets___user_id" FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE INDEX "IDX___wallets___id" ON wallets (id);
CREATE INDEX "IDX___wallets___user_id" ON wallets (user_id);