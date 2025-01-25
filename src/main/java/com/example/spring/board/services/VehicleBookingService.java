package com.example.spring.board.services;

import com.example.spring.board.dto.res.VehicleBookingDetail;
import com.example.spring.board.model.Booking;
import com.example.spring.board.model.Vehicle;
import com.example.spring.board.model.VehicleBooking;
import com.example.spring.board.services.core.BookingCoreService;
import com.example.spring.board.services.core.VehicleBookingCoreService;
import com.example.spring.board.services.core.VehicleCoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

import static com.example.spring.board.enums.VehicleStatus.BOOKED;

@Service
@RequiredArgsConstructor
public class VehicleBookingService {
    private final VehicleBookingCoreService vehicleBookingCoreService;
    private final VehicleCoreService vehicleCoreService;
    private final BookingCoreService bookingCoreService;

    public ResponseEntity<String> insertVehicleBookingService(VehicleBookingDetail vehicleBookingDetail){
        Long vehicleId = vehicleBookingDetail.getVehicleId();
        Long bookingId = vehicleBookingDetail.getBookingId();

        Vehicle vehicle = vehicleCoreService.getVehicleById(vehicleId);
        if(Objects.isNull(vehicle)){
            return ResponseEntity.status(404).body("Vehicle not found for this id: " + vehicleId);
        }

        Booking booking = bookingCoreService.getBookingById(bookingId);
        if(Objects.isNull(booking)){
            return ResponseEntity.status(404).body("Booking not found for this id: " + bookingId);
        }

        VehicleBooking vehicleBooking = VehicleBooking.builder()
                .bookingId(vehicleBookingDetail.getBookingId())
                .vehicleId(vehicleBookingDetail.getVehicleId())
                .build();

        VehicleBooking savedVehicleBooking = vehicleBookingCoreService.saveVehicleBooking(vehicleBooking);
        return ResponseEntity.ok(savedVehicleBooking.getBookingId().toString());
    }
}
