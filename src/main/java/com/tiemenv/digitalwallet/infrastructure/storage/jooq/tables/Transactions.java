/*
 * This file is generated by jOOQ.
 */
package com.tiemenv.digitalwallet.infrastructure.storage.jooq.tables;


import com.tiemenv.digitalwallet.infrastructure.storage.jooq.Indexes;
import com.tiemenv.digitalwallet.infrastructure.storage.jooq.Keys;
import com.tiemenv.digitalwallet.infrastructure.storage.jooq.Public;
import com.tiemenv.digitalwallet.infrastructure.storage.jooq.enums.Currency;
import com.tiemenv.digitalwallet.infrastructure.storage.jooq.enums.TransactionType;
import com.tiemenv.digitalwallet.infrastructure.storage.jooq.tables.records.TransactionsRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Transactions extends TableImpl<TransactionsRecord> {

    private static final long serialVersionUID = -2146791926;

    /**
     * The reference instance of <code>public.transactions</code>
     */
    public static final Transactions TRANSACTIONS = new Transactions();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TransactionsRecord> getRecordType() {
        return TransactionsRecord.class;
    }

    /**
     * The column <code>public.transactions.id</code>.
     */
    public final TableField<TransactionsRecord, UUID> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.UUID.nullable(false).defaultValue(org.jooq.impl.DSL.field("uuid_generate_v4()", org.jooq.impl.SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.transactions.wallet_id</code>.
     */
    public final TableField<TransactionsRecord, UUID> WALLET_ID = createField(DSL.name("wallet_id"), org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.transactions.type</code>.
     */
    public final TableField<TransactionsRecord, TransactionType> TYPE = createField(DSL.name("type"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false).asEnumDataType(com.tiemenv.digitalwallet.infrastructure.storage.jooq.enums.TransactionType.class), this, "");

    /**
     * The column <code>public.transactions.amount</code>.
     */
    public final TableField<TransactionsRecord, Double> AMOUNT = createField(DSL.name("amount"), org.jooq.impl.SQLDataType.DOUBLE.nullable(false), this, "");

    /**
     * The column <code>public.transactions.currency</code>.
     */
    public final TableField<TransactionsRecord, Currency> CURRENCY = createField(DSL.name("currency"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false).asEnumDataType(com.tiemenv.digitalwallet.infrastructure.storage.jooq.enums.Currency.class), this, "");

    /**
     * The column <code>public.transactions.created_at</code>.
     */
    public final TableField<TransactionsRecord, Timestamp> CREATED_AT = createField(DSL.name("created_at"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>public.transactions</code> table reference
     */
    public Transactions() {
        this(DSL.name("transactions"), null);
    }

    /**
     * Create an aliased <code>public.transactions</code> table reference
     */
    public Transactions(String alias) {
        this(DSL.name(alias), TRANSACTIONS);
    }

    /**
     * Create an aliased <code>public.transactions</code> table reference
     */
    public Transactions(Name alias) {
        this(alias, TRANSACTIONS);
    }

    private Transactions(Name alias, Table<TransactionsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Transactions(Name alias, Table<TransactionsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Transactions(Table<O> child, ForeignKey<O, TransactionsRecord> key) {
        super(child, key, TRANSACTIONS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.IDX___TRANSACTIONS___ID, Indexes.IDX___TRANSACTIONS___WALLET_ID, Indexes.PK___TRANSACTION_ID___ID);
    }

    @Override
    public UniqueKey<TransactionsRecord> getPrimaryKey() {
        return Keys.PK___TRANSACTION_ID___ID;
    }

    @Override
    public List<UniqueKey<TransactionsRecord>> getKeys() {
        return Arrays.<UniqueKey<TransactionsRecord>>asList(Keys.PK___TRANSACTION_ID___ID);
    }

    @Override
    public List<ForeignKey<TransactionsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<TransactionsRecord, ?>>asList(Keys.TRANSACTIONS__FK___TRANSACTIONS___WALLET_ID);
    }

    public Wallets wallets() {
        return new Wallets(this, Keys.TRANSACTIONS__FK___TRANSACTIONS___WALLET_ID);
    }

    @Override
    public Transactions as(String alias) {
        return new Transactions(DSL.name(alias), this);
    }

    @Override
    public Transactions as(Name alias) {
        return new Transactions(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Transactions rename(String name) {
        return new Transactions(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Transactions rename(Name name) {
        return new Transactions(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<UUID, UUID, TransactionType, Double, Currency, Timestamp> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}