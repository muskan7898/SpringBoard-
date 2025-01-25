package com.example.spring.board.controller;

import com.example.spring.board.dto.res.VehicleBookingDetail;
import com.example.spring.board.services.VehicleBookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/vehicle-booking")
public class VehicleBookingController {
    private final VehicleBookingService vehicleBookingService;
    @PostMapping("/create")
    public ResponseEntity<String> insertVehicleBooking(@RequestBody @Valid VehicleBookingDetail vehicleBookingDetail){
        try{
            return vehicleBookingService.insertVehicleBookingService(vehicleBookingDetail);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}
