package com.tiemenv.digitalwallet.services

import com.tiemenv.digitalwallet.dto.AddWalletDTO
import com.tiemenv.digitalwallet.models.WalletModel
import com.tiemenv.digitalwallet.repositories.jooq.WalletRepositoryJooq
import org.springframework.stereotype.Service
import java.util.*

@Service
class WalletService(private val walletRepository: WalletRepositoryJooq) {

        fun addWallet(addWalletDTO: AddWalletDTO): WalletModel {
            val wallet = WalletModel(
                id = UUID.randomUUID(),
                userId = addWalletDTO.userId,
                balance = addWalletDTO.balance,
                currency = addWalletDTO.currency,
                isLocked = false,
                createdAt = null
            )
            return walletRepository.addWallet(wallet)
        }
}