package com.toll.Scanner_Service.dto;

import lombok.Data;

@Data
public class VehicleResponse {
    private Long id;
    private Long userId;
    private String vehicleNumber;
    private String vehicleType;
    private String model;
    private String tagId;
}
