package com.loveable.openFeignService.feign.dto;

import com.loveable.openFeignService.feign.enums.Status;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BillingResponse {
    private Long customerId;
    private BigDecimal amount;
    private String status;
    private LocalDate createdAt;
}