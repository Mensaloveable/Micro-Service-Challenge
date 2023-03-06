package com.loveable.billingworker.service;

import com.loveable.openFeignService.feign.dto.BillingResponse;

public interface ProcessFund {
    BillingResponse processFund(Long id);
}
