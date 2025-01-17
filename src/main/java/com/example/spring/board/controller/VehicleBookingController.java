package com.example.spring.board.controller;

import com.example.spring.board.dto.res.VehicleBookingDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vehicle-booking")
public class VehicleBookingController {
    @PostMapping("/create")
    public String insertVehicleBooking(@RequestBody @Valid VehicleBookingDetail vehicleBookingDetail){
        return "";
    }

}
