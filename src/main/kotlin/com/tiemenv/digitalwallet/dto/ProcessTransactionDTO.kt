package com.tiemenv.digitalwallet.dto

import com.tiemenv.digitalwallet.models.Currency
import com.tiemenv.digitalwallet.models.TransactionType
import jakarta.validation.constraints.NotEmpty
import java.math.BigDecimal
import java.util.UUID

data class ProcessTransactionDTO(
    @NotEmpty
    val walletId: UUID,
    @NotEmpty
    val amount: BigDecimal,
    @NotEmpty
    val currency: Currency,
    @NotEmpty
    val type: TransactionType
)