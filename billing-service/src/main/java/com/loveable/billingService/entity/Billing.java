package com.loveable.billingService.entity;

import com.loveable.billingService.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate createdAt;
    private LocalDate modifiedAt;
}
