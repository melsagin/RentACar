package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.FuelService;
import com.etiya.rentACar.business.dtos.requests.fuels.CreateFuelRequest;
import com.etiya.rentACar.business.dtos.requests.fuels.UpdateFuelRequest;
import com.etiya.rentACar.business.dtos.responses.fuels.CreatedFuelResponse;
import com.etiya.rentACar.business.dtos.responses.fuels.GetFuelListResponse;
import com.etiya.rentACar.business.dtos.responses.fuels.GetFuelResponse;
import com.etiya.rentACar.business.dtos.responses.fuels.UpdatedFuelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fuels")
public class FuelsController {
    private FuelService fuelService;

    @GetMapping("/getAll")
    public List<GetFuelListResponse> getAll(){
        return fuelService.getAll();
    }

    @GetMapping("/{id}")
    public GetFuelResponse getById(@PathVariable int id){
        return  fuelService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//201
    public CreatedFuelResponse add(@Valid @RequestBody CreateFuelRequest createFuelRequest){
        return fuelService.add(createFuelRequest);
    }

    @PutMapping
    public UpdatedFuelResponse update(@Valid @RequestBody UpdateFuelRequest updateFuelRequest){
        return fuelService.update(updateFuelRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id){
        fuelService.delete(id);
    }



//    @GetMapping("/{id}")
//    public CreatedFuelResponse findById(@PathVariable int id){
//        return fuelService.findById(id);
//    }
//
//    @GetMapping
//    public List<CreatedFuelResponse> findAll(){
//        return fuelService.findAll();
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public CreatedFuelResponse save(@Valid @RequestBody CreateFuelRequest createFuelRequest){
//        return fuelService.save(createFuelRequest);
//    }
//
//    @PutMapping()
//    public String update(@Valid @RequestBody UpdateFuelRequest updateFuelRequest){
//        return fuelService.update(updateFuelRequest);
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable int id){
//        return fuelService.delete(id);
//    }
}
