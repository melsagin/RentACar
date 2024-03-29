package com.etiya.rentACar.business.dtos.responses.rentals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChangedRentedCarResponse {
    private int id;
    private int carId;
    private LocalDateTime updatedDate;
}
