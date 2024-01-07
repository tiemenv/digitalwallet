package com.tiemenv.digitalwallet.configuration

import org.jooq.ConnectionProvider
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DataSourceConnectionProvider
import org.jooq.impl.DefaultConfiguration
import org.jooq.impl.DefaultDSLContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
class JOOQConfiguration {

    @Bean
    fun dataSourceConnectionProvider(dataSource: DataSource): ConnectionProvider {
        return DataSourceConnectionProvider(TransactionAwareDataSourceProxy(dataSource))
    }

    @Bean
    fun defaultConfiguration(dataSourceConnectionProvider: ConnectionProvider): DefaultConfiguration {
        val configuration = DefaultConfiguration()
        configuration.set(dataSourceConnectionProvider)
        configuration.set(SQLDialect.POSTGRES)
        return configuration
    }

    @Bean
    fun dslContext(defaultConfiguration: DefaultConfiguration): DSLContext {
        return DefaultDSLContext(defaultConfiguration)
    }
}