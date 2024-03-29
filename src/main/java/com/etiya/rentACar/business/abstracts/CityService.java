package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.dtos.requests.cities.CreateCityRequest;
import com.etiya.rentACar.business.dtos.requests.cities.UpdateCityRequest;
import com.etiya.rentACar.business.dtos.responses.cities.CreatedCityResponse;
import com.etiya.rentACar.business.dtos.responses.cities.GetCityListResponse;
import com.etiya.rentACar.business.dtos.responses.cities.GetCityResponse;
import com.etiya.rentACar.business.dtos.responses.cities.UpdatedCityResponse;

import java.util.List;

public interface CityService {
    List<GetCityListResponse> getAll();

    GetCityResponse getById(int id);

    CreatedCityResponse add(CreateCityRequest createCityRequest);

    UpdatedCityResponse update(UpdateCityRequest updateCityRequest);

    void delete(int id);

}
