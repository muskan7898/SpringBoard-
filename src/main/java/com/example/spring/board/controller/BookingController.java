package com.example.spring.board.controller;


import com.example.spring.board.dto.req.CreateBookingRequest;
import com.example.spring.board.services.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@Controller
@RequiredArgsConstructor
@RequestMapping("/booking")

public class BookingController {
    private final BookingService bookingService;

    @PostMapping()
    public ResponseEntity<String> insertBooking(@RequestBody @Valid CreateBookingRequest createBookingRequest){
        try{
            return ResponseEntity.ok(bookingService.insertBooking(createBookingRequest));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllBooking(){
        try{
            return ResponseEntity.ok(bookingService.getAllBookings());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id)
    {
        try{
            return ResponseEntity.ok(bookingService.deleteBookingById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}
