package com.example.spring.board.dto.res;

import com.example.spring.board.enums.VehicleStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleBookingResponse {
    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BookingDetails {
        private String startDate;
        private String endDate;
    }

    private String model;
    private int manufactureYear;
    private VehicleStatus status;
    private String vehicleType;
    private List<BookingDetails> bookingList;

}
