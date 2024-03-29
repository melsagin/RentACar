package com.etiya.rentACar.business.dtos.requests.invoices;

import com.etiya.rentACar.entities.Rental;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInvoiceRequest {
    private double totalPrice;
    private int rentalId;
}
