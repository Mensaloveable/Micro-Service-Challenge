package com.loveable.billingworker.service;

import com.loveable.openFeignService.feign.entity.Billing;

public interface ProcessFund {
    Billing processFund(Long id) throws InterruptedException;
}
