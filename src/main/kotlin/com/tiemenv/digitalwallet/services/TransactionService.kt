package com.tiemenv.digitalwallet.services

import com.tiemenv.digitalwallet.dto.ProcessTransactionDTO
import com.tiemenv.digitalwallet.dto.TransactionResponse
import com.tiemenv.digitalwallet.dto.TransactionResponseMapper
import com.tiemenv.digitalwallet.models.TransactionModel
import com.tiemenv.digitalwallet.models.TransactionType
import com.tiemenv.digitalwallet.repositories.jooq.WalletRepositoryJooq
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class TransactionService(private val walletRepository: WalletRepositoryJooq) {
    fun getTransactions(walletId: UUID): List<TransactionModel> {
        val transactions = walletRepository.getTransactions(walletId)
        return transactions
    }

    fun processTransaction(processTransactionDTO: ProcessTransactionDTO): TransactionModel {
        val transactionModel = TransactionModel(
            id = UUID.randomUUID(),
            walletId = processTransactionDTO.walletId,
            type = processTransactionDTO.type,
            amount = processTransactionDTO.amount,
            currency = processTransactionDTO.currency,
            createdAt = null
        )
        // check that transaction is within allowed limits, for a DEBIT the amount has to be within 10 and 10000 GBP,
        // for a CREDIT, the amount has to be less than 5000 GBP
        if (transactionModel.type == TransactionType.DEBIT) {
            if (transactionModel.amount < BigDecimal.valueOf(10) || transactionModel.amount > BigDecimal.valueOf(10000)) {
                throw Exception("Invalid amount for DEBIT transaction")
            }
        } else if (transactionModel.type == TransactionType.CREDIT) {
            if (transactionModel.amount > BigDecimal.valueOf(5000)) {
                throw Exception("Invalid amount for CREDIT transaction")
            }
        }

        val wallet = walletRepository.getWallet(transactionModel.walletId)
        wallet.isPresent || throw Exception("Wallet not found")
        val walletModel = wallet.get()


        // if the transaction type is DEBIT, it can't be processed if the wallet balance is less than the transaction amount
        if (transactionModel.type == TransactionType.DEBIT) {
            if (walletModel.balance < transactionModel.amount) {
                throw Exception("Insufficient funds for DEBIT transaction")
            }
        }

        val updatedWallet = when (transactionModel.type) {
            TransactionType.CREDIT -> walletModel.copy(balance = walletModel.balance + transactionModel.amount)
            TransactionType.DEBIT -> walletModel.copy(balance = walletModel.balance - transactionModel.amount)
        }

        walletRepository.updateWallet(updatedWallet)

        return walletRepository.addTransaction(transactionModel)
    }
}