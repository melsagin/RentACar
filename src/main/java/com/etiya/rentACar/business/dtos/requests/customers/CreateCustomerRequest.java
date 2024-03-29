package com.etiya.rentACar.business.dtos.requests.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCustomerRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String companyName;
}
