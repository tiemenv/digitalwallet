package com.tiemenv.digitalwallet.models

import java.math.BigDecimal
import java.sql.Timestamp
import java.util.*

data class WalletModel(
    val id: UUID,
    val userId: UUID,
    val balance: BigDecimal,
    val currency: Currency,
    val isLocked: Boolean,
    val createdAt: Timestamp?
) {
    companion object {
        fun init(
            userId: UUID,
            balance: BigDecimal,
            currency: Currency,
            isLocked: Boolean,
            createdAt: Timestamp?
        ): WalletModel {
            return WalletModel(
                id = UUID.randomUUID(),
                userId = userId,
                balance = balance,
                currency = currency,
                isLocked = isLocked,
                createdAt = createdAt
            )
        }
    }
}

enum class Currency {
    GBP
}