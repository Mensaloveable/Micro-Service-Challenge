package com.loveable.openFeignService.feign;

import com.loveable.openFeignService.feign.dto.BillingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("billing-worker")
public interface BillingFeign {
    @GetMapping("/api/v1/billing/{id}")
    BillingResponse processFund(@PathVariable("id") Long id);
}
