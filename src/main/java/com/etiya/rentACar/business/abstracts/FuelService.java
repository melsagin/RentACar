package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.dtos.requests.fuels.CreateFuelRequest;
import com.etiya.rentACar.business.dtos.requests.fuels.UpdateFuelRequest;
import com.etiya.rentACar.business.dtos.responses.fuels.CreatedFuelResponse;
import com.etiya.rentACar.business.dtos.responses.fuels.GetFuelListResponse;
import com.etiya.rentACar.business.dtos.responses.fuels.GetFuelResponse;
import com.etiya.rentACar.business.dtos.responses.fuels.UpdatedFuelResponse;

import java.util.List;


public interface FuelService {
    List<GetFuelListResponse> getAll();

    GetFuelResponse getById(int id);
    CreatedFuelResponse add(CreateFuelRequest createFuelRequest);

    UpdatedFuelResponse update(UpdateFuelRequest updateFuelRequest);

    void delete(int id);




//    CreatedFuelResponse save(CreateFuelRequest fuel);
//
//    List<CreatedFuelResponse> findAll();
//
//    CreatedFuelResponse findById(int id);
//
//    String update(UpdateFuelRequest updateFuelRequest);
//
//    String delete(int id);
//
//    Optional<Fuel> getById(int id);
}