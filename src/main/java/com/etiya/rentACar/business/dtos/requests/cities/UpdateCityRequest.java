package com.etiya.rentACar.business.dtos.requests.cities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCityRequest {
    private int id;
    private String name;
}
