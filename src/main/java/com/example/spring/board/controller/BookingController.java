package com.example.spring.board.controller;


import com.example.spring.board.dto.req.CreateBooking;
import com.example.spring.board.dto.res.BookingDetail;
import com.example.spring.board.services.BookingService;
import com.example.spring.board.services.core.BookingCoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<String> insertBooking(@RequestBody @Valid CreateBooking createBooking){
        return ResponseEntity.ok(bookingService.insertBookingService(createBooking));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<BookingDetail>> getAllBooking(){
        return bookingService.getAllBookingService();
    }


    @GetMapping("/{id}")
    public ResponseEntity<BookingDetail> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getBookingByIdService(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id)
    {
        bookingService.deleteBookingByIdService(id);
        return ResponseEntity.ok().build();
    }


}
