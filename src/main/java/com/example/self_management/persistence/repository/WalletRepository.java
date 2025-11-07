package com.example.self_management.persistence.repository;

import com.example.self_management.model.domain.Wallet;
import com.example.self_management.persistence.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<WalletEntity,Long> {
}
