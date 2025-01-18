package com.example.spring.board.services;

import com.example.spring.board.model.Booking;
import com.example.spring.board.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;

    public Booking savaBooking(Booking booking){
        return null;
    }

    public List<Booking> getAllBooking(){
        return null;
    }

    public Booking getBookingById(Long id){
        return null;
    }

    public void deleteBookingById(Long id){

    }

    public Booking getBookingByVehicleId(Long VehicleId){
        return null;
    }
}

