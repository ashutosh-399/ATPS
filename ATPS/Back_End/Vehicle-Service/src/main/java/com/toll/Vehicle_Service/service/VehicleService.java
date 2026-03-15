package com.toll.Vehicle_Service.service;

import com.toll.Vehicle_Service.dto.VehicleDTO;
import com.toll.Vehicle_Service.entity.Vehicle;
import com.toll.Vehicle_Service.repository.VehicleRepo;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    public @Nullable Vehicle registerVehicle(VehicleDTO vehicleDTO) {
        if(vehicleRepo.findByVehicleNumber(vehicleDTO.getVehicleNumber()).isPresent()){
            throw new RuntimeException("Vehicle already registered");
        }
        Vehicle vehicle = Vehicle.builder()
                .userId(vehicleDTO.getUserId())
                .vehicleNumber(vehicleDTO.getVehicleNumber())
                .vehicleType(vehicleDTO.getVehicleType())
                .model(vehicleDTO.getModel())
                .tagId("TAG-"+ System.currentTimeMillis())
                .build();

        return vehicleRepo.save(vehicle);


    }

    public @Nullable List<Vehicle> getByUserId(Long userId) {
        List<Vehicle> vehicles = vehicleRepo.findByUserId(userId);
        return vehicles;
    }

    public @Nullable Vehicle getByVehicleNumber(String vehicleNumber) {
        Vehicle vehicle = vehicleRepo.findByVehicleNumber(vehicleNumber)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        return vehicle;
    }
}
