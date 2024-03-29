package com.etiya.rentACar.business.dtos.requests.rentals;

import com.etiya.rentACar.entities.Customer;
import com.etiya.rentACar.entities.RentalBranch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateRentalRequest {

    private LocalDate startDate;

    private LocalDate endDate;

    private int customerId;

    private int carId;

}
