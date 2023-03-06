package com.loveable.openFeignService.feign;

import com.loveable.openFeignService.feign.dto.BillingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@FeignClient("billing-service")
public interface Feign {
    @PostMapping("/api/v1/billing/fund/{id}/{amount}")
    BillingResponse fund(@PathVariable("id") Long id, @PathVariable("amount") BigDecimal amount);
}
