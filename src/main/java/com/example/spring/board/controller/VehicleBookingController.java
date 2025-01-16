package com.example.spring.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vehicle-booking")
public class VehicleBookingController {
    @PostMapping("/create")
    public String insertVehicleBooking(){
        return "";
    }

}
