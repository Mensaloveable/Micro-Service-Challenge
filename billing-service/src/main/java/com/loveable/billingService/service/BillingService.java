package com.loveable.billingService.service;

import com.loveable.billingService.dto.BillingResponse;

import java.math.BigDecimal;

public interface BillingService {
    BillingResponse fundWallet(Long id, BigDecimal amount);
}
