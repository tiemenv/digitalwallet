package com.tiemenv.digitalwallet.configuration

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class OpenAPIConfig {

    @Bean
    fun myOpenAPI(): OpenAPI {
        val info: Info = Info()
            .title("Digital Wallet API")
            .version("1.0")
            .description("Digital Wallet API")
        val openAPI = OpenAPI()
        openAPI.servers = listOf(
            Server().url("http://localhost:9000"),
        )
        openAPI.info(info)
        return openAPI

    }
}