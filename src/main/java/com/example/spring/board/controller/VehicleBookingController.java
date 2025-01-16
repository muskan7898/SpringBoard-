package com.example.spring.board.controller;

import com.example.spring.board.dto.res.VehicleBookingDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vehicle-booking")
public class VehicleBookingController {
    @PostMapping("/create")
    public String insertVehicleBooking(@RequestBody VehicleBookingDetail vehicleBookingDetail){
        return "";
    }

}
