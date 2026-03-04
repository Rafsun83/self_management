package com.example.self_management.model.dto.wallet;


import com.example.self_management.enums.wallets.WalletType;

public record CreateWalletRequest(WalletType type, Number totalAmount, String category, String walletName, String note) {
}
