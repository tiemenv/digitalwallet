DROP TABLE IF EXISTS transactions;

CREATE TYPE transaction_type AS ENUM ('DEBIT', 'CREDIT');

CREATE TABLE transactions (
    id UUID NOT NULL DEFAULT uuid_generate_v4(),
    wallet_id UUID NOT NULL,
    type transaction_type NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    currency currency NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT "PK___transaction_id___id" PRIMARY KEY (id),
    CONSTRAINT "FK___transactions___wallet_id" FOREIGN KEY (wallet_id) REFERENCES wallets(id) ON DELETE CASCADE
);

CREATE INDEX "IDX___transactions___id" ON transactions (id);
CREATE INDEX "IDX___transactions___wallet_id" ON transactions (wallet_id);