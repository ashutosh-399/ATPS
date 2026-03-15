package com.toll.Scanner_Service.feign;

import com.toll.Scanner_Service.dto.TollResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "TOLL-SERVICE")
public interface TollClient {

    @GetMapping("/toll/getByVehicleType/{vehicleType}")
    TollResponse getTollByVehicleType(@PathVariable String vehicleType);
}
