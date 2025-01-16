package com.example.spring.board.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetail {
    private Long id;
    private String startDate;
    private String endDate;
}

