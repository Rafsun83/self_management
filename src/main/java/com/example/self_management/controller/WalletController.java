package com.example.self_management.controller;

import com.example.self_management.model.domain.Wallet;
import com.example.self_management.model.dto.CreateWalletRequest;
import com.example.self_management.service.WalletService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallets")
@Tag(name = "Get wallet", description = "All wallet get here")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }


    @Operation(summary = "Get All wallet data")
    @GetMapping
    public List<Wallet> getAllWallet(@ParameterObject Pageable pageable) {
        return walletService.getAllWallet(pageable);
    }

    @Operation(summary = "Create wallet", description = "Create your wallet")
    @PostMapping
    public Long addWallet(@RequestBody CreateWalletRequest  createWalletRequest) {
        return walletService.addWallet(createWalletRequest);

    }
}
