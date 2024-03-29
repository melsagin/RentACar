package com.etiya.rentACar.business.dtos.requests.invoices;

import com.etiya.rentACar.entities.Rental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInvoiceRequest {
    private int id;
    private double totalPrice;
    private int rentalId;
}
