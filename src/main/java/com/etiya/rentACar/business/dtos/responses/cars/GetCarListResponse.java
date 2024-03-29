package com.etiya.rentACar.business.dtos.responses.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCarListResponse {
    private int id;
    private int modelYear;
    private String plate;
    private int carState;
    private double dailyPrice;
    private int kilometer;
    private int modelId;//burada model ve rentalbranchın namelerini de tuttu hoca
    private int rentalBranchId;
//    private String modelName;
//    private String rentalBranchCityName;
//    private String modelBrandName;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime deletedDate;
}
