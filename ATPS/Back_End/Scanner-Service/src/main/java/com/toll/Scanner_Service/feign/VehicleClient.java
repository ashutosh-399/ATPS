package com.toll.Scanner_Service.feign;

import com.toll.Scanner_Service.dto.VehicleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "VEHICLE-SERVICE")
public interface VehicleClient {

    @GetMapping("/vehicles/getByVehicleNumber/{vehicleNumber}")
    VehicleResponse getVehicleByNumber(@PathVariable String vehicleNumber);
}
