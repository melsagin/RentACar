package com.etiya.rentACar.business.dtos.requests.rentalBranches;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateRentalBranchRequest {
    private int id;
    private int cityId;
}
