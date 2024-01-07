package com.tiemenv.digitalwallet.dto

import com.tiemenv.digitalwallet.models.Currency
import com.tiemenv.digitalwallet.models.TransactionModel
import com.tiemenv.digitalwallet.models.TransactionType
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.UUID

data class TransactionResponse(
    val id: UUID?,
    val walletId: UUID,
    val type: TransactionType,
    val amount: BigDecimal,
    val currency: Currency,
    val createdAt: Timestamp?
)

object TransactionResponseMapper {
    fun fromModel(transactionModel: TransactionModel): TransactionResponse {
        return TransactionResponse(
            id = transactionModel.id,
            walletId = transactionModel.walletId,
            type = transactionModel.type,
            amount = transactionModel.amount,
            currency = transactionModel.currency,
            createdAt = transactionModel.createdAt
        )
    }
}