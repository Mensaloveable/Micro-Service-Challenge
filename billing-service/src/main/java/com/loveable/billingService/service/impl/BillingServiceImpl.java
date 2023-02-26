package com.loveable.billingService.service.impl;

import com.loveable.billingService.entity.Billing;
import com.loveable.billingService.enums.Status;
import com.loveable.billingService.repository.BillingRepository;
import com.loveable.billingService.service.BillingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BillingServiceImpl implements BillingService {

    private final BillingRepository billingRepository;
    @Override
    public String fundWallet(Long id, BigDecimal amount) {
        Billing billing = Billing.builder()
                .amount(amount)
                .createdAt(LocalDate.now())
                .status(Status.PENDING)
                .modifiedAt(null)
                .customerId(id)
                .build();

        billingRepository.save(billing);
        return "Transaction Successful";
    }
}
