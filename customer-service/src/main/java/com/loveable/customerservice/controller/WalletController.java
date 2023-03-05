package com.loveable.customerservice.controller;

import com.loveable.customerservice.service.WalletService;
import com.loveable.openFeignService.feign.dto.BillingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wallet")
public class WalletController {
    private final WalletService walletService;

    @PostMapping("/{amount}")
    public ResponseEntity<BillingResponse> fundWallet(@PathVariable("amount") String amountStr){
        BigDecimal amount = new BigDecimal(amountStr);
        BillingResponse billingResponse = walletService.fundWallet(amount);
        return new ResponseEntity<>(billingResponse, HttpStatus.OK);
    }
}