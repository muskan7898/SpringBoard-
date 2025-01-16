package com.example.spring.board.controller;


import com.example.spring.board.dto.res.BookingDetail;
import com.example.spring.board.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {
    private BookingService bookingService;

    @PostMapping("/create")
    public String insertBooking(@RequestBody BookingDetail bookingDetail){
        return "";
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<BookingDetail>> getAllBooking(){
        return null;
    }


    @GetMapping("/{id}")
    public ResponseEntity<BookingDetail> getBookingById(@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/by-vehicle/{vehicleId}")
    public List<BookingDetail> getBookingsByVehicle(@PathVariable Long vehicleId) {
        return null;
    }

}
