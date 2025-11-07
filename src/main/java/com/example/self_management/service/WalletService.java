package com.example.self_management.service;


import com.example.self_management.mapper.WalletMapper;
import com.example.self_management.model.domain.Wallet;
import com.example.self_management.model.dto.CreateWalletRequest;
import com.example.self_management.persistence.entity.WalletEntity;
import com.example.self_management.persistence.repository.WalletRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WalletService {

    private final WalletRepository walletRepository;
    private final WalletMapper  walletMapper;

    public WalletService(WalletRepository walletRepository, WalletMapper walletMapper) {
        this.walletRepository = walletRepository;
        this.walletMapper = walletMapper;
    }

    public List<Wallet> getAllWallet(Pageable pageable) {
        List<WalletEntity>  walletEntityList = walletRepository.findAll(pageable).getContent();
        return walletEntityList.stream().map(walletMapper :: entityToWalletDomain).toList();
    }

    public Long addWallet(CreateWalletRequest createWalletRequest) {
        var saveWallet = walletMapper.createWalletRequestToEntity(createWalletRequest);
        var saveWalletEntity = walletRepository.save(saveWallet);
        return saveWalletEntity.getId();
    }

}
