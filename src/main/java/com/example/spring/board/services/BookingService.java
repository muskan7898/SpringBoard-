package com.example.spring.board.services;

import com.example.spring.board.dto.req.CreateBooking;
import com.example.spring.board.dto.res.BookingDetail;
import com.example.spring.board.model.Booking;
import com.example.spring.board.services.core.BookingCoreService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingCoreService bookingCoreService;

    public String insertBookingService(@RequestBody CreateBooking createBooking){
        Booking booking = new Booking();
        booking.setStartDate(createBooking.getStartDate());
        booking.setEndDate(createBooking.getEndDate());

        Booking savedBooking = bookingCoreService.saveBooking(booking);

        return savedBooking.getId().toString();
    }

    public ResponseEntity<List<BookingDetail>> getAllBookingService(){
        List<Booking> bookings = bookingCoreService.getAllBooking();
        List<BookingDetail> bookingDetails = new ArrayList<>();

        bookings.forEach(b -> {
            BookingDetail bookingDetail = new BookingDetail(
                    b.getId(),
                    b.getStartDate(),
                    b.getEndDate()
            );
            bookingDetails.add(bookingDetail);
        });
        return ResponseEntity.ok(bookingDetails);
    }

    public BookingDetail getBookingByIdService(Long id){
        Booking booking = bookingCoreService.getBookingById(id);
        return new BookingDetail(
                booking.getId(),
                booking.getStartDate(),
                booking.getEndDate()
        );
    }

    public ResponseEntity<Booking> deleteBookingByIdService(Long id){
        Booking booking = bookingCoreService.getBookingById(id);
        if(booking == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Return 404 if booking doesn't exist
        }
        bookingCoreService.deleteBookingById(id);
        return ResponseEntity.ok(booking);
    }
}