package com.tiemenv.digitalwallet.configuration

import org.flywaydb.core.Flyway
import org.springframework.boot.autoconfigure.flyway.FlywayProperties
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(
    DataSourceProperties::class,
    FlywayProperties::class
)
internal class DatabaseConfig {
    @Bean(initMethod = "migrate")
    fun flyway(flywayProperties: FlywayProperties, dataSourceProperties: DataSourceProperties): Flyway {
        return Flyway.configure()
            .dataSource(
                dataSourceProperties.url,
                dataSourceProperties.username,
                dataSourceProperties.password
            )
            .locations(*flywayProperties.locations.toTypedArray())
            .baselineOnMigrate(true)
            .driver(dataSourceProperties.driverClassName)
            .schemas(flywayProperties.schemas[0])
            .load()
    }
}
