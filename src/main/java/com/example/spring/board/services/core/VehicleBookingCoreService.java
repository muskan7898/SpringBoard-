package com.example.spring.board.services.core;

import com.example.spring.board.model.VehicleBooking;
import com.example.spring.board.repository.VehicleBookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleBookingCoreService {

    private final VehicleBookingRepository vehicleBookingRepository;

    public VehicleBooking saveVehicleBooking(VehicleBooking vehicleBooking){
        try {
            return vehicleBookingRepository.save(vehicleBooking);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public VehicleBooking getVehicleBookingByVehicleId(Long id){
        try {
            return vehicleBookingRepository.getByVehicleId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

