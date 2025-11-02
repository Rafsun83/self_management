package com.example.self_management.controller;

import com.example.self_management.model.domain.Wallet;
import com.example.self_management.service.WalletService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallets")
@Tag(name = "Get Wallet", description = "All wallet get here")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }


    @Operation(summary = "Get All wallet data")
    @GetMapping
    public List<Wallet> getAllWallet(){
        return walletService.getAllWallet();
    }

    @Operation(summary = "Create Wallet", description = "Create your Wallet")
    @PostMapping
    public ResponseEntity<Wallet> addWallet( @RequestBody Wallet wallet){
        Wallet addWallet = walletService.addWallet(wallet);
        return ResponseEntity.ok(addWallet);
    }
}
