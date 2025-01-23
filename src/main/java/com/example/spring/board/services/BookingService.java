package com.example.spring.board.services;

import com.example.spring.board.dto.req.CreateBooking;
import com.example.spring.board.dto.res.BookingDetail;
import com.example.spring.board.model.Booking;
import com.example.spring.board.services.core.BookingCoreService;
import lombok.RequiredArgsConstructor;
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

        for(Booking b : bookings){
            BookingDetail bookingDetail = new BookingDetail();

            bookingDetail.setId(b.getId());
            bookingDetail.setStartDate(b.getStartDate());
            bookingDetail.setEndDate(b.getEndDate());

            bookingDetails.add(bookingDetail);
        }

        return ResponseEntity.ok(bookingDetails);
    }

    public BookingDetail getBookingByIdService(Long id){
        Booking booking = bookingCoreService.getBookingById(id);
        BookingDetail bookingDetail = new BookingDetail();

        bookingDetail.setId(booking.getId());
        bookingDetail.setStartDate(booking.getStartDate());
        bookingDetail.setEndDate(booking.getEndDate());
        System.out.println(booking.getEndDate());

        return bookingDetail;
    }

    public void deleteBookingByIdService(Long id){
        bookingCoreService.deleteBookingById(id);
    }

}
