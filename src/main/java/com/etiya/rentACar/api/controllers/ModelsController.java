package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.ModelService;
import com.etiya.rentACar.business.dtos.requests.brands.CreateBrandRequest;
import com.etiya.rentACar.business.dtos.requests.brands.UpdateBrandRequest;
import com.etiya.rentACar.business.dtos.requests.models.CreateModelRequest;
import com.etiya.rentACar.business.dtos.requests.models.UpdateModelRequest;
import com.etiya.rentACar.business.dtos.responses.brands.CreatedBrandResponse;
import com.etiya.rentACar.business.dtos.responses.brands.GetBrandListResponse;
import com.etiya.rentACar.business.dtos.responses.brands.GetBrandResponse;
import com.etiya.rentACar.business.dtos.responses.brands.UpdatedBrandResponse;
import com.etiya.rentACar.business.dtos.responses.models.CreatedModelResponse;
import com.etiya.rentACar.business.dtos.responses.models.GetModelListResponse;
import com.etiya.rentACar.business.dtos.responses.models.GetModelResponse;
import com.etiya.rentACar.business.dtos.responses.models.UpdatedModelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/models")
public class ModelsController {

    private ModelService modelService;

    @GetMapping("/getAll")
    public List<GetModelListResponse> getAll(){
        return modelService.getAll();
    }

    @GetMapping("/{id}")
    public GetModelResponse getById(@PathVariable int id){
        return  modelService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//201
    public CreatedModelResponse add(@Valid @RequestBody CreateModelRequest createModelRequest){
        return modelService.add(createModelRequest);
    }

    @PutMapping
    public UpdatedModelResponse update(@Valid @RequestBody UpdateModelRequest updateModelRequest){
        return modelService.update(updateModelRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id){
        modelService.delete(id);
    }
//    @GetMapping("/{id}")
//    public CreatedModelResponse findById(@PathVariable int id) {
//        return modelService.findById(id);
//    }
//
//    @GetMapping
//    public List<CreatedModelResponse> findAll() {
//        return modelService.findAll();
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public CreatedModelResponse save(@Valid @RequestBody CreateModelRequest createModelRequest) {
//        return modelService.save(createModelRequest);
//    }
//
//    @PutMapping
//    public String update(@Valid @RequestBody UpdateModelRequest updateModelRequest) {
//        return modelService.update(updateModelRequest);
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable int id) {
//        return modelService.delete(id);
//    }
}