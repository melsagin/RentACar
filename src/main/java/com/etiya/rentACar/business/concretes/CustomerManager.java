package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.CustomerService;
import com.etiya.rentACar.business.dtos.requests.customers.CreateCustomerRequest;
import com.etiya.rentACar.business.dtos.requests.customers.UpdateCustomerRequest;
import com.etiya.rentACar.business.dtos.responses.customers.CreatedCustomerResponse;
import com.etiya.rentACar.business.dtos.responses.customers.GetCustomerListResponse;
import com.etiya.rentACar.business.dtos.responses.customers.GetCustomerResponse;
import com.etiya.rentACar.business.dtos.responses.customers.UpdatedCustomerResponse;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.CustomerRepository;
import com.etiya.rentACar.entities.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    //Rules için burada if görmemeliyiz
    private CustomerRepository customerRepository;//bu ifadeyi newlemektense constructorda çağırarak dependecy injection yapılır
    private ModelMapperService modelMapperService;
    //private CustomerBusinessRules brandBusinessRules;

    @Override
    public List<GetCustomerListResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<GetCustomerListResponse> customerResponse = customers.stream()
                .map(customer -> this.modelMapperService.forResponse()
                        .map(customer, GetCustomerListResponse.class)).collect(Collectors.toList());
        return customerResponse;
    }

    @Override
    public GetCustomerResponse getById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow();//id db'de yoksa hata atıyor
        GetCustomerResponse customerResponse = modelMapperService.forResponse().map(customer, GetCustomerResponse.class);
        return customerResponse;
    }

    @Override
    public CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest) {
        //customerBusinessRules.customerNameCannotBeDuplicated(createCustomerRequest.getName());
        Customer customer = modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
        Customer createdCustomer = customerRepository.save(customer);
        CreatedCustomerResponse createdCustomerResponse = modelMapperService.forResponse().map(createdCustomer, CreatedCustomerResponse.class);
        return createdCustomerResponse;
    }

    @Override
    public UpdatedCustomerResponse update(UpdateCustomerRequest updateCustomerRequest) {
        Customer getCustomer = customerRepository.findById(updateCustomerRequest.getId()).get();
        Customer customer = modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
        //customer.setUpdatedDate(LocalDateTime.now());
        customer.setCreatedDate(getCustomer.getCreatedDate());
        Customer updatedCustomer = customerRepository.save(customer);
        UpdatedCustomerResponse updatedCustomerResponse = modelMapperService.forResponse().map(updatedCustomer, UpdatedCustomerResponse.class);
        return updatedCustomerResponse;
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }
}
