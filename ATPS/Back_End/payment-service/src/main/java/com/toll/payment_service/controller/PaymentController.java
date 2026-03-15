package com.toll.payment_service.controller;

import com.toll.payment_service.dto.PaymentDTO;
import com.toll.payment_service.entity.Transaction;
import com.toll.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/pay")
    public ResponseEntity<Transaction> pay(@RequestBody PaymentDTO paymentDTO){
        return ResponseEntity.ok(paymentService.pay(paymentDTO));
    }

    @PostMapping("/getUserTransactions/{userId}")
    public ResponseEntity<List<Transaction>> getUserTransactions(@PathVariable Long userId){
        return ResponseEntity.ok(paymentService.getUserTransactions(userId));
    }
}
