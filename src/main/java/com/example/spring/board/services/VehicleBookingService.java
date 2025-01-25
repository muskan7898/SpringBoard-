package com.example.spring.board.services;

import com.example.spring.board.dto.res.VehicleBookingDetail;
import com.example.spring.board.model.VehicleBooking;
import com.example.spring.board.services.core.VehicleBookingCoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleBookingService {
    private final VehicleBookingCoreService vehicleBookingCoreService;

    public String insertVehicleBookingService(VehicleBookingDetail vehicleBookingDetail){
        VehicleBooking vehicleBooking = new VehicleBooking();
        vehicleBooking.setBookingId(vehicleBookingDetail.getBookingId());
        vehicleBooking.setVehicleId(vehicleBookingDetail.getVehicleId());

        VehicleBooking savedVehicleBooking = vehicleBookingCoreService.saveVehicleBooking(vehicleBooking);
        return savedVehicleBooking.getBookingId().toString();
    }
}
