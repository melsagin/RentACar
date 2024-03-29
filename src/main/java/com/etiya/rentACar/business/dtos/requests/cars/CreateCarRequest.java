package com.etiya.rentACar.business.dtos.requests.cars;

import com.etiya.rentACar.business.constants.Messages;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCarRequest {

    @NotNull(message = Messages.CarMessages.YEAR_NOT_NULL)
    @Max(value = 2024, message = Messages.CarMessages.YEAR_NOT_GREATER_THAN_TWO_THOUSAND_TWENTY_FOUR)
    private int modelYear;

    @NotNull()
    @Pattern(regexp = Messages.CarMessages.ENTER_VALID_PLATE_REGEX, message = Messages.CarMessages.ENTER_VALID_PLATE)
    //kural - dönen hata mesajı
    private String plate;

    @NotNull
    //@Positive(message = Messages.CarMessages.CAR_STATE_IS_NOT_NEGATIVE)
    @Min(value = 1, message = Messages.CarMessages.CAR_STATE_MIN_VALUES)
    @Max(value = 3, message = Messages.CarMessages.CAR_STATE_MAX_VALUES)
    private int carState;

    @NotNull
    @Positive(message = Messages.CarMessages.DAILY_PRICE_NOT_NEGATIVE)
    private double dailyPrice;

    @NotNull(message = Messages.CarMessages.KILOMETER_NOT_NULL)
    @Positive(message = Messages.CarMessages.KILOMETER_NOT_NEGATIVE)
    private int kilometer;

    private int rentalBranchId;

    private int modelId;
}