package com.loveable.billingService.service.impl;

import com.loveable.billingService.dto.BillingResponse;
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
    public BillingResponse fundWallet(Long customerId, BigDecimal amount) {
        Billing billing = Billing.builder()
                .amount(amount)
                .createdAt(LocalDate.now())
                .status(Status.PENDING)
                .modifiedAt(null)
                .customerId(customerId)
                .build();

        Billing savedBilling = billingRepository.save(billing);

        return BillingResponse.builder()
                .amount(savedBilling.getAmount())
                .createdAt(savedBilling.getCreatedAt())
                .customerId(savedBilling.getCustomerId())
                .status(savedBilling.getStatus())
                .build();
    }
}
