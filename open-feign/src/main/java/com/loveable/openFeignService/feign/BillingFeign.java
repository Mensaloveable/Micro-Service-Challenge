package com.loveable.openFeignService.feign;

import com.loveable.openFeignService.feign.dto.BillingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("billing-worker")
public interface BillingFeign {
    @PutMapping("/api/v1/process/{id}")
    BillingResponse processFund(@PathVariable("id") Long id);
}
