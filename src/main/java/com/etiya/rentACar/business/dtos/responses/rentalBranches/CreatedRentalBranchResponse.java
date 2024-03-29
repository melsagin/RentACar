package com.etiya.rentACar.business.dtos.responses.rentalBranches;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedRentalBranchResponse {
    private int id;//bu hocada yok
    private int cityId;
    private LocalDateTime createdDate;
}
