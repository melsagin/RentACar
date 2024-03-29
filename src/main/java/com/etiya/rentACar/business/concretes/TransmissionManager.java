package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.TransmissionService;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.business.dtos.requests.transmissions.CreateTransmissionRequest;
import com.etiya.rentACar.business.dtos.requests.transmissions.UpdateTransmissionRequest;
import com.etiya.rentACar.business.dtos.responses.transmissions.CreatedTransmissionResponse;
import com.etiya.rentACar.business.dtos.responses.transmissions.GetTransmissionListResponse;
import com.etiya.rentACar.business.dtos.responses.transmissions.GetTransmissionResponse;
import com.etiya.rentACar.business.dtos.responses.transmissions.UpdatedTransmissionResponse;
import com.etiya.rentACar.business.rules.TransmissionBusinessRules;
import com.etiya.rentACar.dataAccess.abstracts.TransmissionRepository;
import com.etiya.rentACar.entities.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TransmissionManager implements TransmissionService {

    private TransmissionRepository transmissionRepository;
    private ModelMapperService modelMapperService;
    private TransmissionBusinessRules transmissionBusinessRules;

    @Override
    public List<GetTransmissionListResponse> getAll() {
        List<Transmission> transmissions = transmissionRepository.findAll();
        List<GetTransmissionListResponse> transmissionResponse = transmissions.stream()
                .map(transmission ->this.modelMapperService.forResponse()
                        .map(transmission, GetTransmissionListResponse.class)).collect(Collectors.toList());
        return transmissionResponse;
    }

    @Override
    public GetTransmissionResponse getById(int id) {
        Transmission transmission = transmissionRepository.findById(id).orElseThrow();//id db'de yoksa hata atıyor
        GetTransmissionResponse transmissionResponse = modelMapperService.forResponse().map(transmission, GetTransmissionResponse.class);
        return transmissionResponse;
    }

    @Override
    public CreatedTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest) {
        transmissionBusinessRules.transmissionNameCannotBeDuplicated(createTransmissionRequest.getName());
        Transmission transmission = modelMapperService.forRequest().map(createTransmissionRequest, Transmission.class);
//        transmission.setCreatedDate(LocalDateTime.now());
        Transmission createdTransmission = transmissionRepository.save(transmission);
        CreatedTransmissionResponse createdTransmissionResponse = modelMapperService.forResponse().map(createdTransmission, CreatedTransmissionResponse.class);
        return createdTransmissionResponse;
    }

    @Override
    public UpdatedTransmissionResponse update(UpdateTransmissionRequest updateTransmissionRequest) {
        Transmission getTransmission = transmissionRepository.findById(updateTransmissionRequest.getId()).get();//
        Transmission transmission = modelMapperService.forRequest().map(updateTransmissionRequest, Transmission.class);
//        transmission.setUpdatedDate(LocalDateTime.now());
        transmission.setCreatedDate(getTransmission.getCreatedDate());//
        Transmission updatedTransmission = transmissionRepository.save(transmission);
        UpdatedTransmissionResponse updatedTransmissionResponse = modelMapperService.forResponse().map(updatedTransmission, UpdatedTransmissionResponse.class);
        return updatedTransmissionResponse;
    }

    @Override
    public void delete(int id) {//soft delete kullanımı
        transmissionRepository.deleteById(id);
    }


//    @Override
//    public CreatedTransmissionResponse save(CreateTransmissionRequest createTransmissionRequest) {
//        Transmission transmission = new Transmission();
//        transmission.setName(createTransmissionRequest.getName());
//        transmission.setCreatedDate(LocalDateTime.now());
//        Transmission createdTransmission =  this.transmissionRepository.save(transmission);
//
//        CreatedTransmissionResponse createdTransmissionResponse = new CreatedTransmissionResponse();
//        createdTransmissionResponse.setId(createdTransmission.getId());
//        createdTransmissionResponse.setName(createdTransmission.getName());
//        createdTransmissionResponse.setCreatedDate(createdTransmission.getCreatedDate());
//
//        return createdTransmissionResponse;
//    }
//
//    @Override
//    public List<CreatedTransmissionResponse> findAll() {
//        List<Transmission> transmissions = transmissionRepository.findAll();
//        List<CreatedTransmissionResponse> createdTransmissionResponses = new ArrayList<>();
//        for (Transmission transmission : transmissions){
//            if (transmission.getDeleteDate() == null){
//                CreatedTransmissionResponse createdTransmissionResponse = new CreatedTransmissionResponse();
//                createdTransmissionResponse.setId(transmission.getId());
//                createdTransmissionResponse.setName(transmission.getName());
//                createdTransmissionResponse.setCreatedDate(transmission.getCreatedDate());
//                createdTransmissionResponses.add(createdTransmissionResponse);
//            }
//        }
//        return createdTransmissionResponses;
//    }
//
//    @Override
//    public CreatedTransmissionResponse findById(int id) {
//        Optional<Transmission> transmission = getById(id);
//        CreatedTransmissionResponse createdTransmissionResponse = new CreatedTransmissionResponse();
//        createdTransmissionResponse.setId(transmission.get().getId());
//        createdTransmissionResponse.setName(transmission.get().getName());
//        createdTransmissionResponse.setCreatedDate(transmission.get().getCreatedDate());
//        return createdTransmissionResponse;
//    }
//
//    @Override
//    public String update(UpdateTransmissionRequest updateTransmissionRequest) {
//        Optional<Transmission> transmission = getById(updateTransmissionRequest.getId());
//        transmission.get().setName(updateTransmissionRequest.getName());
//        transmission.get().setUpdateDate(LocalDateTime.now());
//        transmissionRepository.save(transmission.get());
//        return "Updated";
//    }
//
//    @Override
//    public String delete(int id) {
//        Optional<Transmission> transmission = getById(id);
//        transmission.get().setDeleteDate(LocalDateTime.now());
//        transmissionRepository.save(transmission.get());
//        return "Deleted";
//    }
//
//    public Optional<Transmission> getById(int id){
//        return transmissionRepository.findById(id);
//    }
}