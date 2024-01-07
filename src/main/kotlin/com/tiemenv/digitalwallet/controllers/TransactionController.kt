package com.tiemenv.digitalwallet.controllers

import com.tiemenv.digitalwallet.dto.ProcessTransactionDTO
import com.tiemenv.digitalwallet.dto.TransactionResponse
import com.tiemenv.digitalwallet.dto.TransactionResponseMapper
import com.tiemenv.digitalwallet.models.Currency
import com.tiemenv.digitalwallet.models.TransactionType
import com.tiemenv.digitalwallet.services.TransactionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal
import java.util.*

@RestController
class TransactionController(private val transactionService: TransactionService) {

    @PostMapping("/transaction")
    fun addTransaction(@RequestBody request: AddTransactionRequest): ResponseEntity<TransactionResponse> {
        val transaction = transactionService.processTransaction(request.toDTO())
        return ResponseEntity.ok(TransactionResponseMapper.fromModel(transaction))
    }

    @GetMapping("/transactions")
    fun getTransactions(@RequestParam walletId: String): ResponseEntity<List<TransactionResponse>> {
        val transactions = transactionService.getTransactions(UUID.fromString(walletId))
        return ResponseEntity.ok(transactions.map { TransactionResponseMapper.fromModel(it) })
    }
}

data class AddTransactionRequest(
    val walletId: String,
    val type: String,
    val amount: Double,
    val currency: String
) {
    fun toDTO() = ProcessTransactionDTO(
        walletId = UUID.fromString(walletId),
        type = TransactionType.valueOf(type),
        amount = BigDecimal.valueOf(amount),
        currency = Currency.valueOf(currency)
    )
}