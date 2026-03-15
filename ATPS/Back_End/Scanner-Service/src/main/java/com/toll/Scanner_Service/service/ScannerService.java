package com.toll.Scanner_Service.service;

import com.toll.Scanner_Service.dto.*;
import com.toll.Scanner_Service.feign.PaymentClient;
import com.toll.Scanner_Service.feign.TollClient;
import com.toll.Scanner_Service.feign.VehicleClient;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScannerService {

    @Autowired
    private VehicleClient vehicleClient;
    @Autowired
    private TollClient tollClient;
    @Autowired
    private PaymentClient paymentClient;

    public @Nullable TransactionResponse processScan(String vehicleNumber) {

        VehicleResponse vehicle = vehicleClient.getVehicleByNumber(vehicleNumber);
        TollResponse toll = tollClient.getTollByVehicleType(vehicle.getVehicleType());

        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setUserId(vehicle.getUserId());
        paymentRequest.setAmount(toll.getTollFee());
        paymentRequest.setVehicleNumber(vehicle.getVehicleNumber());

        TransactionResponse transaction = paymentClient.pay(paymentRequest);

        return transaction;

    }
}











