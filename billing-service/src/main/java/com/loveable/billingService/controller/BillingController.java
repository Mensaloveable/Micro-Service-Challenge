package com.loveable.billingService.controller;

import com.loveable.billingService.service.BillingService;
import com.loveable.openFeignService.feign.dto.BillingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/billing")
public class BillingController {
    private final BillingService billingService;

    @PostMapping("/fund/{amount}")
    public BillingResponse fund(/*@RequestBody BigDecimal amount, */@PathVariable("amount") String amountStr){
        BigDecimal amount = new BigDecimal(amountStr);
        return billingService.fundWallet(amount);
    }
}
