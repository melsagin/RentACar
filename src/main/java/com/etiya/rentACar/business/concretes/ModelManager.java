package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.ModelService;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.business.dtos.requests.models.CreateModelRequest;
import com.etiya.rentACar.business.dtos.requests.models.UpdateModelRequest;
import com.etiya.rentACar.business.dtos.responses.models.CreatedModelResponse;
import com.etiya.rentACar.business.dtos.responses.models.GetModelListResponse;
import com.etiya.rentACar.business.dtos.responses.models.GetModelResponse;
import com.etiya.rentACar.business.dtos.responses.models.UpdatedModelResponse;
import com.etiya.rentACar.business.rules.ModelBusinessRules;
import com.etiya.rentACar.dataAccess.abstracts.ModelRepository;
import com.etiya.rentACar.entities.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelMapperService modelMapperService;
    private ModelRepository modelRepository;
    private ModelBusinessRules modelBusinessRules;

//    private BrandService brandService;
//    private FuelService fuelService;
//    private TransmissionService transmissionService;

    @Override
    public List<GetModelListResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetModelListResponse> modelResponse = models.stream()
                .map(model ->this.modelMapperService.forResponse()
                        .map(model, GetModelListResponse.class)).collect(Collectors.toList());
        return modelResponse;
    }

    @Override
    public GetModelResponse getById(int id) {
        Model model = modelRepository.findById(id).orElseThrow();//id db'de yoksa hata atıyor
        GetModelResponse modelResponse = modelMapperService.forResponse().map(model, GetModelResponse.class);
        return modelResponse;
    }

    @Override
    public CreatedModelResponse add(CreateModelRequest createModelRequest) {
        modelBusinessRules.modelNameCannotBeDuplicated(createModelRequest.getName());
        Model model = modelMapperService.forRequest().map(createModelRequest, Model.class);
//        model.setCreatedDate(LocalDateTime.now());
        Model createdModel = modelRepository.save(model);
        CreatedModelResponse createdModelResponse = modelMapperService.forResponse().map(createdModel, CreatedModelResponse.class);
        return createdModelResponse;
    }

    @Override
    public UpdatedModelResponse update(UpdateModelRequest updateModelRequest) {
        Model getModel = modelRepository.findById(updateModelRequest.getId()).get();
        Model model = modelMapperService.forRequest().map(updateModelRequest, Model.class);
//        model.setUpdatedDate(LocalDateTime.now());
        model.setCreatedDate(getModel.getCreatedDate());
        Model updatedModel = modelRepository.save(model);
        UpdatedModelResponse updatedModelResponse = modelMapperService.forResponse().map(updatedModel, UpdatedModelResponse.class);
        return updatedModelResponse;
    }

    @Override
    public void delete(int id) {
        modelRepository.deleteById(id);
    }


//    @Override
//    public CreatedModelResponse findById(int id) {
//        Optional<Model> model = modelRepository.findById(id);
//        CreatedModelResponse createdModelResponse = new CreatedModelResponse();
//        createdModelResponse.setId(model.get().getId());
//        createdModelResponse.setName(model.get().getName());
//        createdModelResponse.setCreatedDate(model.get().getCreatedDate());
//        createdModelResponse.setBrand(brandService.findById(model.get().getBrand().getId()));
//        createdModelResponse.setFuel(fuelService.findById(model.get().getFuel().getId()));
//        createdModelResponse.setTransmission(transmissionService.findById(model.get().getTransmission().getId()));
//        return createdModelResponse;
//    }
//
//    @Override
//    public List<CreatedModelResponse> findAll() {
//        List<Model> modelList = modelRepository.findAll();
//        return modelList.stream().map(model -> modelMapperService.forResponse().map(model, CreatedModelResponse.class)).collect(Collectors.toList());
//    }
//
//    @Override
//    public CreatedModelResponse save(CreateModelRequest createModelRequest) {
//        Model model = modelMapperService.forRequest().map(createModelRequest, Model.class);
//        modelRepository.save(model);
//
//        CreatedModelResponse createdModelResponse = new CreatedModelResponse();
//        createdModelResponse.setId(model.getId());
//        createdModelResponse.setName(model.getName());
//        createdModelResponse.setBrand(brandService.findById(createModelRequest.getBrandId()));
//        createdModelResponse.setFuel(fuelService.findById(createModelRequest.getFuelId()));
//        createdModelResponse.setTransmission(transmissionService.findById(createModelRequest.getTransmissionId()));
//        createdModelResponse.setCreatedDate(LocalDateTime.now());
//        return createdModelResponse;
//    }
//
//    @Override
//    public String update(UpdateModelRequest updateModelRequest) {
//        Optional<Model> model = modelRepository.findById(updateModelRequest.getId());
//        model.get().setName(updateModelRequest.getName());
//        model.get().setBrand(brandService.getById(updateModelRequest.getBrandId()).get());
//        model.get().setFuel(fuelService.getById(updateModelRequest.getFuelId()).get());
//        model.get().setTransmission(transmissionService.getById(updateModelRequest.getTransmissionId()).get());
//        model.get().setUpdateDate(LocalDateTime.now());
//        modelRepository.save(model.get());
//        return "Updated...";
//    }
//
//    @Override
//    public String delete(int id) {
//        Optional<Model> model = getById(id);
//        model.get().setDeleteDate(LocalDateTime.now());
//        modelRepository.deleteById(id);
//        return "Deleted...";
//    }
//
//    @Override
//    public Optional<Model> getById(int id) {
//        return modelRepository.findById(id);
//    }
}
