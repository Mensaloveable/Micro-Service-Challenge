package com.loveable.billingworker.controller;

import com.loveable.billingworker.service.ProcessFund;
import com.loveable.openFeignService.feign.dto.BillingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class WorkerController {
    private final ProcessFund processFund;

    @PutMapping("/process/{id}")
    public BillingResponse process(@PathVariable("id") Long idStr){
        Long id = Long.valueOf(idStr);
        return processFund.processFund(id);
    }
}
