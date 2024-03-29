package com.etiya.rentACar.business.dtos.requests.rentals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChangedRentedCarRequest {
    private int id;
    private int carId;
//    private int customerId;
}
