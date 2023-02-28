package com.loveable.customerservice.service.impl;

import com.loveable.customerservice.dto.BillingResponse;
import com.loveable.customerservice.model.User;
import com.loveable.customerservice.repository.UserRepository;
import com.loveable.customerservice.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    private User getLoggedInUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(authentication)
                .orElseThrow(() -> new RuntimeException("User not authorized"));
    }

    @Override
    public BillingResponse fundWallet(BigDecimal amount) {
        User user = getLoggedInUser();
        return restTemplate.getForObject(
                "http:localhost:8081/api/v1/billing/{id}",
                BillingResponse.class,
                user.getId()
        );
    }
}
