package com.etiya.rentACar.business.abstracts;

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
import com.etiya.rentACar.entities.Model;

import java.util.List;
import java.util.Optional;

public interface ModelService {
    List<GetModelListResponse> getAll();
    GetModelResponse getById(int id);
    CreatedModelResponse add(CreateModelRequest createModelRequest);
    UpdatedModelResponse update(UpdateModelRequest updateModelRequest);
    void delete(int id);

//    CreatedModelResponse findById(int id);
//
//    List<CreatedModelResponse> findAll();
//
//    CreatedModelResponse save(CreateModelRequest createModelRequest);
//
//    String update(UpdateModelRequest updateModelRequest);
//
//    String delete(int id);
//
//    Optional<Model> getById(int id);

}
