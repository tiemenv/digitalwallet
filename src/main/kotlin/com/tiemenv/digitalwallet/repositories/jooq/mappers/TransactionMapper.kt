package com.tiemenv.digitalwallet.repositories.jooq.mappers

import com.tiemenv.digitalwallet.infrastructure.storage.jooq.tables.records.TransactionsRecord
import com.tiemenv.digitalwallet.models.TransactionModel
import com.tiemenv.digitalwallet.infrastructure.storage.jooq.enums.Currency as JooqCurrency
import com.tiemenv.digitalwallet.models.Currency as DomainCurrency
import com.tiemenv.digitalwallet.infrastructure.storage.jooq.enums.TransactionType as JooqTransactionType
import com.tiemenv.digitalwallet.models.TransactionType as DomainTransactionType

object TransactionMapper {
    fun fromModel(transactionModel: TransactionModel): TransactionsRecord {
        val transactionsRecord =
            TransactionsRecord()
        transactionsRecord.id = transactionModel.id
        transactionsRecord.walletId = transactionModel.walletId
        transactionsRecord.type = JooqTransactionType.valueOf(transactionModel.type.toString())
        transactionsRecord.amount = transactionModel.amount.toDouble()
        transactionsRecord.currency = JooqCurrency.valueOf(transactionModel.currency.toString())
        return transactionsRecord
    }

    fun toModel(transactionsRecord: TransactionsRecord): TransactionModel {
        return TransactionModel(
            id = transactionsRecord.id,
            walletId = transactionsRecord.walletId,
            type = DomainTransactionType.valueOf(transactionsRecord.type.toString()),
            amount = transactionsRecord.amount.toBigDecimal(),
            currency = DomainCurrency.valueOf(transactionsRecord.currency.toString()),
            createdAt = transactionsRecord.createdAt
        )
    }
}