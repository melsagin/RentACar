package com.etiya.rentACar.business.dtos.requests.rentalBranches;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateRentalBranchRequest {
    private int cityId;
}
