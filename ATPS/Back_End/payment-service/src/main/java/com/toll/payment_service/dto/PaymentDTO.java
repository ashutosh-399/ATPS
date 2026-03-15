package com.toll.payment_service.dto;

import lombok.Data;

@Data
public class PaymentDTO {

    private Long userId;
    private Double amount;
    private String vehicleNumber;
}
