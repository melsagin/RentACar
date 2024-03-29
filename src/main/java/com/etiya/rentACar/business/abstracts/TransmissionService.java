package com.etiya.rentACar.business.abstracts;
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
import com.etiya.rentACar.entities.Transmission;

import java.util.List;
import java.util.Optional;

public interface TransmissionService {

    List<GetTransmissionListResponse> getAll();

    GetTransmissionResponse getById(int id);
    CreatedTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest);

    UpdatedTransmissionResponse update(UpdateTransmissionRequest updateTransmissionRequest);

    void delete(int id);

//    CreatedTransmissionResponse save(CreateTransmissionRequest transmission);
//
//    List<CreatedTransmissionResponse> findAll();
//
//    CreatedTransmissionResponse findById(int id);
//
//    String update(UpdateTransmissionRequest updateTransmissionRequest);
//
//    String delete(int id);
//
//    Optional<Transmission> getById(int id);

}
