package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
