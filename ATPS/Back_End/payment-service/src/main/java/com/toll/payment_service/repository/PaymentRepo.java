package com.toll.payment_service.repository;

import com.toll.payment_service.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepo extends JpaRepository<Transaction, Long> {

    List<Transaction> findTransactionsByUserId(Long userId);
}
