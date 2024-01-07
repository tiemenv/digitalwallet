package com.tiemenv.digitalwallet.dto

import com.tiemenv.digitalwallet.models.Currency
import com.tiemenv.digitalwallet.models.WalletModel
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.UUID

data class WalletResponse(
    val id: UUID,
    val userId: UUID,
    val balance: BigDecimal,
    val currency: Currency,
    val createdAt: Timestamp?
)

object WalletResponseMapper {
    fun fromModel(walletModel: WalletModel): WalletResponse {
        return WalletResponse(
            id = walletModel.id,
            userId = walletModel.userId,
            balance = walletModel.balance,
            currency = walletModel.currency,
            createdAt = walletModel.createdAt
        )
    }
}