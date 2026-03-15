package com.toll.Scanner_Service.feign;

import com.toll.Scanner_Service.dto.PaymentRequest;
import com.toll.Scanner_Service.dto.TransactionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentClient {

    @PostMapping("/payments/pay")
    TransactionResponse pay(@RequestBody PaymentRequest paymentRequest);
}
