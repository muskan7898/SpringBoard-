package com.example.spring.board.services.core;

import com.example.spring.board.model.Booking;
import com.example.spring.board.repository.BookingRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


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

    /*
        * class A {}
        class B extends A {}
        class C extends B {}

        try {}
        catch(A e) {}
        catch(B e) {}
        catch(C e) {}
    * */
    public Booking getBookingById(Long id) {
        try{
            Supplier<EntityNotFoundException> orElseHandler = () ->
                    new EntityNotFoundException("booking not found for this id: " + id);
            return bookingRepository.findById(id).orElseThrow(orElseHandler);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e);
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
}

