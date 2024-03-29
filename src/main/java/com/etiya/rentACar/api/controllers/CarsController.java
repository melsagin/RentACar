package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.dtos.requests.brands.CreateBrandRequest;
import com.etiya.rentACar.business.dtos.requests.brands.UpdateBrandRequest;
import com.etiya.rentACar.business.dtos.requests.cars.CreateCarRequest;
import com.etiya.rentACar.business.dtos.requests.cars.UpdateCarRequest;
import com.etiya.rentACar.business.dtos.responses.brands.CreatedBrandResponse;
import com.etiya.rentACar.business.dtos.responses.brands.GetBrandListResponse;
import com.etiya.rentACar.business.dtos.responses.brands.GetBrandResponse;
import com.etiya.rentACar.business.dtos.responses.brands.UpdatedBrandResponse;
import com.etiya.rentACar.business.dtos.responses.cars.CreatedCarResponse;
import com.etiya.rentACar.business.dtos.responses.cars.GetCarListResponse;
import com.etiya.rentACar.business.dtos.responses.cars.GetCarResponse;
import com.etiya.rentACar.business.dtos.responses.cars.UpdatedCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/cars")
public class CarsController {
    private CarService carService;

    @GetMapping("/getAll")
    public List<GetCarListResponse> getAll(){
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public GetCarResponse getById(@PathVariable int id){
        return  carService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//201
    public CreatedCarResponse add(@Valid @RequestBody CreateCarRequest createCarRequest){
        return carService.add(createCarRequest);
    }

    @PutMapping
    public UpdatedCarResponse update(@Valid @RequestBody UpdateCarRequest updateCarRequest){
        return carService.update(updateCarRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        carService.delete(id);
    }

    @GetMapping("/searchPlate")
    public List<GetCarListResponse> getSearchPlate(@RequestParam String plate){
        return carService.getSearchPlate(plate);
    }


//    @GetMapping("/{id}")
//    public CreatedCarResponse findById(@PathVariable int id) {
//        return carService.findById(id);
//    }
//
//    @GetMapping
//    public List<CreatedCarResponse> findAll() {
//       return carService.findAll();
//    }
//
//    @PostMapping
//    public CreatedCarResponse save(@Valid @RequestBody CreateCarRequest createCarRequest){
//        return carService.save(createCarRequest);
//    }
//
//    @PutMapping
//    public String update(@Valid @RequestBody UpdateCarRequest updateCarRequest) {
//       return carService.update(updateCarRequest);
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable int id) {
//       return carService.delete(id);

//    }
}
