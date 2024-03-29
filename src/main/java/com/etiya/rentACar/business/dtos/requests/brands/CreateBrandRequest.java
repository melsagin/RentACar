package com.etiya.rentACar.business.dtos.requests.brands;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBrandRequest {
    @NotEmpty(message = "Brand name connot be empty")
    @Size(min = 2,max = 30)
    private String name;
}