package com.etiya.rentACar.business.dtos.responses.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedCarResponse {
    private int id;

    private int modelYear;

    private String plate;

    private int carState;

    private double dailyPrice;

    private int kilometer;

    private int modelId;

    private int rentalBranchId;

    private LocalDateTime createdDate;
}