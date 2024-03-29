package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.CustomerService;
import com.etiya.rentACar.business.dtos.requests.customers.CreateCustomerRequest;
import com.etiya.rentACar.business.dtos.requests.customers.UpdateCustomerRequest;
import com.etiya.rentACar.business.dtos.responses.customers.CreatedCustomerResponse;
import com.etiya.rentACar.business.dtos.responses.customers.GetCustomerListResponse;
import com.etiya.rentACar.business.dtos.responses.customers.GetCustomerResponse;
import com.etiya.rentACar.business.dtos.responses.customers.UpdatedCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomersController {
    private CustomerService customerService;

    @GetMapping("/getAll")
    public List<GetCustomerListResponse> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public GetCustomerResponse getById(@PathVariable int id){
        return customerService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//201
    public CreatedCustomerResponse add(@Valid @RequestBody CreateCustomerRequest createCustomerRequest){
        return customerService.add(createCustomerRequest);
    }

    @PutMapping
    public UpdatedCustomerResponse update(@Valid @RequestBody UpdateCustomerRequest updateCustomerRequest){
        return customerService.update(updateCustomerRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id){
        customerService.delete(id);
    }

}
