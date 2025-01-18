package com.example.spring.board.services;

import com.example.spring.board.model.VehicleBooking;
import com.example.spring.board.repository.VehicleBookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleBookingService {

    private final VehicleBookingRepository vehicleBookingRepository;

    public VehicleBooking saveVehicleBooking(VehicleBooking vehicleBooking){
        return null;
    }

}
