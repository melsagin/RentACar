package com.etiya.rentACar.business.dtos.requests.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCustomerRequest {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String companyName;
}
