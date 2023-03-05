package com.loveable.billingService.dto;

import com.loveable.billingService.enums.Status;
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
    private Status status;
    private LocalDate createdAt;
}