package com.loveable.customerservice.service;

import com.loveable.customerservice.dto.BillingResponse;

import java.math.BigDecimal;

public interface WalletService {
    public BillingResponse fundWallet(BigDecimal amount);
}
