package com.etiya.rentACar.business.dtos.responses.cars;

import com.etiya.rentACar.entities.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedCarResponse {
    private int id;
    private int modelYear;
    private String plate;
    private int carState;
    private double dailyPrice;
    private int kilometer;
    private int modelId;
    private int rentalBranchId;
//    private String modelName;
//    private String rentalBranchCityName;
//    private String modelBrandName;
    private LocalDateTime updatedDate;
}
