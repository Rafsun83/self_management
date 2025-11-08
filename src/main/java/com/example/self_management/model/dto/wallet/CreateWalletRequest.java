package com.example.self_management.model.dto.wallet;


public record CreateWalletRequest(String type, Number amount, String category) {
}
