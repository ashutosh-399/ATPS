package com.toll.toll_service.controller;

import com.netflix.discovery.converters.Auto;
import com.toll.toll_service.dto.TollDTO;
import com.toll.toll_service.enity.Toll;
import com.toll.toll_service.service.TollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/toll")
public class TollController {

    @Autowired
    private TollService tollService;

    @PostMapping("/create")
    public ResponseEntity<Toll> create(@RequestBody TollDTO tollDTO){
        return ResponseEntity.ok(tollService.createToll(tollDTO));
    }

    @GetMapping("/getByVehicleType/{vehicleType}")
    public ResponseEntity<Toll> getTollByVehicleType(@PathVariable String vehicleType){
        return ResponseEntity.ok(tollService.getTollByVehicleType(vehicleType));
    }
}
