package com.example.spring.board.services;

import com.example.spring.board.dto.req.CreateBooking;
import com.example.spring.board.dto.res.BookingDetail;
import com.example.spring.board.model.Booking;
import com.example.spring.board.services.core.BookingCoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingCoreService bookingCoreService;

    public String insertBookingService(@RequestBody CreateBooking createBooking){
        Booking booking = Booking.builder()
                .startDate(createBooking.getStartDate())
                .endDate(createBooking.getEndDate())
                .build();

        Booking savedBooking = bookingCoreService.saveBooking(booking);
        return savedBooking.getId().toString();
    }

    public List<BookingDetail> getAllBookingService(){
        List<Booking> bookings = bookingCoreService.getAllBooking();
        List<BookingDetail> bookingDetails = new ArrayList<>();

        bookings.forEach(b -> {
            bookingDetails.add(new BookingDetail(
                    b.getId(),
                    b.getStartDate(),
                    b.getEndDate()
            ));
        });
        return bookingDetails;
    }

    public BookingDetail getBookingByIdService(Long id){
        Booking booking = bookingCoreService.getBookingById(id);
        return new BookingDetail(
                booking.getId(),
                booking.getStartDate(),
                booking.getEndDate()
        );
    }

    public Booking deleteBookingByIdService(Long id){
        Booking booking = bookingCoreService.getBookingById(id);
        if(booking == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "booking not found for this id: " + id);
        }
        bookingCoreService.deleteBookingById(id);
        return booking;
    }
}