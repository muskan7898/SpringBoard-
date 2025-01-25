package com.example.spring.board.services;

import com.example.spring.board.dto.req.CreateVehicle;
import com.example.spring.board.dto.req.UpdateVehicleStatus;
import com.example.spring.board.dto.res.VehicleDetail;
import com.example.spring.board.enums.VehicleStatus;
import com.example.spring.board.model.Vehicle;
import com.example.spring.board.model.VehicleType;
import com.example.spring.board.services.core.VehicleCoreService;
import com.example.spring.board.services.core.VehicleTypeCoreService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleCoreService vehicleCoreService;
    private final VehicleTypeCoreService vehicleTypeCoreService;

    public String insertVehicleService(CreateVehicle createVehicle){
        Vehicle vehicle = Vehicle.builder()
                .status(createVehicle.getStatus())
                        .model(createVehicle.getModel())
                                        .typeId(createVehicle.getTypeId())
                                                .manufactureYear(createVehicle.getManufactureYear())
                                                        .build();

        Vehicle savedVehicle = vehicleCoreService.saveVehicle(vehicle);
        return savedVehicle.getId().toString();
    }

    public String updateVehicleStatusService(UpdateVehicleStatus updateVehicleStatus, Long id){
        try {
            Vehicle existingVehicle = vehicleCoreService.getVehicleById(id);
            if(Objects.isNull(existingVehicle)){
                throw new EntityNotFoundException("vehicle not found for this id: " + id);
            }
            existingVehicle.setStatus(updateVehicleStatus.getNewStatus());
            vehicleCoreService.saveVehicle(existingVehicle);
            return id.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<List<VehicleDetail>> getAllVehicleService() {
        List<VehicleDetail> vehicleDetails = new ArrayList<>();

        List<Vehicle> vehicles = vehicleCoreService.getAllVehicle();

        if(Objects.isNull(vehicles)){
            return ResponseEntity.ok(vehicleDetails);
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
        return ResponseEntity.ok(vehicleDetails);
    }

    public ResponseEntity<VehicleDetail> getVehicleByIdService(Long id) {
        Vehicle v = vehicleCoreService.getVehicleById(id);

        if (Objects.isNull(v)) {
            return ResponseEntity.notFound().build();
        }
        VehicleType vehicleType = vehicleTypeCoreService.getVehicleTypeById(v.getTypeId());
        String typeName = (vehicleType != null) ? vehicleType.getTypeName() : "Unknown";


        return ResponseEntity.ok(new VehicleDetail(
                v.getId(),
                v.getModel(),
                v.getManufactureYear(),
                v.getStatus().toString(),
                typeName
         ));
    }

    public ResponseEntity<Vehicle> deleteVehicleByService(Long id){
        Vehicle vehicle = vehicleCoreService.getVehicleById(id);
        if(Objects.isNull(vehicle)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Return 404 if booking doesn't exist
        }
        vehicleCoreService.deleteVehicle(id);
        return ResponseEntity.ok(vehicle);
    }

    public ResponseEntity<List<VehicleDetail>> getVehicleByStatusService(VehicleStatus status){
        List<Vehicle> vehicles = vehicleCoreService.getVehicleByStatus(status);
        List<VehicleDetail> vehicleDetails = new ArrayList<>();

        if (Objects.isNull(vehicles)) {
            return ResponseEntity.ok(vehicleDetails);
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
        return ResponseEntity.ok(vehicleDetails);
    }
}
