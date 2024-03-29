package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.dtos.requests.customers.CreateCustomerRequest;
import com.etiya.rentACar.business.dtos.requests.customers.UpdateCustomerRequest;
import com.etiya.rentACar.business.dtos.responses.customers.CreatedCustomerResponse;
import com.etiya.rentACar.business.dtos.responses.customers.GetCustomerListResponse;
import com.etiya.rentACar.business.dtos.responses.customers.GetCustomerResponse;
import com.etiya.rentACar.business.dtos.responses.customers.UpdatedCustomerResponse;

import java.util.List;

public interface CustomerService {
    List<GetCustomerListResponse> getAll();

    GetCustomerResponse getById(int id);
    CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest);

    UpdatedCustomerResponse update(UpdateCustomerRequest updateCustomerRequest);

    void delete(int id);
}
