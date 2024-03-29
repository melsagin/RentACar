package com.etiya.rentACar.business.dtos.responses.fuels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UpdatedFuelResponse {

    private int id;
    private String name;
    private LocalDateTime updatedDate;
}
