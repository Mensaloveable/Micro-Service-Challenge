package com.loveable.billingworker.service.impl;

import com.loveable.billingworker.service.ProcessFund;
import com.loveable.openFeignService.feign.BillingFeign;
import com.loveable.openFeignService.feign.entity.Billing;
import com.loveable.openFeignService.feign.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessFundImpl implements ProcessFund {
    private final BillingFeign billingFeign;

    @Override
    public Billing processFund(Long id) throws InterruptedException {
        Billing billing = billingFeign.processFund(id);
        billing.setStatus(Status.SUCCESSFUL);
        return billing;
    }
}