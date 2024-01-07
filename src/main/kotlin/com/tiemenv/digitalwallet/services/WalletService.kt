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
                createdAt = null
            )
            return walletRepository.addWallet(wallet)
        }

        fun getWallet(walletId: UUID): WalletModel {
            val wallet = walletRepository.getWallet(walletId)
            wallet.isPresent || throw Exception("Wallet not found")
            return wallet.get()
        }

        fun updateWallet(walletModel: WalletModel): WalletModel {
            return walletRepository.updateWallet(walletModel)
        }
}