package com.etiya.rentACar.business.abstracts;

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
import com.etiya.rentACar.entities.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<GetCarListResponse> getAll();
    GetCarResponse getById(int id);
    CreatedCarResponse add(CreateCarRequest createCarRequest);
    UpdatedCarResponse update(UpdateCarRequest updateCarRequest);
    void delete(int id);
    List<GetCarListResponse> getSearchPlate(String plate);

    GetCarListResponse getByCarId(int id);

    void updateCarState(int carId, int state);

    void updateCarKilometer(int carId, int endKilometer);

//    CreatedCarResponse save(CreateCarRequest car);
//
//    List<CreatedCarResponse> findAll();
//
//    CreatedCarResponse findById(int id);
//
//    String update(UpdateCarRequest updateCarRequest);
//
//    String delete(int id);
//    Optional<Car> getById(int id);
}