package com.etiya.rentACar.business.dtos.responses.rentals;

import com.etiya.rentACar.business.dtos.responses.cars.GetCarListResponse;
import com.etiya.rentACar.business.dtos.responses.cars.GetCarResponse;
import com.etiya.rentACar.business.dtos.responses.customers.GetCustomerListResponse;
import com.etiya.rentACar.business.dtos.responses.rentalBranches.GetRentalBranchListResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetRentalResponse {

    private int id;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate returnDate;

    private int startKilometer;

    private int endKilometer;

    private String startLocation;

    private GetCarResponse car;

    private GetCustomerListResponse customer;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime deletedDate;
}
