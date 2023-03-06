package com.loveable.billingworker.service.impl;

import com.loveable.billingService.entity.Billing;
import com.loveable.billingService.enums.Status;
import com.loveable.billingService.repository.BillingRepository;
import com.loveable.billingworker.BillingWorkerRepository;
import com.loveable.billingworker.service.ProcessFund;
import com.loveable.openFeignService.feign.dto.BillingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ProcessFundImpl implements ProcessFund {
    private final BillingWorkerRepository workerRepository;
    private final BillingRepository billingRepository;

    @Override
    public BillingResponse processFund(Long id) {
        Billing billing = billingRepository.findById(id).get();
        billing.setStatus(Status.SUCCESSFUL);
        billing.setModifiedAt(LocalDate.now());

        //Todo: Tread waiting

        Billing processedBilling = billingRepository.save(billing);

        return BillingResponse.builder()
                .customerId(processedBilling.getCustomerId())
                .modifiedAt(processedBilling.getModifiedAt())
                .status(processedBilling.getStatus().name())
                .amount(processedBilling.getAmount())
                .createdAt(processedBilling.getCreatedAt())
                .build();
    }
}
