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
public class UpdateRentalRequest {
    public int id;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate returnDate;

    private int endKilometer;

    private int customerId;

    private int carId;
}
