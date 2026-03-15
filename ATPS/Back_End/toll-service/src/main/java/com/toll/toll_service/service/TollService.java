package com.toll.toll_service.service;

import com.toll.toll_service.dto.TollDTO;
import com.toll.toll_service.enity.Toll;
import com.toll.toll_service.repository.TollRepo;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TollService {

    @Autowired
    private TollRepo tollRepo;

    public @Nullable Toll createToll(TollDTO tollDTO) {
        Toll toll = Toll.builder()
                .tollName(tollDTO.getTollName())
                .location(tollDTO.getLocation())
                .vehicleType(tollDTO.getVehicleType())
                .tollFee(tollDTO.getTollFee())
                .build();

        toll = tollRepo.save(toll);
        return toll;
    }

    public @Nullable Toll getTollByVehicleType(String vehicleType) {
        Optional<Toll> toll = tollRepo.findTollByVehicleType(vehicleType);
        return toll.orElseThrow(() -> new RuntimeException("Toll not found for vehicle type: " + vehicleType));
    }
}
