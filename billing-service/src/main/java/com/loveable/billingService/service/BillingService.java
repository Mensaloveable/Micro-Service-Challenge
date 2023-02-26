package com.loveable.billingService.service;

import java.math.BigDecimal;

public interface BillingService {
    String fundWallet(Long id, BigDecimal amount);
}
