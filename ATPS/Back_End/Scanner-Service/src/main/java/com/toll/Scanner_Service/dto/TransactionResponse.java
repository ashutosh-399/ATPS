package com.toll.Scanner_Service.dto;

import lombok.Data;

@Data
public class TransactionResponse {
    private Long id;
    private Long userId;
    private Double amount;
    private String vehicleNumber;
    private String status;
    private String dateTime;
}
