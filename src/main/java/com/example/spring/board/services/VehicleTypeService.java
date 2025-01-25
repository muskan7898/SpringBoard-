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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class VehicleTypeService {
    private final VehicleTypeCoreService vehicleTypeCoreService;

    public String insertVehicleTypeService(@RequestBody VehicleTypeDetail vehicleTypeDetail){
        VehicleType vehicleType = new VehicleType();
        vehicleType.setTypeName(vehicleTypeDetail.getType());
        VehicleType savedVehicleType = vehicleTypeCoreService.saveVehicleType(vehicleType);
        return savedVehicleType.getId().toString();
    }

    public VehicleTypeDetail getVehicleByIdService(Long id){
        VehicleType vehicleType = vehicleTypeCoreService.getVehicleTypeById(id);
        VehicleTypeDetail vehicleTypeDetail = new VehicleTypeDetail();
        vehicleTypeDetail.setTypeId(vehicleType.getId());
        vehicleTypeDetail.setType(vehicleType.getTypeName());
        return vehicleTypeDetail;
    }


    public ResponseEntity<VehicleType> deleteVehicleTypeByIdService(Long id){
        VehicleType vehicleType = vehicleTypeCoreService.getVehicleTypeById(id);
        if(Objects.isNull(vehicleType)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        vehicleTypeCoreService.deleteVehicleTypeById(id);
        return ResponseEntity.ok(vehicleType);
    }

    public ResponseEntity<List<VehicleTypeDetail>> getAllVehicleTypeService(){
        List<VehicleType> vehicleTypes = vehicleTypeCoreService.getAllVehicleTypes();
        List<VehicleTypeDetail> vehicleTypeDetails = new ArrayList<>();

        for(VehicleType vt : vehicleTypes){
            VehicleTypeDetail vehicleTypeDetail = new VehicleTypeDetail();
            vehicleTypeDetail.setTypeId(vt.getId());
            vehicleTypeDetail.setType(vt.getTypeName());

            vehicleTypeDetails.add(vehicleTypeDetail);
        }

        return ResponseEntity.ok(vehicleTypeDetails);
    }

}
