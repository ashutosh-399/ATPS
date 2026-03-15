package com.toll.Scanner_Service.dto;

import lombok.Data;

@Data
public class TollResponse {
    private Long id;
    private String tollName;
    private String location;
    private String vehicleType;
    private Double tollFee;
}
