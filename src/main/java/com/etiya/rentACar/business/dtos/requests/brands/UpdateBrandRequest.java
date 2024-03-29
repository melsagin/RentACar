package com.etiya.rentACar.business.dtos.requests.brands;

import com.etiya.rentACar.business.constants.Messages;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBrandRequest {
    @NotNull(message = Messages.IdMessages.ID_NOT_NULL)
    private int id;

    @NotNull
    @Size(min = 2,max = 30)
    private String name;
}