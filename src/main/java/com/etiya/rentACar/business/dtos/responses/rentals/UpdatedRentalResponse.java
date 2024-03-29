package com.etiya.rentACar.business.dtos.responses.rentals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedRentalResponse {
    private int id;
    private int carId;
    private int customerId;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate returnDate;
    private int endKilometer;
    private LocalDateTime updatedDate;
}
