package com.tiemenv.digitalwallet.repositories.jooq

import com.tiemenv.digitalwallet.infrastructure.storage.jooq.Tables.TRANSACTIONS
import com.tiemenv.digitalwallet.infrastructure.storage.jooq.Tables.WALLETS
import com.tiemenv.digitalwallet.models.TransactionModel
import com.tiemenv.digitalwallet.models.WalletModel
import org.jooq.DSLContext
import org.springframework.stereotype.Component
import com.tiemenv.digitalwallet.repositories.WalletRepositoryInterface
import com.tiemenv.digitalwallet.repositories.jooq.mappers.TransactionMapper
import com.tiemenv.digitalwallet.repositories.jooq.mappers.WalletMapper
import java.util.*


@Component
class WalletRepositoryJooq(private val dslContext: DSLContext): WalletRepositoryInterface {

    override fun getTransactions(walletId: UUID): List<TransactionModel> {
        val transactionRecords = dslContext
            .selectFrom(TRANSACTIONS)
            .where(TRANSACTIONS.WALLET_ID.eq(walletId))
            .fetchInto(TRANSACTIONS)
        return transactionRecords.map { TransactionMapper.toModel(it) }

    }

    override fun addTransaction(transactionModel: TransactionModel): TransactionModel {
        val transactionRecord = TransactionMapper.fromModel(transactionModel)
        dslContext.insertInto(TRANSACTIONS).set(transactionRecord).execute()
        return TransactionMapper.toModel(transactionRecord)
    }

    override fun getWallet(walletId: UUID): Optional<WalletModel> {
        val walletModel = dslContext
            .selectFrom(WALLETS)
            .where(WALLETS.ID.eq(walletId))
            .fetchOne()
            ?.let { WalletMapper.toModel(it)}
        return Optional.ofNullable(walletModel)
    }

    override fun updateWallet(walletModel: WalletModel): WalletModel {
        val walletRecord = WalletMapper.fromModel(walletModel)
        dslContext.update(WALLETS)
            .set(walletRecord)
            .where(WALLETS.ID.eq(walletModel.id))
            .execute()
        return walletModel
    }

    override fun addWallet(walletModel: WalletModel): WalletModel {
        val walletRecord = WalletMapper.fromModel(walletModel)
        dslContext.insertInto(WALLETS).set(walletRecord).execute()
        return WalletMapper.toModel(walletRecord)
    }

}