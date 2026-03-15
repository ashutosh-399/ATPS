package com.toll.Scanner_Service.controller;

import com.toll.Scanner_Service.dto.ScannerDTO;
import com.toll.Scanner_Service.dto.TransactionResponse;
import com.toll.Scanner_Service.service.ScannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scanner")
public class ScannerController {

    @Autowired
    private ScannerService scannerService;

    @PostMapping("/scan")
    public ResponseEntity<TransactionResponse> scan(@RequestBody ScannerDTO ScannerDTO ){
        return ResponseEntity.ok(scannerService.processScan(ScannerDTO.getVehicleNumber()));
    }
}
