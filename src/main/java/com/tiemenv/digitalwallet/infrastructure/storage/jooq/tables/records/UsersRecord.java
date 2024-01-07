/*
 * This file is generated by jOOQ.
 */
package com.tiemenv.digitalwallet.infrastructure.storage.jooq.tables.records;


import com.tiemenv.digitalwallet.infrastructure.storage.jooq.tables.Users;

import java.sql.Timestamp;
import java.util.UUID;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
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
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements Record3<UUID, String, Timestamp> {

    private static final long serialVersionUID = -2011478427;

    /**
     * Setter for <code>public.users.id</code>.
     */
    public void setId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.users.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.users.username</code>.
     */
    public void setUsername(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.users.username</code>.
     */
    public String getUsername() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.users.created_at</code>.
     */
    public void setCreatedAt(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.users.created_at</code>.
     */
    public Timestamp getCreatedAt() {
        return (Timestamp) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<UUID, String, Timestamp> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<UUID, String, Timestamp> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return Users.USERS.ID;
    }

    @Override
    public Field<String> field2() {
        return Users.USERS.USERNAME;
    }

    @Override
    public Field<Timestamp> field3() {
        return Users.USERS.CREATED_AT;
    }

    @Override
    public UUID component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getUsername();
    }

    @Override
    public Timestamp component3() {
        return getCreatedAt();
    }

    @Override
    public UUID value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getUsername();
    }

    @Override
    public Timestamp value3() {
        return getCreatedAt();
    }

    @Override
    public UsersRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public UsersRecord value2(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public UsersRecord value3(Timestamp value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public UsersRecord values(UUID value1, String value2, Timestamp value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersRecord
     */
    public UsersRecord() {
        super(Users.USERS);
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(UUID id, String username, Timestamp createdAt) {
        super(Users.USERS);

        set(0, id);
        set(1, username);
        set(2, createdAt);
    }
}