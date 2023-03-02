package com.loveable.customerservice.service.impl;

import com.loveable.customerservice.dto.BillingRequest;
import com.loveable.customerservice.dto.BillingResponse;
import com.loveable.customerservice.model.User;
import com.loveable.customerservice.repository.UserRepository;
import com.loveable.customerservice.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

        String url = "http://localhost:8081/api/v1/billing/{customerId}";

//        BillingResponse response = new BillingResponse();
        BillingRequest request = new BillingRequest(user.getId(), amount);

        //Create an instance of HttpHeaders to set the Content-Type header to application/json or the appropriate
        // content type for your request body:
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Create an instance of HttpEntity with the request body and headers:
//        HttpEntity<BillingResponse> requestEntity = new HttpEntity<>(response, headers);
        HttpEntity<BillingRequest> requestEntity = new HttpEntity<>(request, headers);

        //Use the RestTemplate instance to send the request using the postForEntity method.
        // This method takes two arguments: the URL and the HttpEntity object:
//        BillingResponse responseEntity = restTemplate.postForObject(
//                url,
//                requestEntity,
//                BillingResponse.class,
//                user.getId()
//        );
//
//
//        return responseEntity;
        //Use the RestTemplate instance to send the request using the postForEntity method.
        // This method takes two arguments: the URL and the HttpEntity object:
        ResponseEntity<BillingResponse> responseEntity = restTemplate.postForEntity(
                url,
                requestEntity,
                BillingResponse.class,
                user.getId()
        );

        return responseEntity.getBody();
    }
}
