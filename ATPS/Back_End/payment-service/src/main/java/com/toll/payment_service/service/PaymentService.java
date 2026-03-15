package com.toll.payment_service.service;

import com.toll.payment_service.dto.PaymentDTO;
import com.toll.payment_service.entity.Transaction;
import com.toll.payment_service.feign.UserClient;
import com.toll.payment_service.repository.PaymentRepo;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private PaymentRepo paymentRepo;



    public @Nullable Transaction pay(PaymentDTO paymentDTO) {

        String walletUpdateStatus = userClient.updateWallet(paymentDTO.getUserId(), -paymentDTO.getAmount());

        Transaction txn;

        if(walletUpdateStatus.equals("SUCCESS")){
            txn = Transaction.builder()
                    .userId(paymentDTO.getUserId())
                    .vehicleNumber(paymentDTO.getVehicleNumber())
                    .amount(paymentDTO.getAmount())
                    .status("SUCCESS")
                    .dateTime(LocalDateTime.now())
                    .build();
        }else {
            txn = Transaction.builder()
                    .userId(paymentDTO.getUserId())
                    .vehicleNumber(paymentDTO.getVehicleNumber())
                    .amount(paymentDTO.getAmount())
                    .status("FAILED")
                    .dateTime(LocalDateTime.now())
                    .build();
        }

        return paymentRepo.save(txn);
    }

    public List<Transaction> getUserTransactions(Long userId) {
        List<Transaction> transactions = paymentRepo.findTransactionsByUserId(userId);
        return transactions;
    }

}
