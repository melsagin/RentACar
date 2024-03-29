package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.FuelService;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.business.dtos.requests.fuels.CreateFuelRequest;
import com.etiya.rentACar.business.dtos.requests.fuels.UpdateFuelRequest;
import com.etiya.rentACar.business.dtos.responses.fuels.CreatedFuelResponse;
import com.etiya.rentACar.business.dtos.responses.fuels.GetFuelListResponse;
import com.etiya.rentACar.business.dtos.responses.fuels.GetFuelResponse;
import com.etiya.rentACar.business.dtos.responses.fuels.UpdatedFuelResponse;
import com.etiya.rentACar.business.rules.FuelBusinessRules;
import com.etiya.rentACar.dataAccess.abstracts.FuelRepository;
import com.etiya.rentACar.entities.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FuelManager implements FuelService {
    private FuelRepository fuelRepository;
    private ModelMapperService modelMapperService;
    private FuelBusinessRules fuelBusinessRules;

    @Override
    public List<GetFuelListResponse> getAll() {
        List<Fuel> fuels = fuelRepository.findAll();
        List<GetFuelListResponse> fuelResponse = fuels.stream()
                .map(brand ->this.modelMapperService.forResponse()
                        .map(brand, GetFuelListResponse.class)).collect(Collectors.toList());
        return fuelResponse;
    }

    @Override
    public GetFuelResponse getById(int id) {
        Fuel fuel = fuelRepository.findById(id).orElseThrow();//id db'de yoksa hata atıyor
        GetFuelResponse fuelResponse = modelMapperService.forResponse().map(fuel, GetFuelResponse.class);
        return fuelResponse;
    }

    @Override
    public CreatedFuelResponse add(CreateFuelRequest createFuelRequest) {
        fuelBusinessRules.fuelNameCannotBeDuplicated(createFuelRequest.getName());
        Fuel fuel = modelMapperService.forRequest().map(createFuelRequest, Fuel.class);
        //fuel.setCreatedDate(LocalDateTime.now());
        Fuel createdFuel = fuelRepository.save(fuel);
        CreatedFuelResponse createdFuelResponse = modelMapperService.forResponse().map(createdFuel, CreatedFuelResponse.class);
        return createdFuelResponse;
    }

    @Override
    public UpdatedFuelResponse update(UpdateFuelRequest updateFuelRequest) {
        Fuel getFuel = fuelRepository.findById(updateFuelRequest.getId()).get();
        Fuel fuel = modelMapperService.forRequest().map(updateFuelRequest, Fuel.class);
//        fuel.setUpdatedDate(LocalDateTime.now());
        fuel.setCreatedDate(getFuel.getCreatedDate());
        Fuel updatedFuel = fuelRepository.save(fuel);
        UpdatedFuelResponse updatedFuelResponse = modelMapperService.forResponse().map(updatedFuel, UpdatedFuelResponse.class);
        return updatedFuelResponse;
    }

    @Override
    public void delete(int id) {
        fuelRepository.deleteById(id);
    }


//    @Override
//    public CreatedFuelResponse save(CreateFuelRequest createFuelRequest) {
//        Fuel fuel = new Fuel();
//        fuel.setName(createFuelRequest.getName());
//        fuel.setCreatedDate(LocalDateTime.now());
//
//        Fuel savedFuel = fuelRepository.save(fuel);
//
//        CreatedFuelResponse createdFuelResponse =  new CreatedFuelResponse();
//        createdFuelResponse.setId(savedFuel.getId());
//        createdFuelResponse.setName(savedFuel.getName());
//        createdFuelResponse.setCreatedDate(savedFuel.getCreatedDate());
//        return createdFuelResponse;
//    }
//
//    @Override
//    public List<CreatedFuelResponse> findAll() {
//        List<Fuel> fuels = fuelRepository.findAll();
//        List<CreatedFuelResponse> createdFuelResponses = new ArrayList<>();
//        for (Fuel fuel : fuels) {
//            if(fuel.getDeleteDate() == null){
//                CreatedFuelResponse createdFuelResponse = new CreatedFuelResponse();
//                createdFuelResponse.setId(fuel.getId());
//                createdFuelResponse.setName(fuel.getName());
//                createdFuelResponse.setCreatedDate(fuel.getCreatedDate());
//                createdFuelResponses.add(createdFuelResponse);
//            }
//        }
//        return createdFuelResponses;
//    }
//
//    @Override
//    public CreatedFuelResponse findById(int id) {
//        Optional<Fuel> fuel = fuelRepository.findById(id);
//        CreatedFuelResponse createdFuelResponse = new CreatedFuelResponse();
//        createdFuelResponse.setId(fuel.get().getId());
//        createdFuelResponse.setName(fuel.get().getName());
//        createdFuelResponse.setCreatedDate(fuel.get().getCreatedDate());
//        return createdFuelResponse;
//    }
//
//    @Override
//    public String update(UpdateFuelRequest updateFuelRequest) {
//        Optional<Fuel> fuel = getById(updateFuelRequest.getId());
//        fuel.get().setName(updateFuelRequest.getName());
//        fuel.get().setUpdateDate(LocalDateTime.now());
//        fuelRepository.save(fuel.get());
//        return "Updated";
//    }
//
//    @Override
//    public String delete(int id) {
//        Optional<Fuel> fuel = getById(id);
//        fuel.get().setDeleteDate(LocalDateTime.now());
//        fuelRepository.save(fuel.get());
//        return "Deleted";
//    }
//
//    public Optional<Fuel> getById(int id){
//        return fuelRepository.findById(id);
//    }
}
