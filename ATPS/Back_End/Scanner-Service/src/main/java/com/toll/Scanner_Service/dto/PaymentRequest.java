package com.toll.Scanner_Service.dto;

import lombok.Data;

@Data
public class PaymentRequest {
    private Long userId;
    private Double amount;
    private String vehicleNumber;
}
