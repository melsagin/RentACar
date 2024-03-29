package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.dtos.requests.brands.CreateBrandRequest;
import com.etiya.rentACar.business.dtos.requests.brands.UpdateBrandRequest;
import com.etiya.rentACar.business.dtos.responses.brands.CreatedBrandResponse;
import com.etiya.rentACar.business.dtos.responses.brands.GetBrandListResponse;
import com.etiya.rentACar.business.dtos.responses.brands.GetBrandResponse;
import com.etiya.rentACar.business.dtos.responses.brands.UpdatedBrandResponse;
import com.etiya.rentACar.entities.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {
//    CreatedBrandResponse save(CreateBrandRequest brand);
//
//    List<CreatedBrandResponse>  findAll();
//
//    CreatedBrandResponse findById(int id);
//
//    String update(UpdateBrandRequest updateBrandRequest);
//
//    String delete(int id);

    List<GetBrandListResponse> getAll();

    GetBrandResponse getById(int id);
    CreatedBrandResponse add(CreateBrandRequest createBrandRequest);

    UpdatedBrandResponse update(UpdateBrandRequest updateBrandRequest);

    void delete(int id);
}