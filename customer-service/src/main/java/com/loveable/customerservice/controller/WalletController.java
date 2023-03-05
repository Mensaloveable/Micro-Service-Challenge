package com.loveable.customerservice.controller;

import com.loveable.customerservice.service.WalletService;
import com.loveable.openFeign.feign.dto.BillingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<BillingResponse> fundWallet(@RequestBody BigDecimal amount){
        BillingResponse billingResponse = walletService.fundWallet(amount);
        return new ResponseEntity<>(billingResponse, HttpStatus.OK);
    }
}