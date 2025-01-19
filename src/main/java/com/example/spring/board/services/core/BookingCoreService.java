package com.example.spring.board.services.core;

import com.example.spring.board.model.Booking;
import com.example.spring.board.repository.BookingRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BookingCoreService {
    private final BookingRepository bookingRepository;

    public Booking saveBooking(Booking booking){
        try{
            return bookingRepository.save(booking);
        }
        catch (Exception e){
            System.out.println("some error while saving booking: "+ e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<Booking> getAllBooking(){
        try {
            return bookingRepository.findAll();
        }
        catch (Exception e){
            System.out.println("some error during find all booking: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Booking getBookingById(Long id){
        try{
            Booking booking = bookingRepository.findById(id).orElse(null);
            if(booking == null){
                throw new EntityNotFoundException("booking not found for this id: " + id);
            }
            return booking;
        } catch (Exception e) {
            System.out.println("some error while get booking by id: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void deleteBookingById(Long id){
        try {
            bookingRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("some error while delete booking by id: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }


//    public Booking getBookingByVehicleId(Long VehicleId){
//        try {
//            return bookingRepository.getByVehicleId(VehicleId);
//        } catch (Exception e) {
//            System.out.println("some error by fetching booking by vehicle id: " + e.getMessage());
//            throw new RuntimeException(e);
//        }
//    }
}

