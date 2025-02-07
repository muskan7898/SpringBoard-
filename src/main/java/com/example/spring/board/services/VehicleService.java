package com.example.spring.board.services;

import com.example.spring.board.dto.req.CreateVehicle;
import com.example.spring.board.dto.req.UpdateVehicleStatus;
import com.example.spring.board.dto.res.VehicleBookingResponse;
import com.example.spring.board.dto.res.VehicleDetail;
import com.example.spring.board.enums.VehicleStatus;
import com.example.spring.board.model.Vehicle;
import com.example.spring.board.model.VehicleType;
import com.example.spring.board.repository.VehicleRepository;
import com.example.spring.board.services.core.VehicleCoreService;
import com.example.spring.board.services.core.VehicleTypeCoreService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleCoreService vehicleCoreService;
    private final VehicleTypeCoreService vehicleTypeCoreService;
    private final VehicleRepository vehicleRepository;

    public String insertVehicle(CreateVehicle createVehicle) {
        Vehicle vehicle = Vehicle.builder()
                .status(createVehicle.getStatus())
                .model(createVehicle.getModel())
                .typeId(createVehicle.getTypeId())
                .manufactureYear(createVehicle.getManufactureYear())
                .build();

        Vehicle savedVehicle = vehicleCoreService.saveVehicle(vehicle);
        return savedVehicle.getId().toString();
    }

    public String updateVehicleStatus(UpdateVehicleStatus updateVehicleStatus, Long id) {
        try {
            Vehicle existingVehicle = vehicleCoreService.getVehicleById(id);
            if (Objects.isNull(existingVehicle)) {
                throw new EntityNotFoundException("vehicle not found for this id: " + id);
            }
            existingVehicle.setStatus(updateVehicleStatus.getNewStatus());
            vehicleCoreService.saveVehicle(existingVehicle);
            return id.toString();

        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    public List<VehicleDetail> getAllVehicle() {
        List<VehicleDetail> vehicleDetails = new ArrayList<>();

        List<Vehicle> vehicles = vehicleCoreService.getAllVehicle();

        if (Objects.isNull(vehicles)) {
            return vehicleDetails;
        }

        for (Vehicle v : vehicles) {

            VehicleType vehicleType = vehicleTypeCoreService.getVehicleTypeById(v.getTypeId());
            String typeName = (vehicleType != null) ? vehicleType.getTypeName() : "Unknown";

            vehicleDetails.add(new VehicleDetail(
                    v.getId(),
                    v.getModel(),
                    v.getManufactureYear(),
                    v.getStatus().toString(),
                    typeName
            ));
        }
        return vehicleDetails;
    }

    public VehicleDetail getVehicleById(Long id) {
        try {
            Vehicle v = vehicleCoreService.getVehicleById(id);

            if (Objects.isNull(v)) {
                throw new EntityNotFoundException("vehicle not found for id: " + id);
            }

            VehicleType vehicleType = vehicleTypeCoreService.getVehicleTypeById(v.getTypeId());
            String typeName = (vehicleType != null) ? vehicleType.getTypeName() : "Unknown";


            return new VehicleDetail(
                    v.getId(),
                    v.getModel(),
                    v.getManufactureYear(),
                    v.getStatus().toString(),
                    typeName
            );
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    public Vehicle deleteVehicleById(Long id) {
        try {
            Vehicle vehicle = vehicleCoreService.getVehicleById(id);
            if (Objects.isNull(vehicle)) {
                throw new EntityNotFoundException("vehicle not found with id: " + id);
            }
            vehicleCoreService.deleteVehicle(id);
            return vehicle;
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    public List<VehicleDetail> getVehicleByStatus(VehicleStatus status) {
        List<Vehicle> vehicles = vehicleCoreService.getVehicleByStatus(status);
        List<VehicleDetail> vehicleDetails = new ArrayList<>();

        if (Objects.isNull(vehicles)) {
            return vehicleDetails;
        }

        for (Vehicle v : vehicles) {
            VehicleType vehicleType = vehicleTypeCoreService.getVehicleTypeById(v.getTypeId());
            String typeName = (vehicleType != null) ? vehicleType.getTypeName() : "Unknown";

            vehicleDetails.add(new VehicleDetail(
                    v.getId(),
                    v.getModel(),
                    v.getManufactureYear(),
                    v.getStatus().toString(),
                    typeName
            ));
        }
        return vehicleDetails;
    }

//    public List<Object[]> vehicleWithType(){
//        List<Object[]> results = vehicleRepository.findVehicleWithVehicleType();
//        for (Object[] row : results) {
//            String vehicleName = (String) row[0];
//            String vehicleTypeName = (String) row[1];
//            System.out.println("Vehicle: " + vehicleName + ", Type: " + vehicleTypeName);
//        }
//        return results;
//    }

    // Make sure you have the correct import

    public VehicleBookingResponse getVehicleBookingDetails(Long vehicleId) {
        List<Object[]> result = vehicleRepository.findBookingDetailsByVehicleId(vehicleId);
        if (result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not found for this id");
        }

        // Get vehicle type using vehicle type ID from the result
        VehicleType vehicleType = vehicleTypeCoreService.getVehicleTypeById((Long) result.get(0)[3]);
        String typename = vehicleType == null ? null : vehicleType.getTypeName();

        // Build the response object
        VehicleBookingResponse response = VehicleBookingResponse.builder()
                .model((String) result.get(0)[0])
                .manufactureYear((Integer) result.get(0)[1])
                .status(VehicleStatus.valueOf((String) result.get(0)[2]))
                .vehicleType(typename)  // Set the vehicle type from the service
                .build();

        // List to hold booking details
        List<VehicleBookingResponse.BookingDetails> bookingDetailsList = new ArrayList<>();

        // Iterate through the result and populate the booking details
        for (Object[] row : result) {
            if (row[4] != null && row[5] != null) {
                Timestamp startDate = (Timestamp) row[4];  // start_date at index 4
                Timestamp endDate = (Timestamp) row[5];    // end_date at index 5

                // Format the Timestamp to String
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                // Build the BookingDetails object
                VehicleBookingResponse.BookingDetails bookingDetails = VehicleBookingResponse.BookingDetails.builder()
                        .startDate(sdf.format(startDate))
                        .endDate(sdf.format(endDate))  // Corrected the parenthesis error
                        .build();

                // Add to the list
                bookingDetailsList.add(bookingDetails);
            }
        }

        // Set the list of booking details to the response
        response.setBookingList(bookingDetailsList);

        return response;
    }
}
