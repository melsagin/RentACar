package com.etiya.rentACar.business.dtos.responses.invoices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedInvoiceResponse {
    private int id;
    private double totalPrice;
    private int rentalId;
    private LocalDateTime createdDate;
}
