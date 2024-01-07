package com.tiemenv.digitalwallet.dto

import com.tiemenv.digitalwallet.models.Currency
import com.tiemenv.digitalwallet.models.TransactionType
import jakarta.validation.constraints.NotEmpty
import java.math.BigDecimal
import java.util.UUID

data class AddWalletDTO(
    @NotEmpty
    val userId: UUID,
    @NotEmpty
    val balance: BigDecimal,
    @NotEmpty
    val currency: Currency
)