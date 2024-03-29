package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.RentalService;
import com.etiya.rentACar.business.dtos.requests.rentals.ChangedRentedCarRequest;
import com.etiya.rentACar.business.dtos.requests.rentals.CreateRentalRequest;
import com.etiya.rentACar.business.dtos.requests.rentals.UpdateRentalRequest;
import com.etiya.rentACar.business.dtos.responses.rentals.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/rentals")
public class RentalsController {
    private RentalService rentalService;

    @GetMapping("/getAll")
    public List<GetRentalListResponse> getAll(){
        return rentalService.getAll();
    }

    @GetMapping("/{id}")
    public GetRentalResponse getById(@PathVariable int id){
        return  rentalService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//201
    public CreatedRentalResponse add(@Valid @RequestBody CreateRentalRequest createRentalRequest){
        return rentalService.add(createRentalRequest);
    }

    @PutMapping
    public UpdatedRentalResponse update(@Valid @RequestBody UpdateRentalRequest updateRentalRequest){
        return rentalService.update(updateRentalRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id){
        rentalService.delete(id);
    }

    @PutMapping("/{id}")
    ChangedRentedCarResponse change(@Valid @RequestBody ChangedRentedCarRequest changedRentedCarRequest){
        return rentalService.change(changedRentedCarRequest);
    }

}
