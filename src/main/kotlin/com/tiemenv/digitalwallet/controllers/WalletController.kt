package com.tiemenv.digitalwallet.controllers

import com.tiemenv.digitalwallet.dto.AddWalletDTO
import com.tiemenv.digitalwallet.dto.WalletResponse
import com.tiemenv.digitalwallet.dto.WalletResponseMapper
import com.tiemenv.digitalwallet.models.Currency
import com.tiemenv.digitalwallet.services.WalletService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal
import java.util.*

@RestController
class WalletController(private val walletService: WalletService) {

    @PostMapping("/wallet")
    fun addWallet(@RequestBody request: AddWalletRequest): ResponseEntity<WalletResponse> {
        val wallet = walletService.addWallet(request.toDTO())
        return ResponseEntity.ok(WalletResponseMapper.fromModel(wallet))
    }
}

data class AddWalletRequest(
    val userId: String,
    val currency: String
) {
    fun toDTO() = AddWalletDTO(
        userId = UUID.fromString(userId),
        balance = BigDecimal.ZERO,
        currency = Currency.valueOf(currency)
    )
}