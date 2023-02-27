package com.loveable.openFeign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;

@FeignClient("billing")
public interface Feign {
    @PostMapping("/api/v1/billing/fund")
    String fund(@RequestBody BigDecimal amount);
}
