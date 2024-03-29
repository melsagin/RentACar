package com.etiya.rentACar.business.dtos.responses.rentalBranches;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedRentalBranchResponse {
    private int id;
    private int cityId;
    private LocalDateTime updatedDate;
}
