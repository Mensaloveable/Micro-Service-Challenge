package com.loveable.billingworker.service.impl;

import com.loveable.billingworker.BillingWorkerRepository;
import com.loveable.billingworker.service.ProcessFund;
import com.loveable.openFeignService.feign.dto.BillingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessFundImpl implements ProcessFund {
    private final BillingWorkerRepository workerRepository;
    @Override
    public BillingResponse processFund(Long id) {

        return null;
    }
}
