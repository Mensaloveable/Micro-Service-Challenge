package com.loveable.billingService.service.impl;

import com.loveable.billingService.entity.Billing;
import com.loveable.billingService.enums.Status;
import com.loveable.billingService.repository.BillingRepository;
import com.loveable.billingService.service.BillingService;
import com.loveable.openFeignService.feign.dto.BillingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BillingServiceImpl implements BillingService {

    private final BillingRepository billingRepository;
    @Override
    public BillingResponse fundWallet(Long id, BigDecimal amount) {
        Billing billing = Billing.builder()
                .customerId(id)
                .amount(amount)
                .createdAt(LocalDate.now())
                .status(Status.PENDING)
                .modifiedAt(null)
                .build();

        Billing savedBilling = billingRepository.save(billing);
        return BillingResponse.builder()
                .customerId(savedBilling.getCustomerId())
                .amount(savedBilling.getAmount())
                .createdAt(savedBilling.getCreatedAt())
                .status(savedBilling.getStatus().name())
                .customerId(savedBilling.getCustomerId())
                .modifiedAt(savedBilling.getModifiedAt())
                .build();
    }
}
