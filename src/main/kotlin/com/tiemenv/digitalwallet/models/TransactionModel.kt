package com.tiemenv.digitalwallet.models

import java.math.BigDecimal
import java.sql.Timestamp
import java.util.*

data class TransactionModel(
    val id: UUID?,
    val walletId: UUID,
    val type: TransactionType,
    val amount: BigDecimal,
    val currency: Currency,
    val createdAt: Timestamp?
) {
    companion object {
        fun init(
            id: UUID?,
            walletId: UUID,
            type: TransactionType,
            amount: BigDecimal,
            currency: Currency,
            createdAt: Timestamp?
        ): TransactionModel {
            return TransactionModel(
                id = id ?: UUID.randomUUID(),
                walletId = walletId,
                type = type,
                amount = amount,
                currency = currency,
                createdAt = createdAt
            )
        }
    }
}

enum class TransactionType {
    DEBIT,
    CREDIT
}