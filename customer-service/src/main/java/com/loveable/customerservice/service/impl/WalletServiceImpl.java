package com.loveable.customerservice.service.impl;

import com.loveable.customerservice.model.User;
import com.loveable.customerservice.repository.UserRepository;
import com.loveable.customerservice.service.WalletService;
import com.loveable.openFeignService.feign.Feign;
import com.loveable.openFeignService.feign.dto.BillingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final UserRepository userRepository;
    private final Feign feign;

    private User getLoggedInUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(authentication)
                .orElseThrow(() -> new RuntimeException("User not authorized"));
    }

    @Override
    public BillingResponse fundWallet(BigDecimal amount) {
        User user = getLoggedInUser();
        BillingResponse fund = feign.fund(user.getId(), amount);
        user.setAccountBalance(user.getAccountBalance().add(amount));
        return fund;
    }
}