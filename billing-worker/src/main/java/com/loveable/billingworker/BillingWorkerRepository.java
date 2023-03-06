package com.loveable.billingworker;

import com.loveable.billingService.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingWorkerRepository extends JpaRepository<Billing, Long> {
}
