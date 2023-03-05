package com.loveable.openFeign.feign.dto;

import com.loveable.openFeign.feign.enums.Status;
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