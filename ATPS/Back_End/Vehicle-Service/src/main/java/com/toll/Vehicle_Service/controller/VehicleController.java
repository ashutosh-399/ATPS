package com.toll.Vehicle_Service.controller;

import com.toll.Vehicle_Service.dto.VehicleDTO;
import com.toll.Vehicle_Service.entity.Vehicle;
import com.toll.Vehicle_Service.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/register")
    public ResponseEntity<Vehicle> registerVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return ResponseEntity.ok(vehicleService.registerVehicle(vehicleDTO));
    }

    @PostMapping("/getByUserId/{userId}")
    public ResponseEntity<List<Vehicle>> getVehicleByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(vehicleService.getByUserId(userId));
    }

    @GetMapping("/getByVehicleNumber/{vehicleNumber}")
    public ResponseEntity<Vehicle> getVehicleByNumber(@PathVariable String vehicleNumber){
        return ResponseEntity.ok(vehicleService.getByVehicleNumber(vehicleNumber));
    }
}
