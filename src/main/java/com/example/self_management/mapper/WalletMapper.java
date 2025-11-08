package com.example.self_management.mapper;


import com.example.self_management.model.domain.Wallet;
import com.example.self_management.model.dto.wallet.CreateWalletRequest;
import com.example.self_management.persistence.entity.WalletEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class WalletMapper {

    public Wallet entityToWalletDomain(WalletEntity walletEntity) {
        Wallet wallet = new Wallet();
        BeanUtils.copyProperties(walletEntity,wallet);
        return wallet;
    }

    public WalletEntity createWalletRequestToEntity(CreateWalletRequest createWalletRequest) {
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setCreatedTime(new Date());
        BeanUtils.copyProperties(createWalletRequest,walletEntity);
        return walletEntity;
    }
}
