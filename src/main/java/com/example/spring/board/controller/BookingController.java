package com.example.spring.board.controller;


import com.example.spring.board.dto.req.CreateBooking;
import com.example.spring.board.services.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;




@Controller
@RequiredArgsConstructor
@RequestMapping("/booking")

public class BookingController {
    private final BookingService bookingService;

    @PostMapping()
    public ResponseEntity<String> insertBooking(@RequestBody @Valid CreateBooking createBooking){
        try{
            return ResponseEntity.ok(bookingService.insertBookingService(createBooking));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllBooking(){
        try{
            return ResponseEntity.ok(bookingService.getAllBookingService());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookingById(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(bookingService.getBookingByIdService(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id)
    {
        try{
            return ResponseEntity.ok(bookingService.deleteBookingByIdService(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}
