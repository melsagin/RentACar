package com.etiya.rentACar.business.dtos.responses.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedCustomerResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String companyName;
    private LocalDateTime updatedDate;
}
