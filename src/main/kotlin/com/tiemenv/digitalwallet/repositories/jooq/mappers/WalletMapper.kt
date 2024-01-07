package com.tiemenv.digitalwallet.repositories.jooq.mappers

import com.tiemenv.digitalwallet.infrastructure.storage.jooq.tables.records.WalletsRecord
import com.tiemenv.digitalwallet.models.WalletModel
import com.tiemenv.digitalwallet.infrastructure.storage.jooq.enums.Currency as JooqCurrency
import com.tiemenv.digitalwallet.models.Currency as DomainCurrency

object WalletMapper {
    fun fromModel(walletModel: WalletModel): WalletsRecord {
        val walletsRecord =
            WalletsRecord()
        walletsRecord.id = walletModel.id
        walletsRecord.userId = walletModel.userId
        walletsRecord.balance = walletModel.balance.toDouble()
        walletsRecord.currency = JooqCurrency.valueOf(walletModel.currency.toString())
        walletsRecord.isLocked = walletModel.isLocked
        return walletsRecord
    }

    fun toModel(walletsRecord: WalletsRecord): WalletModel {
        return WalletModel(
            id = walletsRecord.id,
            userId = walletsRecord.userId,
            balance = walletsRecord.balance.toBigDecimal(),
            currency = DomainCurrency.valueOf(walletsRecord.currency.toString()),
            isLocked = walletsRecord.isLocked,
            createdAt = walletsRecord.createdAt
        )
    }
}