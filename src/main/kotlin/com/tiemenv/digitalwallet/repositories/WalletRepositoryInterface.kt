package com.tiemenv.digitalwallet.repositories

import com.tiemenv.digitalwallet.models.TransactionModel
import com.tiemenv.digitalwallet.models.WalletModel
import java.util.*

interface WalletRepositoryInterface {

    fun getTransactions(walletId: UUID): List<TransactionModel>

    fun addTransaction(transactionModel: TransactionModel): TransactionModel

    fun getWallet(walletId: UUID): Optional<WalletModel>

    fun updateWallet(walletModel: WalletModel): WalletModel

    fun addWallet(walletModel: WalletModel): WalletModel
}