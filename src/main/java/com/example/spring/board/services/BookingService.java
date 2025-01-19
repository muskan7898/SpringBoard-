package com.example.spring.board.services;

import com.example.spring.board.dto.req.CreateBooking;
import com.example.spring.board.dto.res.BookingDetail;
import com.example.spring.board.model.Booking;
import com.example.spring.board.services.core.BookingCoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private BookingCoreService bookingCoreService;

    public String insertBookingService(@RequestBody CreateBooking createBooking){
        Booking booking = new Booking();
        booking.setStartDate(createBooking.getStartDate());
        booking.setUpdatedDate(createBooking.getEndDate());

        Booking savedBooking = bookingCoreService.saveBooking(booking);

        return savedBooking.getId().toString();
    }

    public ResponseEntity<List<BookingDetail>> getAllBookingService(){
        List<BookingDetail> bookingDetails = new ArrayList<>();
        //have to complete this

        return ResponseEntity.ok(bookingDetails);
    }

    public ResponseEntity<BookingDetail> getBookingByIdService(Long id){
        Booking booking = bookingCoreService.getBookingById(id);
        BookingDetail bookingDetail = new BookingDetail();

        // complete this
        return ResponseEntity.ok(bookingDetail);
    }

    public void deleteBookingByIdService(Long id){
        bookingCoreService.deleteBookingById(id);
    }

    public BookingDetail getBookingByVehicleIdService(Long vehicleId){
        Booking booking = bookingCoreService.getBookingByVehicleId(vehicleId);
        BookingDetail bookingDetail = new BookingDetail();
        // complete this
        return bookingDetail;
    }

}
