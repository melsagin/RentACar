package com.etiya.rentACar.business.dtos.requests.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCarRequest {
    private int id;

    private int modelYear;

    private String plate;

    private int carState;

    private double dailyPrice;

    private int kilometer;

    private int rentalBranchId;

    private int modelId;
}