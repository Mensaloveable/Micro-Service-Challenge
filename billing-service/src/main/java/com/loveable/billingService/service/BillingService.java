package com.loveable.billingService.service;

import com.loveable.openFeignService.feign.dto.BillingResponse;

import java.math.BigDecimal;

public interface BillingService {
    BillingResponse fundWallet(Long id, BigDecimal amount);
}
