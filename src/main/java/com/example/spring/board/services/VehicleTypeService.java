package com.example.spring.board.services;

import com.example.spring.board.dto.res.VehicleTypeDetail;
import com.example.spring.board.model.VehicleType;
import com.example.spring.board.services.core.VehicleTypeCoreService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class VehicleTypeService {
    private final VehicleTypeCoreService vehicleTypeCoreService;

    public String insertVehicleTypeService(@RequestBody VehicleTypeDetail vehicleTypeDetail){
        VehicleType vehicleType = VehicleType.builder()
                                    .typeName(vehicleTypeDetail.getType())
                                    .build();

        VehicleType savedVehicleType = vehicleTypeCoreService.saveVehicleType(vehicleType);
        return savedVehicleType.getId().toString();
    }

    public VehicleTypeDetail getVehicleByIdService(Long id){
        VehicleType vehicleType = vehicleTypeCoreService.getVehicleTypeById(id);

        return new VehicleTypeDetail(
                vehicleType.getId(),
                vehicleType.getTypeName()
        );
    }


    public VehicleType deleteVehicleTypeByIdService(Long id){
        VehicleType vehicleType = vehicleTypeCoreService.getVehicleTypeById(id);

        if(Objects.isNull(vehicleType)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "vehicle type not found for this id: "+ id);
        }
        vehicleTypeCoreService.deleteVehicleTypeById(id);
        return vehicleType;
    }

    public List<VehicleTypeDetail> getAllVehicleTypeService(){
        List<VehicleType> vehicleTypes = vehicleTypeCoreService.getAllVehicleTypes();
        List<VehicleTypeDetail> vehicleTypeDetails = new ArrayList<>();

        for(VehicleType vt : vehicleTypes){
            vehicleTypeDetails.add(new VehicleTypeDetail(
                    vt.getId(),
                    vt.getTypeName()
            ));
        }
        return vehicleTypeDetails;
    }
}
