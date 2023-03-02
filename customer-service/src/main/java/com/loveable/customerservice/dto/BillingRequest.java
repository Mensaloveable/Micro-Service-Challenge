package com.loveable.customerservice.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BillingRequest {
    private Long id;
    private BigDecimal amount;
}
