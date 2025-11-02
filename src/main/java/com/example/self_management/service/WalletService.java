package com.example.self_management.service;


import com.example.self_management.model.domain.Wallet;
import com.example.self_management.persistence.repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public List<Wallet> getAllWallet(){
        return walletRepository.findAll();
    }

    public Wallet addWallet(Wallet wallet){
        wallet.setCreatedTime(new Date());
        return walletRepository.save(wallet);
    }
}
