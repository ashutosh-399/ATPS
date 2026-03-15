package com.toll.toll_service.dto;

import lombok.Data;

@Data
public class TollDTO {
    private String tollName;
    private String location;
    private String vehicleType;
    private Double tollFee;
}
