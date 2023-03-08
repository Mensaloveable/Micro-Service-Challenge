package com.loveable.billingworker.service.impl;

import com.loveable.billingworker.service.ProcessFund;
import com.loveable.openFeignService.feign.BillingFeign;
import com.loveable.openFeignService.feign.dto.BillingResponse;
import com.loveable.openFeignService.feign.entity.Billing;
import com.loveable.openFeignService.feign.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessFundImpl implements ProcessFund {
    private final BillingFeign billingFeign;

    @Override
    public BillingResponse processFund(Long id) throws InterruptedException {
        BillingResponse billing = billingFeign.processFund(id);
        billing.setStatus("Successful");
        return billing;
    }
}