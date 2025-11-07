package com.example.self_management.model.dto;


public record CreateWalletRequest(String type, Number amount, String category) {
}
