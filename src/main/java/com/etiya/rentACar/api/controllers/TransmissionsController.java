package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.TransmissionService;
import com.etiya.rentACar.business.dtos.requests.brands.CreateBrandRequest;
import com.etiya.rentACar.business.dtos.requests.brands.UpdateBrandRequest;
import com.etiya.rentACar.business.dtos.requests.transmissions.CreateTransmissionRequest;
import com.etiya.rentACar.business.dtos.requests.transmissions.UpdateTransmissionRequest;
import com.etiya.rentACar.business.dtos.responses.brands.CreatedBrandResponse;
import com.etiya.rentACar.business.dtos.responses.brands.GetBrandListResponse;
import com.etiya.rentACar.business.dtos.responses.brands.GetBrandResponse;
import com.etiya.rentACar.business.dtos.responses.brands.UpdatedBrandResponse;
import com.etiya.rentACar.business.dtos.responses.transmissions.CreatedTransmissionResponse;
import com.etiya.rentACar.business.dtos.responses.transmissions.GetTransmissionListResponse;
import com.etiya.rentACar.business.dtos.responses.transmissions.GetTransmissionResponse;
import com.etiya.rentACar.business.dtos.responses.transmissions.UpdatedTransmissionResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/transmissions")
public class TransmissionsController {
    private TransmissionService transmissionService;

    @GetMapping("/getAll")
    public List<GetTransmissionListResponse> getAll(){
        return transmissionService.getAll();
    }

    @GetMapping("/{id}")
    public GetTransmissionResponse getById(@PathVariable int id){
        return  transmissionService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//201
    public CreatedTransmissionResponse add(@Valid @RequestBody CreateTransmissionRequest createTransmissionRequest){
        return transmissionService.add(createTransmissionRequest);
    }

    @PutMapping
    public UpdatedTransmissionResponse update(@Valid @RequestBody UpdateTransmissionRequest updateTransmissionRequest){
        return transmissionService.update(updateTransmissionRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id){
        transmissionService.delete(id);
    }

//    @GetMapping("/{id}")
//    public CreatedTransmissionResponse findById(@PathVariable int id) {
//        return transmissionService.findById(id);
//    }
//
//    @GetMapping
//    public List<CreatedTransmissionResponse> findAll() {
//        return transmissionService.findAll();
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public CreatedTransmissionResponse save(@Valid @RequestBody CreateTransmissionRequest createTransmissionRequest) {
//        return transmissionService.save(createTransmissionRequest);
//    }
//
//    @PutMapping
//    public String update(@Valid @RequestBody UpdateTransmissionRequest updateTransmissionRequest) {
//        return transmissionService.update(updateTransmissionRequest);
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable int id) {
//        return transmissionService.delete(id);
//    }
}

