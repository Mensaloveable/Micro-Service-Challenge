package com.loveable.billingService.service;

import com.loveable.openFeignService.feign.dto.BillingResponse;
import com.loveable.billingService.entity.Billing;

import java.math.BigDecimal;

public interface BillingService {
    BillingResponse fundWallet(Long id, BigDecimal amount);

    BillingResponse getBilling(Long id);
}
