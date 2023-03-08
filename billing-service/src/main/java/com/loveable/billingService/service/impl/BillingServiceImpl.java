package com.loveable.billingService.service.impl;

import com.loveable.billingService.repository.BillingRepository;
import com.loveable.billingService.service.BillingService;
import com.loveable.openFeignService.feign.BillingFeign;
import com.loveable.openFeignService.feign.dto.BillingResponse;
import com.loveable.billingService.entity.Billing;
import com.loveable.billingService.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BillingServiceImpl implements BillingService {
    private final BillingRepository billingRepository;
    private final BillingFeign billingFeign;

    @Override
    public BillingResponse fundWallet(Long id, BigDecimal amount) {
        Billing billing = Billing.builder()
                .customerId(id)
                .amount(amount)
                .createdAt(LocalDate.now())
                .status(Status.PENDING)
                .modifiedAt(null)
                .build();

        Billing response = billingRepository.save(billing);

        return BillingResponse.builder()
                .customerId(response.getCustomerId())
                .amount(response.getAmount())
                .createdAt(response.getCreatedAt())
                .status(response.getStatus().name())
                .customerId(response.getCustomerId())
                .modifiedAt(response.getModifiedAt())
                .build();
    }

    @Override
    public BillingResponse getBilling(Long id) {
        Billing response = billingRepository.findById(id).get();

        return BillingResponse.builder()
                .customerId(response.getCustomerId())
                .amount(response.getAmount())
                .createdAt(response.getCreatedAt())
                .status(response.getStatus().name())
                .customerId(response.getCustomerId())
                .modifiedAt(response.getModifiedAt())
                .build();
    }
}
