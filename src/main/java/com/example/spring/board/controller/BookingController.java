package com.example.spring.board.controller;


import com.example.spring.board.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {
    private BookingService bookingService;

    @PostMapping("/create")
    public String insertBooking(){
        return "";
    }


}
