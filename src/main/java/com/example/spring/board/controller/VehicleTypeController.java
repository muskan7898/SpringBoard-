package com.example.spring.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vehicle-type")
public class VehicleTypeController {
    @PostMapping("/create")
    public String insertVehicleType(){
        return "";
    }
}
