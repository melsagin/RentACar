package com.etiya.rentACar.business.dtos.requests.transmissions;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateTransmissionRequest {
    private int id;

    @NotNull
    @Size(min = 2,max = 30)
    private String name;
}