package com.example.spring.board.services;

import com.example.spring.board.dto.res.VehicleBookingDetail;
import com.example.spring.board.model.Booking;
import com.example.spring.board.model.Vehicle;
import com.example.spring.board.model.VehicleBooking;
import com.example.spring.board.services.core.BookingCoreService;
import com.example.spring.board.services.core.VehicleBookingCoreService;
import com.example.spring.board.services.core.VehicleCoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.Objects;


@Service
@RequiredArgsConstructor
public class VehicleBookingService {
    private final VehicleBookingCoreService vehicleBookingCoreService;
    private final VehicleCoreService vehicleCoreService;
    private final BookingCoreService bookingCoreService;

    public String insertVehicleBookingService(VehicleBookingDetail vehicleBookingDetail){
        Long vehicleId = vehicleBookingDetail.getVehicleId();
        Long bookingId = vehicleBookingDetail.getBookingId();

        Vehicle vehicle = vehicleCoreService.getVehicleById(vehicleId);
        if(Objects.isNull(vehicle)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "vehicle not exist for this id: " + vehicleId);
        }

        Booking booking = bookingCoreService.getBookingById(bookingId);
        if(Objects.isNull(booking)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "booking does not exists for this id: "+ bookingId);
        }

        VehicleBooking vehicleBooking = VehicleBooking.builder()
                .bookingId(vehicleBookingDetail.getBookingId())
                .vehicleId(vehicleBookingDetail.getVehicleId())
                .build();

        VehicleBooking savedVehicleBooking = vehicleBookingCoreService.saveVehicleBooking(vehicleBooking);
        return savedVehicleBooking.getBookingId().toString();
    }
}
