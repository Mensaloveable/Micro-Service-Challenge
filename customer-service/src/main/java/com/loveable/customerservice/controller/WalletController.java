package com.loveable.customerservice.controller;

import com.loveable.customerservice.dto.BillingResponse;
import com.loveable.customerservice.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wallet")
public class WalletController {
    private final WalletService walletService;

    @PostMapping
    public BillingResponse fundWallet(@RequestBody BigDecimal amount){
        return walletService.fundWallet(amount);
    }
}
