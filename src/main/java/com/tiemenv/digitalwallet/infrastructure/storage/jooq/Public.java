/*
 * This file is generated by jOOQ.
 */
package com.tiemenv.digitalwallet.infrastructure.storage.jooq;


import com.tiemenv.digitalwallet.infrastructure.storage.jooq.tables.FlywaySchemaHistory;
import com.tiemenv.digitalwallet.infrastructure.storage.jooq.tables.Transactions;
import com.tiemenv.digitalwallet.infrastructure.storage.jooq.tables.Users;
import com.tiemenv.digitalwallet.infrastructure.storage.jooq.tables.Wallets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 72218968;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.flyway_schema_history</code>.
     */
    public final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = com.tiemenv.digitalwallet.infrastructure.storage.jooq.tables.FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;

    /**
     * The table <code>public.transactions</code>.
     */
    public final Transactions TRANSACTIONS = com.tiemenv.digitalwallet.infrastructure.storage.jooq.tables.Transactions.TRANSACTIONS;

    /**
     * The table <code>public.users</code>.
     */
    public final Users USERS = com.tiemenv.digitalwallet.infrastructure.storage.jooq.tables.Users.USERS;

    /**
     * The table <code>public.wallets</code>.
     */
    public final Wallets WALLETS = com.tiemenv.digitalwallet.infrastructure.storage.jooq.tables.Wallets.WALLETS;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY,
            Transactions.TRANSACTIONS,
            Users.USERS,
            Wallets.WALLETS);
    }
}