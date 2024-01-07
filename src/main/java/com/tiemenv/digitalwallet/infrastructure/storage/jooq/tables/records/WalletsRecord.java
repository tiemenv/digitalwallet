/*
 * This file is generated by jOOQ.
 */
package com.tiemenv.digitalwallet.infrastructure.storage.jooq.tables.records;


import com.tiemenv.digitalwallet.infrastructure.storage.jooq.enums.Currency;
import com.tiemenv.digitalwallet.infrastructure.storage.jooq.tables.Wallets;

import java.sql.Timestamp;
import java.util.UUID;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


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
public class WalletsRecord extends UpdatableRecordImpl<WalletsRecord> implements Record5<UUID, UUID, Double, Currency, Timestamp> {

    private static final long serialVersionUID = -1275738062;

    /**
     * Setter for <code>public.wallets.id</code>.
     */
    public void setId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.wallets.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.wallets.user_id</code>.
     */
    public void setUserId(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.wallets.user_id</code>.
     */
    public UUID getUserId() {
        return (UUID) get(1);
    }

    /**
     * Setter for <code>public.wallets.balance</code>.
     */
    public void setBalance(Double value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.wallets.balance</code>.
     */
    public Double getBalance() {
        return (Double) get(2);
    }

    /**
     * Setter for <code>public.wallets.currency</code>.
     */
    public void setCurrency(Currency value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.wallets.currency</code>.
     */
    public Currency getCurrency() {
        return (Currency) get(3);
    }

    /**
     * Setter for <code>public.wallets.created_at</code>.
     */
    public void setCreatedAt(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.wallets.created_at</code>.
     */
    public Timestamp getCreatedAt() {
        return (Timestamp) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<UUID, UUID, Double, Currency, Timestamp> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<UUID, UUID, Double, Currency, Timestamp> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return Wallets.WALLETS.ID;
    }

    @Override
    public Field<UUID> field2() {
        return Wallets.WALLETS.USER_ID;
    }

    @Override
    public Field<Double> field3() {
        return Wallets.WALLETS.BALANCE;
    }

    @Override
    public Field<Currency> field4() {
        return Wallets.WALLETS.CURRENCY;
    }

    @Override
    public Field<Timestamp> field5() {
        return Wallets.WALLETS.CREATED_AT;
    }

    @Override
    public UUID component1() {
        return getId();
    }

    @Override
    public UUID component2() {
        return getUserId();
    }

    @Override
    public Double component3() {
        return getBalance();
    }

    @Override
    public Currency component4() {
        return getCurrency();
    }

    @Override
    public Timestamp component5() {
        return getCreatedAt();
    }

    @Override
    public UUID value1() {
        return getId();
    }

    @Override
    public UUID value2() {
        return getUserId();
    }

    @Override
    public Double value3() {
        return getBalance();
    }

    @Override
    public Currency value4() {
        return getCurrency();
    }

    @Override
    public Timestamp value5() {
        return getCreatedAt();
    }

    @Override
    public WalletsRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public WalletsRecord value2(UUID value) {
        setUserId(value);
        return this;
    }

    @Override
    public WalletsRecord value3(Double value) {
        setBalance(value);
        return this;
    }

    @Override
    public WalletsRecord value4(Currency value) {
        setCurrency(value);
        return this;
    }

    @Override
    public WalletsRecord value5(Timestamp value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public WalletsRecord values(UUID value1, UUID value2, Double value3, Currency value4, Timestamp value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached WalletsRecord
     */
    public WalletsRecord() {
        super(Wallets.WALLETS);
    }

    /**
     * Create a detached, initialised WalletsRecord
     */
    public WalletsRecord(UUID id, UUID userId, Double balance, Currency currency, Timestamp createdAt) {
        super(Wallets.WALLETS);

        set(0, id);
        set(1, userId);
        set(2, balance);
        set(3, currency);
        set(4, createdAt);
    }
}
