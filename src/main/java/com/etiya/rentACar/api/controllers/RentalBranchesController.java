package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.RentalBranchService;
import com.etiya.rentACar.business.dtos.requests.rentalBranches.CreateRentalBranchRequest;
import com.etiya.rentACar.business.dtos.requests.rentalBranches.UpdateRentalBranchRequest;
import com.etiya.rentACar.business.dtos.responses.rentalBranches.CreatedRentalBranchResponse;
import com.etiya.rentACar.business.dtos.responses.rentalBranches.GetRentalBranchListResponse;
import com.etiya.rentACar.business.dtos.responses.rentalBranches.GetRentalBranchResponse;
import com.etiya.rentACar.business.dtos.responses.rentalBranches.UpdatedRentalBranchResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/rentalBranches")
public class RentalBranchesController {
    private RentalBranchService rentalBranchService;

    @GetMapping("/getAll")
    public List<GetRentalBranchListResponse> getAll(){
        return rentalBranchService.getAll();
    }

    @GetMapping("/{id}")
    public GetRentalBranchResponse getById(@PathVariable int id){
        return  rentalBranchService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//201
    public CreatedRentalBranchResponse add(@Valid @RequestBody CreateRentalBranchRequest createRentalBranchRequest){
        return rentalBranchService.add(createRentalBranchRequest);
    }

    @PutMapping
    public UpdatedRentalBranchResponse update(@Valid @RequestBody UpdateRentalBranchRequest updateRentalBranchRequest){
        return rentalBranchService.update(updateRentalBranchRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id){
        rentalBranchService.delete(id);
    }

}
