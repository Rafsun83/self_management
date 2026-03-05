package com.example.self_management.service;

import com.example.self_management.mapper.WalletTransactionMapper;
import com.example.self_management.model.domain.WalletTransaction;
import com.example.self_management.model.dto.walletTransaction.CreateWalletTransactionRequest;
import com.example.self_management.persistence.entity.WalletEntity;
import com.example.self_management.persistence.entity.WalletTransactionEntity;
import com.example.self_management.persistence.repository.WalletRepository;
import com.example.self_management.persistence.repository.WalletTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class WalletTransactionService {
    private final WalletTransactionRepository walletTransactionRepository;
    private final WalletTransactionMapper walletTransactionMapper;
    private final WalletRepository walletRepository;

    public WalletTransactionService(WalletTransactionRepository walletTransactionRepository, WalletTransactionMapper walletTransactionMapper, WalletRepository walletRepository) {
        this.walletTransactionRepository = walletTransactionRepository;
        this.walletTransactionMapper = walletTransactionMapper;
        this.walletRepository = walletRepository;
    }

    public List<WalletTransaction> getAllWalletTransaction(Long walletId) {
        List<WalletTransactionEntity> allTransactionList = walletTransactionRepository.findByWalletEntityId(walletId);
        return allTransactionList.stream().map(walletTransactionMapper :: entityToWalletTransactionDomain).toList();
    }

    public WalletTransaction createWalletTransaction(Long walletId, CreateWalletTransactionRequest createWalletTransactionRequest){
        // 1️⃣ Find wallet
        WalletEntity wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));

       var transaction = walletTransactionMapper.createWalletTransactionToEntity(createWalletTransactionRequest);
       transaction.setWalletEntity(wallet);
       var saveTransaction  = walletTransactionRepository.save(transaction);
       return walletTransactionMapper.entityToWalletTransactionDomain(saveTransaction);

    }
}
