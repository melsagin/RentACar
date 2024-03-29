package com.etiya.rentACar.business.dtos.requests.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelRequest {
    private int id;

    @NotNull
    @Size(min = 2, max= 30)
    private String name;

    private int brandId;

    private int fuelId;

    private int transmissionId;
}