package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.CityService;
import com.etiya.rentACar.business.dtos.requests.cities.CreateCityRequest;
import com.etiya.rentACar.business.dtos.requests.cities.UpdateCityRequest;
import com.etiya.rentACar.business.dtos.responses.cities.CreatedCityResponse;
import com.etiya.rentACar.business.dtos.responses.cities.GetCityListResponse;
import com.etiya.rentACar.business.dtos.responses.cities.GetCityResponse;
import com.etiya.rentACar.business.dtos.responses.cities.UpdatedCityResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/cities")
public class CitiesController {
    private CityService cityService;

    @GetMapping("/getAll")
    public List<GetCityListResponse> getAll(){
        return cityService.getAll();
    }

    @GetMapping("/{id}")
    public GetCityResponse getById(@PathVariable int id){
        return  cityService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//201
    public CreatedCityResponse add(@Valid @RequestBody CreateCityRequest createCityRequest){
        return cityService.add(createCityRequest);
    }

    @PutMapping
    public UpdatedCityResponse update(@Valid @RequestBody UpdateCityRequest updateCityRequest){
        return cityService.update(updateCityRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id){
        cityService.delete(id);
    }

}
