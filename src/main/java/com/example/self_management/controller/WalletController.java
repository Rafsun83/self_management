package com.example.self_management.controller;

import com.example.self_management.model.domain.Wallet;
import com.example.self_management.model.dto.wallet.CreateWalletRequest;
import com.example.self_management.model.dto.wallet.UpdateWalletRequest;
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
    public List<Wallet> getAllWallet() {
        return walletService.getAllWallet();
    }

    @Operation(summary = "Get wallet by Id", description = "Get wallet by Id through the API")
    @GetMapping("{id}")
    public Wallet getWalletById(@PathVariable Long id) {
        return walletService.getWalletById(id);
    }

    @Operation(summary = "Create wallet", description = "Create your wallet")
    @PostMapping
    public Long addWallet(@RequestBody CreateWalletRequest  createWalletRequest) {
        return walletService.addWallet(createWalletRequest);
    }

    @Operation(summary = "Update wallet", description = "Update wallet using this API")
    @PutMapping("{id}")
    public void updateWallet(@PathVariable Long id, @RequestBody UpdateWalletRequest updateWalletRequest) {
        walletService.updateWallet(id, updateWalletRequest);
    }

    @Operation(summary="Delete Task", description = "Delete task through the API")
    @DeleteMapping("{id}")
    public void deleteTask (@PathVariable Long id) {
        walletService.deleteWallet(id);
    }
}
